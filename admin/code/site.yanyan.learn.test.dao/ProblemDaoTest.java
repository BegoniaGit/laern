package site.yanyan.learn.test.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.pojo.ProblemQuery;
import site.yanyan.learn.pojo.Problem;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import site.yanyan.learn.dao.ProblemDao;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class ProblemDaoTest {
 @Autowired
   ProblemDao testObject;
   
	@Test
	@Transactional
	/**测试查询所有数据,支持回滚*/
	public void testList() {
		ProblemQuery param = new ProblemQuery();
		List<Problem> list = testObject.list(param); 
    	System.out.println(list.size());
    	for(Problem  Problem : list)
		{
			System.out.println("Id:"+ Problem.getId());
		}
	}
	@Test
	@Transactional
	/**测试新增数据,支持回滚*/
	public void testAdd()
	{
		Problem Problem=new Problem();
		testObject.save(Problem);
	}
	@Test
	@Transactional
	/**测试查询数据,支持回滚*/ 
	public void pagelist()
	{
		List<Problem> list = testObject.pagelist(0,3);
		System.out.println(list.size());
		for(Problem Problem : list)
		{
			System.out.println("Id:"+Problem.getId());
		}
	}
	@Test
	@Transactional
	/**测试根据id查询数据,支持回滚*/
	public void TestgetById()
	{
		Problem Problem=testObject.getById((long)4);
		if (Problem!=null) {
			System.out.println("Id:"+Problem.getId());
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
		Problem Problem=testObject.getById((long)5);
		testObject.editById(Problem);
	} 
}