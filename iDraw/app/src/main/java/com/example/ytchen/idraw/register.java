package com.example.ytchen.idraw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {
    Button resgister1;
    Button back;
    EditText account;
    EditText password;

    public static String value;
    public static String pass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log_register);
        resgister1=(Button)findViewById(R.id.register1);
        back=(Button)findViewById(R.id.back);
        account=(EditText)findViewById(R.id.account_zhuce);
        password=(EditText)findViewById(R.id.password_zhuce);
        resgister1.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.register1){
            Register1();
        }
        else if(view.getId()==R.id.back){
            register.super.finish();
        }
    }

    private void Register1() {
        if (getAccount().isEmpty()){
            Toast.makeText(this,"你输入的账号为空！" , Toast.LENGTH_SHORT).show();
            return;
        }

        if (getPassword().isEmpty()){
            Toast.makeText(this,"你输入的密码为空！" , Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            SharedPreferences sp=getSharedPreferences("User", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit=sp.edit();
            edit.putString("Value",account.getText().toString().trim());
            edit.putString("Value",password.getText().toString().trim());
            edit.commit();

            value=sp.getString("Value","Null");
            pass=sp.getString("Value","Null");

            Toast.makeText(this,"注册成功！" , Toast.LENGTH_SHORT).show();
        }
    }




    public String getAccount() {

        return account.getText().toString().trim();
    }

    public String getPassword() {

        return password.getText().toString().trim();
    }

}