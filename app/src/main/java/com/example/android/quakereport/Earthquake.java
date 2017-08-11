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


    /*Constructor methods*/
    public Earthquake(double mag, String place, Long date){
        mMag = mag;
        mPlace = place;
        mDate = date;
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


}
