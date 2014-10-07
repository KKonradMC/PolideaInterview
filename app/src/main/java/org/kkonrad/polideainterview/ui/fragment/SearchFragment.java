package org.kkonrad.polideainterview.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.rest.RestErrorHandler;
import org.kkonrad.polideainterview.R;
import org.kkonrad.polideainterview.model.QuestionList;
import org.kkonrad.polideainterview.rest.SearchRestClient;
import org.springframework.core.NestedRuntimeException;
import org.springframework.web.client.RestClientException;

import timber.log.Timber;

@EFragment(R.layout.fragment_search)
public class SearchFragment extends Fragment {

    @ViewById(R.id.search_field)
    protected EditText mSearchField;

    @RestService
    protected SearchRestClient mSearchRestClient;

    @AfterViews
    protected  void prepareSearchFiled(){
        mSearchField.addTextChangedListener(new TextWatcherAdapter(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != 0){
                    mSearchField.setError(null);
                }
            }
        });
    }

    @AfterInject
    protected void setErrorHandler(){
        mSearchRestClient.setRestErrorHandler(new RestErrorHandler() {

            @Override
            public void onRestClientExceptionThrown(NestedRuntimeException e) {
                Timber.e(e, "Rest error :");
                saveShowToastInUiThread(R.string.sth_was_wrong);
            }
        });
    }

    @Click(R.id.search_button)
    protected void onSearchButtonClick(){
        final String searchText = mSearchField.getText().toString();
        if(searchText.length() == 0){
            mSearchField.setError(getString(R.string.field_cant_be_empty));
        }else{
            searchOnStackOverFlow(searchText);
        }
    }

    @Background
    protected void searchOnStackOverFlow(String searchText){
        final QuestionList questionList = mSearchRestClient.getPostsByTitle(searchText);
        if(questionList != null && questionList.countItems() != 0) {
            Timber.i("QuestionList object:", questionList.toString());
        }else {
            saveShowToastInUiThread(R.string.empty_result);
        }
    }


    private void saveShowToastInUiThread(int messageRes){
        final Activity activity = getActivity();
        if(activity != null && !activity.isFinishing()) {
            showToastInUiThread(messageRes);
        }
    }

    @UiThread
    public void showToastInUiThread(int messageRes){
        Toast.makeText(getActivity(), messageRes, Toast.LENGTH_SHORT).show();
    }


    private static abstract class TextWatcherAdapter implements TextWatcher{
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //do nothing
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //do nothing
        }

        @Override
        public void afterTextChanged(Editable s) {
            //do nothing
        }
    }
}


