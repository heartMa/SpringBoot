package com.w3cjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @class  SpringBootActuator
 * @version 1.0.0
 * @author cos
 * @desc  
 * 	1、原生端点分为三大类
 * 	应用配置类：获取应用程序中加载的应用配置、环境变量、自动化配置报告等与Spring Boot应用密切相关的配置类信息。
 * 	A./autoconfig：该端点用来获取应用的自动化配置报告，其中包括所有自动化配置的候选项。
 * 	同时还列出了每个候选项自动化配置的各个先决条件是否满足。所以，该端点可以帮助我们方便的找到一些自动化配置为什么没有生效的具体原因。
 * 	该报告内容将自动化配置内容分为两部分：
		positiveMatches中返回的是条件匹配成功的自动化配置
		negativeMatches中返回的是条件匹配不成功的自动化配置
		{
		    "positiveMatches": { // 条件匹配成功的
		        "EndpointWebMvcAutoConfiguration": [
		            {
		                "condition": "OnClassCondition",
		                "message": "@ConditionalOnClass classes found: javax.servlet.Servlet,org.springframework.web.servlet.DispatcherServlet"
		            },
		            {
		                "condition": "OnWebApplicationCondition",
		                "message": "found web application StandardServletEnvironment"
		            }
		        ],
		        ...
		    },
		    "negativeMatches": {  // 条件不匹配成功的
		        "HealthIndicatorAutoConfiguration.DataSourcesHealthIndicatorConfiguration": [
		            {
		                "condition": "OnClassCondition",
		                "message": "required @ConditionalOnClass classes not found: org.springframework.jdbc.core.JdbcTemplate"
		            }
		        ],
		        ...
		    }
		}
	从如上示例中我们可以看到，每个自动化配置候选项中都有一系列的条件，比如上面没有成功匹配的HealthIndicatorAutoConfiguration.DataSourcesHealthIndicatorConfiguration配置，
	它的先决条件就是需要在工程中包含org.springframework.jdbc.core.JdbcTemplate类，由于我们没有引入相关的依赖，它就不会执行自动化配置内容。
	所以，当我们发现有一些期望的配置没有生效时，就可以通过该端点来查看没有生效的具体原因。
	B./beans:该端点用来获取应用上下文中创建的所有Bean
		bean：Bean的名称
		scope：Bean的作用域
		type：Bean的Java类型
		reource：class文件的具体路径
		dependencies：依赖的Bean名称
	C./configprops:该端点用来获取应用中配置的属性信息报告。从下面该端点返回示例的片段中，我们看到返回了关于该短信的配置信息，prefix属性代表了属性的配置前缀，properties代表了各个属性的名称和值。
	D./env:用来获取应用所有可用的环境属性报告，包括：环境变量、JVM属性、应用的配置配置、命令行中的参数。
	E./mappings:该端点用来返回所有Spring MVC的控制器映射关系报告。
	F./info:该端点用来返回一些应用自定义的信息。默认在application.properties中配置。
		
	度量指标类：获取应用程序运行过程中用于监控的度量指标，比如：内存信息、线程池信息、HTTP请求统计等。
	A./metrics:该端点用来返回当前应用的各类重要度量指标，比如：内存信息、线程信息、垃圾回收信息等。
		系统信息：包括处理器数量processors、运行时间uptime和instance.uptime、系统平均负载systemload.average。
		mem.*：内存概要信息，包括分配给应用的总内存数量以及当前空闲的内存数量。这些信息来自java.lang.Runtime。
		heap.*：堆内存使用情况。这些信息来自java.lang.management.MemoryMXBean接口中getHeapMemoryUsage方法获取的java.lang.management.MemoryUsage。
		nonheap.*：非堆内存使用情况。这些信息来自java.lang.management.MemoryMXBean接口中getNonHeapMemoryUsage方法获取的java.lang.management.MemoryUsage。
		threads.*：线程使用情况，包括线程数、守护线程数（daemon）、线程峰值（peak）等，这些数据均来自java.lang.management.ThreadMXBean。
		classes.*：应用加载和卸载的类统计。这些数据均来自java.lang.management.ClassLoadingMXBean。
		gc.*：垃圾收集器的详细信息，包括垃圾回收次数gc.ps_scavenge.count、垃圾回收消耗时间gc.ps_scavenge.time、标记-清除算法的次数gc.ps_marksweep.count、标记-清除算法的消耗时间gc.ps_marksweep.time。这些数据均来自java.lang.management.GarbageCollectorMXBean。
		httpsessions.*：Tomcat容器的会话使用情况。包括最大会话数httpsessions.max和活跃会话数httpsessions.active。该度量指标信息仅在引入了嵌入式Tomcat作为应用容器的时候才会提供。
		gauge.*：HTTP请求的性能指标之一，它主要用来反映一个绝对数值。比如上面示例中的gauge.response.hello: 5，它表示上一次hello请求的延迟时间为5毫秒。
		counter.*：HTTP请求的性能指标之一，它主要作为计数器来使用，记录了增加量和减少量。如上示例中counter.status.200.hello: 11，它代表了hello请求返回200状态的次数为11。
	B./dump:该端点用来暴露程序运行中的线程信息。
	C./trace：该端点用来返回基本的HTTP跟踪信息。默认情况下，跟踪信息的存储采用org.springframework.boot.actuate.trace.InMemoryTraceRepository实现的内存方式，始终保留最近的100条请求记录
	
	操作控制类：提供了对应用的关闭等操作类功能。
	A./shutdown:端点就能实现关闭该应用的远程操作。由于开放关闭应用的操作本身是一件非常危险的事，所以真正在线上使用的时候，我们需要对其加入一定的保护机制，比如：定制Actuator的端点路径、整合Spring Security进行安全校验等。
	需配置开启：endpoints.shutdown.enabled=true

 *
 */
@SpringBootApplication
public class SpringBootActuator {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootActuator.class, args);
	}
}
