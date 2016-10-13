package com.example.clark.safeprotecter.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

/**
 * Created by clark on 2016/10/13.
 */

public class SettingItemView extends RelativeLayout {
    private TextView tx1,tx2;
    private CheckBox check;

    public SettingItemView(Context context) {
        this(context,null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.setting_item, this);
        tx1 = (TextView) findViewById(R.id.Item_tx1);
        tx2 = (TextView) findViewById(R.id.Item_tx2);
        check = (CheckBox) findViewById(R.id.check_box);
    }
}
