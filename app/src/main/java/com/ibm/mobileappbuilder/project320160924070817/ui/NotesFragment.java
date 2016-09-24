package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ibm.mobileappbuilder.project320160924070817.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.ViewHolder;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.DriveDSSchemaItem;
import com.ibm.mobileappbuilder.project320160924070817.ds.DriveDS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "NotesFragment" listing
 */
public class NotesFragment extends ListGridFragment<DriveDSSchemaItem>  {

    private Datasource<DriveDSSchemaItem> datasource;


    public static NotesFragment newInstance(Bundle args) {
        NotesFragment fr = new NotesFragment();

        fr.setArguments(args);
        return fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected SearchOptions getSearchOptions() {
      SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
      return searchOptionsBuilder.build();
    }


    /**
    * Layout for the list itselft
    */
    @Override
    protected int getLayout() {
        return R.layout.fragment_list;
    }

    /**
    * Layout for each element in the list
    */
    @Override
    protected int getItemLayout() {
        return R.layout.notes_item;
    }

    @Override
    protected Datasource<DriveDSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = DriveDS.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(DriveDSSchemaItem item, View view, int position) {
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.title != null){
            title.setText(item.title);
            
        }
        
        TextView subtitle = ViewHolder.get(view, R.id.subtitle);
        
        if (item.createdBy != null){
            subtitle.setText(item.createdBy);
            
        }
    }


    @Override
    public void showDetail(DriveDSSchemaItem item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), NotesDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

