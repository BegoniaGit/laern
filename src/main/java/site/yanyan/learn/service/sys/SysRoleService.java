package site.yanyan.learn.service.sys;


import site.yanyan.learn.pojo.dev.PageTableData;
import site.yanyan.learn.pojo.sys.SysRole;
import site.yanyan.learn.vo.sys.SysRoleQuery;

import java.util.List;
public interface SysRoleService {


   /**
    *根据id删除SysRole
    */
	Long delById(Long id);

   /**
    *根据新增SysRole，id自增
    */
    Long save(SysRole record);

   /**
    *根据id查询SysRole
    */
    SysRole getById(Long id);
    
   /**
    *根据id更新SysRole
    */ 
    Long editById(SysRole record);

   /**
    *查询所有SysRole
    */ 
    PageTableData<SysRole> list(int pagenum, int pagesize, SysRoleQuery param);

    List<SysRole> listAll(SysRoleQuery param);
}