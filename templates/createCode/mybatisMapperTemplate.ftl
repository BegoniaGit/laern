<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackageName}.${beanName}Dao">
    <resultMap id="BaseResultMap" type="${beanPackageName}.${beanName}">
        <id column="id" property="id" jdbcType="INTEGER"/>
    <#list fieldList as var>
        <#if var_index != 0>
    <result column="${var.columnName}" property="${var.name}" jdbcType="${var.jdbcType?upper_case}"/></#if>
    </#list>
    </resultMap>
    <sql id="Base_Column_List">
    <#list fieldList as var>
    	<#if var_index != 0>,${var.columnName}<#else>${var.columnName}</#if>
    </#list>
    </sql>
    <select id="getById" resultMap="BaseResultMap" parameterType="java.lang.Long">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        where ${tableName}_id = ${r"#{id,jdbcType=INTEGER}"}
    </select>
    <delete id="delById" parameterType="java.lang.Long">
        delete from ${tableName}
        where id = ${r"#{id,jdbcType=INTEGER}"}
    </delete>

    <insert id="save" parameterType="${beanPackageName}.${beanName}" keyProperty="id" useGeneratedKeys="true">
        insert into ${tableName} ( <#list fieldList as var><#if var_index != 1&&var_index != 0>
        ,${var.columnName}<#elseif var_index != 0>${var.columnName}</#if></#list>
        )
        values (  <#list fieldList as var><#if var_index != 1&&var_index != 0>,${r"#"}{${var.name}
        ,jdbcType=${var.jdbcType?upper_case}}<#elseif var_index != 0>${r"#"}{${var.name}
        ,jdbcType=${var.jdbcType?upper_case}}</#if></#list>
        )
    </insert>

    <update id="editById" parameterType="${beanPackageName}.${beanName}">
        update ${tableName} set <#list fieldList as var> <#if var_index == 0>${var.columnName} = ${r"#"}{${var.name}
        ,jdbcType=${var.jdbcType?upper_case}}
    <#else>,${var.columnName} = ${r"#"}{${var.name},jdbcType=${var.jdbcType?upper_case}}</#if></#list>
        where id = ${r"#{id,jdbcType=INTEGER}"}
    </update>

    <select id="list" resultMap="BaseResultMap" parameterType="${voPackageName}.${voName}">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        <trim prefix="where" prefixOverrides="and|or">
        </trim>
        order by id desc
    </select>

    <select id="pagelist" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${tableName} limit  ${r"#{pageNum}"},${r"#{pageSize}"};
    </select>
</mapper>