/*
 * @Author: Runner 
 * @Description: 从配置文件或者 consul 读取配置文件的固定格式
 * @Date: 2018-08-09 16:06:21 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 16:07:11
 */

package nuctech.bigdata.microservice.servicetemplate.config;
 
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="testconfig")
public class  TestConfig{
  
    private String username;//要与consul上面一致
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
}