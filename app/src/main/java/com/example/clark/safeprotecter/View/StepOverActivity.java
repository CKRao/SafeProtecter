package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/15.
 */

public class StepOverActivity extends Activity {
    private TextView boundNumber;
    private ImageView lock_Icon;
    private Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SpUtils.getSettingBoolean(getApplicationContext(),"config",false)
        if (SpUtils.getBoolean(getApplicationContext(), ConstantValue.STEP_OVER,false)){
            setContentView(R.layout.step_over);
            initUI();
        }else {
            Intent intent = new Intent(this,SettingFangDao01.class);
            startActivity(intent);
            finish();
        }

    }

    private void initUI() {
        boundNumber = (TextView) findViewById(R.id.id_bound_number);
        lock_Icon = (ImageView) findViewById(R.id.id_lock_icon);
        reset = (Button) findViewById(R.id.id_reset);

        String phoneNumber = SpUtils.getString(getApplicationContext(),ConstantValue.CONTACT_NUMBER,"");
        boolean isLock = SpUtils.getBoolean(getApplicationContext(),ConstantValue.OPEN_SECURITY,false);

        boundNumber.setText(phoneNumber);
        if (isLock){
            lock_Icon.setImageResource(R.drawable.lock);
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SettingFangDao01.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
