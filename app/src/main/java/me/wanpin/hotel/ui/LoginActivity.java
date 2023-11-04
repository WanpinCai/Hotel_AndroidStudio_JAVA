package me.wanpin.hotel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.wanpin.hotel.R;

public class LoginActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    private Button btnSubmit;
    private LinearLayout llSms;
    private LinearLayout llPassword;
    private TextView tvSms;
    private TextView tvPassword;
    private TextView tvRegister;
    private TextView tvForgetPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //configure layout
        setContentView(R.layout.activity_login);

        //1 get the 控件 ctrl+alt+f
        btnSubmit = findViewById(R.id.btn_login_submit);
        llSms = findViewById(R.id.ll_login_sms);
        llPassword = findViewById(R.id.ll_login_password);
        tvSms = findViewById(R.id.tv_login_sms);
        tvPassword = findViewById(R.id.tv_login_password);
        tvRegister = findViewById(R.id.tv_login_register);
        tvForgetPassword = findViewById(R.id.tv_login_forget_password);

        //设置控制事件
        setViewListener();
//        //2 创建内部实现类对象
//        ClickListener clickListener = new ClickListener();
//        //2设置点击事件
//        btnSubmit.setOnClickListener(clickListener);


        //3设置点击事件
//        btnSubmit.setOnClickListener(this);


    }

    /**
     * 设置控制事件
     */
    private void setViewListener() {
        //文本-按钮 注册新会员 点击事件
        tvRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //意图
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                //打开activity
                startActivity(intent);
            }
        });

        //文本-按钮 重置密码 点击事件
        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        // 文本-按钮 密码登陆 点击事件
        tvPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llPassword.setVisibility(View.VISIBLE);
                tvSms.setVisibility(View.VISIBLE);
                llSms.setVisibility(View.GONE);
                tvPassword.setVisibility(View.GONE);
            }
        });
        // 文本-按钮 验证码登陆 点击事件
        tvSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llPassword.setVisibility(View.GONE);
                tvSms.setVisibility(View.GONE);
                llSms.setVisibility(View.VISIBLE);
                tvPassword.setVisibility(View.VISIBLE);
            }
        });

        //4匿名内部实现类
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Prompt4: Clicked button",Toast.LENGTH_LONG).show();
            }
        });
    }

    //3,Activity实现Listener
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_login_submit:
//                    Toast.makeText(LoginActivity.this,"Prompt: Clicked button",Toast.LENGTH_LONG).show();
//                    break;
//        }
//
//    }

//    //第二种事件的写法，内部实现类
//    class ClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            int id = v.getId();
//            switch (id){
//                case R.id.btn_login_submit:
//                    Toast.makeText(LoginActivity.this,"Prompt: Clicked button",Toast.LENGTH_LONG).show();
//                    break;
//            }
//
//        }
//    }


    //结合layout实现，不推荐
//    public  void btnClick(View view){
//        //Context,text,duration
//        //上下文
//        Toast.makeText(LoginActivity.this,"Prompt: Clicked button",Toast.LENGTH_LONG).show();
//    }
}
