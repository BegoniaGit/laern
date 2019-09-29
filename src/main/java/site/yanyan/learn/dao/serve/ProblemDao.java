package site.yanyan.learn.dao.serve;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import site.yanyan.learn.pojo.serve.Problem;
import site.yanyan.learn.vo.serve.ProblemQuery;

import java.util.List;
@Mapper
public interface ProblemDao {

   /**
      根据id删除Problem
   */
 //@Delete("delete from problem where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增Problem,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Problem record);
    
    /**
     *根据id查询Problem
     */
    Problem getById(Long id);

    /**
     *根据id更新Problem
     */ 
    int editById(Problem record);

    /**
     *分页查询所有Problem
     */    
    List<Problem> list(ProblemQuery param);
    
    /**
     *分页查询查询所有Problem
     */    
    List<Problem> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}