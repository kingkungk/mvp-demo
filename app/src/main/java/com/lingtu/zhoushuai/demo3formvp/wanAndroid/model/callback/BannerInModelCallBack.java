package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.callback;


import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;

import java.util.List;

//获取banner数据的回调，负责把数据从model层传到presenter层
public interface BannerInModelCallBack{
    void onBannerInModelSuccess(List<BannerBean> bannerBeans);
    void onBannerInModelFail(String errorMessage);
}
