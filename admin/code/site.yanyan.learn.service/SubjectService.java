package site.yanyan.learn.service;

import site.yanyan.learn.pojo.Subject;
import site.yanyan.learn.vo.SubjectQuery;
import java.util.List;
import site.yanyan.learn.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface SubjectService {


   /**
    *根据id删除Subject
    */
	Long delById(Long id);

   /**
    *根据新增Subject，id自增
    */
    Long save(Subject record);

   /**
    *根据id查询Subject
    */
    Subject getById(Long id);
    
   /**
    *根据id更新Subject
    */ 
    Long editById(Subject record);

   /**
    *查询所有Subject
    */ 
    PageTableData<Subject> list(int pagenum, int pagesize,SubjectQuery param);

    List<Subject> listAll(SubjectQuery param);
}