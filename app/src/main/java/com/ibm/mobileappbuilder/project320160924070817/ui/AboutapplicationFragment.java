
package com.ibm.mobileappbuilder.project320160924070817.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.project320160924070817.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.Item;
import com.ibm.mobileappbuilder.project320160924070817.ds.EmptyDatasource;

public class AboutapplicationFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static AboutapplicationFragment newInstance(Bundle args){
        AboutapplicationFragment card = new AboutapplicationFragment();
        card.setArguments(args);

        return card;
    }

    public AboutapplicationFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = EmptyDatasource.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.aboutapplication_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("About application");
    }

}

