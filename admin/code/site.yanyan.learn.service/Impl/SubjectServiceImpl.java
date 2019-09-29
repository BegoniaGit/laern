package site.yanyan.learn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.SubjectDao;
import site.yanyan.learn.pojo.Subject;
import site.yanyan.learn.vo.SubjectQuery;
import site.yanyan.learn.service.SubjectService;
import site.yanyan.learn.pojo.PageTableData;
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
