package site.yanyan.learn.service;

import site.yanyan.learn.pojo.Problem;
import site.yanyan.learn.vo.ProblemQuery;
import java.util.List;
import site.yanyan.learn.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface ProblemService {


   /**
    *根据id删除Problem
    */
	Long delById(Long id);

   /**
    *根据新增Problem，id自增
    */
    Long save(Problem record);

   /**
    *根据id查询Problem
    */
    Problem getById(Long id);
    
   /**
    *根据id更新Problem
    */ 
    Long editById(Problem record);

   /**
    *查询所有Problem
    */ 
    PageTableData<Problem> list(int pagenum, int pagesize,ProblemQuery param);

    List<Problem> listAll(ProblemQuery param);
}