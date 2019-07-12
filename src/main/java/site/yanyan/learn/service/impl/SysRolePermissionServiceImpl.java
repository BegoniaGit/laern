package site.yanyan.learn.service.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.SysRolePermissionDao;
import site.yanyan.learn.pojo.sys.SysRolePermission;
import site.yanyan.learn.vo.SysRolePermissionQuery;
import site.yanyan.learn.service.SysRolePermissionService;
import site.yanyan.learn.pojo.dev.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService{

	@Autowired
	public SysRolePermissionDao sysRolePermissionDao;
	@Override
	public Long delById(Long id) {
	   sysRolePermissionDao.delById(id);
	   return id;
	}

	@Override
	public Long save(SysRolePermission record) {
		sysRolePermissionDao.save(record);
		return record.getPermissionId();
	}

	@Override
	public SysRolePermission getById(Long id) {
		return sysRolePermissionDao.getById(id);
	}


	@Override
	public Long editById(SysRolePermission record) {
		sysRolePermissionDao.editById(record);
		return record.getPermissionId();
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

@Override
	public List<SysRolePermission> listAll(SysRolePermissionQuery param) {
		List<SysRolePermission> datalist = sysRolePermissionDao.list(param);
		return datalist;
	}

}
