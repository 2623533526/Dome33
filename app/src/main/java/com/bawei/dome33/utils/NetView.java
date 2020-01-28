package com.bawei.dome33.utils;



import com.blankj.utilcode.util.NetworkUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public  class NetView {
    private static NetView netUtilts;
    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;

    private NetView() {
        okHttpClient = new OkHttpClient.Builder()
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://mobile.bwstudent.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static NetView getInstance() {
        if(netUtilts==null){
            synchronized (NetView.class){
                if(netUtilts==null){
                    netUtilts=new NetView();
                }
            }
        }
        return netUtilts;
    }

   public <T>T create(Class<T> tClass){
       T t = retrofit.create(tClass);
       return t;
   }
    public <T>T listcreate(Class<T> tClass){
        Retrofit retrofit= new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://blog.zhaoliang5156.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T t = retrofit.create(tClass);
        return t;
    }
    public boolean has(){
        return NetworkUtils.isConnected();
    }

}
