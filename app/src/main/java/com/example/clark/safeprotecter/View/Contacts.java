package com.example.clark.safeprotecter.View;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.clark.safeprotecter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utils.ContactsAdapter;

/**
 * Created by clark on 2016/10/20.
 */

public class Contacts extends Activity {
    private ListView mListView;
    private List<HashMap<String, String>> mHashMapList = new ArrayList<>();
    private ContactsAdapter mContactsAdapter ;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
         mListView.setAdapter(mContactsAdapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_layout);
        initUI();
        inntData();
    }

    private void initUI() {
        mListView = (ListView) findViewById(R.id.id_contact_listview);
        mContactsAdapter =  new ContactsAdapter(getApplicationContext(),mHashMapList);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //1.获取点中条目的索引
                if (mContactsAdapter!=null){
                    HashMap<String,String> hashMap = (HashMap<String, String>) mContactsAdapter.getItem(position);
                    //2.获取当前条目指向集合对应的号码
                    String phone = hashMap.get("phone");
                    //3.将此号码返回给第三个导航界面
                    Intent intent = new Intent();
                    intent.putExtra("phone",phone);
                    setResult(0,intent);
                    //4.结束在此
                    finish();
                }
            }
        });
    }

    private void inntData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //1.获取内容解析器对象
                ContentResolver contentResolver = getContentResolver();
                //2.做查询系统联系人数据库表过程（读取联系人权限）
                Cursor cursor = contentResolver.query(
                        Uri.parse("content://com.android.contacts/raw_contacts"),
                        new String[]{"contact_id"},
                        null, null, null);
                mHashMapList.clear();
                //3.循环游标，直到没有数据为止
                while (cursor.moveToNext()) {
                    String id = cursor.getString(0);
//                    Log.i("Contacts", "id = " + id);
                    Cursor indexCursor = contentResolver.query(
                            Uri.parse("content://com.android.contacts/data"),
                            new String[]{"data1", "mimetype"},
                            "raw_contact_id = ?",
                            new String[]{id}, null
                    );
                    //5.循环获取每一个联系人的电话号码及姓名，数据类型
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    while (indexCursor.moveToNext()) {
//            Log.i("indexCursor","data = "+indexCursor.getString(0));
//            Log.i("indexCursor","mimetype = "+indexCursor.getString(1));
                        String data = indexCursor.getString(0);
                        String type = indexCursor.getString(1);
                        //数据非空判断
                        if (!TextUtils.isEmpty(data)) {
                            if (type.equals("vnd.android.cursor.item/name")) {
                                hashMap.put("name", data);
                            } else if (type.equals("vnd.android.cursor.item/phone_v2")) {
                                hashMap.put("phone", data);
                            }
                        }
                    }
                    indexCursor.close();
                    mHashMapList.add(hashMap);
                }
                cursor.close();
                //7.消息机制，发送一个空消息告诉主线程开始适配数据
                mHandler.sendEmptyMessage(0);
            }
        }
        ).start();
    }
}
