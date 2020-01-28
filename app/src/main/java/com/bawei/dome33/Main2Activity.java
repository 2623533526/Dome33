package com.bawei.dome33;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.dome33.adapter.ListAdapter;
import com.bawei.dome33.base.BaseActity;
import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.presenter.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseActity<Presenter> {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.quanxuan)
    CheckBox quanxuan;
    @BindView(R.id.heji)
    TextView heji;
    @BindView(R.id.tiaozhuan)
    Button tiaozhuan;

    //http://blog.zhaoliang5156.cn/api/shop/shopcart.json
    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        presenter.listsuccess();
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void success(Object object) {
        if (object instanceof ListEntity) {
            ListEntity listEntity = (ListEntity) object;
            List<ListEntity.OrderDataBean> orderData = listEntity.getOrderData();
            ListAdapter listAdapter = new ListAdapter(Main2Activity.this, orderData);
            rv.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
            rv.setAdapter(listAdapter);
        }
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
