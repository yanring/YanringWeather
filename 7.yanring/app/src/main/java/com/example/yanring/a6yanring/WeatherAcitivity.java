package com.example.yanring.a6yanring;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.yanring.a6yanring.Network.RequestForWeatherJson;

import org.json.JSONObject;

import static com.example.yanring.a6yanring.Network.JsonUtil.handleWeatherResponse;

public class WeatherAcitivity extends AppCompatActivity {


    private RequestQueue mQueue;
    private TextView mCityNameText;
    private TextView mDateText;
    private TextView mCurrentWeatherText;
    private TextView mMaxTempText;
    private TextView mMinTempText;
    private TextView mWindDirectText;
    private TextView mWindForceText;
    private TextView mCurrentTempText;
    private Button mRefreshButton;
    private TextView mTipsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mQueue = Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setTitle("YanringWeather");
        setContentView(R.layout.activity_weather_acitivity);

        final WeatherThread weatherThread = new WeatherThread(this);
        weatherThread.start();
        FindViews();
        ShowWeatherData();
        mRefreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherAcitivity.this,"已点击",Toast.LENGTH_SHORT).show();
                ShowWeatherData();
                if (weatherThread.isAlive()==false) {
                    weatherThread.start();
                    Toast.makeText(WeatherAcitivity.this,"正在为您刷新天气",Toast.LENGTH_SHORT).show();
                    ShowWeatherData();

                }

            }
        });

    }

    private void ShowWeatherData() {
        ContentResolver contentResolver = getContentResolver();
        Uri CurrentWeatherUri = Uri.parse("content://com.example.yanring.a6yanring/weather");
        Cursor cursor = contentResolver.query(CurrentWeatherUri, null, null, null, null);
        if(cursor.getCount()>0){

            if(cursor.moveToLast());
            {
                mCityNameText.setText(cursor.getString(cursor.getColumnIndex("city_name")));
                mMaxTempText.setText(cursor.getString(cursor.getColumnIndex("max_temp")));
                mMinTempText.setText(cursor.getString(cursor.getColumnIndex("min_temp")));
                mCurrentWeatherText.setText(cursor.getString(cursor.getColumnIndex("type")));
                mTipsText.setText(cursor.getString(cursor.getColumnIndex("ganmao")));
                mDateText.setText(cursor.getString(cursor.getColumnIndex("date")));
                mCurrentTempText.setText("当前温度:"+cursor.getString(cursor.getColumnIndex("current_temp"))+"℃");
                mWindDirectText.setText(cursor.getString(cursor.getColumnIndex("feng_xiang")));
                mWindForceText.setText(cursor.getString(cursor.getColumnIndex("feng_li")));

            }
            cursor.close();
            Toast.makeText(WeatherAcitivity.this,"刷新成功",Toast.LENGTH_SHORT).show();
        }
    }

    private void FindViews(){
        //weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
        mCityNameText = (TextView) findViewById(R.id.city_name);
        mDateText = (TextView) findViewById(R.id.date);
        mCurrentWeatherText = (TextView) findViewById(R.id.current_weather);
        mMaxTempText = (TextView) findViewById(R.id.max_temperature);
        mMinTempText = (TextView) findViewById(R.id.min_temp);
        mWindDirectText = (TextView) findViewById(R.id.wind_direct);
        mWindForceText = (TextView) findViewById(R.id.wind_force);
        mCurrentTempText = (TextView) findViewById(R.id.current_temperature);
        mTipsText = (TextView) findViewById(R.id.ganmao);
        mRefreshButton = (Button) findViewById(R.id.refresh_button);
    }
}
