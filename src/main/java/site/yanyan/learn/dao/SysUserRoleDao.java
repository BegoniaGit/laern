package site.yanyan.learn.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.SysUserRoleQuery;
import site.yanyan.learn.pojo.sys.SysUserRole;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysUserRoleDao {

   /**
      根据id删除SysUserRole
   */
 //@Delete("delete from sys_user_role where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增SysUserRole,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysUserRole record);
    
    /**
     *根据id查询SysUserRole
     */
    SysUserRole getById(Long id);

    /**
     *根据id更新SysUserRole
     */ 
    int editById(SysUserRole record);

    /**
     *分页查询所有SysUserRole
     */    
    List<SysUserRole> list(SysUserRoleQuery param);
    
    /**
     *分页查询查询所有SysUserRole
     */    
    List<SysUserRole> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}