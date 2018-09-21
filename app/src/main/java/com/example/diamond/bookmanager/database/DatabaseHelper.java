package com.example.diamond.bookmanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.diamond.bookmanager.model.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_USER = "USER";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_PHONE_NUMBER = "Number";
    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +

            COLUMN_USERNAME + " VARCHAR PRIMARY KEY," +
            COLUMN_PASSWORD + " VARCHAR," +
            COLUMN_NAME + " VARCHAR," +
            COLUMN_PHONE_NUMBER + " VARCHAR"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, "bookmanager", null, 1);
    }

    public void insertUser(User user) {
        //xin quyền ghi
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //tạo đối tượng dể truyền dữ liệu
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, user.getUsername());
        contentValues.put(COLUMN_PASSWORD, user.getPassword());
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_PHONE_NUMBER, user.getPhone());

        //câu lệnh insert vào db
        long id = sqLiteDatabase.insert(TABLE_USER, null, contentValues);
        Log.e("insertUser", "ID" + id);
        sqLiteDatabase.close();
    }

    public User getUser(String username) {
        User user = null;
        //xin quyền ghi
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //tạo câu lẹnh query vs cusor
        Cursor cursor = sqLiteDatabase.query(TABLE_USER, new String[]{COLUMN_USERNAME,
                        COLUMN_PASSWORD, COLUMN_NAME, COLUMN_PHONE_NUMBER},
                COLUMN_USERNAME + " =?",
                new String[]{username},
                null, null, null);

        // kiểu tra xem cursor khác null và co chứa giá trị
        if (cursor != null && cursor.moveToFirst()) {
            String user_name = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE_NUMBER));
            user = new User(user_name, password, name, phone);
        }
        sqLiteDatabase.close();
        return user;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.e("DBB", CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}