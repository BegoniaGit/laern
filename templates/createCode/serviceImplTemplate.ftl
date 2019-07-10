package ${servicePackageName}.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${daoPackageName}.${beanName}Dao;
import ${beanPackageName}.${beanName};
import ${voPackageName}.${voName};
import ${servicePackageName}.${beanName}Service;
import ${packageName}.pojo.PageTableData;
import com.github.pagehelper.PageHelper;
@Service
public class ${beanName}ServiceImpl implements ${beanName}Service{

	@Autowired
	public ${beanName}Dao ${beanName?uncap_first}Dao;
	@Override
	public Long delById(Long id) {
	   ${beanName?uncap_first}Dao.delById(id);
	   return id;
	}

	@Override
	public Long save(${beanName} record) {
		${beanName?uncap_first}Dao.save(record);
		return record.get${beanName}Id();
	}

	@Override
	public ${beanName} getById(Long id) {
		return ${beanName?uncap_first}Dao.getById(id);
	}


	@Override
	public Long editById(${beanName} record) {
		${beanName?uncap_first}Dao.editById(record);
		return record.get${beanName}Id();
	}

	@Override
	public PageTableData<${beanName}> list(int pagenum, int pagesize,${voName} param) {
		PageHelper.startPage(pagenum, pagesize);
		List<${beanName}> datalist = ${beanName?uncap_first}Dao.list(param);
		PageTableData<${beanName}> resultPage = new PageTableData<${beanName}>(datalist);
		PageInfo<${beanName}> p = new PageInfo<${beanName}>(datalist);
		BeanUtils.copyProperties(p, resultPage);
		return resultPage;
	}

@Override
	public List<${beanName}> listAll(${voName} param) {
		List<${beanName}> datalist = ${beanName?uncap_first}Dao.list(param);
		return datalist;
	}

}
