package org.kkonrad.polideainterview.model;

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
public class QuestionList  {

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

}
