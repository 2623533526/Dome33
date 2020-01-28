package com.bawei.dome33.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.dome33.cantract.Cantract;
import com.bawei.dome33.mvp.BasePresenter;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public abstract class BaseActity<P extends BasePresenter> extends AppCompatActivity implements Cantract.IView{
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        presenter=initPresenter();
        presenter.attach(this);
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initlayout();
}
