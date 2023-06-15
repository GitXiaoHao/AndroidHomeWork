package top.yh.homework.two;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import top.yh.homework.R;
import top.yh.homework.util.ViewUtil;

public class TwoResultActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_two_result);
        findViewById(R.id.btn_back).setOnClickListener(view -> finish());
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvSno = findViewById(R.id.tv_sno);
        TextView tvHobby = findViewById(R.id.tv_hobby);
        TextView tvMajor = findViewById(R.id.tv_major);
        TextView tvSex = findViewById(R.id.tv_sex);
        TextView tvPartyMember = findViewById(R.id.tv_party_member);
        try {
            tvName.setText(getString(R.string.two_name)  + ":" + intent.getStringExtra("name"));
            tvSno.setText(getString(R.string.two_sno) +":" +intent.getStringExtra("sno"));
            tvHobby.setText(getString(R.string.two_interests) + ":" + intent.getStringExtra("hobby"));
            tvMajor.setText(getString(R.string.two_major) + ":" + intent.getStringExtra("major"));
            tvSex.setText(getString(R.string.two_sex) + ":"  + intent.getStringExtra("sex"));
            tvPartyMember.setText(getString(R.string.two_party_member) + ":" + intent.getStringExtra("isPartyNumber"));
        }catch (Exception e){
            e.printStackTrace();
            ViewUtil.showToast(this,"数据传输失败");
        }
    }
}