/*
 * @Author: Runner 
 * @Description: 数据库实体对象 用于测试
 * @Date: 2018-08-09 16:02:25 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 16:03:02
 */

package nuctech.bigdata.microservice.servicetemplate.entities;
 
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class tb_device_info{
    
    public tb_device_info(){
        
    }

    @Id
    Long  id;
 
    String deviceGuid;
    String deviceType;
    String bizSite;
  
}
