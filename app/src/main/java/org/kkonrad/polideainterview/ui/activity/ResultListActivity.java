package org.kkonrad.polideainterview.ui.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.kkonrad.polideainterview.R;

@EActivity(R.layout.activity_result_list)
public class ResultListActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
    @OptionsItem(android.R.id.home)
    protected void homeSelected(){
        onBackPressed();
    }
}

