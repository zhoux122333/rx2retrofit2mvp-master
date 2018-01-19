package com.aragoto.mvp.presenter;

import com.aragoto.api.RetrofitUtil;
import com.aragoto.data.entity.Gank1;
import com.aragoto.mvp.view.GankView;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author : ARAGoTo
 * e-mail : zhoux122333@163.com
 * time   : 2018/01/18
 * desc   :
 */


public class GankPresenter {
    private GankView view;

    public GankPresenter(GankView view) {
        this.view = view;
    }

    public void loadInfo(){
        RetrofitUtil.getInstance().getApi().getAllGank()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Gank1>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Logger.e("onSubscribe成功",d);
                    }

                    @Override
                    public void onNext(Gank1 gank1) {
                        Logger.e("onNext成功",gank1.toString());

                        view.showInfoSuccess(gank1);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e("onError失败",e.getMessage());
                        view.showInfoFail();
                    }

                    @Override
                    public void onComplete() {
                        Logger.e("onComplete成功");

                    }
                });
    }

}
