package com.bawei.dome33.model;

import android.annotation.SuppressLint;

import com.bawei.dome33.cantract.Cantract;
import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.entity.LogonEntity;
import com.bawei.dome33.entity.RegisterEntity;
import com.bawei.dome33.servier.Server;
import com.bawei.dome33.utils.NetView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public class Model implements Cantract.IModel  {
    @Override
    public void logonsuccess(Map<String, String> map, Cantract.IModel.LogonBackcall logonBackcall) {
        NetView.getInstance().create(Server.class)
                .getlogon(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LogonEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LogonEntity logonEntity) {
                        logonBackcall.success(logonEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                     logonBackcall.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




    @Override
    public void registersuccess(Map<String, String> map, RegisterBackcall registerBackcall) {
        NetView.getInstance().create(Server.class)
                .getregister(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterEntity logonEntity) {
                        registerBackcall.success(logonEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        registerBackcall.error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void listsuccess(ListBackcall listBackcall) {
        NetView.getInstance().listcreate(Server.class)
                .getlist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ListEntity>() {
                    @Override
                    public void accept(ListEntity listEntity) throws Exception {
                       listBackcall.success(listEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listBackcall.error(throwable);
                    }
                });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
