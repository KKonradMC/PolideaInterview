package org.kkonrad.polideainterview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.kkonrad.polideainterview.model.Question;
import org.kkonrad.polideainterview.model.QuestionList;
import org.kkonrad.polideainterview.ui.view.QuestionListItem;
import org.kkonrad.polideainterview.ui.view.QuestionListItem_;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(prefix = "m")
@AllArgsConstructor(suppressConstructorProperties = true)
public class ResultListAdapter extends BaseAdapter{

    private final Context mContext;
    @Setter
    private QuestionList mQuestionList;

    @Override
    public int getCount() {
        return mQuestionList.countItems();
    }

    @Override
    public Question getItem(int position) {
        return mQuestionList.getItemAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final QuestionListItem result;
        if(convertView == null){
            result = QuestionListItem_.build(mContext);
        }else {
            result  = (QuestionListItem) convertView;
        }
        final Question question = getItem(position);
        if(question != null) {
            result.bind(question);
        }
        return result;
    }
}
