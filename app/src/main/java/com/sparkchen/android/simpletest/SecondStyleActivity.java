package com.sparkchen.android.simpletest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class SecondStyleActivity extends AppCompatActivity {

    public static final String[] mTiltles = new String[]{
            "首页", "课程", "直播", "个人"
    };
    private List<Fragment> mFragments;
    ViewPager mViewPager;
    RadioGroup mRg;
    private int position = 0;
    private static int tabLayoutHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_style);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mRg = (RadioGroup) findViewById(R.id.rg);
        initListener();
        initData();
        mRg.measure(0,0);
        tabLayoutHeight=mRg.getMeasuredHeight();


    }

    private void initData() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTiltles.length; i++) {
            ItemFragement itemFragement = ItemFragement.newInstance(mTiltles[i]);
            mFragments.add(itemFragement);
        }
        BaseFragmentAdapter fragmentAdapter = new BaseFragmentAdapter
                (getSupportFragmentManager(), mFragments, mTiltles);

        mViewPager.setAdapter(fragmentAdapter);
        //  设置左右页面 能缓存的fragment 数量
        mViewPager.setOffscreenPageLimit(fragmentAdapter.getCount() - 1);
        mViewPager.setCurrentItem(position);
        ((RadioButton) mRg.getChildAt(position)).setChecked(true);
    }

    /**
     * 菜单显示隐藏动画
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide){
        final ViewGroup.LayoutParams layoutParams = mRg.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if(!showOrHide){
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(mRg, "alpha", 1, 0);
        }else{
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(mRg, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height= (int) valueAnimator.getAnimatedValue();
                mRg.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator,alpha);
        animatorSet.start();
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                RadioButton radioButton = (RadioButton) mRg.getChildAt(position);
                radioButton.setChecked(true);
            }
        });

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (!rb.isChecked()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        startAnimation(true);
                        break;

                    case R.id.rb_course:
                        position = 1;
                        startAnimation(false);
                        break;

                    case R.id.rb_direct_seeding:
                        position = 2;
                        break;

                    case R.id.rb_me:
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;

                }
                mViewPager.setCurrentItem(position);
            }
        });
    }
}
