//IT19146652
//V.W.A.N.R. Wickramasinghe

package com.example.york_4_android_app;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class VideoUploadingTest {

    @Rule
    public ActivityTestRule<VideoUploading> videoUploadingActivity = new ActivityTestRule<>(VideoUploading.class);

    private VideoUploading video = null;

    @Test
    public void testLaunch(){
        View view = video.findViewById(R.id.webview1);

        assertNotNull(view);
    }

    @Before
    public void setUp() throws Exception {
        video = videoUploadingActivity.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        video = null;
    }
}
