package org.kkonrad.polideainterview.ui.fragment;

import android.support.v4.app.Fragment;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.kkonrad.polideainterview.R;

@EFragment(R.layout.fragment_question_details)
public class QuestionDetailsFragment extends Fragment {

    public static final String DETAILS_LINK = "DETAILS_LINK";

    @ViewById(R.id.question_details)
    protected WebView mQuestionDetails;

    @AfterViews
    public void prepareQueryDetails(){

        mQuestionDetails.getSettings().setJavaScriptEnabled(true);
        mQuestionDetails.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                mQuestionDetails.loadUrl("javascript:(function() { " +
                        "document.getElementsByTagName('header')[0].style.display=\"none\"; " +
                        "})()");
            }
        });

        final String link = getActivity().getIntent().getStringExtra(DETAILS_LINK);
        if(link != null) {
            mQuestionDetails.loadUrl(link);
        }
    }
}
