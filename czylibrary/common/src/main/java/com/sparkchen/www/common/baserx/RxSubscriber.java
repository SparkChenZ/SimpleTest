package com.sparkchen.www.common.baserx;

import android.content.Context;

import rx.Subscriber;

/**
 * 项目：SimpleTest on 十二月
 * 作者：${ChenZhiYu} on 2016/12/2 15:28
 * 邮箱：469142634@qq.com
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {

  private Context mContext;
  private String showMsg;
  private boolean isShowDialog;


  public RxSubscriber(Context context, String showMsg, boolean isShowDialog) {
    this.mContext = context;
    this.showMsg = showMsg;
    this.isShowDialog = isShowDialog;
  }

  public RxSubscriber(Context context) {
    this(context, "todo msg", true);
  }

  public RxSubscriber(Context context, boolean isShowDialog) {
    this(context, "todo msg", isShowDialog);
  }


  @Override
  public void onStart() {
    super.onStart();
    if (isShowDialog) {
      // TODO: 2016/12/2 loading start
    }
  }

  @Override
  public void onCompleted() {
    if (isShowDialog) {
      // TODO: 2016/12/2 loading cancel
    }
  }

  @Override
  public void onError(Throwable e) {
    if (isShowDialog) {
      // TODO: 2016/12/2 loading cancel
    }
    if(e instanceof ServerException) {
      _onError(e.getMessage());
    } else {
      _onError("其他错误");
    }
  }

  @Override
  public void onNext(T t) {
    _onNext(t);
  }

  protected abstract void _onNext(T t);

  protected abstract void _onError(String errorMsg);
}
