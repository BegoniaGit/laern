package site.yanyan.learn.service.impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.SysUserDao;
import site.yanyan.learn.pojo.PageTableData;
import site.yanyan.learn.pojo.SysUser;
import site.yanyan.learn.vo.SysUserQuery;
import site.yanyan.learn.service.SysUserService;

import com.github.pagehelper.PageHelper;
@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	public SysUserDao sysUserDao;
	@Override
	public Long delById(Long id) {
	   sysUserDao.delById(id);
	   return id;
	}

	@Override
	public Long save(SysUser record) {
		sysUserDao.save(record);
		return record.getUserId();
	}

	@Override
	public SysUser getById(Long id) {
		return sysUserDao.getById(id);
	}


	@Override
	public Long editById(SysUser record) {
		sysUserDao.editById(record);
		return record.getUserId();
	}

	@Override
	public PageTableData<SysUser> list(int pagenum, int pagesize, SysUserQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<SysUser> datalist = sysUserDao.list(param);
		PageTableData<SysUser> resultPage = new PageTableData<SysUser>(datalist);
		PageInfo<SysUser> p = new PageInfo<SysUser>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<SysUser> listAll(SysUserQuery param) {
		List<SysUser> datalist = sysUserDao.list(param);
		return datalist;
	}

}
