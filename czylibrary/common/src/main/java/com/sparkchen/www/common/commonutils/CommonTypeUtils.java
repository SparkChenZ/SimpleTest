package com.sparkchen.www.common.commonutils;

import java.lang.reflect.ParameterizedType;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/17 17:29
 * 邮箱：469142634@qq.com
 */

public class CommonTypeUtils {

  public static <T> T getT(Object object,int i) {
    try {
      return ((Class<T>)  ((ParameterizedType) (object.getClass()
              .getGenericSuperclass())).getActualTypeArguments()[i])
              .newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return null;
  }

}
