package site.yanyan.learn.controller.dev;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.yanyan.learn.pojo.dev.GenerateInput;
import site.yanyan.learn.service.dev.GenerateService;
import site.yanyan.learn.utils.Freemarker;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成接口
 *  
 */
@Api(tags = "代码生成")
@RestController
@RequestMapping("/generate")
public class GenerateController {

	@Autowired
	private GenerateService generateService;

	@ApiOperation("生成代码")
	@PostMapping(value="/createCode")
	public GenerateInput save(@RequestBody GenerateInput input) throws Exception {
		String tableName = generateService.upperFirstChar(input.getTableName());

		if (input.getBeanName()==null)		
			input.setBeanName(generateService.upperFirstChar(tableName));
		
		if (input.getVoName()==null)		
			input.setVoName(generateService.upperFirstChar(tableName)+"Query");
		
		if (input.getDaoName()==null)		
			input.setDaoName(generateService.upperFirstChar(tableName)+"Dao");
	
		if (input.getMybatisMapperName()==null)		
			input.setMybatisMapperName(generateService.upperFirstChar(tableName)+"Mapper");

		if (input.getServiceName()==null)
			input.setServiceName(generateService.upperFirstChar(tableName)+"Service");
	
		if (input.getControllerName()==null)		
			input.setControllerName(generateService.upperFirstChar(tableName)+"Controller");
		
		if (input.getHtmlName()==null)		
			input.setHtmlName(generateService.upperFirstChar(tableName)+"Html");

		if (input.getControllertestName()==null)
			input.setHtmlName(generateService.upperFirstChar(tableName)+"TestController");

		input.setFields(generateService.listBeanField(input.getTableName()));
	
		
		String beanPackageName = input.getBeanPackageName();
		String voPackageName = input.getVoPackageName();
		String voName = input.getVoName();
		String beanName = input.getBeanName();
		String htmlPackageName = input.getHtmlPackageName();
		String daoPackageName = input.getDaoPackageName();
		String daotestPackageName = input.getDaotestPackageName();
		String mybatisMapperPackageName = input.getMybatisMapperPackageName();
		String servicePackageName = input.getServicePackageName();
		String controllerPackageName = input.getControllerPkgName();
		String classUrl = input.getClassUrl();
		String  controllertestPackageName= input.getControllertestName();
		Map<String,Object> root = new HashMap<String,Object>();		//创建数据模型
		root.put("fieldList", input.getFields());
		root.put("packageName",input.getPackageName());
		root.put("beanPackageName", beanPackageName);						//首字母大写
		root.put("beanName", beanName);								//包名首字母大写	
		root.put("nowDate", new Date());							//当前日期
		root.put("voPackageName", voPackageName);                   //数据查询类
	 	root.put("voName", voName);      
		root.put("daoPackageName", daoPackageName);
		root.put("daotestPackageName", daotestPackageName);
		root.put("servicePackageName",servicePackageName);
		root.put("controllerPackageName",controllerPackageName);
		root.put("tableName", input.getTableName());
		root.put("classUrl", classUrl);
		root.put("controllertestPackageName", controllertestPackageName);

		
		String filePath = "admin/code/";		
		//存放路径
		String ftlPath =  "createCode/";								//ftl路径
		/*生成pojo*/
		Freemarker.printFile("pojoTemplate.ftl", root, beanPackageName+"/"+beanName+".java", filePath, ftlPath);

		/*生成vo*/
		Freemarker.printFile("voTemplate.ftl", root, voPackageName+"/"+beanName+"Query.java", filePath, ftlPath);

		/*生成dao*/
		Freemarker.printFile("daoTemplate.ftl", root, daoPackageName+"/"+beanName+"Dao.java", filePath, ftlPath);
		/*生成dao*/
		Freemarker.printFile("daotestTemplate.ftl", root, daotestPackageName+"/"+beanName+"DaoTest.java", filePath, ftlPath);

		
		/*生成service*/
		Freemarker.printFile("serviceTemplate.ftl", root, servicePackageName+"/"+beanName+"Service.java", filePath, ftlPath);

		/*生成serviceImp*/
		Freemarker.printFile("serviceImplTemplate.ftl", root, servicePackageName+"/Impl/"+beanName+"ServiceImpl.java", filePath, ftlPath);

		/*生成controller*/
		Freemarker.printFile("controllerTemplate.ftl", root, controllerPackageName+"/"+beanName+"Controller.java", filePath, ftlPath);

		/*生成mapper*/
		Freemarker.printFile("mybatisMapperTemplate.ftl", root, mybatisMapperPackageName+"/"+beanName+"Mapper.xml", filePath, ftlPath);

		Freemarker.printFile("controllerTestTemplate.ftl", root, controllertestPackageName+"/"+beanName+"ControllerTest.java", filePath, ftlPath);

		return input;
	}
	
	

}
