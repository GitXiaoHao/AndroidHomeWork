package top.yh.homework.three;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;
import java.util.Map;

import top.yh.homework.R;
import top.yh.homework.three.adapter.ThreeAdapter;
import top.yh.homework.three.entity.Fruit;

public class ThreeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_main);
        ListView lvList = findViewById(R.id.lv_list);
        List<Fruit> list = Fruit.getDefaultList();
        final ThreeMainActivity that = this;
        Map<String, String> descMap = Fruit.getDescMap();
        ThreeAdapter adapter = new ThreeAdapter(this, list);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener((adapterView, view, i, l) -> {
            new AlertDialog.Builder(that).setTitle(list.get(i).name)
                    .setMessage(descMap.get(list.get(i).name))
                    .setPositiveButton("确定", (dialog, id) -> {

                    })
                    .setNegativeButton("取消", (dialog, id) -> {

                    }).create().show();
        });
    }
}