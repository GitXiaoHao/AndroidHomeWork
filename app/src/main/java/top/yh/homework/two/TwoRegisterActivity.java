
package top.yh.homework.two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import top.yh.homework.R;
import top.yh.homework.util.StringUtil;
import top.yh.homework.util.ViewUtil;

public class TwoRegisterActivity extends AppCompatActivity {
    List<String> hobbyList;
    String major;
    String hobby = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_register);
        final TwoRegisterActivity that = this;
        hobbyList = new ArrayList<>();
        String[] majorArray = getResources().getStringArray(R.array.majorArray);
        major = majorArray[0];
        EditText etName = findViewById(R.id.et_name);
        EditText etSno = findViewById(R.id.et_sno);
        Spinner spMajor = findViewById(R.id.sp_major);
        RadioGroup rgSex = findViewById(R.id.eg_sex);
        RadioButton rbMan = findViewById(R.id.rb_man);
        RadioButton rbWoman = findViewById(R.id.rb_woman);
        CheckBox cbBasketball = findViewById(R.id.cb_basketball);
        CheckBox cbBaseball = findViewById(R.id.cb_baseball);
        CheckBox cbBadminton = findViewById(R.id.cb_badminton);
        CheckBox cbFootball = findViewById(R.id.cb_football);
        RadioGroup rgPartyNumber = findViewById(R.id.rg_party_number);

        cbBasketball.setOnCheckedChangeListener(new CheckBoxChangeListener(cbBasketball));
        cbBaseball.setOnCheckedChangeListener(new CheckBoxChangeListener(cbBaseball));
        cbBadminton.setOnCheckedChangeListener(new CheckBoxChangeListener(cbBadminton));
        cbFootball.setOnCheckedChangeListener(new CheckBoxChangeListener(cbFootball));
        spMajor.setSelection(0);
        spMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                major = majorArray[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();
            String sno = etSno.getText().toString().trim();
            if (StringUtil.isEmpty(sno) || StringUtil.isEmpty(name) || hobbyList.size() == 0) {
                ViewUtil.showToast(that, "请将信息填写完整");
                return;
            }
            String sex = rgSex.getCheckedRadioButtonId() == rbMan.getId() ? "男" : "女";
            String isPartyNumber = rgPartyNumber.getCheckedRadioButtonId() == R.id.rb_yes ? "是" : "否";
            hobbyList.forEach(ho -> hobby += ho + "/");
            startActivity(new Intent(that, TwoResultActivity.class)
                    .putExtra("name", name)
                    .putExtra("sno", sno)
                    .putExtra("sex", sex)
                    .putExtra("isPartyNumber", isPartyNumber)
                    .putExtra("major", major)
                    .putExtra("hobby", hobby));
        });
    }

    private class CheckBoxChangeListener implements CompoundButton.OnCheckedChangeListener {
        CheckBox box;

        public CheckBoxChangeListener(CheckBox box) {
            this.box = box;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String s = box.getText().toString();
            if (b) {
                hobbyList.add(s);
            } else {
                hobbyList.remove(s);
            }
        }
    }
}