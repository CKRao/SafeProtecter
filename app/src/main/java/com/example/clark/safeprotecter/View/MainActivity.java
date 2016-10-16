package com.example.clark.safeprotecter.View;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.clark.safeprotecter.R;

import java.util.ArrayList;
import java.util.List;

import Model.GridDataBean;
import Utils.ConstantValue;
import Utils.Md5Utils;
import Utils.MyAdapter;
import Utils.SpUtils;

public class MainActivity extends AppCompatActivity {


    private GridView mGridView;
    private List<GridDataBean> mList;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化布局
        initUI();
        //初始化数据
        initData();
        mAdapter = new MyAdapter(this, mList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showDialog();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void showDialog() {
        //判断本地是否保存密码（sp  ）
        String psd = SpUtils.getPassWord(this, ConstantValue.MOBILE_SAFE_PSD, "");
        if (TextUtils.isEmpty(psd)) {
            //1.初始设置密码对话框
            showSetPsdDialog();
        } else {
            //2.确认密码对话框
            showConfirmPsdDialog();
        }
    }

    /**
     * 确认密码对话框
     */
    private void showConfirmPsdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View view = View.inflate(this, R.layout.layout_confirm_psd, null);
        dialog.setView(view);
        dialog.show();
        Button submit = (Button) view.findViewById(R.id.id_submit);
        Button cancel = (Button) view.findViewById(R.id.id_cancel);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_confirmPsd = (EditText) view.findViewById(R.id.id_confirm_psd);
                String confirmPsd = et_confirmPsd.getText().toString();

                if (!TextUtils.isEmpty(confirmPsd)) {
                    String psd = SpUtils.getPassWord(getApplicationContext(), ConstantValue.MOBILE_SAFE_PSD, "");
                    Log.i("MD5",psd);
                    if (psd.equals(Md5Utils.encoder(confirmPsd))) {
                        //进入手机防盗模块，开启一个新的Activity
                        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                        startActivity(intent);
                        //关闭对话框，跳入新的界面
                        dialog.dismiss();
                    } else {
                        Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 设置密码对话框
     */
    private void showSetPsdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View view = View.inflate(this, R.layout.layout_set_psd, null);
        dialog.setView(view);
        dialog.show();
        Button submit = (Button) view.findViewById(R.id.id_submit);
        Button cancel = (Button) view.findViewById(R.id.id_cancel);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_setPsd = (EditText) view.findViewById(R.id.id_set_psd);
                EditText et_confirmPsd = (EditText) view.findViewById(R.id.id_confirm_psd);

                String psd = et_setPsd.getText().toString();
                String confirmPsd = et_confirmPsd.getText().toString();

                if (!TextUtils.isEmpty(psd) && !TextUtils.isEmpty(confirmPsd)) {
                    if (psd.equals(confirmPsd)) {
                        //进入手机防盗模块，开启一个新的Activity
                        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                        startActivity(intent);
                        //关闭对话框，跳入新的界面
                        dialog.dismiss();
                        //储存密码
                        SpUtils.putPassWord(getApplicationContext(),
                                ConstantValue.MOBILE_SAFE_PSD, Md5Utils.encoder(psd));
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "请输入密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void initData() {
        mList = new ArrayList<>();
        GridDataBean mBean0 = new GridDataBean("手机防盗", R.drawable.key);
        mList.add(mBean0);
        GridDataBean mBean1 = new GridDataBean("通信卫士", R.drawable.contacts);
        mList.add(mBean1);
        GridDataBean mBean2 = new GridDataBean("软件管理", R.drawable.software);
        mList.add(mBean2);
        GridDataBean mBean3 = new GridDataBean("进程管理", R.drawable.working);
        mList.add(mBean3);
        GridDataBean mBean4 = new GridDataBean("流量统计", R.drawable.flow);
        mList.add(mBean4);
        GridDataBean mBean5 = new GridDataBean("手机杀毒", R.drawable.cross);
        mList.add(mBean5);
        GridDataBean mBean6 = new GridDataBean("缓存清理", R.drawable.trash);
        mList.add(mBean6);
        GridDataBean mBean7 = new GridDataBean("高级工具", R.drawable.tools);
        mList.add(mBean7);
        GridDataBean mBean8 = new GridDataBean("设置中心", R.drawable.setting);
        mList.add(mBean8);
//        mBean.setName("通信卫士");
//        mBean.setName("软件管理");
//        mBean.setName("进程管理");
//        mBean.setName("流量统计");
//        mBean.setName("手机杀毒");
//        mBean.setName("缓存清理");
//        mBean.setName("高级工具");
//        mBean.setName("设置中心");

    }

    private void initUI() {
        mGridView = (GridView) findViewById(R.id.gridView);
    }


}
