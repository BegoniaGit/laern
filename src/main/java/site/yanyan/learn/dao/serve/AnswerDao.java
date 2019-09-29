package site.yanyan.learn.dao.serve;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import site.yanyan.learn.pojo.serve.Answer;
import site.yanyan.learn.vo.serve.AnswerQuery;

import java.util.List;
@Mapper
public interface AnswerDao {

   /**
      根据id删除Answer
   */
 //@Delete("delete from answer where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增Answer,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Answer record);
    
    /**
     *根据id查询Answer
     */
    Answer getById(Long id);

    /**
     *根据id更新Answer
     */ 
    int editById(Answer record);

    /**
     *分页查询所有Answer
     */    
    List<Answer> list(AnswerQuery param);
    
    /**
     *分页查询查询所有Answer
     */    
    List<Answer> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}