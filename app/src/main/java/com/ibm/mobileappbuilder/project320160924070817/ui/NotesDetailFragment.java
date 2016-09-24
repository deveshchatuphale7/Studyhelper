
package com.ibm.mobileappbuilder.project320160924070817.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.project320160924070817.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.DriveDSSchemaItem;
import com.ibm.mobileappbuilder.project320160924070817.ds.DriveDS;

public class NotesDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<DriveDSSchemaItem> implements ShareBehavior.ShareListener  {

    private Datasource<DriveDSSchemaItem> datasource;
    public static NotesDetailFragment newInstance(Bundle args){
        NotesDetailFragment fr = new NotesDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public NotesDetailFragment(){
        super();
    }

    @Override
    public Datasource<DriveDSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = DriveDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.notesdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final DriveDSSchemaItem item, View view) {
        if (item.title != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.title);
            
        }
        if (item.createdBy != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.createdBy);
            
        }
        if (item.modifiedDate != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(DateFormat.getMediumDateFormat(getActivity()).format(item.modifiedDate) + " " + DateFormat.getTimeFormat(getActivity()).format(item.modifiedDate));
            
        }
        if (item.downloadUrl != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.downloadUrl);
            
        }
    }

    @Override
    protected void onShow(DriveDSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        DriveDSSchemaItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.title != null ? item.title : "" ) + "\n" +
                    (item.createdBy != null ? item.createdBy : "" ) + "\n" +
                    (item.modifiedDate != null ? DateFormat.getMediumDateFormat(getActivity()).format(item.modifiedDate) + " " + DateFormat.getTimeFormat(getActivity()).format(item.modifiedDate) : "" ) + "\n" +
                    (item.downloadUrl != null ? item.downloadUrl : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

