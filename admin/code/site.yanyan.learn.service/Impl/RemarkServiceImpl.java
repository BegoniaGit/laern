package site.yanyan.learn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.RemarkDao;
import site.yanyan.learn.pojo.Remark;
import site.yanyan.learn.vo.RemarkQuery;
import site.yanyan.learn.service.RemarkService;
import site.yanyan.learn.pojo.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class RemarkServiceImpl implements RemarkService{

	@Autowired
	public RemarkDao remarkDao;
	@Override
	public Long delById(Long id) {
	   remarkDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Remark record) {
		remarkDao.save(record);
		return record.getRemarkId();
	}

	@Override
	public Remark getById(Long id) {
		return remarkDao.getById(id);
	}


	@Override
	public Long editById(Remark record) {
		remarkDao.editById(record);
		return record.getRemarkId();
	}

	@Override
	public PageTableData<Remark> list(int pagenum, int pagesize,RemarkQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Remark> datalist = remarkDao.list(param);
		PageTableData<Remark> resultPage = new PageTableData<Remark>(datalist);
		PageInfo<Remark> p = new PageInfo<Remark>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<Remark> listAll(RemarkQuery param) {
		List<Remark> datalist = remarkDao.list(param);
		return datalist;
	}

}
