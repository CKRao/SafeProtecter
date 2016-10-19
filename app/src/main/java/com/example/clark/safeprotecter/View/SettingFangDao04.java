package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/19.
 */

public class SettingFangDao04 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting04);

        Button button1 = (Button) findViewById(R.id.id_before_04);
        Button id_accomplish_04= (Button) findViewById(R.id.id_accomplish_04);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SettingFangDao04.this,SettingFangDao03.class);
                startActivity(intent);
                finish();
            }
        });
        id_accomplish_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SettingFangDao04.this,StepOverActivity.class);
                startActivity(intent);
                finish();
                SpUtils.putBoolean(getApplicationContext(), ConstantValue.STEP_OVER,true);
            }
        });
    }
}
