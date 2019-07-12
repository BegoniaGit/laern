package site.yanyan.learn.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.sys.SysRoleQuery;
import site.yanyan.learn.pojo.sys.SysRole;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRoleDao {

   /**
      根据id删除SysRole
   */
 //@Delete("delete from sys_role where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增SysRole,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysRole record);
    
    /**
     *根据id查询SysRole
     */
    SysRole getById(Long id);

    /**
     *根据id更新SysRole
     */ 
    int editById(SysRole record);

    /**
     *分页查询所有SysRole
     */    
    List<SysRole> list(SysRoleQuery param);
    
    /**
     *分页查询查询所有SysRole
     */    
    List<SysRole> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}