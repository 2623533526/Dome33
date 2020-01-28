package com.bawei.dome33.mvp;

import java.lang.ref.WeakReference;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView>{
    public M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<V>(v);
    }
    public void detach(){
        weakReference.clear();
    }
    public V getView(){
        return weakReference.get();
    }
    protected abstract M initModel();
}
