package site.yanyan.learn.test.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.pojo.SubjectQuery;
import site.yanyan.learn.pojo.Subject;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import site.yanyan.learn.dao.SubjectDao;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class SubjectDaoTest {
 @Autowired
   SubjectDao testObject;
   
	@Test
	@Transactional
	/**测试查询所有数据,支持回滚*/
	public void testList() {
		SubjectQuery param = new SubjectQuery();
		List<Subject> list = testObject.list(param); 
    	System.out.println(list.size());
    	for(Subject  Subject : list)
		{
			System.out.println("Id:"+ Subject.getId());
		}
	}
	@Test
	@Transactional
	/**测试新增数据,支持回滚*/
	public void testAdd()
	{
		Subject Subject=new Subject();
		testObject.save(Subject);
	}
	@Test
	@Transactional
	/**测试查询数据,支持回滚*/ 
	public void pagelist()
	{
		List<Subject> list = testObject.pagelist(0,3);
		System.out.println(list.size());
		for(Subject Subject : list)
		{
			System.out.println("Id:"+Subject.getId());
		}
	}
	@Test
	@Transactional
	/**测试根据id查询数据,支持回滚*/
	public void TestgetById()
	{
		Subject Subject=testObject.getById((long)4);
		if (Subject!=null) {
			System.out.println("Id:"+Subject.getId());
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
		Subject Subject=testObject.getById((long)5);
		testObject.editById(Subject);
	} 
}