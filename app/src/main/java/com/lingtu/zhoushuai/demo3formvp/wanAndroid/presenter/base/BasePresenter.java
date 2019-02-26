package com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter.base;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.base.BaseContract;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {

    public T mView;
    public CompositeDisposable mCompositeDisposable;

    public synchronized void addSubscription(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        dispose();
    }

    public void dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable = null;
        }
    }

    public T getView() {
        return mView;
    }
}

