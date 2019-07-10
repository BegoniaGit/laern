package site.yanyan.learn.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.SysRolePermissionQuery;
import site.yanyan.learn.pojo.SysRolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRolePermissionDao {

   /**
      根据id删除SysRolePermission
   */
 //@Delete("delete from sys_role_permission where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增SysRolePermission,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysRolePermission record);
    
    /**
     *根据id查询SysRolePermission
     */
    SysRolePermission getById(Long id);

    /**
     *根据id更新SysRolePermission
     */ 
    int editById(SysRolePermission record);

    /**
     *分页查询所有SysRolePermission
     */    
    List<SysRolePermission> list(SysRolePermissionQuery param);
    
    /**
     *分页查询查询所有SysRolePermission
     */    
    List<SysRolePermission> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}