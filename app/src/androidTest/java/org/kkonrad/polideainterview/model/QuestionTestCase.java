package org.kkonrad.polideainterview.model;

import android.os.Parcel;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionTestCase extends TestCase {

    private Question mQuestion;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mQuestion = new Question();
    }

    public void testParcelable(){
        mQuestion.setAcceptedAnswerId(1000);
        mQuestion.setAnswerCount(1001);
        mQuestion.setAnswered(true);
        mQuestion.setBountyAmount(1002);
        mQuestion.setBountyClosesDate(new Date(1000000));
        mQuestion.setClosedDate(new Date(1001000));
        mQuestion.setClosedReason("Just because");
        mQuestion.setCommunityOwedDate(new Date(1002000));
        mQuestion.setCreationDate(new Date(1003000));
        mQuestion.setLastActivityDate(new Date(1004000));
        mQuestion.setLastEditDate(new Date(1005000));
        mQuestion.setLink("http://test.com/test_link/&acF@t");
        mQuestion.setLockedDate(new Date(1006000));
        mQuestion.setMigratedFrom("Migration From");
        mQuestion.setMigratedTo("Migration To");
        mQuestion.setOwner(new ShallowUser());
        mQuestion.setProtectedDate(new Date(1007000));
        mQuestion.setQuestionId(1003);
        mQuestion.setScore(1004);
        final List<String> tags = new ArrayList<String>();
        tags.add("android");
        tags.add("ios");
        tags.add("windows phone");
        mQuestion.setTags(tags);
        mQuestion.setTitle("How to ... ?");
        mQuestion.setViewCount(1005);

        final Parcel parcel = Parcel.obtain();
        mQuestion.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final Question questionFromParcel = Question.CREATOR.createFromParcel(parcel);

        assertEquals(mQuestion, questionFromParcel);
    }

    public void testParcelableWithNull(){
        final Parcel parcel = Parcel.obtain();
        mQuestion.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final Question questionFromParcel = Question.CREATOR.createFromParcel(parcel);
        assertEquals(mQuestion, questionFromParcel);
    }
}
