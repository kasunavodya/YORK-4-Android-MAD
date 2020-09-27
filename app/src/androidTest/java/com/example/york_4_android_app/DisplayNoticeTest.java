package com.example.york_4_android_app;

import android.view.View;
import android.widget.ImageView;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayNoticeTest {

    @Rule
    public ActivityTestRule<DisplayNotice> eActivityTestRule = new ActivityTestRule<DisplayNotice>(DisplayNotice.class);

    private DisplayNotice notice = null;
    private ImageView Imageview;

    @Before
    public void setUp() throws Exception {
        notice = eActivityTestRule.getActivity();

        Imageview = (ImageView) notice.findViewById(R.id.autoCompleteTextView);
    }

    @After
    public void tearDown() throws Exception {

        notice = null;
    }

    @Test
    public void testLaunch(){
    /*    View view = notice.findViewById(R.id.displayImageView);
        assertNotNull(view);*/
    }
}