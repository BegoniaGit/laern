package ${beanPackageName};

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
@JsonInclude(Include.NON_NULL)

/**${beanName}*/
public class ${beanName} implements Serializable {

<#list fieldList as var>
    <#if var.type=='String'>
	@ApiModelProperty(value = "${var.columnComment}(字符长度为1-${var.columLength})")
	@Size(min=1, max=${var.columLength},message="${var.columnComment}字符长度为1-${var.columLength}")
    <#else>
	@ApiModelProperty(value = "${var.columnComment}")
    </#if>
	private <#if var.type=='String'>String</#if><#if var.type=='Long'>Long</#if><#if var.type=='Integer'>Integer</#if><#if var.type=='Timestamp'>Timestamp</#if><#if var.type=='Double'>Double</#if><#if var.type=='Float'>Float</#if><#if var.type=='BigDecimal'>BigDecimal</#if><#if var.type=='Date'>Date</#if> ${var.name};

</#list>

    private static final long serialVersionUID = 1L;

<#list fieldList as var>
    <#if var.type=='String'>
    public String get${var.name?cap_first} () {   
    	 return ${var.name};
    }

    public void set${var.name?cap_first} (String ${var.name}) {
    	 this.${var.name}= ${var.name} == null ? null : ${var.name}.trim();
    }

    </#if>
    <#if var.type=='Integer'>
	public Integer get${var.name?cap_first} () {   
		  return ${var.name};
	}
	
	public void set${var.name?cap_first} (Integer ${var.name}) {
		  this.${var.name}= ${var.name} ;
	}

    </#if>
    <#if var.type=='Long'>
	public Long get${var.name?cap_first} () {   
		return ${var.name};
	}
		
	public void set${var.name?cap_first} (Long ${var.name}) {
		this.${var.name}= ${var.name} ;
	}

    </#if>
    <#if var.type=='Double'>
	public Double get${var.name?cap_first} () {   
		  return ${var.name};
	}
	
	public void set${var.name?cap_first} (Double ${var.name}) {
		  this.${var.name}= ${var.name};
	}

    </#if>
    <#if var.type=='Float'>
	public Float get${var.name?cap_first} () {   
		return ${var.name};
	}
		
	public void set${var.name?cap_first} (Float ${var.name}) {
		this.${var.name}= ${var.name};
	}

    </#if>
    <#if var.type=='BigDecimal'>
	public BigDecimal get${var.name?cap_first} () {   
	    return ${var.name};
	}

	public void set${var.name?cap_first} (BigDecimal ${var.name}) {
	    this.${var.name}= ${var.name};
	}

    </#if>
    <#if var.type=='Date'>
	public Date get${var.name?cap_first} () {   
	    return ${var.name};
	}

	public void set${var.name?cap_first} (Date ${var.name}) {
	    this.${var.name}= ${var.name};
	}

    </#if>
</#list>

	public void difference(${beanName} obj) {
		String defString = "";
<#list fieldList as var>
    <#if var.type=='String'>
	   if(!this.${var.name}.equals(obj.get${var.name?cap_first}())) {
			 defString += "${var.columnComment}从" + this.${var.name} +"修改为" +obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='Integer'>
		if ( !Objects.equals(this.${var.name} , obj.get${var.name?cap_first}())){
			defString += "${var.columnComment}从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='Long'>
		if (!Objects.equals(this.${var.name},obj.get${var.name?cap_first}())){
			defString += "${var.columnComment}从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='Double'>
		if (Math.abs(this.${var.name} - obj.get${var.name?cap_first}()) > 0 ) {
			defString += "${var.columnComment}从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='Float'>
		if (Math.abs(this.${var.name} - obj.get${var.name?cap_first}()) > 0 ) {
			defString += "${var.columnComment}从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='BigDecimal'>
		if (this.${var.name}.compareTo(obj.get${var.name?cap_first}()) != 0){
			defString += "${var.columnComment}从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}

    </#if>
    <#if var.type=='Date'>
		if((!${var.name}.equals("createTime") || !${var.name}.equals("updateTime")) && this.${var.name}.compareTo(obj.get${var.name?cap_first}() != 0 )){
			defString += "${var.columnComment}"从" + this.${var.name} + "修改为" + obj.get${var.name?cap_first}();
		}
    </#if>
</#list>

    }
}