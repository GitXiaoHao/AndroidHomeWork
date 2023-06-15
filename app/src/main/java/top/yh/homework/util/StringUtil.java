package top.yh.homework.util;

/**
 * @author yuhao
 * @date 2023/3/31
 **/
public class StringUtil {
    private StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
