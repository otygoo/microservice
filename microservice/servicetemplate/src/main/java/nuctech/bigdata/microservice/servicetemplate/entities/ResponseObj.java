/*
 * @Author: Runner 
 * @Description: 统一的Api输出数据结构
 * @Date: 2018-08-09 16:02:05 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-10 08:27:48
 */
package nuctech.bigdata.microservice.servicetemplate.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "接口输出数据结构")
@Data
public class ResponseObj  {
  
    public ResponseObj(int code, String msg) {
        setCode(code);
        setMessage(msg);
    }
    @ApiModelProperty(value = "响应码")
    public int code = -1;

    @ApiModelProperty(value = "响应数据")
    public Object data = null;

    @ApiModelProperty(value = "响应异常时的提示信息")
    public String message = null;
    
    @ApiModelProperty(value = "响应时间")
    public String datetime;
  

}