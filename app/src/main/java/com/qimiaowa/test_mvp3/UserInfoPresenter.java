package com.qimiaowa.test_mvp3;

import android.os.Handler;

/**
 * Created by Administrator on 2018/2/28/028.
 */

public class UserInfoPresenter {
    private IUserInfoView iUserInfoView;
    public UserInfoPresenter(IUserInfoView iUserInfoView) {
        this.iUserInfoView = iUserInfoView;
    }

    public void loadUserInfo() {
        final String userId = iUserInfoView.loadUserId();
        iUserInfoView.showLoading();//接口请求前显示loading
        //这里模拟接口请求回调-
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userId.equals("1000")){
                    //模拟接口返回的json，并转换为javaBean
                    UserInfoModel userInfoModel = new UserInfoModel("小宝", 1, "杭州");
                    iUserInfoView.showUserInfo(userInfoModel);
                    iUserInfoView.dismissLoading();
                }else {
                    iUserInfoView.dismissLoading();
                }

            }
        }, 2000);
    }


}
