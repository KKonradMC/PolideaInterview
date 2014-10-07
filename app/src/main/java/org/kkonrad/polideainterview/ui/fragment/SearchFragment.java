package org.kkonrad.polideainterview.ui.fragment;

import android.support.v4.app.Fragment;
import android.widget.EditText;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.kkonrad.polideainterview.R;

@EFragment(R.layout.fragment_search)
public class SearchFragment extends Fragment {

    @ViewById(R.id.search_field)
    protected EditText mSearchField;

}
