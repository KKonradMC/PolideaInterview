package org.kkonrad.polideainterview.model;

import android.os.Parcel;
import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(prefix = "m")
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class QuestionList implements CustomParcelable {

    public static final Creator<QuestionList> CREATOR = new Creator<QuestionList>() {
        @Override
        public QuestionList createFromParcel(Parcel source) {
            return new QuestionList(source);
        }

        @Override
        public QuestionList[] newArray(int size) {
            return new QuestionList[size];
        }
    };

    public static final String ITEMS = "items";
    public static final String HAS_MORE = "has_more";
    public static final String QUOTA_MAX = "quota_max";
    public static final String QUOTA_REMAINING = "quota_remaining";

    @Setter(AccessLevel.PACKAGE)
    @JsonProperty(ITEMS)
    private List<Question> mQuestionsArray;
    @Getter
    @Setter
    @JsonProperty(HAS_MORE)
    private boolean mHasMore;
    @Getter
    @Setter
    @JsonProperty(QUOTA_MAX)
    private Integer mQuotaMax;
    @Getter
    @Setter
    @JsonProperty(QUOTA_REMAINING)
    private Integer mQuotaRemaining;

    private QuestionList(Parcel source){
        mHasMore = source.readByte() == TRUE;
        final int quotaMax = source.readInt();
        mQuotaMax = quotaMax != EMPTY_INT ? quotaMax : null;
        final int quotaRemaining = source.readInt();
        mQuotaRemaining = quotaRemaining != EMPTY_INT ? quotaRemaining : null;
        mQuestionsArray = source.readArrayList(Question.class.getClassLoader());
    }
    public int countItems(){
        if(mQuestionsArray == null){
            return  0;
        }
        return mQuestionsArray.size();
    }

    @Nullable
    public Question getItemAt(int index){
        if(index >= countItems() || mQuestionsArray == null){
            return  null;
        }
        return mQuestionsArray.get(index);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(mHasMore ? TRUE : FALSE);
        dest.writeInt(mQuotaMax != null ? mQuotaMax : EMPTY_INT);
        dest.writeInt(mQuotaRemaining != null ? mQuotaRemaining : EMPTY_INT);
        dest.writeList(mQuestionsArray);
    }
}
