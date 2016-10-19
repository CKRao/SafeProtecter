package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/13.
 */

public class SettingActivity extends Activity {
    private SettingItemView update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        //初始化自动更新条目
        initUpdate();
    }

    private void initUpdate() {
        //获取自动更新条目是否已被选中
        boolean OpenUpdate = SpUtils.getBoolean(this, ConstantValue.OPEN_UPDATE,false);
        update = (SettingItemView) findViewById(R.id.update);
        //设置自动更新条目的状态
        update.setCheck(OpenUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取之前的选中状态
                boolean isChecked = update.isItemChecked();
                //对原有状态进行取反
                //使得原先选中的状态变为未选中，原先未选中的变为选中
                update.setCheck(!isChecked);
                SpUtils.putBoolean(SettingActivity.this,ConstantValue.OPEN_UPDATE,!isChecked);
            }
        });
    }
}
