package site.yanyan.learn.test.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.pojo.RemarkQuery;
import site.yanyan.learn.pojo.Remark;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import site.yanyan.learn.dao.RemarkDao;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class RemarkDaoTest {
 @Autowired
   RemarkDao testObject;
   
	@Test
	@Transactional
	/**测试查询所有数据,支持回滚*/
	public void testList() {
		RemarkQuery param = new RemarkQuery();
		List<Remark> list = testObject.list(param); 
    	System.out.println(list.size());
    	for(Remark  Remark : list)
		{
			System.out.println("Id:"+ Remark.getId());
		}
	}
	@Test
	@Transactional
	/**测试新增数据,支持回滚*/
	public void testAdd()
	{
		Remark Remark=new Remark();
		testObject.save(Remark);
	}
	@Test
	@Transactional
	/**测试查询数据,支持回滚*/ 
	public void pagelist()
	{
		List<Remark> list = testObject.pagelist(0,3);
		System.out.println(list.size());
		for(Remark Remark : list)
		{
			System.out.println("Id:"+Remark.getId());
		}
	}
	@Test
	@Transactional
	/**测试根据id查询数据,支持回滚*/
	public void TestgetById()
	{
		Remark Remark=testObject.getById((long)4);
		if (Remark!=null) {
			System.out.println("Id:"+Remark.getId());
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
		Remark Remark=testObject.getById((long)5);
		testObject.editById(Remark);
	} 
}