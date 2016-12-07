package com.sparkchen.www.common.base;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/17 11:21
 * 邮箱：469142634@qq.com
 */

public interface BaseView {

  void showLoading(String loadContent);

  void showStop();

  void showErrorTip(String errorMsg);
}
