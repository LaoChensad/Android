package com.example.ytchen.idraw;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.ytchen.idraw.register.pass;
import static com.example.ytchen.idraw.register.value;

public class log_on_Activity extends AppCompatActivity implements View.OnClickListener{
    EditText account;
    EditText password;
    Button LoginBtn;
    Button register2;
    String save_account;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhuce);
        account=(EditText)findViewById(R.id.account);
        password=(EditText)findViewById(R.id.password);
        LoginBtn=(Button)findViewById(R.id.bt_zhuce);
        register2=(Button)findViewById(R.id.register2);
        LoginBtn.setOnClickListener(this);
        register2.setOnClickListener(this);

        boolean first = false;
        SharedPreferences setting = getSharedPreferences("setting", 0);
        first = setting.getBoolean("FIRST", true);
        if (first) {
            setting.edit().putBoolean("FIRST", false).apply();
        }else{
            save_account = setting.getString("account", "");
            String save_password = setting.getString("password", "");

            account.setText(save_account);
            password.setText(save_password);
        }

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.bt_zhuce){
            login();

        }

        if(v.getId()==R.id.register2){
            Intent intent=new Intent(getApplicationContext(),register.class);
            startActivity(intent);
        }



    }

    private void login() {
        if (getAccount().isEmpty()){
            Toast.makeText(this,"你输入的账号为空！" , Toast.LENGTH_SHORT).show();
            return;
        }

        if (getPassword().isEmpty()){
            Toast.makeText(this,"你输入的密码为空！" , Toast.LENGTH_SHORT).show();
            return;
        }

        if (getAccount().equals(value) && getPassword().equals(pass)) {
            Toast.makeText(this,"登录成功" , Toast.LENGTH_SHORT).show();
            SharedPreferences setting = getSharedPreferences("setting", 0);
            SharedPreferences.Editor ed = setting.edit();

            ed.putString("account", getAccount());
            ed.putString("password", getPassword());

            ed.apply();

            Intent intent = new Intent();
            intent.putExtra("account",getAccount());
            setResult(2,intent);

            //startActivity(new Intent(login.this,HomePage.class));
            Intent intent12=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent12);
        } else {


            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
    }


    public String getAccount() {
        return account.getText().toString().trim();
    }

    public String getPassword() {
        return password.getText().toString().trim();
    }

}

