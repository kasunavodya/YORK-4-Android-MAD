//IT19146652
//V.W.A.N.R. Wickramasinghe

package com.example.york_4_android_app;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class NoticeUploadTest {

    @Rule
    public ActivityTestRule<NoticeUpload> nActivityTestRule = new ActivityTestRule<NoticeUpload>(NoticeUpload.class);

    private NoticeUpload nActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(DisplayNotice.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {

        nActivity = nActivityTestRule.getActivity();
    }

    @Test
    public  void testLaunchSecondActivityOnButtonClick(){
        assertNotNull(nActivity.findViewById(R.id.cameraBtn));

        onView(withId(R.id.cameraBtn)).perform(click());

        Activity secondActicvity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(secondActicvity);
        secondActicvity.finish();

    }

    @After
    public void tearDown() throws Exception {
    }
}