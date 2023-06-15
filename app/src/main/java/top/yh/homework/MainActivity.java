package top.yh.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import top.yh.homework.five.FiveMainActivity;
import top.yh.homework.four.FourMainActivity;
import top.yh.homework.one.OneActivity;
import top.yh.homework.seven.SevenMainActivity;
import top.yh.homework.six.SixMainActivity;
import top.yh.homework.three.ThreeMainActivity;
import top.yh.homework.two.TwoRegisterActivity;
import top.yh.homework.util.ViewUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity that = this;
        findViewById(R.id.btn_one).setOnClickListener(view -> ViewUtil.jumpToPage(that, OneActivity.class));
        findViewById(R.id.btn_two).setOnClickListener(view -> ViewUtil.jumpToPage(that, TwoRegisterActivity.class));
        findViewById(R.id.btn_three).setOnClickListener(view -> ViewUtil.jumpToPage(that, ThreeMainActivity.class));
        findViewById(R.id.btn_four).setOnClickListener(view -> ViewUtil.jumpToPage(that, FourMainActivity.class));
        findViewById(R.id.btn_five).setOnClickListener(view -> ViewUtil.jumpToPage(that, FiveMainActivity.class));
        findViewById(R.id.btn_six).setOnClickListener(view -> ViewUtil.jumpToPage(that, SixMainActivity.class));
        findViewById(R.id.btn_seven).setOnClickListener(view -> ViewUtil.jumpToPage(that, SevenMainActivity.class));
    }
}