package com.bawei.dome33.cantract;

import com.bawei.dome33.entity.ListEntity;
import com.bawei.dome33.entity.LogonEntity;
import com.bawei.dome33.entity.RegisterEntity;
import com.bawei.dome33.mvp.IBaseModel;
import com.bawei.dome33.mvp.IBaseView;

import java.util.Map;

/**
 * @author: 张家辅
 * @date: 2020/01/22
 */
public interface Cantract {
   public   interface IView extends IBaseView
    {
        void success(Object object);
        void error(Throwable throwable);
    }
    public   interface IPresenter
    {
        void logonsuccess(Map<String, String> map);
        void registersuccess(Map<String, String> map);
        void listsuccess();
        void error(Throwable throwable);
    }
    public   interface IModel extends IBaseModel
    {
        void logonsuccess(Map<String, String> map, LogonBackcall logonBackcall);
        void registersuccess(Map<String, String> map, RegisterBackcall registerBackcall);
        void listsuccess(ListBackcall listBackcall);
        void error(Throwable throwable);
        interface RegisterBackcall{
            void success(RegisterEntity registerEntity);
            void error(Throwable throwable);
        }
        interface LogonBackcall{
            void success(LogonEntity logonEntity);
            void error(Throwable throwable);
        }
        interface ListBackcall{
            void success(ListEntity listEntity);
            void error(Throwable throwable);
        }
    }
}
