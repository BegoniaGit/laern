package site.yanyan.learn.service;

import site.yanyan.learn.pojo.Remark;
import site.yanyan.learn.vo.RemarkQuery;
import java.util.List;
import site.yanyan.learn.pojo.PageTableData;
import org.springframework.transaction.annotation.Transactional;
public interface RemarkService {


   /**
    *根据id删除Remark
    */
	Long delById(Long id);

   /**
    *根据新增Remark，id自增
    */
    Long save(Remark record);

   /**
    *根据id查询Remark
    */
    Remark getById(Long id);
    
   /**
    *根据id更新Remark
    */ 
    Long editById(Remark record);

   /**
    *查询所有Remark
    */ 
    PageTableData<Remark> list(int pagenum, int pagesize,RemarkQuery param);

    List<Remark> listAll(RemarkQuery param);
}