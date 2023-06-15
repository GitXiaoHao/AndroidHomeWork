package top.yh.homework.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import top.yh.homework.R;
import top.yh.homework.util.StringUtil;
import top.yh.homework.util.ViewUtil;

public class SevenMainActivity extends AppCompatActivity {
    private EditText etX;
    private EditText etY;
    private int x;
    private int y;
    private final int LINE = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_main);
        Button btnLine = findViewById(R.id.btn_line);
        Button btnRectangle = findViewById(R.id.btn_rectangle);
        Button btnCircle = findViewById(R.id.btn_circle);
        ImageView ivIcon = findViewById(R.id.iv_icon);
        etX = findViewById(R.id.et_x);
        etY = findViewById(R.id.et_y);
        // 创建空白的bitmap
        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        // 新建画布,关联bitmap
        Canvas canvas = new Canvas(bitmap);
        // 绘制背景
        canvas.drawColor(Color.WHITE);
        //创建蓝画笔
        Paint bluePaint = new Paint();
        bluePaint.setStyle(Paint.Style.STROKE);
        bluePaint.setColor(Color.BLUE);
        //画笔粗细为9像素点
        bluePaint.setStrokeWidth(9);
        btnLine.setOnClickListener(view -> {
            if (check()) {
                canvas.drawColor(0,PorterDuff.Mode.CLEAR);
                //划线
                canvas.drawLine(x, y, x + LINE, y, bluePaint);
                //显示bitmap到ImageView中
                ivIcon.setImageBitmap(bitmap);
            }
        });
        btnCircle.setOnClickListener(view -> {
            if (check()) {
                canvas.drawColor(0,PorterDuff.Mode.CLEAR);
                canvas.drawCircle(x,y,LINE,bluePaint);
                ivIcon.setImageBitmap(bitmap);
            }
        });
        btnRectangle.setOnClickListener(view -> {
            if (check()) {
                canvas.drawColor(0,PorterDuff.Mode.CLEAR);
                Rect rect = new Rect();
                rect.top = y;
                rect.bottom = y + LINE;
                rect.left = x;
                rect.right = x + LINE;
                canvas.drawRect(rect, bluePaint);
                ivIcon.setImageBitmap(bitmap);
            }
        });
    }
    private boolean check(){
        String x = etX.getText().toString().trim();
        String y = etY.getText().toString().trim();
        if (StringUtil.isEmpty(x) || StringUtil.isEmpty(y)) {
            ViewUtil.showToast(this,"请输入坐标");
            return false;
        }
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        return true;
    }

}