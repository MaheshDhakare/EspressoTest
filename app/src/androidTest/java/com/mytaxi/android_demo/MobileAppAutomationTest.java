package com.mytaxi.android_demo;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressBackUnconditionally;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MobileAppAutomationTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() throws InterruptedException {

        loginToMyTaxi("crazydog335","venture");

        Thread.sleep(8000);
        onView(withId(R.id.textSearch)).perform(replaceText("s"));
        Thread.sleep(2000);
        onView(withId(R.id.textSearch)).perform(typeText("a"));
        Thread.sleep(5000);
//        ViewInteraction test734 = onData(anything()).atPosition(1).perform(click());
//        ViewInteraction appCompatTextView = onData(anything()).inAdapterView(withClassName(is("android.widget.EditText")))
//                .atPosition(2)
//                .perform(click());

//         Thread.sleep(8000);
        pressBackUnconditionally();

        Thread.sleep(5000);
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Logout")).perform(click());

    }

    public void loginToMyTaxi(String UserName, String Password) {

        ViewInteraction userName = onView(withId(R.id.edt_username)).perform(replaceText(UserName));
        ViewInteraction passWord = onView(withId(R.id.edt_password)).perform(replaceText(Password));
        ViewInteraction loginButton = onView(withId(R.id.btn_login)).perform(click());

    }
    public void checkElementVisibility(String UserName, String Password) {

        ViewInteraction check = onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
    }
}
