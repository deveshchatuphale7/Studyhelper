

package com.ibm.mobileappbuilder.project320160924070817.ds;
import com.ibm.mobileappbuilder.project320160924070817.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// AnalysisgraphDSSchemaItem static data
public class AnalysisgraphDSItems{

    public static List<AnalysisgraphDSSchemaItem> ITEMS = new ArrayList<AnalysisgraphDSSchemaItem>();
    static {
        // Add items.
        AnalysisgraphDSSchemaItem item;
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 78;
        item.month = "Jan";
        item.id = "57e63d83f222cb0300d48978";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 64;
        item.month = "Feb";
        item.id = "57e63d9af222cb0300d48979";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 55;
        item.month = "Mar";
        item.id = "57e64873f222cb0300d489b2";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 57;
        item.month = "Apr";
        item.id = "57e64876744eca030056c46e";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 60;
        item.month = "May";
        item.id = "57e64879f222cb0300d489b3";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 63;
        item.month = "Jun";
        item.id = "57e6487ef222cb0300d489b4";
        addItem(item);
        item = new AnalysisgraphDSSchemaItem();
        item.attendence = 66;
        item.month = "Jul";
        item.id = "57e64883744eca030056c470";
        addItem(item);
    }
    public static void addItem(AnalysisgraphDSSchemaItem item) {
        ITEMS.add(item);
    }
}


