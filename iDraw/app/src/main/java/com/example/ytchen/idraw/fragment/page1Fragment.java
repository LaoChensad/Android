package com.example.ytchen.idraw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ytchen.idraw.R;
import com.example.ytchen.idraw.paihangActivity;


public class page1Fragment extends Fragment{
    private Button bt_page1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page1, container, false);

        bt_page1=(Button)view.findViewById(R.id.bt_page1);
        bt_page1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent();
                intent.setClass(getActivity(),paihangActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }



}

