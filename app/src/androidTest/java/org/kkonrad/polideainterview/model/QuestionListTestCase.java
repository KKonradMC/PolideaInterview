package org.kkonrad.polideainterview.model;


import android.os.Parcel;

import junit.framework.TestCase;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class QuestionListTestCase extends TestCase{

    private QuestionList mQuestionList;
    private List mQuestions;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mQuestionList = new QuestionList();
        mQuestions = Mockito.mock(List.class);
    }

    public void testParcelable(){
        mQuestionList.setHasMore(true);
        mQuestionList.setQuotaMax(100);
        mQuestionList.setQuotaRemaining(1000);
        mQuestionList.setQuestionsArray(new ArrayList<Question>());

        final Parcel parcel = Parcel.obtain();
        mQuestionList.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final QuestionList questionListFromParcel = QuestionList.CREATOR.createFromParcel(parcel);

        assertEquals(mQuestionList, questionListFromParcel);
    }

    public void testParcelableWithNull(){
        final Parcel parcel = Parcel.obtain();
        mQuestionList.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final QuestionList questionListFromParcel = QuestionList.CREATOR.createFromParcel(parcel);
        assertEquals(mQuestionList, questionListFromParcel);
    }

    public void testListSize(){
        Mockito.when(mQuestions.size()).thenReturn(10);
        mQuestionList.setQuestionsArray(mQuestions);
        assertTrue(mQuestionList.countItems() == 10);
    }


    public void testIndexOutOfBound(){
        Mockito.when(mQuestions.size()).thenReturn(10);
        mQuestionList.setQuestionsArray(mQuestions);
        assertTrue(mQuestionList.getItemAt(12) == null);
    }
}
