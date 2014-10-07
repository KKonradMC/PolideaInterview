package org.kkonrad.polideainterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(prefix = "m")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
public class Question {

    public static final String ACCEPTED_ANSWER_ID = "accepted_answer_id";
    public static final String ANSWER_COUNT = "answer_count";
    public static final String BOUNTY_AMOUNT = "bounty_amount";
    public static final String BOUNTY_CLOSES_DATE = "bounty_closes_date";
    public static final String CLOSED_DATE = "closed_date";
    public static final String CLOSED_REASON = "closed_reason";
    public static final String COMMUNITY_OWNED_DATE = "community_owned_date";
    public static final String CREATION_DATE = "creation_date";
    public static final String IS_ANSWERED = "is_answered";
    public static final String LAST_ACTIVITY_DATE = "last_activity_date";
    public static final String LAST_EDIT_DATE = "last_edit_date";
    public static final String LINK = "link";
    public static final String LOCKED_DATE = "locked_date";
    public static final String MIGRATED_FROM = "migrated_from";
    public static final String MIGRATED_TO = "migrated_to";
    public static final String OWNER = "owner";
    public static final String PROTECTED_DATE = "protected_date";
    public static final String QUESTION_ID = "question_id";
    public static final String SCORE = "score";
    public static final String TAGS = "tags";
    public static final String TITLE = "title";
    public static final String VIEW_COUNT = "view_count";

    @Getter
    @Setter
    @JsonProperty(ACCEPTED_ANSWER_ID)
    private Integer mAcceptedAnswerId;
    @Getter
    @Setter
    @JsonProperty(ANSWER_COUNT)
    private Integer mAnswerCount;
    @Getter
    @Setter
    @JsonProperty(BOUNTY_AMOUNT)
    private Integer mBountyAmount;
    @Getter
    @Setter
    @JsonProperty(BOUNTY_CLOSES_DATE)
    private Date mBountyClosesDate;
    @Getter
    @Setter
    @JsonProperty(CLOSED_DATE)
    private Date mClosedDate;
    @Getter
    @Setter
    @JsonProperty(CLOSED_REASON)
    private String mClosedReason;
    @Getter
    @Setter
    @JsonProperty(COMMUNITY_OWNED_DATE)
    private Date mCommunityOwedDate;
    @Getter
    @Setter
    @JsonProperty(CREATION_DATE)
    private Date mCreationDate;
    @Getter
    @Setter
    @JsonProperty(IS_ANSWERED)
    private boolean mAnswered;
    @Getter
    @Setter
    @JsonProperty(LAST_ACTIVITY_DATE)
    private Date mLastActivityDate;
    @Getter
    @Setter
    @JsonProperty(LAST_EDIT_DATE)
    private Date mLastEditDate;
    @Getter
    @Setter
    @JsonProperty(LINK)
    private String mLink;
    @Getter
    @Setter
    @JsonProperty(LOCKED_DATE)
    private Date mLockedDate;
    @Getter
    @Setter
    @JsonProperty(MIGRATED_FROM)
    private String mMigratedFrom;
    @Getter
    @Setter
    @JsonProperty(MIGRATED_TO)
    private String mMigratedTo;
    @Getter
    @Setter
    @JsonProperty(OWNER)
    private ShallowUser mOwner;
    @Getter
    @Setter
    @JsonProperty(PROTECTED_DATE)
    private Date mProtectedDate;
    @Getter
    @Setter
    @JsonProperty(QUESTION_ID)
    private Integer mQuestionId;
    @Getter
    @Setter
    @JsonProperty(SCORE)
    private Integer mScore;

    @Setter
    @JsonProperty(TAGS)
    private List<String> mTags;
    @Getter
    @Setter
    @JsonProperty(TITLE)
    private String mTitle;
    @Getter
    @Setter
    @JsonProperty(VIEW_COUNT)
    private Integer mViewCount;

}
