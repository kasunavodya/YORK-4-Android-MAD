//IT19144986
//H.M.Kasuni Navodya

package com.example.york_4_android_app;

import android.view.View;
import android.widget.Button;
import androidx.test.filters.SmallTest;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnterDetailsTest {

    @Rule
    public ActivityTestRule<EnterDetails> eActivityTestRule = new ActivityTestRule<EnterDetails>(EnterDetails.class);

    private EnterDetails eActivity = null;

    @Before
    public void setUp() throws Exception {
        eActivity = eActivityTestRule.getActivity();

    }

    @Test
    public void testLaunch(){

        View view = eActivity.findViewById(R.id.editTextTextPersonNameID);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        eActivity = null;

    }

    @SmallTest
    public void testbutton() {

        Button btn = (Button) eActivityTestRule.getActivity().findViewById(R.id.button2);
        assertNotNull(btn);

    }



}