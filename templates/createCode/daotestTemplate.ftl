package ${daotestPackageName};
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ${beanPackageName}.${beanName}Query;
import ${beanPackageName}.${beanName};
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ${daoPackageName}.${beanName}Dao;
@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest
public class ${beanName}DaoTest {
 @Autowired
   ${beanName}Dao testObject;
   
	@Test
	@Transactional
	/**测试查询所有数据,支持回滚*/
	public void testList() {
		${beanName}Query param = new ${beanName}Query();
		List<${beanName}> list = testObject.list(param); 
    	System.out.println(list.size());
    	for(${beanName}  ${beanName} : list)
		{
			System.out.println("Id:"+ ${beanName}.getId());
		}
	}
	@Test
	@Transactional
	/**测试新增数据,支持回滚*/
	public void testAdd()
	{
		${beanName} ${beanName}=new ${beanName}();
		testObject.save(${beanName});
	}
	@Test
	@Transactional
	/**测试查询数据,支持回滚*/ 
	public void pagelist()
	{
		List<${beanName}> list = testObject.pagelist(0,3);
		System.out.println(list.size());
		for(${beanName} ${beanName} : list)
		{
			System.out.println("Id:"+${beanName}.getId());
		}
	}
	@Test
	@Transactional
	/**测试根据id查询数据,支持回滚*/
	public void TestgetById()
	{
		${beanName} ${beanName}=testObject.getById((long)4);
		if (${beanName}!=null) {
			System.out.println("Id:"+${beanName}.getId());
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
		${beanName} ${beanName}=testObject.getById((long)5);
		testObject.editById(${beanName});
	} 
}