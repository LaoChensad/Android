package com.example.ytchen.idraw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class paihangActivity extends Activity {

    private Context mContext;
    private ListView lv_paihang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = paihangActivity.this;
        lv_paihang = (ListView)findViewById(R.id.lv_paihang);
        setContentView(R.layout.paihang);

        // ArrayAdapter的参数1是一个context，代表要生成ListView的上下文
        // 参数2要传入的是一个布局文件id值，这里使用google预置的布局文件
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(paihangActivity.this, android.R.layout.simple_list_item_1);

        ListView lv_paihang = (ListView)findViewById(R.id.lv_paihang);
        lv_paihang.setAdapter(adapter);

        // 添加数据
        for(int i = 0; i < 20; i++){
            adapter.add("item " + String.valueOf(i));
        }

    }

}
