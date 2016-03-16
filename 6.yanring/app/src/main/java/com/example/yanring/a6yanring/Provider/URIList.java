package com.example.yanring.a6yanring.Provider;

import com.example.yanring.a6yanring.Database.WeatherDatabaseHelper;

/**
 * Created by Yanring on 2016/3/15.
 */
public class URIList {
    public static final  String CONTENT = "content://";
    public static final  String AUTHORITY= "com.example.yanring.a6yanring";
    public static final  String WEATHER_URI = CONTENT+AUTHORITY+"/"+ WeatherDatabaseHelper.TABLE_NAME;
}
