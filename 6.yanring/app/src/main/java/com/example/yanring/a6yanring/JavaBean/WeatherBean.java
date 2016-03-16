package com.example.yanring.a6yanring.JavaBean;

import java.util.List;


/**
 * Created by Yanring on 2016/3/14.
 */
public class WeatherBean {
    //=================================
    public class Yesterday {
        private String fl;

        private String fx;

        private String high;

        private String type;

        private String low;

        private String date;

        public void setFl(String fl){
            this.fl = fl;
        }
        public String getFl(){
            return this.fl;
        }
        public void setFx(String fx){
            this.fx = fx;
        }
        public String getFx(){
            return this.fx;
        }
        public void setHigh(String high){
            this.high = high;
        }
        public String getHigh(){
            return this.high;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setLow(String low){
            this.low = low;
        }
        public String getLow(){
            return this.low;
        }
        public void setDate(String date){
            this.date = date;
        }
        public String getDate(){
            return this.date;
        }

    }
    //=================================

    public class Forecast {
        private String fengxiang;

        private String fengli;

        private String high;

        private String type;

        private String low;

        private String date;

        public void setFengxiang(String fengxiang){
            this.fengxiang = fengxiang;
        }
        public String getFengxiang(){
            return this.fengxiang;
        }
        public void setFengli(String fengli){
            this.fengli = fengli;
        }
        public String getFengli(){
            return this.fengli;
        }
        public void setHigh(String high){
            this.high = high;
        }
        public String getHigh(){
            return this.high;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setLow(String low){
            this.low = low;
        }
        public String getLow(){
            return this.low;
        }
        public void setDate(String date){
            this.date = date;
        }
        public String getDate(){
            return this.date;
        }

    }
    //=================================


    public class Data {
        private String wendu;

        private String ganmao;

        private List<Forecast> forecast ;

        private Yesterday yesterday;

        private String aqi;

        private String city;

        public void setWendu(String wendu){
            this.wendu = wendu;
        }
        public String getWendu(){
            return this.wendu;
        }
        public void setGanmao(String ganmao){
            this.ganmao = ganmao;
        }
        public String getGanmao(){
            return this.ganmao;
        }
        public void setForecast(List<Forecast> forecast){
            this.forecast = forecast;
        }
        public List<Forecast> getForecast(){
            return this.forecast;
        }
        public void setYesterday(Yesterday yesterday){
            this.yesterday = yesterday;
        }
        public Yesterday getYesterday(){
            return this.yesterday;
        }
        public void setAqi(String aqi){
            this.aqi = aqi;
        }
        public String getAqi(){
            return this.aqi;
        }
        public void setCity(String city){
            this.city = city;
        }
        public String getCity(){
            return this.city;
        }

    }
  //  =================================

//    public static class Root {
//        private String desc;
//
//        private int status;
//
//        private Data data;
//
//        public void setDesc(String desc){
//            this.desc = desc;
//        }
//        public String getDesc(){
//            return this.desc;
//        }
//        public void setStatus(int status){
//            this.status = status;
//        }
//        public int getStatus(){
//            return this.status;
//        }
//        public void setData(Data data){
//            this.data = data;
//        }
//        public Data getData(){
//            return this.data;
//        }
//
//    }
    Data data;
            public Data getData(){
            return this.data;
        }
}
