package site.yanyan.learn.service.sys.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.sys.SysRolePermissionDao;
import site.yanyan.learn.pojo.sys.SysRolePermission;
import site.yanyan.learn.vo.sys.SysRolePermissionQuery;
import site.yanyan.learn.service.sys.SysRolePermissionService;
import site.yanyan.learn.pojo.dev.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService{

	@Autowired
	public SysRolePermissionDao sysRolePermissionDao;

	@Override
	public SysRolePermission delByInfo(SysRolePermission sysRolePermission) {
	   sysRolePermissionDao.delByInfo(sysRolePermission);
	   return sysRolePermission;
	}

	@Override
	public SysRolePermission save(SysRolePermission record) {
		sysRolePermissionDao.save(record);
		return record;
	}

	@Override
	public List<SysRolePermission> getByRoleId(Long roleId)
	{
		return sysRolePermissionDao.getByRoleId(roleId);
	}


	@Override
	public PageTableData<SysRolePermission> list(int pagenum, int pagesize,SysRolePermissionQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<SysRolePermission> datalist = sysRolePermissionDao.list(param);
		PageTableData<SysRolePermission> resultPage = new PageTableData<SysRolePermission>(datalist);
		PageInfo<SysRolePermission> p = new PageInfo<SysRolePermission>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}


}
