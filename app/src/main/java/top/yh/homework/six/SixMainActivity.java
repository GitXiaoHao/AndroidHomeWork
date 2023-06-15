package top.yh.homework.six;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import top.yh.homework.R;
import top.yh.homework.util.StringUtil;
import top.yh.homework.util.ViewUtil;

public class SixMainActivity extends AppCompatActivity {
    private StringBuilder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_main);
        final SixMainActivity that = this;
        builder = new StringBuilder();
        EditText etNum = findViewById(R.id.et_num);
        Button btnCal = findViewById(R.id.btn_cal);
        TextView tvRes = findViewById(R.id.tv_res);
        btnCal.setOnClickListener(view -> {
            String num = etNum.getText().toString().trim();
            if (StringUtil.isEmpty(num)) {
                ViewUtil.showToast(that,"请输入数字");
                return;
            }
            int n = Integer.parseInt(num);
            that.runOnUiThread(() -> {
                builder.append("和为：").append(n * (n + 1) / 2);
                tvRes.setText(builder);
                tvRes.setVisibility(View.VISIBLE);
            });
            that.runOnUiThread(()-> {
                int sum = 1;
                for (int i = 1; i <= n; i++) {
                    sum *= i;
                }
                builder.append("    乘积为：").append(sum);
                tvRes.setText(builder);
                tvRes.setVisibility(View.VISIBLE);
            });
        });
    }
}