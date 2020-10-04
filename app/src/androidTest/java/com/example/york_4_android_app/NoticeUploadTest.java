//IT19146652
//V.W.A.N.R. Wickramasinghe

package com.example.york_4_android_app;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoticeUploadTest {

    @Rule
    public ActivityTestRule<NoticeUpload> eActivityTestRule = new ActivityTestRule<NoticeUpload>(NoticeUpload.class);

    private NoticeUpload notice = null;
    private ImageView Imageview;


    @Before
    public void setUp() throws Exception {

        notice = eActivityTestRule.getActivity();

        Imageview = (ImageView) notice.findViewById(R.id.autoCompleteTextView);

    }
    @Test
    public void testLaunch(){
        View view = notice.findViewById(R.id.displayImageView);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        notice = null;

    }
}
