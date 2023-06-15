package top.yh.homework.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * @user
 * @date
 */
public class PermissionUtil {
    /**
     * 检查多个权限
     * 返回true表示已完全启用权限，返回false表示未完全启用权限
     */
    public static boolean checkPermission(Activity activity,String[] permissions,int requestCode){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return true;
        }
        int check = PackageManager.PERMISSION_GRANTED;
        for (String permission : permissions) {
            check = ContextCompat.checkSelfPermission(activity,permission);
            if (check != PackageManager.PERMISSION_GRANTED) {
                //没有授权
                break;
            }
        }
        //未开启权限，则请求系统弹窗
        if (check != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,permissions,requestCode);
            return false;
        }
        return true;
    }

    /**
     * 检查权限结果数组，返回true表示都已经获得授权。返回false 表示至少有一个未获得授权
     * @param grantResults
     * @return
     */
    public static boolean checkGrant(int[] grantResults) {
        if (grantResults != null) {
            //遍历权限结果数组中的每条选择结果
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    //未获得授权
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
