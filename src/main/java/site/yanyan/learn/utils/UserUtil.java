package site.yanyan.learn.utils;

import site.yanyan.learn.pojo.sys.SysUser;

public class UserUtil {

    private static SysUser currentUser;


    public static SysUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(SysUser currentUser) {
        UserUtil.currentUser = currentUser;
    }


}
