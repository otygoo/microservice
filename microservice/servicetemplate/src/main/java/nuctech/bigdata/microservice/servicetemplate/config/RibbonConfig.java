// package nuctech.bigdata.microservice.servicetemplate.Config;

// import java.nio.charset.StandardCharsets;

// import org.springframework.cloud.client.loadbalancer.LoadBalanced;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.converter.StringHttpMessageConverter;
// import org.springframework.web.client.RestTemplate;

// /**
//  * 整理到通用库
//  */
// @Configuration
// public class RibbonConfig {
// 	@Bean
// 	@LoadBalanced
// 	RestTemplate restTemplate() {
// 		RestTemplate restTemplate = new RestTemplate();
// 		// restTemplate.getForObject(url,obj.class); 可自动把返回数据转化为对象
// 		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
// 		return restTemplate;
// 	}

// }