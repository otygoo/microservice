/*
 * @Author: Runner 
 * @Description: Swagger 文档，需要配置显示的Controller包，否则显示会比较乱
 * @Date: 2018-08-09 15:58:25 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 16:00:49
 */

package nuctech.bigdata.microservice.servicetemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("nuctech.bigdata.microservice.servicetemplate.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}