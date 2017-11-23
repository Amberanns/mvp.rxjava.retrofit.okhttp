package com.bawei.mvprjo.api;

import com.bawei.mvprjo.bean.MyBean;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiService {
    @GET("v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
    Observable<MyBean> getdatas();
}
