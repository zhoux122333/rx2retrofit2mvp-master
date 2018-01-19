package com.aragoto.api.interceptor;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * author : ARAGoTo
 * e-mail : zhoux122333@163.com
 * time   : 2018/01/16
 * desc   : 访问和回执消息的拦截器
 */


public class MessageInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        Logger.e(String.format("发送请求 %s on %s%n%s",
                request.url(), chain.connection(), request.toString()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        Logger.w(String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                response.request().url(), responseBody.string(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}
