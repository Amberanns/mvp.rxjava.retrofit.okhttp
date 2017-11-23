package com.bawei.mvprjo.model;

import com.bawei.mvprjo.LoggingInterceptor;
import com.bawei.mvprjo.api.Api;
import com.bawei.mvprjo.api.ApiService;
import com.bawei.mvprjo.bean.MyBean;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class model implements Imodel{
    private Retrofit retrofit;
    private ApiService apiService;
    private Observable<MyBean> noParams;

    @Override
    public void Request(String url, final Onclick onclick) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Api.PATH)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        //通过动态代理得到网络接口对象
        apiService = retrofit.create(ApiService.class);
        noParams = apiService.getdatas();

        noParams.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onclick.error(e.getMessage().toString());
                    }


                    @Override
                    public void onNext(MyBean bean) {
                        List<MyBean.SongListBean>data=bean.getSong_list();
                        onclick.datasuccess(data);
                    }
                });

    }
}
