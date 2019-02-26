package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleBean;

//获取Article数据的回调，负责把数据从model层传到presenter层
public interface ArticleInModelCallBack {
    void onArticleInModelSuccess(ArticleBean articleListBean);
    void onArticleInModelFail(String errorMessage);
}
