package org.kkonrad.polideainterview.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class ShallowUser {

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
}
