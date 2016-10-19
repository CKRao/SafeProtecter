package com.example.clark.safeprotecter.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

import static com.example.clark.safeprotecter.R.attr.destitle;

/**
 * Created by clark on 2016/10/13.
 */

public class SettingItemView extends RelativeLayout {
    private TextView tx1,tx2;
    private CheckBox check;
    public static final String NAME_SPACE = "xmlns:clark=\"http://schemas.android.com/apk/com.example.clark.safeprotecter.View.SettingItemView\"";
    private String mDestitle;
    private String mDeson;
    private String mDsoff;

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
        //初始化控件的自定义属性
        initAttrs(context,attrs);
        tx1.setText(mDestitle);
        setCheck(false);
    }

    private void initAttrs(Context context,AttributeSet attrs) {
        //通过TypedArray引入自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.SettingItemView);
        //从自定义属性中获取String
        mDestitle = ta.getString(R.styleable.SettingItemView_destitle);
        mDeson = ta.getString(R.styleable.SettingItemView_deson);
        mDsoff = ta.getString(R.styleable.SettingItemView_desoff);
        //下列API有问题，自定义属性在项目运行时未显示，有时间再去解决此问题
//        mDestitle = attrs.getAttributeValue(NAME_SPACE,"destitle");
//        mDeson  = attrs.getAttributeValue(NAME_SPACE,"deson");
//        mDsoff = attrs.getAttributeValue(NAME_SPACE,"desoff");
    }

    /**
     *判断Item是否选中，与CheckBox的选中状态绑定
     * @return 返回SettingItemView是否选中，
     * true开启（checkbox选中，返回true） flase（checkbox未选中 返回flase）
     */
    public boolean isItemChecked(){
        return check.isChecked();
    }
    /**
     * 改变Item选中状态
     * @param isCheck 作为是否开启的变量，在点击过程中传递
     */
    public void setCheck(boolean isCheck){
        //当前条目状态改变，checkbox状态也跟随着改变
         check.setChecked(isCheck);
        if (isCheck){
            //开启
            tx2.setText(mDeson);
        }else {
            //关闭
            tx2.setText(mDsoff);
        }
    }
}
