package ${servicePackageName};

import ${beanPackageName}.${beanName};
import ${voPackageName}.${voName};
import java.util.List;
import ${packageName}.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface ${beanName}Service {


   /**
    *根据id删除${beanName}
    */
	Long delById(Long id);

   /**
    *根据新增${beanName}，id自增
    */
    Long save(${beanName} record);

   /**
    *根据id查询${beanName}
    */
    ${beanName} getById(Long id);
    
   /**
    *根据id更新${beanName}
    */ 
    Long editById(${beanName} record);

   /**
    *查询所有${beanName}
    */ 
    PageTableData<${beanName}> list(int pagenum, int pagesize,${voName} param);

    List<${beanName}> listAll(${voName} param);
}