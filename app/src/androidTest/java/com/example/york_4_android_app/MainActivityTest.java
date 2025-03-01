//IT19144986
//H.M.Kasuni Navodya

package com.example.york_4_android_app;
import android.view.View;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){

        View view = mActivity.findViewById(R.id.textVw1);

        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;

    }
}