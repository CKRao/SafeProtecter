package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clark.safeprotecter.R;

import Utils.ConstantValue;
import Utils.SpUtils;

import static android.R.id.button2;
import static com.example.clark.safeprotecter.R.id.id_choose_contacts;

/**
 * Created by clark on 2016/10/19.
 */

public class SettingFangDao03 extends Activity {
    private Button button1, button2, id_choose_contacts;
    private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_setting03);
        initUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            String phone = data.getStringExtra("phone");
            phone = phone.replace("-", "").replace(" ", "").trim();
            et_number.setText(phone);
            SpUtils.putString(getApplicationContext(), ConstantValue.CONTACT_NUMBER, phone);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initUI() {
        button1 = (Button) findViewById(R.id.id_before_03);
        button2 = (Button) findViewById(R.id.id_next_03);
        id_choose_contacts = (Button) findViewById(R.id.id_choose_contacts);
        et_number = (EditText) findViewById(R.id.et_number);
        String contactPhone = SpUtils.getString(getApplicationContext(), ConstantValue.CONTACT_NUMBER, "");
        //回显联系人的号码
        et_number.setText(contactPhone);
        id_choose_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao03.this, Contacts.class);
                startActivityForResult(intent, 0);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingFangDao03.this, SettingFangDao02.class);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et_number.getText().toString();
                if (!TextUtils.isEmpty(phone)) {
                    Intent intent = new Intent(SettingFangDao03.this, SettingFangDao04.class);
                    startActivity(intent);
                    finish();
                    SpUtils.putString(getApplicationContext(), ConstantValue.CONTACT_NUMBER, phone);
                } else {
                    Toast.makeText(getApplicationContext(), "请输入电话号码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
