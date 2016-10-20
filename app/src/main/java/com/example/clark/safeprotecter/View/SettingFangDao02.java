package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/19.
 */

public class SettingFangDao02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting02);

        Button button1 = (Button) findViewById(R.id.id_before_02);
        Button button2 = (Button) findViewById(R.id.id_next_02);
        final SettingItemView settingItemView = (SettingItemView) findViewById(R.id.id_sim_bound_checbox);
        String sim_number = SpUtils.getString(getApplicationContext(), ConstantValue.SIM_BOUND,"");
        if (TextUtils.isEmpty(sim_number)){
            settingItemView.setCheck(false);
        }else {
            settingItemView.setCheck(true);
        }

        settingItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isCheck = settingItemView.isItemChecked();
                settingItemView.setCheck(!isCheck);
                if (!isCheck){
                    //存储sim卡序列号
                    TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    String sim_number = manager.getSimSerialNumber();
                    SpUtils.putString(getApplicationContext(),ConstantValue.SIM_BOUND,sim_number);
                }else {
                   SpUtils.remove(getApplicationContext(),ConstantValue.SIM_BOUND);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao02.this, SettingFangDao01.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.pre_in_anim,R.anim.pre_out_anim);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settingItemView.isItemChecked()) {
                    Intent intent = new Intent(SettingFangDao02.this, SettingFangDao03.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.next_in_anim,R.anim.next_out_anim);
                }else {
                    Toast.makeText(getApplicationContext(),"请绑定sim卡",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
