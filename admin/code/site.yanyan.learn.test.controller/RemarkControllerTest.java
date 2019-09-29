package site.yanyan.learn.test.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.alibaba.fastjson.JSONObject;

import site.yanyan.learn.vo.RemarkQuery;
import site.yanyan.learn.pojo.Remark;
import site.yanyan.learn.service.RemarkService;
import site.yanyan.learn.dao.RemarkDao;
import site.yanyan.learn.service.Impl.RemarkServiceImpl;
import site.yanyan.learn.controller.RemarkController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RemarkControllerTest {

    @Autowired
	public RemarkService remarkService;

    @Autowired
	public RemarkController testObject;

    private MockMvc mockMvc;

    @Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(testObject).build();
	}

    @After
    public void tearDown() throws Exception {
    }

    @Test
	public void testSave() throws Exception {
		Remark t = new Remark();

		String jsonStr = JSONObject.toJSONString(t);

		//访问路径需要手动填写  如/api/dicts
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/xxx/xxx");
		builder.contentType(MediaType.APPLICATION_JSON);
		builder.header("token", "e9bcd690-dfb5-40e8-860d-9e228952ed73");
		builder.content(jsonStr);
		MvcResult result = mockMvc.perform(builder).andReturn();
		System.out.println(result);

	}

}