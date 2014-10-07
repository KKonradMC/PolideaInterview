package org.kkonrad.polideainterview.model;


import android.os.Parcel;

import junit.framework.TestCase;

import org.kkonrad.polideainterview.model.type.EUserType;

public class ShallowUserTestCase extends TestCase{

    private ShallowUser mShallowUser;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mShallowUser = new ShallowUser();
    }

    public void testParcelable(){

        mShallowUser.setAcceptRate(10);
        mShallowUser.setDisplayName("Jon Bravo");
        mShallowUser.setLink("http://stackoverflow.com/test");
        mShallowUser.setProfileImage("http://image.com/112@1");
        mShallowUser.setReputation(1000);
        mShallowUser.setUserId(10);
        mShallowUser.setUserType(EUserType.unregistered);

        final Parcel parcel = Parcel.obtain();
        mShallowUser.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final ShallowUser shallowUserFromParcel = ShallowUser.CREATOR.createFromParcel(parcel);

        assertEquals(mShallowUser, shallowUserFromParcel);
    }

    public void testParcelableWithNull(){

        final Parcel parcel = Parcel.obtain();
        mShallowUser.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final ShallowUser shallowUserFromParcel = ShallowUser.CREATOR.createFromParcel(parcel);

        assertEquals(mShallowUser, shallowUserFromParcel);
    }
}
