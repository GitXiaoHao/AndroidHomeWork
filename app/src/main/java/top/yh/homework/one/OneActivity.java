package top.yh.homework.one;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import top.yh.homework.R;
import top.yh.homework.util.StringUtil;
import top.yh.homework.util.ViewUtil;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        final OneActivity that = this;
        EditText etOne = findViewById(R.id.et_one);
        EditText etTwo = findViewById(R.id.et_two);
        TextView tvRes = findViewById(R.id.tv_res);
        Button btnCal = findViewById(R.id.btn_cal);
        ActivityResultLauncher<Intent> register =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            Intent intent = result.getData();
                            if (intent == null || result.getResultCode() != RESULT_OK) {
                                return;
                            }
                            tvRes.setText(intent.getStringExtra("result"));
                        });
        btnCal.setOnClickListener(view -> {
            String one = etOne.getText().toString().trim();
            String two = etTwo.getText().toString().trim();
            if (StringUtil.isEmpty(one) || StringUtil.isEmpty(two)) {
                //为空
                ViewUtil.showToast(that, "请输入数据!");
                return;
            }
            register.launch(new Intent(that, ResultActivity.class).putExtra("one", one)
                    .putExtra("two", two));
        });
    }
}