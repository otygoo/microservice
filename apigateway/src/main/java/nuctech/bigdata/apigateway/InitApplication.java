package nuctech.bigdata.apigateway;

import com.didispace.swagger.butler.EnableSwaggerButler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 网关
 * 路由
 * 前端应该使用 nginx keepalive 做负载
 * 第二层为 zuul集群
 * 第三层为 microservice
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableSwaggerButler
@SpringBootApplication
@RestController
public class InitApplication {

	@RequestMapping("/")
	public String index() {
		return "ApiGateway Config OK !";
	}

	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class, args);
	}
}
