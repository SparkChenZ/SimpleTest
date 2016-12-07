package com.sparkchen.www.common.baseapp;

import android.app.Activity;

import java.util.Stack;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/18 15:44
 * 邮箱：469142634@qq.com
 */

public class AppManager {

  private static Stack<Activity> activityStack;
  private volatile static AppManager instance;

  private AppManager() {

  }

  /**
   * 双重校验
   * @return
   */
  public static AppManager getInstance() {
    if(instance == null) {
      synchronized (AppManager.class){
        if(instance == null) {
          instance = new AppManager();
          instance.activityStack = new Stack<>();
        }
      }
    }
    return instance;
  }


}
