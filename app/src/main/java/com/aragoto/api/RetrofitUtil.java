package com.aragoto.api;

import com.aragoto.api.interceptor.MessageInterceptor;
import com.aragoto.data.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : ARAGoTo
 * e-mail : zhoux122333@163.com
 * time   : 2018/01/16
 * desc   : Retrofit工具类
 */


public class RetrofitUtil {
    //单列
    private volatile static RetrofitUtil mInstance;
    private Retrofit mRetrofit;
    private Api mApi;

    private RetrofitUtil(){
        mRetrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(Constant.host)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = mRetrofit.create(Api.class);
    }
    public static RetrofitUtil getInstance(){
        if (mInstance==null){
            synchronized (RetrofitUtil.class){
                if (mInstance == null){
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    private static OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .addInterceptor(new MessageInterceptor())
                .build();
    }

    public Api getApi(){
        return mApi;
    }
}
