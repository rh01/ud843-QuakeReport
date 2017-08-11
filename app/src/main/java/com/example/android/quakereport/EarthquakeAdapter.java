package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by shine on 17-8-11.
 */

public class EarthquakeAdapter extends ArrayAdapter {


    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param androidFlavors A List of AndroidFlavor objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> androidFlavors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, androidFlavors);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentAndroidFlavor = (Earthquake) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.mag);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentAndroidFlavor.getMag());



        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.place);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(splitPreLocation(currentAndroidFlavor.getPlace()));

        TextView detailsTextView = (TextView) listItemView.findViewById(R.id.details);
        detailsTextView.setText(splitEndLocation(currentAndroidFlavor.getPlace()));



      /*  // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        dateTextView.setText(currentAndroidFlavor.getDate());*/

        // 根据地震时间（以毫秒为单位）创建一个新的 Date 对象
        Date dateObject = new Date(currentAndroidFlavor.getTimeInMilliseconds());


        // 找到视图 ID 为 date 的 TextView
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // 设置日期字符串的格式（即 "Mar 3, 1984"）
        String formattedDate = formatDate(dateObject);
        // 在该 TextView 中显示目前地震的日期
        dateView.setText(formattedDate);

        // 找到视图 ID 为 time 的 TextView
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // 设置时间字符串的格式（即 "4:30PM"）
        String formattedTime = formatTime(dateObject);
        // 在该 TextView 中显示目前地震的时间
        timeView.setText(formattedTime);

        // 返回目前显示适当数据的列表项视图
        return listItemView;



    }


    /**
     * 从 Date 对象返回格式化的日期字符串（即 "Mar 3, 1984"）。
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * 从 Date 对象返回格式化的时间字符串（即 "4:30 PM"）。
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    private String splitPreLocation(String location){
        String locationToLowwer = location.toLowerCase();
        int splitIndex = locationToLowwer.indexOf("of");
        if(splitIndex == -1){
           return "Near the";
        }
        return location.substring(0, splitIndex+2);
    }

    private String splitEndLocation(String location){
        String locationToLowwer = location.toLowerCase();
        int splitIndex = locationToLowwer.indexOf("of");
        if(splitIndex == -1){

            return location;
        }
        return location.substring(splitIndex+2, location.length());
    }

}
