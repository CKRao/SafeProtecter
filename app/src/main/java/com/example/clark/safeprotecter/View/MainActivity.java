package com.example.clark.safeprotecter.View;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.clark.safeprotecter.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import Model.GridDataBean;
import Utils.MyAdapter;

public class MainActivity extends AppCompatActivity {


    private GridView mGridView;
    private List<GridDataBean> mList;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化布局
        initUI();
        //初始化数据
        initData();
        mAdapter = new MyAdapter(this,mList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
        GridDataBean mBean0 = new GridDataBean("手机防盗",R.drawable.key);
        mList.add(mBean0);
        GridDataBean mBean1 = new GridDataBean("通信卫士",R.drawable.contacts);
        mList.add(mBean1);
        GridDataBean mBean2 = new GridDataBean("软件管理",R.drawable.software);
        mList.add(mBean2);
        GridDataBean mBean3 = new GridDataBean("进程管理",R.drawable.working);
        mList.add(mBean3);
        GridDataBean mBean4 = new GridDataBean("流量统计",R.drawable.flow);
        mList.add(mBean4);
        GridDataBean mBean5 = new GridDataBean("手机杀毒",R.drawable.cross);
        mList.add(mBean5);
        GridDataBean mBean6 = new GridDataBean("缓存清理",R.drawable.trash);
        mList.add(mBean6);
        GridDataBean mBean7 = new GridDataBean("高级工具",R.drawable.tools);
        mList.add(mBean7);
        GridDataBean mBean8 = new GridDataBean("设置中心",R.drawable.setting);
        mList.add(mBean8);
//        mBean.setName("通信卫士");
//        mBean.setName("软件管理");
//        mBean.setName("进程管理");
//        mBean.setName("流量统计");
//        mBean.setName("手机杀毒");
//        mBean.setName("缓存清理");
//        mBean.setName("高级工具");
//        mBean.setName("设置中心");

    }

    private void initUI() {
        mGridView = (GridView) findViewById(R.id.gridView);
    }



}
