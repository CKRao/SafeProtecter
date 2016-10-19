package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/15.
 */

public class StepOverActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SpUtils.getSettingBoolean(getApplicationContext(),"config",false)
        if (SpUtils.getBoolean(getApplicationContext(), ConstantValue.STEP_OVER,false)){
            setContentView(R.layout.step_over);
        }else {
            Intent intent = new Intent(this,SettingFangDao01.class);
            startActivity(intent);
            finish();
        }

    }
}
