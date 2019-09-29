package site.yanyan.learn.service.serve.Impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.serve.ProblemDao;
import site.yanyan.learn.pojo.serve.Problem;
import site.yanyan.learn.vo.serve.ProblemQuery;
import site.yanyan.learn.service.serve.ProblemService;
import site.yanyan.learn.pojo.dev.PageTableData;
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
