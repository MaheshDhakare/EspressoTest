package com.mytaxi_MobileAppAutomationTest;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;

import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;

import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;


public class DemoTest_ReusableMethods {

    private ViewInteraction userName = onView(ViewMatchers.withId(R.id.edt_username));
    private ViewInteraction passWord = onView(withId(R.id.edt_password));
    private ViewInteraction loginButton = onView(withId(R.id.btn_login));

// Use this method to when to try login to demo app with username and password
    public void login(String UserName, String Password) {

        userName.check(matches(isEnabled())).perform(replaceText(UserName));
        System.out.println("--UserName entered successfully");
        passWord.check(matches(isEnabled())).perform(replaceText(Password));
        System.out.println("--Password entered successfully");
        loginButton.check(matches(isEnabled())).perform(click());
        System.out.println("--Clicked on login button successfully");

    }

// Use this method to when to try login to demo app with username only.
    public void login(String UserName) {

        userName.check(matches(isEnabled())).perform(replaceText(UserName));
        System.out.println("--UserName entered successfully");
        loginButton.check(matches(isEnabled())).perform(click());
        System.out.println("--Clicked on login button successfully");

    }

// Use this method to Search and call driver.
    public void SearchAndcallDriver(Character FirstChar, Character SecChar, String driverName) {

        String FirstChar_string = Character.toString(FirstChar);
        String SecChar_string = Character.toString(SecChar);

        try {
            Thread.sleep(2000);
            onView(withId(R.id.textSearch)).perform(typeText(FirstChar_string));
            Thread.sleep(2000);
            onView(withId(R.id.textSearch)).perform(typeText(SecChar_string), closeSoftKeyboard());
            onData(anything())
                    .inAdapterView(withId(R.id.drawer_layout)).atPosition(0).onChildView(withText(driverName)).perform(click());
/*            onView(withId(R.id.drawer_layout)).inRoot(onData(anything()).onChildView(withContentDescription("searchContainer"))
                    .onChildView(withText("Sarah Scott")).perform(click()));*/
           onView(withId(R.id.fab)).perform(click());
        } catch (InterruptedException e) {
            System.out.println("--Unable to search driver name");
        }
    }

// Use this method to will logout the app if already logged In.
    public void closeTheapp(){

        if (checkViewisDisplayed(loginButton)) {
            // Don't do anything.
        } else {
            onView(withContentDescription("Open navigation drawer")).perform(click());
            onView(withText("Logout")).perform(click());
        }
    }

// Use this method to will verify wheather the view is displayed or not.
    public boolean checkViewisDisplayed(ViewInteraction test) {
       try {

           test.check(matches(isDisplayed()));
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
