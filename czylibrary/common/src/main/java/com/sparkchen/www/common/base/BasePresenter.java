package com.sparkchen.www.common.base;

import android.content.Context;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/4 16:12
 * 邮箱：469142634@qq.com
 */

public abstract class BasePresenter<M, V> {

  //// TODO: 2016/11/16 考虑增加 Rx 框架关联 BasePresenter
  //// TODO: 2016/11/16 考虑增加 BasePresenter 中的生命周期  1.onStart  2.onDestroy

  private Context mContext;
  private M mModel;
  private V mView;

  public void setVM(M model, V view) {
    this.mModel = model;
    this.mView = view;
  }



}
