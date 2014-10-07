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
public class Question implements CustomParcelable{

    public final static Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
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

    @Override
    public int describeContents() {
        return 0;
    }

    private Question(Parcel source){

        final int acceptedAnswerId = source.readInt();
        mAcceptedAnswerId = acceptedAnswerId != EMPTY_INT ? acceptedAnswerId : null;
        final int answerCount = source.readInt();
        mAnswerCount = answerCount != EMPTY_INT ? answerCount : null;
        final int bountyAmount = source.readInt();
        mBountyAmount = bountyAmount != EMPTY_INT ? bountyAmount : null;
        final long bountyClosesData = source.readLong();
        mBountyClosesDate =bountyClosesData != EMPTY_INT ? new Date(bountyClosesData) : null;
        final long closedData = source.readLong();
        mClosedDate =closedData != EMPTY_INT ? new Date(closedData) : null;
        mClosedReason = source.readString();
        final long communityOwnedDate = source.readLong();
        mCommunityOwedDate =communityOwnedDate != EMPTY_INT ? new Date(communityOwnedDate) : null;
        final long createDate = source.readLong();
        mCreationDate =createDate != EMPTY_INT ? new Date(createDate) : null;
        mAnswered = source.readByte() == TRUE;
        final long lastActivityDate = source.readLong();
        mLastActivityDate =lastActivityDate != EMPTY_INT ? new Date(lastActivityDate) : null;
        final long lastEditDate = source.readLong();
        mLastEditDate =lastEditDate != EMPTY_INT ? new Date(lastEditDate) : null;
        mLink = source.readString();
        final long lockedDate = source.readLong();
        mLockedDate =lockedDate != EMPTY_INT ? new Date(lockedDate) : null;
        mMigratedFrom = source.readString();
        mMigratedTo = source.readString();
        final long protectedDate = source.readLong();
        mProtectedDate =protectedDate != EMPTY_INT ? new Date(protectedDate) : null;
        final int questionId = source.readInt();
        mQuestionId = questionId != EMPTY_INT ? questionId : null;
        final int score = source.readInt();
        mScore = score != EMPTY_INT ? score : null;
        mTags = source.readArrayList(String.class.getClassLoader());
        mTitle = source.readString();
        final int viewCount = source.readInt();
        mViewCount = viewCount != EMPTY_INT ? viewCount : null;
        mOwner = source.readParcelable(ShallowUser.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAcceptedAnswerId != null ? mAcceptedAnswerId : EMPTY_INT);
        dest.writeInt(mAnswerCount != null ? mAnswerCount : EMPTY_INT);
        dest.writeInt(mBountyAmount != null ? mBountyAmount : EMPTY_INT);
        dest.writeLong(mBountyClosesDate != null ? mBountyClosesDate.getTime() : EMPTY_INT);
        dest.writeLong(mClosedDate != null ? mClosedDate.getTime() : EMPTY_INT);
        dest.writeString(mClosedReason);
        dest.writeLong(mCommunityOwedDate != null ? mCommunityOwedDate.getTime() : EMPTY_INT);
        dest.writeLong(mCreationDate != null ? mCreationDate.getTime() : EMPTY_INT);
        dest.writeByte(mAnswered ? TRUE : FALSE);
        dest.writeLong(mLastActivityDate != null ? mLastActivityDate.getTime() : EMPTY_INT);
        dest.writeLong(mLastEditDate != null ? mLastEditDate.getTime() : EMPTY_INT);
        dest.writeString(mLink);
        dest.writeLong(mLockedDate != null ? mLockedDate.getTime() : EMPTY_INT);
        dest.writeString(mMigratedFrom);
        dest.writeString(mMigratedTo);
        dest.writeLong(mProtectedDate != null ? mProtectedDate.getTime() : EMPTY_INT);
        dest.writeInt(mQuestionId != null ? mQuestionId : EMPTY_INT);
        dest.writeInt(mScore != null ? mScore : EMPTY_INT);
        dest.writeList(mTags);
        dest.writeString(mTitle);
        dest.writeInt(mViewCount != null ? mViewCount : EMPTY_INT);
        dest.writeParcelable(mOwner, 0);
    }

}
