package com.qimiaowa.test_mvp3;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IUserInfoView, View.OnClickListener {
    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_address;
    private UserInfoPresenter presenter;
    //进度条
    ProgressDialog progressDialog;
    private Button mBtnRequst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_address = (TextView) findViewById(R.id.tv_address);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        presenter = new UserInfoPresenter(this);
    }

    @Override
    public String loadUserId() {
        return "1000";
    }

    @Override
    public void showLoading() {

        progressDialog.show();

    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        Toast.makeText(this,"数据请求成功", Toast.LENGTH_SHORT).show();
        tv_name.setText(userInfoModel.getName());
        tv_age.setText(userInfoModel.getAge() + "");
        tv_address.setText(userInfoModel.getAddress());
    }

    private void initView() {
        mBtnRequst = (Button) findViewById(R.id.btn_requst);
        mBtnRequst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_requst:
                presenter.loadUserInfo();
                break;
        }
    }
}
