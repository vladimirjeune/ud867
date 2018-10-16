package com.example.android.clickcounter.androidtesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.clickcounter.ClickActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ClickFragmentTest {

    @Rule
    public ActivityTestRule<ClickActivity> mActivityRule = new ActivityTestRule<>(ClickActivity.class);

    // TODO: Put a couple reasonable Espresso tests here.


}
