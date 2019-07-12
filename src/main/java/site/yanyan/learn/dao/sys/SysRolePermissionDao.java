package site.yanyan.learn.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.sys.SysRolePermissionQuery;
import site.yanyan.learn.pojo.sys.SysRolePermission;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRolePermissionDao {

   /**
      根据id删除SysRolePermission
   */
 //@Delete("delete from sys_role_permission where id = #{id,jdbcType=INTEGER}")
    int delByInfo(SysRolePermission sysRolePermission);
    
   /**
    *根据新增SysRolePermission,id自增
    */
    int save(SysRolePermission record);
    
    /**
     *根据id查询SysRolePermission
     */
    List<SysRolePermission> getByRoleId(Long roleId);


    /**
     *分页查询所有SysRolePermission
     */    
    List<SysRolePermission> list(SysRolePermissionQuery param);
    

}