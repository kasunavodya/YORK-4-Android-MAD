//IT19146652
//V.W.A.N.R. Wickramasinghe

package com.example.york_4_android_app;

import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class NotesUploadTest {

    @Rule
    public ActivityTestRule<NoticeUpload> nActivityTestRule = new ActivityTestRule<NoticeUpload>(NoticeUpload.class);

    private NoticeUpload notesUpload = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(DisplayNotice.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        notesUpload = nActivityTestRule.getActivity();
    }


    @After
    public void tearDown() throws Exception {
    }
}