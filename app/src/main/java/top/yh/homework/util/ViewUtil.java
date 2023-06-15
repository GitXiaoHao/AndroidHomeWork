package top.yh.homework.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.Random;

import top.yh.homework.MainActivity;
import top.yh.homework.two.TwoRegisterActivity;

/**
 * @user
 * @date
 */
public class ViewUtil {
    public static void hideOneInputMethod(Activity ac, View v) {
        //从系统服务中获取输入法管理器
        InputMethodManager imm = (InputMethodManager) ac.getSystemService(Context.INPUT_METHOD_SERVICE);
        //关闭软硬盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /***
     * 生成验证码
     * @return
     */
    public static String getVerifyCode(Activity activity) {
        //生成六位随机验证码
        String verifyCode = String.format("%06d", new Random().nextInt(999999));
        //弹出提醒对话框 提示用户记住验证码
        new AlertDialog.Builder(activity)
                .setTitle("请记住验证码")
                .setMessage("本次验证码是" + verifyCode)
                .setPositiveButton("好的", null)
                .create().show();
        return verifyCode;
    }

    public static void showToast(Context context, String desc) {
        Toast.makeText(context, desc, Toast.LENGTH_SHORT).show();
    }

    /**
     * 根据手机的分辨率从dp的单位转成px（像素）
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        //获取当前手机的像素密度（1个dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static void jumpToPage(Activity that, Class<?> twoRegisterActivityClass) {
        that.startActivity(new Intent(that, twoRegisterActivityClass));
    }
}
