package com.bawei.dome33.servier;

import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.entity.LogonEntity;
import com.bawei.dome33.entity.RegisterEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public interface Server {
    @POST("small/user/v1/register")
    @FormUrlEncoded
     Observable<RegisterEntity> getregister(@FieldMap Map<String, String> map);
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<LogonEntity> getlogon(@FieldMap Map<String, String> map);
    @GET("api/shop/shopcart.json")
    Observable<ListEntity> getlist();
}
