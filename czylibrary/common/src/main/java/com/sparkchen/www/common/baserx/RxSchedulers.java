package com.sparkchen.www.common.baserx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 项目：SimpleTest on 十二月
 * 作者：${ChenZhiYu} on 2016/12/2 16:34
 * 邮箱：469142634@qq.com
 */

public class RxSchedulers {

  public static <T> Observable.Transformer<T,T> io_main() {
    return new Observable.Transformer<T, T>() {
      @Override
      public Observable<T> call(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }


}
