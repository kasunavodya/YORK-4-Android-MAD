//IT19168814
// Y.D Gogerly

package com.example.york_4_android_app;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddTimetable3Test {

    @Rule
    public ActivityTestRule<AddTimetable3> tActivityTestRule = new ActivityTestRule<AddTimetable3>(AddTimetable3.class);

    private AddTimetable3 tActivity = null;

    @Before
    public void setUp() throws Exception {

        tActivity = tActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch() {

        View view = tActivity.findViewById(R.id.textVw1);

        assertNotNull(view);

    }
}