package site.yanyan.learn.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import site.yanyan.learn.vo.RemarkQuery;
import site.yanyan.learn.pojo.Remark;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RemarkDao {

   /**
      根据id删除Remark
   */
 //@Delete("delete from remark where id = #{id,jdbcType=INTEGER}")
    int delById(Long id);
    
   /**
    *根据新增Remark,id自增
    */
	@Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Remark record);
    
    /**
     *根据id查询Remark
     */
    Remark getById(Long id);

    /**
     *根据id更新Remark
     */ 
    int editById(Remark record);

    /**
     *分页查询所有Remark
     */    
    List<Remark> list(RemarkQuery param);
    
    /**
     *分页查询查询所有Remark
     */    
    List<Remark> pagelist(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
     
}