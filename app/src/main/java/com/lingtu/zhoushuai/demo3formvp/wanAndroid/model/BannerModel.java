package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model;

import com.lingtu.zhoushuai.demo3formvp.Api.RetroifitServiceApi;

import com.lingtu.zhoushuai.demo3formvp.utils.NetManagerUtil;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.response.ResultObserver;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.ArticleInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback.BannerInModelCallBack;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter.base.BasePresenter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class BannerModel {

    private BasePresenter presenter;

    public BannerModel(BasePresenter presenter) {
        this.presenter = presenter;
    }

    //获取banner数据的网络请求
    //这里是没有请求参数的，有请求参数的话应该要这么写：
    //public void getLoginInModel(BaseCallBack baseCallBack,LoginRequestBody loginRequestBody)
    public void getBannerInModel(final BannerInModelCallBack bannerInModelCallBack) {
        Disposable disposable = NetManagerUtil.getInstance()
                .create(RetroifitServiceApi.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResultObserver<List<BannerBean>>(presenter.getView()) {

                    @Override
                    public void succeed(List<BannerBean> bannerBeans) {
                        bannerInModelCallBack.onBannerInModelSuccess(bannerBeans);
                    }

                    @Override
                    public void failed(String failedMsg) {
                        bannerInModelCallBack.onBannerInModelFail(failedMsg);
                    }
                });
        presenter.addSubscription(disposable);
    }

    //获取首页列表数据的网络请求
    public void getArticleListInModel(int curPage, final ArticleInModelCallBack articleInModelCallBack) {
        Disposable disposable = NetManagerUtil.getInstance()
                .create(RetroifitServiceApi.class)
                .getArticle(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResultObserver<ArticleBean>(presenter.getView()) {
                    @Override
                    public void succeed(ArticleBean articleBean) {
                        articleInModelCallBack.onArticleInModelSuccess(articleBean);
                    }

                    @Override
                    public void failed(String failedMsg) {
                        articleInModelCallBack.onArticleInModelFail(failedMsg);
                    }
                });
        presenter.addSubscription(disposable);
    }
}
