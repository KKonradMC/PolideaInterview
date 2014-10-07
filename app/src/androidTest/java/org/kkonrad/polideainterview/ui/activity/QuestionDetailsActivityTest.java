package org.kkonrad.polideainterview.ui.activity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.kkonrad.polideainterview.R;
import org.kkonrad.polideainterview.ui.fragment.QuestionDetailsFragment;


public class QuestionDetailsActivityTest extends ActivityInstrumentationTestCase2<QuestionDetailsActivity_> {

    private Solo mSolo;

    public QuestionDetailsActivityTest(){
        super(QuestionDetailsActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        Intent intent = new Intent(getActivity(), QuestionDetailsActivity_.class);
        intent.putExtra(QuestionDetailsFragment.DETAILS_LINK, "http://stackoverflow.com/questions/26221243/adding-integers-to-multiplication-table");
        setActivityIntent(intent);
        mSolo = new Solo(getInstrumentation(), getActivity());
    }

    public void testPrecondition(){
        mSolo.assertCurrentActivity("Wrong activity", QuestionDetailsActivity_.class);
        assertTrue(mSolo.getView(R.id.question_details) != null);
    }
}
