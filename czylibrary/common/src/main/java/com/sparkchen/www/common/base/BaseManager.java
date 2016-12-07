package com.sparkchen.www.common.base;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/17 11:45
 * 邮箱：469142634@qq.com
 */

public interface BaseManager {

  interface Model extends BaseModel {
  }

  interface View extends BaseView {
  }

  abstract static class Presenter extends BasePresenter<Model, View> {

  }


}
