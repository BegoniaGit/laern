package site.yanyan.learn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MyFile{
    protected String name;
    protected String format;
    protected long size;
    private String time;
    protected Date lastModified;
    protected String parentPath;
    protected String path;
    protected boolean isDirectory=false;
    protected boolean isNull=true;

    public MyFile(String name, String format, long size, String time,String parentPath,String path) {
        this.name = name;
        this.format = format;
        this.size = size;
        this.time = time;
        this.parentPath=parentPath;
        this.path=path;
        conversionDate(time);

    }

    public void conversionDate(String time){
        try{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM dd HH:mm",Locale.US);
                this.lastModified=simpleDateFormat.parse(time);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public Date lastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", lastModified=" + lastModified +
                ", parentPath='" + parentPath + '\'' +
                ", path='" + path + '\'' +
                ", isDirectory=" + isDirectory +
                ", isNull=" + isNull +
                '}';
    }
}
