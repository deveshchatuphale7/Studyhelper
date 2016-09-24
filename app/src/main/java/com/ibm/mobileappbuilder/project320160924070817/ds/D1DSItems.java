

package com.ibm.mobileappbuilder.project320160924070817.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;
import com.ibm.mobileappbuilder.project320160924070817.R;
import java.util.ArrayList;
import java.util.List;
import ibmmobileappbuilder.util.StringUtils;

// D1DSSchemaItem static data
public class D1DSItems{

    public static List<D1DSSchemaItem> ITEMS = new ArrayList<D1DSSchemaItem>();
    static {
        // Add items.
        D1DSSchemaItem item;
        item = new D1DSSchemaItem();
        item.text2 = "56";
        item.text1 = "Physics";
        item.picture = R.drawable.png_t0ozxlo2lh;
        item.id = "57e63a28f222cb0300d488b6";
        addItem(item);
        item = new D1DSSchemaItem();
        item.text2 = "78";
        item.text1 = "Chemistry";
        item.picture = R.drawable.png_0viqo8l4nq;
        item.id = "57e63a43f222cb0300d488b7";
        addItem(item);
        item = new D1DSSchemaItem();
        item.text2 = "89";
        item.text1 = "Mathematics";
        item.picture = R.drawable.png_dw9pv0vcjt;
        item.id = "57e63a4a744eca030056c30c";
        addItem(item);
    }
    public static void addItem(D1DSSchemaItem item) {
        ITEMS.add(item);
    }
}


