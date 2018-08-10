package nuctech.bigdata.microservice.servicetemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
// import lombok.extern.log4j.Log4j2;
import nuctech.bigdata.microservice.servicetemplate.repository.tb_device_infoRepository;
import nuctech.bigdata.microservice.servicetemplate.service.tb_device_infoService;
import nuctech.bigdata.microservice.servicetemplate.config.TestConfig;
// import nuctech.bigdata.microservice.servicetemplate.model.tb_device_infoTest;
// import nuctech.bigdata.microservice.servicetemplate.service.tb_device_infoTestService;
//@Log4j2
import nuctech.bigdata.microservice.servicetemplate.entities.ResponseObj;

import org.apache.logging.log4j.Logger;


import org.apache.logging.log4j.LogManager;

@Api(value = "TestController", description = " 一些常用测试实例，")
@RestController
public class TestController extends ControllerBase {

	private static final Logger logger = LogManager.getLogger(TestController.class);
	
	@GetMapping("/log")
	public ResponseObj logTest() {
	
		code = 0;
		logger.debug("log4j2 success ===== debug");
		logger.warn("log4j2 success ===== warn");
		logger.info("log4j2 success ===== info");
		logger.error("log4j2 success ===== error");
		return Result();
	}

	// #region 直接用 Repository 访问 数据库
	@Autowired
	private tb_device_infoRepository testre;

	@ApiOperation(value = "查询", notes = "查找所有" )
	@GetMapping("/all")
	// @RequestMapping( value="/findAll" ,method = RequestMethod.GET)
	public ResponseObj getAll() {
		code = 0;
		data = testre.findAll();
		return Result();
	}
	// #endregion

	// #region 经Service 访问数据库
	@Autowired
	private tb_device_infoService testservice;

	@GetMapping("/all2")
	public ResponseObj getAll2() {
		code = 0;
		data = testservice.getAll();
		return Result(); 
	}
	// #endregion

	// #region 读取consul 配置
	// 读取配置值 不会事实刷新
	@Value("${testconfig.username}")
	private String name;

	// 会实时刷新
	@Autowired
	private TestConfig cfg;

	@ApiOperation(value = "查找所有 Title", notes = "查找所有 一些描述 访问路径：/index/222?getname=aad")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "路径参数", required = false, dataType = "int", paramType = "path"),
		@ApiImplicitParam(name = "getname", value = "query 问号形式 参数测试", required = false, dataType = "String", paramType = "query"),
	})
	@GetMapping("/index/{id}")
	public ResponseObj index(
		@PathVariable("id") int id, 
		@RequestParam(required = false,defaultValue = "1") String getname ) {
				
			data = "from class : " + cfg.getUsername() + " from value:" + name
				+ "  get id:"+id 
				+ "  getname: "+getname;

		
			return Result();
	}
	// #endregion

	// #region 服务间通讯，以及网络通讯
	/*
	 * 用loadBalancer看下某服务的负载信息列表 用RestTemplate 服务间通讯
	 **/
	@Autowired
	private LoadBalancerClient loadBalancer;

	@GetMapping("/getinsinfo")
	public ResponseObj testRibbon() {
		// RestTemplate xx = new RestTemplate();
		ServiceInstance ins = loadBalancer.choose("servicetemplate");
		data = ins.getHost() + ":" + ins.getPort();
		return Result(); 
	}
	// #endregion

}
