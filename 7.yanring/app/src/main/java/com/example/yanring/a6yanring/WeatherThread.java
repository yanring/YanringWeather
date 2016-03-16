package com.example.yanring.a6yanring;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.yanring.a6yanring.Network.RequestForWeatherJson;

import org.json.JSONObject;

import static com.example.yanring.a6yanring.Network.JsonUtil.handleWeatherResponse;

/**
 * Created by Yanring on 2016/3/15.
 */
public class WeatherThread extends Thread {

    private final Context mContext;
    private final RequestQueue mQueue;

    public WeatherThread(Context context){
        mContext = context;
        mQueue = Volley.newRequestQueue(context);
    }
    @Override
    public void run() {
        super.run();
        RequestForWeatherJson requestForWeatherJson = new RequestForWeatherJson("http://wthrcdn.etouch.cn/weather_mini?citykey=101030100", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        handleWeatherResponse(mContext,response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(requestForWeatherJson);
        synchronized (this){
            try {
                //每隔10分钟自动更新
                this.wait(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
