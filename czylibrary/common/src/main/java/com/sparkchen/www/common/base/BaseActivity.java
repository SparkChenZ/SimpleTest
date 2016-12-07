package com.sparkchen.www.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sparkchen.www.common.permission.EasyPermissions;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/4 16:06
 * 邮箱：469142634@qq.com
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

  private P mPresenter;
  private M mModel;
  private Context mContext;

  public static final int PERMANENTLY_DENIED_REQUEST_CODE = 428;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    mContext = this;
    ButterKnife.bind(this);
//    mPresenter = CommonTypeUtils.getT(this, 0);
//    mModel = CommonTypeUtils.getT(this, 1);
    this.initView();
    this.initPresenter();
  }


  // 获取activity布局资源
  public abstract int getLayoutId();

  // 需要MVP模式页面在其中进行初始化绑定
  public abstract void initPresenter();

  // 初始化activity控件view
  public abstract void initView();

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  @Override
  public void onPermissionsGranted(int requestCode, List<String> perms) {

  }

  @Override
  public void onPermissionsDenied(int requestCode, List<String> perms) {

  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }
}
