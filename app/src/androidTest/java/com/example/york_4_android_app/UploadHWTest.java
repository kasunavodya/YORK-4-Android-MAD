//IT19144986
//H.M.Kasuni Navodya

package com.example.york_4_android_app;

import android.view.View;
import android.widget.EditText;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class UploadHWTest {

    @Rule
    public ActivityTestRule<UploadHW> eActivityTestRule = new ActivityTestRule<UploadHW>(UploadHW.class);

    private UploadHW upload = null;
    private EditText Title;

    @Before
    public void setUp() throws Exception {
        upload = eActivityTestRule.getActivity();

        Title = (EditText) upload.findViewById(R.id.autoCompleteTextView);

    }

    @Test
    public void testLaunch(){

        View view = upload.findViewById(R.id.textVw1);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        upload = null;

    }

    public void testText() {
        assertEquals("",Title.getText());

    }

}