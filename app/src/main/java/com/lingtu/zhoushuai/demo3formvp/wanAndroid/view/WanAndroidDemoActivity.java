package com.lingtu.zhoushuai.demo3formvp.wanAndroid.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lingtu.zhoushuai.demo3formvp.R;

import com.lingtu.zhoushuai.demo3formvp.wanAndroid.contract.WanAndroidContract;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.ArticleBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean.BannerBean;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.presenter.BannerPresenter;
import com.lingtu.zhoushuai.demo3formvp.wanAndroid.view.base.BaseActivity;

import java.util.List;

public class WanAndroidDemoActivity extends BaseActivity<BannerPresenter> implements WanAndroidContract.View {

    private Button button1;
    private TextView textView1;
    private Button button2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wan_android_demo);

        findView();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getBanner();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getArticle(0);
            }
        });

    }

    private void findView() {
        button1 = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
    }

    @Override
    public void initView() {
        presenter = new BannerPresenter();
    }

    @Override
    public void showLoading() {
        //显示加载框
        Toast.makeText(this, "显示加载框", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        //消失加载框
        Toast.makeText(this, "消失加载框", Toast.LENGTH_SHORT).show();
    }

    /*
     * 获取banner成功
     * */
    @Override
    public void onBannerSuccess(List<BannerBean> beans) {
        textView1.setText(beans.get(0).title);
    }

    /*
     * 获取banner失败
     * */
    @Override
    public void onBannerFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    /*
     * 获取article成功
     * */
    @Override
    public void onArticleSuccess(ArticleBean bean) {
        textView2.setText(bean.datas.get(0).title);
    }

    /*
     * 获取article失败
     * */
    @Override
    public void onArticleFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
