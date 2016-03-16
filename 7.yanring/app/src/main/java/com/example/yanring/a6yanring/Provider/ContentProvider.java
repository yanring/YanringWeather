package com.example.yanring.a6yanring.Provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.yanring.a6yanring.Database.WeatherDatabaseHelper;

import java.security.Provider;

/**
 * Created by Yanring on 2016/3/15.
 */
public class ContentProvider extends android.content.ContentProvider {
    private static UriMatcher sUriMatcher;
    String mTableName = WeatherDatabaseHelper.TABLE_NAME;
    public  static final  int URI_MATH_WHEATHER = 1;
    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(URIList.AUTHORITY, WeatherDatabaseHelper.TABLE_NAME,1);
    }

    private WeatherDatabaseHelper mWeatherDatabaseHelper;

    @Override
    public boolean onCreate() {
        mWeatherDatabaseHelper = new WeatherDatabaseHelper(this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String tableName = mTableName;
        if (TextUtils.isEmpty(tableName)){
            return null;
        }
        Cursor cursor = mWeatherDatabaseHelper.getReadableDatabase().query(tableName,projection,selection,selectionArgs,null,null,sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String tableName = mTableName;
        if (TextUtils.isEmpty(tableName)){
            return null;
        }
        long id = mWeatherDatabaseHelper.getWritableDatabase().insert(tableName,null,values);
        //insert will return a id, to recognize which item you inserted.

        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String tableName = mTableName;
        if (TextUtils.isEmpty(tableName)){
            return -1;
        }
        int count = mWeatherDatabaseHelper.getWritableDatabase().delete(tableName,selection,selectionArgs);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
