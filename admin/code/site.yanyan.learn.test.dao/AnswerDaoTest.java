package site.yanyan.learn.test.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.pojo.AnswerQuery;
import site.yanyan.learn.pojo.Answer;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import site.yanyan.learn.dao.AnswerDao;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class AnswerDaoTest {
 @Autowired
   AnswerDao testObject;
   
	@Test
	@Transactional
	/**测试查询所有数据,支持回滚*/
	public void testList() {
		AnswerQuery param = new AnswerQuery();
		List<Answer> list = testObject.list(param); 
    	System.out.println(list.size());
    	for(Answer  Answer : list)
		{
			System.out.println("Id:"+ Answer.getId());
		}
	}
	@Test
	@Transactional
	/**测试新增数据,支持回滚*/
	public void testAdd()
	{
		Answer Answer=new Answer();
		testObject.save(Answer);
	}
	@Test
	@Transactional
	/**测试查询数据,支持回滚*/ 
	public void pagelist()
	{
		List<Answer> list = testObject.pagelist(0,3);
		System.out.println(list.size());
		for(Answer Answer : list)
		{
			System.out.println("Id:"+Answer.getId());
		}
	}
	@Test
	@Transactional
	/**测试根据id查询数据,支持回滚*/
	public void TestgetById()
	{
		Answer Answer=testObject.getById((long)4);
		if (Answer!=null) {
			System.out.println("Id:"+Answer.getId());
		}
		else
		{
			System.err.println("null");
		}
	}
	
	@Test
	@Transactional
	/**测试编辑数据,支持回滚*/ 
	public void TestUpdate()
	{
		Answer Answer=testObject.getById((long)5);
		testObject.editById(Answer);
	} 
}