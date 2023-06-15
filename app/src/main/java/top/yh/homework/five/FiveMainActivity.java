package top.yh.homework.five;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import top.yh.homework.R;
import top.yh.homework.five.adapter.ListAdapter;
import top.yh.homework.five.entity.CardInfo;
import top.yh.homework.five.helper.SqliteHelper;
import top.yh.homework.util.TimeUtil;
import top.yh.homework.util.ViewUtil;

public class FiveMainActivity extends AppCompatActivity {
    private SqliteHelper helper;
    private List<CardInfo> list;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_main);
        final FiveMainActivity that = this;
        Button btnClock = findViewById(R.id.btn_clock_in);
        Button btnDisPlay = findViewById(R.id.btn_display);
        ListView lvList = findViewById(R.id.lv_list);
        list = new ArrayList<>();
        adapter = new ListAdapter(this, list);
        lvList.setAdapter(adapter);
        btnClock.setOnClickListener(view -> {
            String time = TimeUtil.getTimeToYearMonthDayHourMinuteSecond();
            if (helper.save(time) > 0L) {
                ViewUtil.showToast(that,"打卡成功");
            }
        });
        btnDisPlay.setOnClickListener(view -> {
            list.clear();
            list.addAll(helper.queryAll());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        helper = SqliteHelper.getInstance(this);
        helper.openReadLink();
        helper.openWriteLink();
    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.closeLink();
    }
}