package site.yanyan.learn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yanyan.learn.dao.AnswerDao;
import site.yanyan.learn.pojo.Answer;
import site.yanyan.learn.vo.AnswerQuery;
import site.yanyan.learn.service.AnswerService;
import site.yanyan.learn.pojo.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	public AnswerDao answerDao;
	@Override
	public Long delById(Long id) {
	   answerDao.delById(id);
	   return id;
	}

	@Override
	public Long save(Answer record) {
		answerDao.save(record);
		return record.getAnswerId();
	}

	@Override
	public Answer getById(Long id) {
		return answerDao.getById(id);
	}


	@Override
	public Long editById(Answer record) {
		answerDao.editById(record);
		return record.getAnswerId();
	}

	@Override
	public PageTableData<Answer> list(int pagenum, int pagesize,AnswerQuery param) {
		PageHelper.startPage(pagenum, pagesize);
		List<Answer> datalist = answerDao.list(param);
		PageTableData<Answer> resultPage = new PageTableData<Answer>(datalist);
		PageInfo<Answer> p = new PageInfo<Answer>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<Answer> listAll(AnswerQuery param) {
		List<Answer> datalist = answerDao.list(param);
		return datalist;
	}

}
