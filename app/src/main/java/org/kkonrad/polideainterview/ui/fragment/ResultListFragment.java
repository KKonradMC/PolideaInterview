package org.kkonrad.polideainterview.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.rest.RestErrorHandler;
import org.kkonrad.polideainterview.R;
import org.kkonrad.polideainterview.adapter.ResultListAdapter;
import org.kkonrad.polideainterview.model.Question;
import org.kkonrad.polideainterview.model.QuestionList;
import org.kkonrad.polideainterview.rest.SearchRestClient;
import org.kkonrad.polideainterview.ui.activity.QuestionDetailsActivity_;
import org.springframework.core.NestedRuntimeException;
import org.springframework.web.client.RestClientException;

import timber.log.Timber;

@EFragment(R.layout.fragment_result_list)
@OptionsMenu(R.menu.menu_result_list_fragment)
public class ResultListFragment extends Fragment {

    public static final String FRAGMENT_ARGS = "FRAGMENT_ARGS";
    public static final String QUESTION_LIST = "QUESTION_LIST";
    public static final String SEARCH_WORD = "SEARCH_WORD";
    @ViewById(R.id.result_list)
    protected ListView mResultList;

    @RestService
    protected SearchRestClient mSearchRestClient;

    @InstanceState
    protected QuestionList mQuestionList;

    @InstanceState
    protected String mSearchWord;

    @AfterViews
    protected void prepareResultList(){
        final Bundle args =  getActivity().getIntent().getBundleExtra(FRAGMENT_ARGS);
        if(args != null) {
            if (mSearchWord == null) {
                mSearchWord = args.getString(SEARCH_WORD);
            }
            if (mQuestionList == null) {
                mQuestionList = args.getParcelable(QUESTION_LIST);
            }
        }else {
            throw new IllegalArgumentException("Args cannot be null.");
        }
        mResultList.setAdapter(new ResultListAdapter(getActivity(),mQuestionList));
    }

    @AfterInject
    protected void setErrorHandler(){
        mSearchRestClient.setRestErrorHandler(new RestErrorHandler() {
            @Override
            public void onRestClientExceptionThrown(NestedRuntimeException e) {
                Timber.e(e, "Rest error :");
                final Activity activity = getActivity();
                if(activity != null && !activity.isFinishing()) {
                    showToastInUiThread(R.string.sth_was_wrong);
                }
            }
        });
    }

    @ItemClick(R.id.result_list)
    public void onResultItemClick(Question question){
        final String link = question.getLink();
        if(link != null){
            final Intent intent = new Intent(getActivity(), QuestionDetailsActivity_.class);
            intent.putExtra(QuestionDetailsFragment.DETAILS_LINK, link);
            startActivity(intent);
        }else{
            Toast.makeText(getActivity(), R.string.could_not_display_details, Toast.LENGTH_LONG).show();
        }
    }

    @OptionsItem(R.id.menu_item_result_list_refresh)
    protected void onResultListRefresh(){
        refreshResultList();
    }

    @Background
    protected void refreshResultList(){
        mQuestionList = mSearchRestClient.getPostsByTitle(mSearchWord);
        if(mQuestionList != null) {
            final Activity activity = getActivity();
            if (activity != null && !activity.isFinishing()) {
                refreshResultListOnUIThread(mQuestionList);
            }
        }
    }

    @UiThread
    protected void refreshResultListOnUIThread(QuestionList questionList){
        final ResultListAdapter adapter = (ResultListAdapter)mResultList.getAdapter();
        adapter.setQuestionList(questionList);
        adapter.notifyDataSetChanged();
    }

    @UiThread
    public void showToastInUiThread(int messageRes){
        Toast.makeText(getActivity(), messageRes, Toast.LENGTH_SHORT).show();
    }


}
