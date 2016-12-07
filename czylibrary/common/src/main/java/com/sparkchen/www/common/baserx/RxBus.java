package com.sparkchen.www.common.baserx;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.subjects.Subject;

/**
 * 项目：SimpleTest on 十二月
 * 作者：${ChenZhiYu} on 2016/12/2 17:22
 * 邮箱：469142634@qq.com
 */

public class RxBus {

  private static RxBus instance;

  @SuppressWarnings("rawtypes")
  private ConcurrentHashMap<Object,List<Subject>> subjectMapper = new ConcurrentHashMap<>();

  public static synchronized RxBus getInstance() {
    if(instance == null) {
      instance = new RxBus();
    }
    return instance;
  }

  private RxBus() {
  }
}
