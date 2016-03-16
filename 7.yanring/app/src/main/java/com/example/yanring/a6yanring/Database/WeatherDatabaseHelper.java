package com.example.yanring.a6yanring.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yanring on 2016/3/15.
 */
public class WeatherDatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "weather";

    public WeatherDatabaseHelper(Context context) {
        super(context,"weather.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ("
                + "id PRIMARY KEY ON CONFLICT REPLACE, "
                + "city_name text, "
                + "max_temp text, "
                + "min_temp text, "
                + "type text, "
                + "date text, "
                +"ganmao text, "
                + "current_temp text, "
                + "feng_xiang text, "
                + "feng_li text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
