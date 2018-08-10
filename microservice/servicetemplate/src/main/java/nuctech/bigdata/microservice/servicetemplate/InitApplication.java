/*
 * @Author: Runner 
 * @Description: 微服务入口类
 * @Date: 2018-08-09 16:04:42 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 16:05:47
 */
package nuctech.bigdata.microservice.servicetemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import nuctech.bigdata.microservice.servicetemplate.config.TestConfig;

@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties({ TestConfig.class })
@SpringBootApplication
public class InitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class, args);
	}

	@Value("${spring.application.name}")
	String servername;
	@Value("${server.port}")
	String serverport;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String index() {
		return "Config OK ,"+servername + " is runing on port : " + serverport;
	}

}
