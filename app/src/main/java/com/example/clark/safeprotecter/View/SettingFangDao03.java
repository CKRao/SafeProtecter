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

public class SettingFangDao03 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting03);

        Button button1 = (Button) findViewById(R.id.id_before_03);
        Button button2 = (Button) findViewById(R.id.id_next_03);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao03.this,SettingFangDao02.class);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao03.this,SettingFangDao04.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
