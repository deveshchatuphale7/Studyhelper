
package com.ibm.mobileappbuilder.project320160924070817.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class AnalysisgraphDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("month") public String month;
    @SerializedName("attendence") public Integer attendence;

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
        dest.writeString(month);
        dest.writeValue(attendence);
    }

    public static final Creator<AnalysisgraphDSSchemaItem> CREATOR = new Creator<AnalysisgraphDSSchemaItem>() {
        @Override
        public AnalysisgraphDSSchemaItem createFromParcel(Parcel in) {
            AnalysisgraphDSSchemaItem item = new AnalysisgraphDSSchemaItem();

            item.id = in.readString();
            item.month = in.readString();
            item.attendence = (Integer) in.readValue(null);
            return item;
        }

        @Override
        public AnalysisgraphDSSchemaItem[] newArray(int size) {
            return new AnalysisgraphDSSchemaItem[size];
        }
    };

}


