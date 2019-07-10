package site.yanyan.learn.utils;

public class RunMilieu {

    /**
     * 判断是否是linux运行环境
     *
     * @return 是linux   true   不是  false
     */
    public static boolean jugdeRunMIlieu() {
        String osName = System.getProperties().getProperty("os.name");
        if (osName.equals("Linux")) {
            return true;
        } else {
            return false;
        }
    }
}
