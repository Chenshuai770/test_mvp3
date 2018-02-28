package com.qimiaowa.test_mvp3;

/**
 * Created by Administrator on 2018/2/28/028.
 */

public interface IUserInfoView {
    String loadUserId();//假设接口请求需要一个userId
    void showLoading();//展示加载框
    void dismissLoading();//取消加载框展示
    void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调

}
