package com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.WanAndroidContract;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.WanAndroidDemoModel;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.ArticleInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.BannerInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter.base.BasePresenter;

import java.util.List;

public class WanAndroidDemoPresenter extends BasePresenter<WanAndroidContract.View> implements WanAndroidContract.Presenter {

    //持有model对象
    private WanAndroidDemoModel wanAndroidDemoModel;

    public WanAndroidDemoPresenter() {
        wanAndroidDemoModel = new WanAndroidDemoModel(this);
    }

    @Override
    public void getBanner() {

        mView.showLoading();

        wanAndroidDemoModel.getBannerInModel(new BannerInModelCallBack() {
            @Override
            public void onBannerInModelSuccess(List<BannerBean> bannerBeans) {
                mView.onBannerSuccess(bannerBeans);
            }

            @Override
            public void onBannerInModelFail(String errorMessage) {
                mView.onBannerFail(errorMessage);
            }
        });
    }

    @Override
    public void getArticle(int curPage) {
        mView.showLoading();

        wanAndroidDemoModel.getArticleListInModel(curPage, new ArticleInModelCallBack() {
            @Override
            public void onArticleInModelSuccess(ArticleBean articleListBean) {
                mView.onArticleSuccess(articleListBean);
            }

            @Override
            public void onArticleInModelFail(String errorMessage) {
                mView.onArticleFail(errorMessage);
            }
        });
    }

}
