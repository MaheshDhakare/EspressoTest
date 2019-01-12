package com.mytaxi_MobileAppAutomationTest;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
/*import static android.support.test.espresso.action.ViewActions.click;*/
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
/*import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;*/
/*import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;*/
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class HomeTest_TestCases {

    private DemoTest_ReusableMethods ReuMethods = new DemoTest_ReusableMethods();
    private ViewInteraction loginTitle = onView(withText("mytaxi demo"));
    private ViewInteraction loginError = onView(withText("Login failed"));

@Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

@Test
    public void TC_001_LoginToMytaxiDemoAppWithCorrectCredentials() {
    System.out.println("# TC_001_LoginToMytaxiDemoAppWithCorrectCredentials Starts here #");
        ReuMethods.login("crazydog335","venture");
    try {
        Thread.sleep(2000);
        loginTitle.check(matches(isDisplayed()));
        System.out.println("--Login to mytaxiDemoapp is successful");
        ReuMethods.closeTheapp();
    } catch (InterruptedException e) {
        System.out.println("--Login to mytaxiDemoapp is failed");
    }
    System.out.println("------------TC_001 Ends here-----------");
    }
@Test
    public void TC_002_LoginToMytaxiDemoAppWithInCorrectUsername() {
    System.out.println("# TC_002_LoginToMytaxiDemoAppWithInCorrectUsername Starts here #");
    ReuMethods.login("crazydog3351", "venture");
    try {
        Thread.sleep(3000);
        loginError.check(matches(isDisplayed()));
        System.out.println("--Login failed message is poped up");
        }
    catch (InterruptedException e) {
        System.out.println("--Login failed message is not poped up");
        }
    System.out.println("------------TC_002 Ends here-----------");
    }
@Test
    public void TC_003_LoginToMytaxiDemoAppWithInCorrectPassword() {
    System.out.println("# TC_003_LoginToMytaxiDemoAppWithInCorrectPassword Starts here #");
        ReuMethods.login("crazydog335","venture1");
        try {
            Thread.sleep(2000);
            loginError.check(matches(isDisplayed()));
            System.out.println("--Login failed message is poped up");
        }
        catch (InterruptedException e) {
            System.out.println("--Login failed message is not poped up");
        }
    System.out.println("------------TC_003 Ends here-----------");
    }
@Test
    public void TC_004_LoginToMytaxiDemoAppWithoutPassword() {
    System.out.println("# TC_004_LoginToMytaxiDemoAppWithoutPassword Starts here #");
        ReuMethods.login("crazydog335");
        try {
            Thread.sleep(2000);
            loginError.check(matches(isDisplayed()));
            System.out.println("--Login failed message is poped up");
        }
        catch (InterruptedException e) {
            System.out.println("--Login failed message is not poped up");
        }
    System.out.println("------------TC_004 Ends here-----------");
    }

@Test
    public void TC_005_SearchAndCallmytaxiDriver() {
    System.out.println("# TC_005_SearchAndCallmytaxiDriver Starts here #");

        ReuMethods.login("crazydog335","venture");
          System.out.println("--Login to mytaxiDemoapp is successful");
        ReuMethods.SearchAndcallDriver('s','a',"Sarah Scott");

    System.out.println("------------TC_005 Ends here-----------");
    }

@Before
    public void teardown ()
    {
        ReuMethods.closeTheapp();
    }

}
