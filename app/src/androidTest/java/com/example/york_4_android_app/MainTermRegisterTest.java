//IT19162560
//Lebunahewa.O.I

package com.example.york_4_android_app;

import android.view.View;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTermRegisterTest {

    @Rule
    public ActivityTestRule<MainTermRegister> eActivityTestRule = new ActivityTestRule<MainTermRegister>(MainTermRegister.class);
    private MainTermRegister Activity = null;

    @Before
    public void setUp() throws Exception {
        Activity = eActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){
        View view = Activity.findViewById(R.id.Sid);
        assertNotNull(view);

    }
}