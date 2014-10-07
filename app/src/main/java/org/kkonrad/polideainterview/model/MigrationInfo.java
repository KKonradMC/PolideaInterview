package org.kkonrad.polideainterview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

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
public class MigrationInfo implements CustomParcelable{
    public static final Parcelable.Creator<MigrationInfo> CREATOR = new Parcelable.Creator<MigrationInfo>() {
        @Override
        public MigrationInfo createFromParcel(Parcel source) {
            return new MigrationInfo(source);
        }

        @Override
        public MigrationInfo[] newArray(int size) {
            return new MigrationInfo[size];
        }
    };



    public static final String ON_DATE = "on_date";
    public static final String QUESTION_ID = "question_id";

    @Getter
    @Setter
    @JsonProperty(ON_DATE)
    private Date mOnDate;

    @Getter
    @Setter
    @JsonProperty(QUESTION_ID)
    private Integer mQuestionId;

    private MigrationInfo(Parcel source){
        final long onDate = source.readLong();
        mOnDate = onDate != EMPTY_INT ? new Date(onDate): null;
        final int id = source.readInt();
        mQuestionId =id != EMPTY_INT ? id : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mOnDate != null ? mOnDate.getTime() :EMPTY_INT);
        dest.writeInt(mQuestionId != null ? mQuestionId : EMPTY_INT);
    }
}
