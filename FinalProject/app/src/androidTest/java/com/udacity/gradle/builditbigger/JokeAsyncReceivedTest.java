package com.udacity.gradle.builditbigger;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncReceivedTest {

    // We have access to MainActivity
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    /**
     * Beginning the Fragment so we have it available for our tests.
     * You could also do it in the test function
     * https://android.jlelse.eu/the-basics-of-android-espresso-testing-activities-fragments-7a8bfbc16dc5
     */
    @Before
    public void init() {
        mMainActivityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void jokeAsyncReceivedTest() {


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withId(R.id.tell_joke_button)).perform(click());

        // The Interstitial
        ViewInteraction imageButton = onView(allOf(withContentDescription("Interstitial close button"), isDisplayed()));
        imageButton.perform(click());

        // Now should be on AndroidLib's MainActivity
        onView(withId(R.id.tv_joke)).check(matches(not(withText(""))));

    }

}
