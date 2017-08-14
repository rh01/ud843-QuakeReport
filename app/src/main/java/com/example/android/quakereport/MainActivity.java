package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /** 地震列表的适配器 */
    private EarthquakeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // 在布局中查找 {@link ListView} 的引用
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // 创建新适配器，将空地震列表作为输入
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());

        // 在 {@link ListView} 上设置适配器
        // 以便可以在用户界面中填充列表
        earthquakeListView.setAdapter(mAdapter);

        // 在 ListView 上设置项目单击监听器，该监听器会向 Web 浏览器发送 intent，
        // 打开包含有关所选地震详细信息的网站。
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 查找单击的当前地震
                Earthquake currentEarthquake = (Earthquake) mAdapter.getItem(position);

                // 将字符串 URL 转换成 URI 对象（传递到 Intent 构造函数中）
                Uri earthquakeUri = Uri.parse(currentEarthquake.getURL());

                // 创建新 intent 以查看地震 URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // 发送 intent 以启动新活动
                startActivity(websiteIntent);
            }
        });
    }
}
