package ${daoPackageName};
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ${voPackageName}.${beanName}Query;
import ${beanPackageName}.${beanName};
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ${beanName}Dao {

   /**
      根据id删除${beanName}
   */
 //@Delete("delete from ${tableName} where id = ${r'#{id,jdbcType=INTEGER}'}")
    int delById(Long id);
    
   /**
    *根据新增${beanName},id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(${beanName} record);
    
    /**
     *根据id查询${beanName}
     */
    ${beanName} getById(Long id);

    /**
     *根据id更新${beanName}
     */ 
    int editById(${beanName} record);

    /**
     *分页查询所有${beanName}
     */    
    List<${beanName}> list(${beanName}Query param);
    
    /**
     *分页查询查询所有${beanName}
     */    
    List<${beanName}> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}