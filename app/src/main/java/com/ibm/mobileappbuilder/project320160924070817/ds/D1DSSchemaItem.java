
package com.ibm.mobileappbuilder.project320160924070817.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class D1DSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("text1") public String text1;
    @SerializedName("text2") public String text2;
    @SerializedName("picture") public Integer picture;
    @SerializedName("text3") public String text3;

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
        dest.writeString(text1);
        dest.writeString(text2);
        dest.writeValue(picture);
        dest.writeString(text3);
    }

    public static final Creator<D1DSSchemaItem> CREATOR = new Creator<D1DSSchemaItem>() {
        @Override
        public D1DSSchemaItem createFromParcel(Parcel in) {
            D1DSSchemaItem item = new D1DSSchemaItem();

            item.id = in.readString();
            item.text1 = in.readString();
            item.text2 = in.readString();
            item.picture = (Integer) in.readValue(null);
            item.text3 = in.readString();
            return item;
        }

        @Override
        public D1DSSchemaItem[] newArray(int size) {
            return new D1DSSchemaItem[size];
        }
    };

}


