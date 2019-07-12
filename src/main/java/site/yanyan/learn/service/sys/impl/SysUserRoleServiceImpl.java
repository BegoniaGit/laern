package site.yanyan.learn.service.sys.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.sys.SysUserRoleDao;
import site.yanyan.learn.pojo.sys.SysUserRole;
import site.yanyan.learn.vo.sys.SysUserRoleQuery;
import site.yanyan.learn.service.sys.SysUserRoleService;
import site.yanyan.learn.pojo.dev.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService{

	@Autowired
	public SysUserRoleDao sysUserRoleDao;
	@Override
	public Long delById(Long id) {
	   sysUserRoleDao.delById(id);
	   return id;
	}

	@Override
	public Long save(SysUserRole record) {
		sysUserRoleDao.save(record);
		return record.getUserId();
	}

	@Override
	public SysUserRole getById(Long id) {
		return sysUserRoleDao.getById(id);
	}


	@Override
	public Long editById(SysUserRole record) {
		sysUserRoleDao.editById(record);
		return record.getUserId();
	}

	@Override
	public PageTableData<SysUserRole> list(int pagenum, int pagesize,SysUserRoleQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<SysUserRole> datalist = sysUserRoleDao.list(param);
		PageTableData<SysUserRole> resultPage = new PageTableData<SysUserRole>(datalist);
		PageInfo<SysUserRole> p = new PageInfo<SysUserRole>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<SysUserRole> listAll(SysUserRoleQuery param) {
		List<SysUserRole> datalist = sysUserRoleDao.list(param);
		return datalist;
	}

}
