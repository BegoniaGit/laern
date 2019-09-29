package site.yanyan.learn.dao.serve;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.serve.SubjectQuery;
import site.yanyan.learn.pojo.serve.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SubjectDao {

   /**
      根据id删除Subject
   */
 //@Delete("delete from subject where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增Subject,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Subject record);
    
    /**
     *根据id查询Subject
     */
    Subject getById(Long id);

    /**
     *根据id更新Subject
     */ 
    int editById(Subject record);

    /**
     *分页查询所有Subject
     */    
    List<Subject> list(SubjectQuery param);
    
    /**
     *分页查询查询所有Subject
     */    
    List<Subject> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}