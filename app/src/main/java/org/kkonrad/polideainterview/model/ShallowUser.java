package org.kkonrad.polideainterview.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.kkonrad.polideainterview.model.type.EUserType;

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
public class ShallowUser implements CustomParcelable {

    public static final Creator<ShallowUser> CREATOR = new Creator<ShallowUser>() {
        @Override
        public ShallowUser createFromParcel(Parcel source) {
            return new ShallowUser(source);
        }

        @Override
        public ShallowUser[] newArray(int size) {
            return new ShallowUser[size];
        }
    };
    public static final String ACCEPT_RATE = "accept_rate";
    public static final String DISPLAY_NAME = "display_name";
    public static final String LINK = "link";
    public static final String PROFILE_IMAGE = "profile_image";
    public static final String REPUTATION = "reputation";
    public static final String USER_ID = "user_id";
    public static final String USER_TYPE = "user_type";

    @Getter
    @Setter
    @JsonProperty(ACCEPT_RATE)
    private Integer mAcceptRate;
    @Getter
    @Setter
    @JsonProperty(DISPLAY_NAME)
    private String mDisplayName;
    @Getter
    @Setter
    @JsonProperty(LINK)
    private String mLink;
    @Getter
    @Setter
    @JsonProperty(PROFILE_IMAGE)
    private String mProfileImage;
    @Getter
    @Setter
    @JsonProperty(REPUTATION)
    private Integer mReputation;
    @Getter
    @Setter
    @JsonProperty(USER_ID)
    private Integer mUserId;
    @Getter
    @Setter
    @JsonProperty(USER_TYPE)
    private EUserType mUserType;

    private ShallowUser(Parcel source){
        final int acceptRate = source.readInt();
        mAcceptRate = acceptRate != EMPTY_INT ? acceptRate : null;
        mDisplayName = source.readString();
        mLink = source.readString();
        mProfileImage = source.readString();
        final int reputation = source.readInt();
        mReputation = reputation != EMPTY_INT ? reputation : null;
        final int userId = source.readInt();
        mUserId = userId != EMPTY_INT ? userId : null;
        final int userType = source.readInt();
        mUserType =userType != EMPTY_INT ? EUserType.values()[userType] : null;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAcceptRate != null ? mAcceptRate : EMPTY_INT);
        dest.writeString(mDisplayName);
        dest.writeString(mLink);
        dest.writeString(mProfileImage);
        dest.writeInt(mReputation != null ? mReputation : EMPTY_INT);
        dest.writeInt(mUserId != null ? mUserId : EMPTY_INT);
        dest.writeInt(mUserType != null ? mUserType.ordinal() : EMPTY_INT);
    }
}
