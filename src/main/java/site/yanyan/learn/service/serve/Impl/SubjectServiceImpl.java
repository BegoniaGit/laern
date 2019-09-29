package site.yanyan.learn.service.serve.Impl;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.serve.SubjectDao;
import site.yanyan.learn.pojo.serve.Subject;
import site.yanyan.learn.vo.serve.SubjectQuery;
import site.yanyan.learn.service.serve.SubjectService;
import site.yanyan.learn.pojo.dev.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	public SubjectDao subjectDao;
	@Override
	public Long delById(Long id) {
	   subjectDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Subject record) {
		subjectDao.save(record);
		return record.getSubjectId();
	}

	@Override
	public Subject getById(Long id) {
		return subjectDao.getById(id);
	}


	@Override
	public Long editById(Subject record) {
		subjectDao.editById(record);
		return record.getSubjectId();
	}

	@Override
	public PageTableData<Subject> list(int pagenum, int pagesize,SubjectQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Subject> datalist = subjectDao.list(param);
		PageTableData<Subject> resultPage = new PageTableData<Subject>(datalist);
		PageInfo<Subject> p = new PageInfo<Subject>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<Subject> listAll(SubjectQuery param) {
		List<Subject> datalist = subjectDao.list(param);
		return datalist;
	}

}
