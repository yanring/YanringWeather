package com.example.yanring.a6yanring.Network;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.yanring.a6yanring.JavaBean.WeatherBean;
import com.example.yanring.a6yanring.Provider.URIList;
import com.google.gson.Gson;

/**
 * Created by Yanring on 2016/3/14.
 */
public class JsonUtil {
    public static void handleWeatherResponse(Context context, String response){
        try {
            Gson gson = new Gson();
            WeatherBean weather = gson.fromJson(response,WeatherBean.class);
            saveWeatherInfo(context,weather);
        }catch (Exception e){

        }
    }
    private static void saveWeatherInfo(Context context, WeatherBean weather) {
        ContentResolver cr = context.getContentResolver();
        Uri insertUri = Uri.parse("content://com.example.yanring.a6yanring/weather");
        ContentValues cvs = new ContentValues();
        cvs.put("city_Name", weather.getData().getCity());
        cvs.put("max_temp",weather.getData().getForecast().get(0).getHigh());
        cvs.put("min_temp",weather.getData().getForecast().get(0).getLow());
        cvs.put("type",weather.getData().getForecast().get(0).getType());
        cvs.put("date",weather.getData().getForecast().get(0).getDate());
        cvs.put("ganmao",weather.getData().getGanmao());
        cvs.put("current_temp",weather.getData().getWendu());
        cvs.put("feng_xiang",weather.getData().getForecast().get(0).getFengxiang());
        cvs.put("feng_li",weather.getData().getForecast().get(0).getFengli());
        Uri uri = cr.insert(insertUri, cvs);
        Log.i("TAG2",weather.getData().getForecast().get(0).getHigh());
        Log.i("TAG2",weather.getData().getForecast().get(0).getFengxiang());
        Log.i("TAG2",weather.getData().getGanmao());

    }
}
