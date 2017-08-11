package com.example.android.quakereport;

/**
 * Created by shine on 17-8-11.
 */

public class Earthquake {
    /* mag is magnitude */
    private String mMag;
    /* place that earthquake occurs*/
    private String mPlace;
    /* date for earthquake occurs*/
    private String mDate;

    /*Constructor methods*/
    public Earthquake(String mag, String place, String date){
        mMag = mag;
        mPlace = place;
        mDate = date;
    }


    /*pubic methods that getter*/
    public String getMag(){return mMag;}

    public String getPlace(){return mPlace;}

    public String getDate(){return mDate;}


}
