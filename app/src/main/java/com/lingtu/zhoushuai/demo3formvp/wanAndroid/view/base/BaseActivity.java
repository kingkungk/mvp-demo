package com.lingtu.zhoushuai.demo3formvp.wanAndroid.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.base.BaseContract;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter.base.BasePresenter;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseContract.View {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public abstract void initView();
}
