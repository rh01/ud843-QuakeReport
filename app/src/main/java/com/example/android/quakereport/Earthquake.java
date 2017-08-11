package com.example.android.quakereport;

/**
 * Created by shine on 17-8-11.
 */

public class Earthquake {
    /* mag is magnitude */
    private double mMag;
    /* place that earthquake occurs*/
    private String mPlace;
    /* date for earthquake occurs*/
    private Long mDate;
    /* url*/
    private String mUrl;


    /**
     * 构造一个新的 {@link Earthquake} 对象。
     *
     * @param mag 表示地震的震级（大小）
     * @param place 表示地震发生的位置
     * @param date 表示地震发生时以毫秒（根据 Epoch）计的时间
     * @param url 表示用于查找关于地震的更多详细信息的网站 URL
     */
    /*Constructor methods*/
    public Earthquake(double mag, String place, Long date, String url){
        mMag = mag;
        mPlace = place;
        mDate = date;
        mUrl = url;
    }


    /*pubic methods that getter*/
    public double getMag(){
       return mMag;}


    public String getPlace(){return mPlace;}

    /**
     * 返回地震的时间。
     */
    public long getTimeInMilliseconds() {
        return mDate;
    }

    /**
     * 返回地震的详情地址。
     */
    public String getURL() {
        return mUrl;
    }



}
