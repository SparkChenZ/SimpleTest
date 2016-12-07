package com.sparkchen.android.simpletest;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sparkchen.www.common.base.BaseActivity;
import com.sparkchen.www.common.permission.AfterPermissionGranted;
import com.sparkchen.www.common.permission.EasyPermissions;

import java.util.List;

import butterknife.Bind;

/**
 * 项目：SimpleTest on 十一月
 * 作者：${ChenZhiYu} on 2016/11/28 17:00
 * 邮箱：469142634@qq.com
 */

public class TestPermissionActivity extends BaseActivity implements View.OnClickListener {

  private static final int REQUEST_CAMERA_PERMISSION = 0x01;
  private static final int REQUEST_OPEN_CAMERA = 1;

  private static final int REQUEST_PHONE_PERMISSION = 0x02;
  private static final int REQUEST_PHONE_CALL = 2;
  @Bind(R.id.button)
  Button button;
  @Bind(R.id.button2)
  Button button2;
  @Bind(R.id.button3)
  Button button3;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public int getLayoutId() {
    return R.layout.test_activity_permission;
  }

  @Override
  public void initPresenter() {

  }

  @Override
  public void initView() {
    button.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
  }

  @Override
  public void onPermissionsGranted(int requestCode, List perms) {
    super.onPermissionsGranted(requestCode, perms);
    switch (requestCode) {
      case REQUEST_OPEN_CAMERA:
        Toast.makeText(this, "相机权限通过", Toast.LENGTH_SHORT).show();
        break;
      case REQUEST_PHONE_CALL:
        Toast.makeText(this, "电话权限通过", Toast.LENGTH_SHORT).show();
        break;
    }
  }

  @Override
  public void onPermissionsDenied(int requestCode, List perms) {
    super.onPermissionsDenied(requestCode, perms);
    switch (requestCode) {
      case REQUEST_OPEN_CAMERA:
        Toast.makeText(this, "相机权限拒绝", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
          EasyPermissions.onPermissionsPermanentlyDenied(this,
                  getString(R.string.rationale),
                  getString(R.string.rationale_title),
                  getString(android.R.string.ok),
                  getString(android.R.string.cancel),
                  PERMANENTLY_DENIED_REQUEST_CODE);
        }
        break;
      case REQUEST_PHONE_CALL:
        Toast.makeText(this, "电话权限拒绝", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
          EasyPermissions.onPermissionsPermanentlyDenied(this,
                  getString(R.string.rationale),
                  getString(R.string.rationale_title),
                  getString(android.R.string.ok),
                  getString(android.R.string.cancel),
                  PERMANENTLY_DENIED_REQUEST_CODE);
        }
        break;
    }
  }

  @AfterPermissionGranted(REQUEST_CAMERA_PERMISSION)
  private void openCamera() {
    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(intent, REQUEST_OPEN_CAMERA);
    }
  }

  @AfterPermissionGranted(REQUEST_PHONE_PERMISSION)
  private void callPhone() {
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_CALL);
    Uri uri = Uri.parse("tel://10086");
    intent.setData(uri);
    startActivityForResult(intent,REQUEST_PHONE_CALL);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.button:
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
          openCamera();
        } else {
          EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera), REQUEST_CAMERA_PERMISSION, Manifest.permission.CAMERA);
        }
        break;
      case R.id.button2:
        if(EasyPermissions.hasPermissions(this,Manifest.permission.CALL_PHONE)) {
          callPhone();
        } else {
          EasyPermissions.requestPermissions(this, getString(R.string.rationale_phone), REQUEST_PHONE_PERMISSION, Manifest.permission.CALL_PHONE);
        }
        break;
      case R.id.button3:

        break;
    }
  }
}
