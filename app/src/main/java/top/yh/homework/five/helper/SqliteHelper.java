package top.yh.homework.five.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import top.yh.homework.five.entity.CardInfo;

/**
 * @user
 * @date
 */
public class SqliteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "card.db";
    private static final String TABLE_NAME = "card_info";
    private static final int DB_VERSION = 1;
    private static SqliteHelper helper;
    /**
     * 读实例
     */
    private SQLiteDatabase rsd = null;
    /**
     * 写实例
     */
    private SQLiteDatabase wsd = null;

    private SqliteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static SqliteHelper getInstance(Context context) {
        if (helper == null) {
            helper = new SqliteHelper(context);
        }
        return helper;
    }

    /**
     * 打开数据库的读连接
     *
     * @return
     */
    public SQLiteDatabase openReadLink() {
        if (rsd == null || !rsd.isOpen()) {
            rsd = helper.getReadableDatabase();
        }
        return rsd;
    }

    /**
     * 打开数据库的写连接
     *
     * @return
     */
    public SQLiteDatabase openWriteLink() {
        if (wsd == null || !wsd.isOpen()) {
            wsd = helper.getWritableDatabase();
        }
        return wsd;
    }

    public void closeLink() {
        if (rsd != null && rsd.isOpen()) {
            rsd.close();
            rsd = null;
        }
        if (wsd != null && wsd.isOpen()) {
            wsd.close();
            wsd = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table if not exists " + TABLE_NAME +
                "(_id integer primary key autoincrement not null," +
                "timer text not null);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long save(String timer) {
        ContentValues values = new ContentValues();
        values.put("timer", timer);
        return wsd.insert(TABLE_NAME, null, values);
    }

    @SuppressLint("Range")
    public List<CardInfo> queryAll() {
        List<CardInfo> list = new ArrayList<>();
        Cursor cursor = rsd.rawQuery("select * from " + TABLE_NAME, null);
        while (cursor.moveToNext()){
            list.add(new CardInfo(
                    cursor.getInt(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("timer"))
            ));
        }
        cursor.close();
        return list;
    }
}
