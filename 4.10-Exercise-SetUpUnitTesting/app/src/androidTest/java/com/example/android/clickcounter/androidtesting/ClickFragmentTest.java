package com.example.android.clickcounter.androidtesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.clickcounter.ClickActivity;
import com.example.android.clickcounter.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ClickFragmentTest {

    @Rule
    public ActivityTestRule<ClickActivity> mActivityRule
            = new ActivityTestRule<>(ClickActivity.class);

    // TODO: Put a couple reasonable Espresso tests here.
    @Test
    public void verifyClickButtonIncrementsValue() {
        String zeroValue = "0";
        String onePlusZeroValue = "1";

        // Find the initial value that should be zero
        onView(withId(R.id.click_count_text_view)).check(matches(withText(zeroValue)));

        // Find the button and click it
        onView(withId(R.id.click_button)).perform(click());

        // Find the new value and make sure it has incremented
        onView(withId(R.id.click_count_text_view)).check(matches(withText(onePlusZeroValue)));

    }



}
