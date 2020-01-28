package com.bawei.dome33.presenter;


import com.bawei.dome33.cantract.Cantract;
import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.entity.LogonEntity;
import com.bawei.dome33.entity.RegisterEntity;
import com.bawei.dome33.model.Model;
import com.bawei.dome33.mvp.BasePresenter;

import java.util.Map;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public class Presenter extends BasePresenter<Model, Cantract.IView> implements Cantract.IPresenter {
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void logonsuccess(Map<String, String> map) {
        model.logonsuccess(map, new Cantract.IModel.LogonBackcall() {
            @Override
            public void success(LogonEntity logonEntity) {
                getView().success(logonEntity);
            }

            @Override
            public void error(Throwable throwable) {
             getView().error(throwable);
            }
        });
    }

    @Override
    public void registersuccess(Map<String, String> map) {
        model.registersuccess(map, new Cantract.IModel.RegisterBackcall() {
            @Override
            public void success(RegisterEntity registerEntity) {
                getView().success(registerEntity);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    public void listsuccess() {
        model.listsuccess(new Cantract.IModel.ListBackcall() {
            @Override
            public void success(ListEntity listEntity) {
                getView().success(listEntity);
            }

            @Override
            public void error(Throwable throwable) {
              getView().error(throwable);
            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
