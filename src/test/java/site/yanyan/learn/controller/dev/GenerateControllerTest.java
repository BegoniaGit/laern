package site.yanyan.learn.controller.dev;


import com.alibaba.fastjson.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import site.yanyan.learn.pojo.dev.GenerateInput;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateControllerTest {
	@Autowired
	GenerateController testObject;
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	@Before
	public void setUp() throws Exception { 
		//MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效） 
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		//单个类  拦截器无效
		//this.mockMvc = MockMvcBuilders.standaloneSetup(testObject).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() throws Exception {

		String tables[]={"problem","remark","answer"};  //表名
		String packageNamePrime="site.yanyan.learn.";

		GenerateInput t = new GenerateInput();
		t.setPackageName(packageNamePrime.substring(0,packageNamePrime.length()-1));
		t.setBeanPackageName(packageNamePrime+"pojo");
		t.setVoPackageName(packageNamePrime+"vo");
		t.setDaoPackageName(packageNamePrime+"dao");
		t.setServicePackageName(packageNamePrime+"service");
		t.setControllerPkgName(packageNamePrime+"controller");
		t.setDaotestPackageName(packageNamePrime+"test.dao"); //包
		t.setControllertestName(packageNamePrime+"test.controller"); //包
		t.setMybatisMapperPackageName("learn");//目录

		for(String table : tables)
		{
			t.setTableName(table);
			String jsonStr = JSONObject.toJSONString(t);
			MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/generate/createCode");
			builder.contentType(MediaType.APPLICATION_JSON);
			builder.content(jsonStr);
			MvcResult result = mockMvc.perform(builder).andReturn();
			  
			byte[] outstr = result.getResponse().getContentAsByteArray();
			String srt2=new String(outstr,"UTF-8");
			System.out.println(srt2);
		}
		
	} 
}