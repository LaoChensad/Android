package com.example.ytchen.idraw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.ytchen.idraw.R;
import com.example.ytchen.idraw.count_settingActivity;

public class page3Fragment extends Fragment{

    private Button bt_page3_count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page3, container, false);

        bt_page3_count=(Button)view.findViewById(R.id.bt_page3_count);
        bt_page3_count.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent();
                intent.setClass(getActivity(),count_settingActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }




}
