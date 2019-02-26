package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.response;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.base.BaseContract;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.Result;

import io.reactivex.observers.DisposableObserver;

public abstract class ResultObserver<D> extends DisposableObserver<Result<D>> {

    private BaseContract.View mView;

    public ResultObserver(BaseContract.View view) {
        mView = view;
    }

    @Override
    public void onNext(Result<D> result) {
        if (result.getErrorCode() == Result.SUCCEED_CODE){
            succeed(result.getData());
        } else {
            failed(result.getErrorMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        failed(e.toString());
    }

    @Override
    public void onComplete() {
        mView.hideLoading();
    }

    public abstract void succeed(D d);

    public abstract void failed(String failedMsg);
}
