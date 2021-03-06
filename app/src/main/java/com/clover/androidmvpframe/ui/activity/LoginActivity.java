package com.clover.androidmvpframe.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.clover.androidmvpframe.Base.BaseActivity;
import com.clover.androidmvpframe.R;
import com.clover.androidmvpframe.bean.User;
import com.clover.androidmvpframe.presenter.login.LoginPresenter;
import com.clover.androidmvpframe.view.login.ILoginView;


public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {



    private AutoCompleteTextView username;

    private EditText password;

    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter(this);

        initView();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(username.getText().toString().trim());
                user.setPassword(password.getText().toString().trim());
                mPresenter.login(user);
            }
        });


    }

    private void initView() {

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

    }

    @Override
    public void showLoading() {
        Log.e("login", "showLoading: 登录中...");
    }

    @Override
    public void stopLoading() {
        Log.e("login", "showLoading: 登录结果返回...");
    }

    @Override
    public void success() {
        Log.e("login", "showLoading: 登录成功...");
    }

    @Override
    public void error() {
        Log.e("login", "showLoading: 登录失败...");
    }

}

