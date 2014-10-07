package org.kkonrad.polideainterview.ui.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.jetbrains.annotations.NotNull;
import org.kkonrad.polideainterview.R;
import org.kkonrad.polideainterview.model.Question;

@EViewGroup(R.layout.view_question_item)
public class QuestionListItem extends RelativeLayout{

    @ViewById(R.id.avatar_image)
    protected ImageView mAvatarImage;
    @ViewById(R.id.post_title)
    protected TextView mPostTitle;
    @ViewById(R.id.author)
    protected TextView mAuthor;
    @ViewById(R.id.count_answer)
    protected TextView mCountAnswer;

    public QuestionListItem(Context context) {
        super(context);
    }

    public void bind(@NotNull Question question){
        Picasso.with(getContext())
                .load(question.getOwner().getProfileImage())
                .placeholder(R.drawable.user_placeholder)
                .into(mAvatarImage);
        mPostTitle.setText(question.getTitle());
        mAuthor.setText(question.getOwner().getDisplayName());
        final String countAnswerLabel = String.format(getResources().getString(R.string.answer), question.getAnswerCount());
        mCountAnswer.setText(countAnswerLabel);
    }

}
