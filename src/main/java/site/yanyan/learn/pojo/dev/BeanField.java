package site.yanyan.learn.pojo.dev;

import java.io.Serializable;

public class BeanField implements Serializable {

    private static final long serialVersionUID = 4279960350136806659L;
    /**
     * 字段名
     */
    private String columnName;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 字段长度
     */
    private String columLength;
    /**
     * 字段长度
     */

    private String columnComment;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private String columnDefault;

    private String name;

    private String type;
    /**
     * 字段长度
     */
    private int length;

    private String jdbcType;

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColumLength() {
        return columLength;
    }

    public void setColumLength(String columLength) {
        this.columLength = columLength;
    }

}
