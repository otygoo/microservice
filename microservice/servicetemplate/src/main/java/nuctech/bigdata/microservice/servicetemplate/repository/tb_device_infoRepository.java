/*
 * @Author: Runner 
 * @Description: 测试数据仓储 Repository  只需要extends  JpaRepository<T 即可支持默认的一些操作
 * @Date: 2018-08-09 16:03:35 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 16:04:17
 */
package nuctech.bigdata.microservice.servicetemplate.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import nuctech.bigdata.microservice.servicetemplate.entities.tb_device_info;

public interface tb_device_infoRepository extends  JpaRepository<tb_device_info, Integer> {

}