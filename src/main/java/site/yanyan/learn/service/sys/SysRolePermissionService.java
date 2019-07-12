package site.yanyan.learn.service.sys;

import site.yanyan.learn.pojo.sys.SysRolePermission;
import site.yanyan.learn.vo.sys.SysRolePermissionQuery;
import java.util.List;
import site.yanyan.learn.pojo.dev.PageTableData;

public interface SysRolePermissionService {





    SysRolePermission delByInfo(SysRolePermission sysRolePermission);

   /**
    *根据新增SysRolePermission，id自增
    */
   SysRolePermission save(SysRolePermission record);

   /**
    *根据id查询SysRolePermission
    */
    List<SysRolePermission> getByRoleId(Long id);


   /**
    *查询所有SysRolePermission
    */ 
    PageTableData<SysRolePermission> list(int pagenum, int pagesize,SysRolePermissionQuery param);


}