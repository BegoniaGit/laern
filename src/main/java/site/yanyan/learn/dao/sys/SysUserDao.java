package site.yanyan.learn.dao.sys;
import java.util.List;

import org.apache.ibatis.annotations.*;
import site.yanyan.learn.vo.sys.LoginUserQuery;
import site.yanyan.learn.vo.sys.SysUserQuery;
import site.yanyan.learn.pojo.sys.SysUser;

@Mapper
public interface SysUserDao {

   /**
      根据id删除SysUser
   */
 //@Delete("delete from sys_user where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增SysUser,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(SysUser record);
    
    /**
     *根据id查询SysUser
     */
    SysUser getById(Long id);

    /**
     *根据id更新SysUser
     */ 
    int editById(SysUser record);

    /**
     *分页查询所有SysUser
     */    
    List<SysUser> list(SysUserQuery param);
    
    /**
     *分页查询查询所有SysUser
     */    
    List<SysUser> pagelist(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);


    @Select("SELECT COUNT(*) FROM sys_user")
    int getCount();


    SysUser getUserByInfo(LoginUserQuery loginUserQuery);
     
}