package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.clark.safeprotecter.R;

/**
 * Created by clark on 2016/10/19.
 */

public class SettingFangDao01 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting01);
        Button button= (Button) findViewById(R.id.id_next_01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao01.this,SettingFangDao02.class);
                startActivity(intent);
                finish();
                //开启平移动画
                overridePendingTransition(R.anim.next_in_anim,R.anim.next_out_anim);
            }
        });
    }
}
