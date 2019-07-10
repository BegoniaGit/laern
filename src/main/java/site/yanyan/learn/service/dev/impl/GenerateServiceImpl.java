package site.yanyan.learn.service.dev.impl;

import com.google.common.collect.Maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import site.yanyan.learn.pojo.dev.BeanField;
import site.yanyan.learn.pojo.dev.GenerateInput;
import site.yanyan.learn.service.dev.GenerateService;
import site.yanyan.learn.utils.StrUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class GenerateServiceImpl implements GenerateService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<BeanField> beanFieldMapper = new RowMapper<BeanField>() {

		@Override
		public BeanField mapRow(ResultSet rs, int paramInt) throws SQLException {
			BeanField beanField = new BeanField();
			beanField.setColumnName(rs.getString("column_name"));
			beanField.setColumnType(rs.getString("data_type"));
			beanField.setColumnComment(rs.getString("column_comment"));
			beanField.setColumnDefault(rs.getString("column_default"));
			beanField.setColumLength(subString(rs.getString("column_type"),"(",")"));
			//获取数据表字段的长度
			return beanField;
		}
	};
	
	
	/*字符串分割*/
	
	public static String subString(String str, String strStart, String strEnd) {  
		  
        /* 找出指定的2个字符在 该字符串里面的 位置 */  
        int strStartIndex = str.indexOf(strStart);  
        int strEndIndex = str.indexOf(strEnd);  
  
        /* index 为负数 即表示该字符串中 没有该字符 */  
        if (strStartIndex < 0) {  
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";  
        }  
        if (strEndIndex < 0) {  
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";  
        }  
        /* 开始截取 */  
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());  
        return result;  
    } 

	@Override
	public List<BeanField> listBeanField(String tableName) {
		List<BeanField> beanFields = jdbcTemplate.query(
				"select column_name, data_type, column_comment,column_type,column_default FROM information_schema.columns WHERE table_name= ? and table_schema = (select database())",
				new String[] { tableName }, beanFieldMapper);
		
		//"SELECT a.name,b.name,c.DATA_TYPE,b.max_length FROM sys.tables a join sys.columns b on b.object_id = a.object_id join INFORMATION_SCHEMA.COLUMNS c on b.name=c.COLUMN_NAME and a.name=c.TABLE_NAME where a.name=tableName";
		
		if (CollectionUtils.isEmpty(beanFields)) {
			throw new IllegalArgumentException("表" + tableName + "不存在");
		}

		beanFields.parallelStream().forEach(b -> {
			b.setName(StrUtil.str2hump(b.getColumnName()));
			String type = map.get(b.getColumnType());
			String jdbcType = jdbcMap.get(b.getColumnType());
			if (type == null) {
				type = String.class.getSimpleName();
			}
			b.setType(type);
			b.setJdbcType(jdbcType);
			if ("id".equals(b.getName())) {
				b.setType(Long.class.getSimpleName());
			}

			b.setColumnDefault(b.getColumnDefault() == null ? "" : b.getColumnDefault());
		});

		return beanFields;
	}

	/**
	 * mysql类型与java类型部分对应关系
	 */
	private static Map<String, String> map = Maps.newHashMap();
	static {
		map.put("int", Long.class.getSimpleName());
		map.put("tinyint", Integer.class.getSimpleName());
		map.put("double", Double.class.getSimpleName());
		map.put("float", Float.class.getSimpleName());
		map.put("decimal", BigDecimal.class.getSimpleName());
		map.put("date", Date.class.getSimpleName());
		map.put("timestamp", Timestamp.class.getSimpleName());
		map.put("datetime", Date.class.getSimpleName());
		map.put("varchar", String.class.getSimpleName());
		map.put("text", String.class.getSimpleName());
		map.put("longtext", String.class.getSimpleName());
		map.put("blob", String.class.getSimpleName());
		

	}
	
	private static Map<String, String> jdbcMap = Maps.newHashMap();
	static {
		jdbcMap.put("int", "INTEGER");
		jdbcMap.put("tinyint", "INTEGER");
		jdbcMap.put("double", "DOUBLE");
		jdbcMap.put("float", "FLOAT");
		jdbcMap.put("decimal", "DECIMAL");
		jdbcMap.put("date", "DATE");
		jdbcMap.put("char", "CHAR");
		jdbcMap.put("timestamp", "TIMESTAMP");
		jdbcMap.put("datetime", "DATE");
		jdbcMap.put("varchar", "VARCHAR");
		jdbcMap.put("text", "VARCHAR");
		jdbcMap.put("longtext", "VARCHAR");
		jdbcMap.put("blob", "VARCHAR");

	}

	@Override
	public String upperFirstChar(String string) {
		String name = StrUtil.str2hump(string);
		String firstChar = name.substring(0, 1);
		name = name.replaceFirst(firstChar, firstChar.toUpperCase());
		return name;
	}

	@Override
	public void saveCode(GenerateInput input) {
		return;
	}

}
