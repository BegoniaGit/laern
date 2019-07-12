package site.yanyan.learn.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.sys.SysPermissionQuery;
import site.yanyan.learn.pojo.sys.SysPermission;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysPermissionDao {

   /**
      根据id删除SysPermission
   */
 //@Delete("delete from sys_permission where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增SysPermission,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysPermission record);
    
    /**
     *根据id查询SysPermission
     */
    SysPermission getById(Long id);

    /**
     *根据id更新SysPermission
     */ 
    int editById(SysPermission record);

    /**
     *分页查询所有SysPermission
     */    
    List<SysPermission> list(SysPermissionQuery param);

    /**
     *分页查询所有SysPermission
     */
    List<SysPermission> listByRoleId(Long roleId);



    
    /**
     *分页查询查询所有SysPermission
     */    
    List<SysPermission> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}