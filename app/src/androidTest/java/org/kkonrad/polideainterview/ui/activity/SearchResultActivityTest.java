package org.kkonrad.polideainterview.ui.activity;


import android.test.ActivityInstrumentationTestCase2;


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

    @Override
    public void tearDown() throws Exception {
        mSolo.finishOpenedActivities();
    }
}
