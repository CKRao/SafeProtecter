package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by clark on 2016/10/15.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("测试");
        setContentView(textView);
    }
}
