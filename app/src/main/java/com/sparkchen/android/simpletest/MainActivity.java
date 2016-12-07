package com.sparkchen.android.simpletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sparkchen.www.common.base.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    public void onButtonClick(View view){

        switch (view.getId()){
            case R.id.btn_first_style:
                jump(FirstStyleActivity.class);
                break;
            case R.id.btn_second_style:
                jump(SecondStyleActivity.class);
                break;

            case R.id.btn_third_style:
                jump(ThreeActivity.class);
                break;
            default:
                break;
        }
    }

    public void jump(Class<? extends Activity> clz){
        Intent intent = new Intent();
        intent.setClass(this,clz);
        startActivity(intent);
    }
}
