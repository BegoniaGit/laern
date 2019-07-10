package site.yanyan.learn.service;

import site.yanyan.learn.pojo.SysUserRole;
import site.yanyan.learn.vo.SysUserRoleQuery;
import java.util.List;
import site.yanyan.learn.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface SysUserRoleService {


   /**
    *根据id删除SysUserRole
    */
	Long delById(Long id);

   /**
    *根据新增SysUserRole，id自增
    */
    Long save(SysUserRole record);

   /**
    *根据id查询SysUserRole
    */
    SysUserRole getById(Long id);
    
   /**
    *根据id更新SysUserRole
    */ 
    Long editById(SysUserRole record);

   /**
    *查询所有SysUserRole
    */ 
    PageTableData<SysUserRole> list(int pagenum, int pagesize,SysUserRoleQuery param);

    List<SysUserRole> listAll(SysUserRoleQuery param);
}