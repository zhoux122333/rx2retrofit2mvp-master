package com.aragoto.api;

import com.aragoto.data.entity.Gank1;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author : ARAGoTo
 * e-mail : zhoux122333@163.com
 * time   : 2018/01/16
 * desc   : gankApi
 */


public interface Api {
    //http://gank.io/api
    //所有干货
    @GET("data/Android/10/1")
    Observable<Gank1> getAllGank();


//    @GET("data/Android/10/1")
//    Call<ResponseBody> getAllGankNoRx();

}
