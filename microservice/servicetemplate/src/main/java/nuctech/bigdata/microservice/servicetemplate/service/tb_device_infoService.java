/*
 * @Author: Runner 
 * @Description: 
 * @Date: 2018-08-09 16:04:23 
 * @Last Modified by:   Runner 
 * @Last Modified time: 2018-08-09 16:04:23 
 */
package nuctech.bigdata.microservice.servicetemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nuctech.bigdata.microservice.servicetemplate.repository.tb_device_infoRepository;
import nuctech.bigdata.microservice.servicetemplate.entities.tb_device_info; 
 
@Service
public class tb_device_infoService {
    @Autowired
    private tb_device_infoRepository tb_device_infoRepository;

    public Iterable<tb_device_info> getAll(){
        Iterable<tb_device_info> tb_device_infoTestList = tb_device_infoRepository.findAll();
        return tb_device_infoTestList;
    }

    public tb_device_info findByIdUser(Integer id){
        tb_device_info  xx = tb_device_infoRepository.findById(id).get();
        return xx;
    }

    public tb_device_info addTb_device_infoTest(tb_device_info xx){
        tb_device_info xxx = tb_device_infoRepository.save(xx);
        return xxx;
    }
    public void deleteTb_device_infoTest(Integer id){
        tb_device_infoRepository.deleteById(id);
    }

}