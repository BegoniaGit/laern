package site.yanyan.learn.service;

import site.yanyan.learn.pojo.SysRolePermission;
import site.yanyan.learn.vo.SysRolePermissionQuery;
import java.util.List;
import site.yanyan.learn.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface SysRolePermissionService {


   /**
    *根据id删除SysRolePermission
    */
	Long delById(Long id);

   /**
    *根据新增SysRolePermission，id自增
    */
    Long save(SysRolePermission record);

   /**
    *根据id查询SysRolePermission
    */
    SysRolePermission getById(Long id);
    
   /**
    *根据id更新SysRolePermission
    */ 
    Long editById(SysRolePermission record);

   /**
    *查询所有SysRolePermission
    */ 
    PageTableData<SysRolePermission> list(int pagenum, int pagesize,SysRolePermissionQuery param);

    List<SysRolePermission> listAll(SysRolePermissionQuery param);
}