package site.yanyan.learn.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.ProblemQuery;
import site.yanyan.learn.pojo.Problem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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