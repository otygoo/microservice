/*
 * @Author: Runner 
 * @Description: Controller 的 基类 
 * @Date: 2018-08-09 16:01:02 
 * @Last Modified by: Runner
 * @Last Modified time: 2018-08-09 18:50:46
 */
package nuctech.bigdata.microservice.servicetemplate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import nuctech.bigdata.microservice.servicetemplate.entities.ResponseObj;

public abstract class ControllerBase {

    int code = -1;
    Object data = null;
    String message = null;

    public ResponseObj Result() {
        ResponseObj obj = new ResponseObj(this.code,this.message);
        //obj.code = this.code;
        obj.setData(this.data);
        //obj.message = this.message;
        obj.setDatetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return obj;
    }

}
