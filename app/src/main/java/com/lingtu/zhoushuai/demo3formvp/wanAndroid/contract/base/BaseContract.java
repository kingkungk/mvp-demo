package com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.base;

public interface BaseContract {
    interface View {
        /**
         * 显示加载中
         */
        void showLoading();

        /**
         * 隐藏加载
         */
        void hideLoading();
    }

    interface Presenter<V extends View> {
        void attachView(V v);

        void detachView();
    }
}
