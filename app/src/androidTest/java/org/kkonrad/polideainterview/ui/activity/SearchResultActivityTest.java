package org.kkonrad.polideainterview.ui.activity;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;


import com.robotium.solo.Solo;

import org.kkonrad.polideainterview.R;

public class SearchResultActivityTest extends ActivityInstrumentationTestCase2<SearchActivity_> {

    private Solo mSolo;

    public SearchResultActivityTest() {
        super(SearchActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        mSolo = new Solo(getInstrumentation(), getActivity());
    }

    public void testPrecondition(){
        mSolo.assertCurrentActivity("Wrong activity", SearchActivity_.class);
        assertTrue(mSolo.getView(R.id.search_field) != null);
        assertTrue(mSolo.getView(R.id.search_button)  != null);
    }

    public void testIsErrorDisplayed(){
        final String message = getActivity().getString(R.string.search);
        mSolo.clickOnButton(message);
        mSolo.sleep(2000);
        final String errorMessage = getActivity().getString(R.string.field_cant_be_empty);
        assertEquals(errorMessage, ((EditText) mSolo.getView(R.id.search_field)).getError());
    }

    public void testIsErrorHidden(){
        final String message = getActivity().getString(R.string.search);
        mSolo.clickOnButton(message);
        mSolo.sleep(2000);
        final String errorMessage = getActivity().getString(R.string.field_cant_be_empty);
        final EditText editText = ((EditText) mSolo.getView(R.id.search_field));
        assertEquals(errorMessage, editText.getError());
        
        mSolo.sleep(2000);
        mSolo.enterText(editText, "java");
        assertEquals(null, editText.getError());
    }


    @Override
    public void tearDown() throws Exception {
        mSolo.finishOpenedActivities();
    }
}
