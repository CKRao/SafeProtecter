package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

/**
 * Created by clark on 2016/10/19.
 */

public class SettingFangDao04 extends Activity {
    private Button button1,id_accomplish_04;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting04);
        initUI();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SettingFangDao04.this,SettingFangDao03.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.pre_in_anim,R.anim.pre_out_anim);
            }
        });
        id_accomplish_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SpUtils.getBoolean(getApplicationContext(),ConstantValue.OPEN_SECURITY,false)){
                    Intent intent= new Intent(SettingFangDao04.this,StepOverActivity.class);
                    startActivity(intent);
                    finish();
                    SpUtils.putBoolean(getApplicationContext(), ConstantValue.STEP_OVER,true);
                    overridePendingTransition(R.anim.next_in_anim,R.anim.next_out_anim);
                }else {
                    Toast.makeText(getApplicationContext(),"请开启安全设置",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initUI() {
        button1 = (Button) findViewById(R.id.id_before_04);
         id_accomplish_04= (Button) findViewById(R.id.id_accomplish_04);
         checkBox = (CheckBox) findViewById(R.id.checkBox);
        //选中状态回显
        boolean open_security =  SpUtils.getBoolean(getApplicationContext(),ConstantValue.OPEN_SECURITY,false);
        checkBox.setChecked(open_security);
       if (open_security){
           checkBox.setText("安全设置已开启");
       }else {
           checkBox.setText("安全设置已关闭");
       }
        //监听checkbox的改变状态
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //isChecked点击后选中的状态
                //存储点击后的状态
                SpUtils.putBoolean(getApplicationContext(),ConstantValue.OPEN_SECURITY,isChecked);
                //根据是否选中的状态去修改显示的文字
                if (isChecked){
                    checkBox.setText("安全设置已开启");
                }else {
                    checkBox.setText("安全设置已关闭");
                }
            }
        });
    }
}
