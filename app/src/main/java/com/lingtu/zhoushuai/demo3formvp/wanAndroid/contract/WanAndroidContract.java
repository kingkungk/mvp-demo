package com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.base.BaseContract;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

import java.util.List;

/*
* 增加契约接口，里面有v层的接口和p层的接口，这样就不用分开了，写在一起，代码少写一点
* */
public interface WanAndroidContract {

    interface View extends BaseContract.View {

        //BaseView里面就有的方法
        @Override
        void hideLoading();

        @Override
        void showLoading();

        //属于BannerContract.View的方法，用于回调presenter回来的banner数据到view层
        void onBannerSuccess(List<BannerBean> beans);
        void onBannerFail(String errorMsg);

        //属于BannerContract.View的方法，用于回调presenter回来的article数据到view层
        void onArticleSuccess(ArticleBean bean);
        void onArticleFail(String errorMsg);
    }

    interface Presenter extends BaseContract.Presenter<View>{
        /*
        *请求banner的接口
        *
        * 这里的getBanner()后面是没有参数的，因为调用的是wanandroid的接口，他这么设定的，所以只能这么写
        * 正常的后台接口对应的写法应该是下面这样的
        * void login(String username, String password);
        * */
        void getBanner();

        /*
        * 请求article的接口
        * */
        void getArticle(int curPage);
    }

}
