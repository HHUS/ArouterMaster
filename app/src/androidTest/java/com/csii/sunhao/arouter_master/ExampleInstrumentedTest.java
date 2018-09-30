package com.csii.sunhao.arouter_master;

import android.content.Context;
import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.csii.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public ActivityTestRule<MainActivity> rule=new ActivityTestRule<MainActivity>(MainActivity.class,true);


    @Test
    public void login(){
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.csii.sunhao.arouter_master", appContext.getPackageName());
    }

    @Test
    public void useAppContext2() {
        // Context of the app under test.

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.csii.sunhao.arouter_master", appContext.getPackageName());
    }
}
