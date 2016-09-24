
package com.ibm.mobileappbuilder.project320160924070817.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    public static final Creator<FDSSchemaItem> CREATOR = new Creator<FDSSchemaItem>() {
        @Override
        public FDSSchemaItem createFromParcel(Parcel in) {
            FDSSchemaItem item = new FDSSchemaItem();

            item.id = in.readString();
            return item;
        }

        @Override
        public FDSSchemaItem[] newArray(int size) {
            return new FDSSchemaItem[size];
        }
    };

}


