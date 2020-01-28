package com.bawei.dome33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.dome33.base.BaseActity;
import com.bawei.dome33.entity.LogonEntity;
import com.bawei.dome33.entity.RegisterEntity;
import com.bawei.dome33.presenter.Presenter;
import com.blankj.utilcode.util.EncryptUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActity<Presenter> {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.logon)
    Button logon;
    @BindView(R.id.register)
    Button register;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        logon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(phone.getText().toString())||TextUtils.isEmpty(pwd.getText().toString())){
                    Toast.makeText(MainActivity.this, "不可为空", Toast.LENGTH_SHORT).show();
                }else {
                    String md5_phone = phone.getText().toString();
                    String md5_pwd = EncryptUtils.encryptMD5ToString( pwd.getText().toString()).substring(0,8);
                    Log.i("密码：",md5_pwd);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone",md5_phone);
                    map.put("pwd",md5_pwd);
                    presenter.logonsuccess(map);



                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(phone.getText().toString())||TextUtils.isEmpty(pwd.getText().toString())){
                    Toast.makeText(MainActivity.this, "不可为空", Toast.LENGTH_SHORT).show();
                }else {
                    String md5_phone = phone.getText().toString();
                    String md5_pwd =EncryptUtils.encryptMD5ToString( pwd.getText().toString()).substring(0,8);
                    Log.i("账号：",md5_phone);
                    Log.i("密码：",md5_pwd);
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone",md5_phone);
                    map.put("pwd",md5_pwd);
                    presenter.registersuccess(map);
                }
            }
        });
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object object) {
        if(object instanceof RegisterEntity){
            RegisterEntity registerEntity=(RegisterEntity)object;
            String message = registerEntity.getMessage();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }else if(object instanceof LogonEntity){
            LogonEntity logonEntity=(LogonEntity)object;
            Toast.makeText(this, logonEntity.getMessage(), Toast.LENGTH_SHORT).show();
            if(logonEntity.getStatus().equals("0000")){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("bitmap",logonEntity.getResult().getHeadPic());
                startActivity(intent);
            }
        }
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
