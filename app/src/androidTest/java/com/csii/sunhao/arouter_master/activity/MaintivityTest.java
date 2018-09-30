package com.csii.sunhao.arouter_master.activity;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.csii.MainActivity;
import com.csii.sunhao.arouter_master.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * ViewMatchers - 在当前View层级去匹配指定的View .
 * ViewActions - 执行Views的某些行为，如点击事件 .
 * ViewAssertions - 检查Views的某些状态，如是否显示 .
 */
@RunWith(AndroidJUnit4.class)
public class MaintivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickTest(){

        onView(withId(R.id.test)) //1.匹配View
                .perform(click()) //2.执行View行为
                .check(matches(isDisplayed())); //3.验证View


    }



}
