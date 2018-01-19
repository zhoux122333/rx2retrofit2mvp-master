package com.aragoto.base;

import com.aragoto.api.Api;
import com.aragoto.api.RetrofitUtil;

import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;

/**
 * author : ARAGoTo
 * e-mail : zhoux122333@163.com
 * time   : 2018/01/18
 * desc   : basePresenter泛型
 */


public abstract class BasePresenter<V>{
    protected Api mApi = RetrofitUtil.getInstance().getApi();
    protected V mView;
    private ArrayCompositeSubscription arrayCompositeSubscription;
}
