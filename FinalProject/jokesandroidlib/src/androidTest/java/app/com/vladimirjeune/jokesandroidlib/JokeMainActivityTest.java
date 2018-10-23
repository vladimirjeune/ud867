package app.com.vladimirjeune.jokesandroidlib;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class JokeMainActivityTest {

    private String sortOfFunnyJoke = "A guy walks into a NoSQL bar; immediately walks out because there are no tables.";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
    = new ActivityTestRule<MainActivity>(MainActivity.class) {

        // Needed to test that when given a joke, because we are not a standalone app and we're given
        // an Intent Extra to start. Needed to be tested. Got code from here.
        // https://github.com/barend/android-espresso-intent-sample/blob/master/app/src/androidTest/java/nl/garvelink/blog/espressointentsample/MainActivityLaunchIntentTest.java
        // https://xebia.com/blog/android-intent-extras-espresso-rules/
        @Override
        protected Intent getActivityIntent() {
//          String  sortOfFunnyJoke = "A guy walks into a NoSQL bar; immediately walks out because there are no tables.";
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, MainActivity.class);
            result.putExtra(MainActivity.JOKE_TAG, sortOfFunnyJoke);
            return result;
        }
    };

    // TODO: Test code. This is a placeholder
    // https://developer.android.com/training/testing/espresso/intents
    // https://developer.android.com/training/testing/set-up-project
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("app.com.vladimirjeune.jokesandroidlib.test", appContext.getPackageName());
    }


    @Test
    public void acceptsJokeIntentTest() {
        onView(withId(R.id.tv_joke)).check(matches(withText(sortOfFunnyJoke)));
    }

}
