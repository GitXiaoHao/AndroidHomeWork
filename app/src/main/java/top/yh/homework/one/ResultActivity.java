package top.yh.homework.one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import top.yh.homework.R;
import top.yh.homework.util.ViewUtil;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final ResultActivity that = this;
        Intent intent = getIntent();
        if (intent == null) {
            ViewUtil.showToast(that,"没有接收到数据");
            return;
        }
        String one = intent.getStringExtra("one");
        String two = intent.getStringExtra("two");
        String res = (Integer.parseInt(one) + Integer.parseInt(two)) + "";
        TextView tvRes = findViewById(R.id.tv_res);
        tvRes.setText(res);
        findViewById(R.id.btn_back).setOnClickListener(view -> {
            //返回上一页面
            setResult(RESULT_OK,new Intent().putExtra("result",res));
            finish();
        });
    }
}