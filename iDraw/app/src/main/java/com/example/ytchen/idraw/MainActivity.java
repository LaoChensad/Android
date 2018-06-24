package com.example.ytchen.idraw;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ytchen.idraw.fragment.page1Fragment;
import com.example.ytchen.idraw.fragment.page2Fragment;
import com.example.ytchen.idraw.fragment.page3Fragment;



public class MainActivity extends FragmentActivity implements View.OnClickListener{

    //UI Object
    private MyFragment page2Fragment;
    private TextView txt_topbar;
    //private TextView txt_channel;
    private TextView txt_homepage;
    private TextView txt_dynamic;
    private TextView txt_trade;
    private FrameLayout ly_content;

    //Fragment Object
    private MyFragment fg1,fg2,fg3;
    private FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        txt_homepage.performClick();   //模拟一次点击，既进去后选择第一项

    }



    //UI组件初始化与事件绑定
    private void bindViews() {
        //txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_homepage = (TextView) findViewById(R.id.txt_homepage);
        txt_dynamic = (TextView) findViewById(R.id.txt_dynamic);
        txt_trade = (TextView) findViewById(R.id.txt_trade);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        //txt_channel.setOnClickListener(this);
        txt_homepage.setOnClickListener(this);
        txt_dynamic.setOnClickListener(this);
        txt_trade.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        //txt_channel.setSelected(false);
        txt_homepage.setSelected(false);
        txt_dynamic.setSelected(false);
        txt_trade.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.txt_homepage:
                setSelected();
                txt_homepage.setSelected(true);
                if (fg1 == null) {
                    fg1 = new MyFragment("第一个Fragment");
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page1Fragment()).commit();

                } else {
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page1Fragment()).commit();
                }
                break;
            case R.id.txt_dynamic:
                setSelected();
                txt_dynamic.setSelected(true);
                if (fg2 == null) {
                    fg2 = new MyFragment("第二个Fragment");
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page2Fragment()).commit();
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page2Fragment()).commit();
                }
                break;
            case R.id.txt_trade:
                setSelected();
                txt_trade.setSelected(true);
                if (fg3 == null) {
                    fg3 = new MyFragment("第三个Fragment");
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page3Fragment()).commit();

                } else {
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, new page3Fragment()).commit();
                }
                break;
        }
        fTransaction.commit();

    }
}


