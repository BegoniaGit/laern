package site.yanyan.learn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import site.yanyan.learn.pojo.sys.SysPermission;
import site.yanyan.learn.pojo.sys.SysRole;
import site.yanyan.learn.pojo.sys.SysUser;

import java.util.List;

public class UserUtil {

    private static SysUser currentUser;



    public static SysUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(SysUser currentUser) {
        UserUtil.currentUser = currentUser;
    }


}
