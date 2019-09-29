package site.yanyan.learn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.ProblemDao;
import site.yanyan.learn.pojo.Problem;
import site.yanyan.learn.vo.ProblemQuery;
import site.yanyan.learn.service.ProblemService;
import site.yanyan.learn.pojo.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class ProblemServiceImpl implements ProblemService{

	@Autowired
	public ProblemDao problemDao;
	@Override
	public Long delById(Long id) {
	   problemDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Problem record) {
		problemDao.save(record);
		return record.getProblemId();
	}

	@Override
	public Problem getById(Long id) {
		return problemDao.getById(id);
	}


	@Override
	public Long editById(Problem record) {
		problemDao.editById(record);
		return record.getProblemId();
	}

	@Override
	public PageTableData<Problem> list(int pagenum, int pagesize,ProblemQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Problem> datalist = problemDao.list(param);
		PageTableData<Problem> resultPage = new PageTableData<Problem>(datalist);
		PageInfo<Problem> p = new PageInfo<Problem>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<Problem> listAll(ProblemQuery param) {
		List<Problem> datalist = problemDao.list(param);
		return datalist;
	}

}
