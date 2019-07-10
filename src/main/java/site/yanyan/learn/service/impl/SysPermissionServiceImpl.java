package site.yanyan.learn.service.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.SysPermissionDao;
import site.yanyan.learn.pojo.SysPermission;
import site.yanyan.learn.vo.SysPermissionQuery;
import site.yanyan.learn.service.SysPermissionService;
import site.yanyan.learn.pojo.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class SysPermissionServiceImpl implements SysPermissionService{

	@Autowired
	public SysPermissionDao sysPermissionDao;
	@Override
	public Long delById(Long id) {
	   sysPermissionDao.delById(id);
	   return id;
	}

	@Override
	public Long save(SysPermission record) {
		sysPermissionDao.save(record);
		return record.getPermissionId();
	}

	@Override
	public SysPermission getById(Long id) {
		return sysPermissionDao.getById(id);
	}


	@Override
	public Long editById(SysPermission record) {
		sysPermissionDao.editById(record);
		return record.getPermissionId();
	}

	@Override
	public PageTableData<SysPermission> list(int pagenum, int pagesize,SysPermissionQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<SysPermission> datalist = sysPermissionDao.list(param);
		PageTableData<SysPermission> resultPage = new PageTableData<SysPermission>(datalist);
		PageInfo<SysPermission> p = new PageInfo<SysPermission>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<SysPermission> listAll(SysPermissionQuery param) {
		List<SysPermission> datalist = sysPermissionDao.list(param);
		return datalist;
	}

}
