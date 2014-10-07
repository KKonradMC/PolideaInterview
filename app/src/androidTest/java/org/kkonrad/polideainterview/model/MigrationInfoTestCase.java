package org.kkonrad.polideainterview.model;

import android.os.Parcel;

import junit.framework.TestCase;

import java.util.Date;


public class MigrationInfoTestCase extends TestCase {

    private MigrationInfo mMigrationInfo;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMigrationInfo = new MigrationInfo();

    }

    public void testParcelable(){

        mMigrationInfo.setOnDate(new Date());
        mMigrationInfo.setQuestionId(1001);

        final Parcel parcel = Parcel.obtain();
        mMigrationInfo.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final MigrationInfo migrationInfoFromParcel = MigrationInfo.CREATOR.createFromParcel(parcel);

       assertEquals(mMigrationInfo, migrationInfoFromParcel);
    }

    public void testParcelableWithNull(){

        final Parcel parcel = Parcel.obtain();
        mMigrationInfo.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        final MigrationInfo migrationInfoFromParcel = MigrationInfo.CREATOR.createFromParcel(parcel);

        assertEquals(mMigrationInfo, migrationInfoFromParcel);
    }

}
