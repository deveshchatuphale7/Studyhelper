package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.project320160924070817.R;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ui.ListGridFragment;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.ViewHolder;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.D1DSSchemaItem;
import com.ibm.mobileappbuilder.project320160924070817.ds.D1DS;
import android.content.Intent;
import ibmmobileappbuilder.util.Constants;

import static ibmmobileappbuilder.util.NavigationUtils.generateIntentToAddOrUpdateItem;

/**
 * "SubjectsFragment" listing
 */
public class SubjectsFragment extends ListGridFragment<D1DSSchemaItem>  {

    private Datasource<D1DSSchemaItem> datasource;


    public static SubjectsFragment newInstance(Bundle args) {
        SubjectsFragment fr = new SubjectsFragment();

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
        return R.layout.subjects_item;
    }

    @Override
    protected Datasource<D1DSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
      datasource = D1DS.getInstance(getSearchOptions());
      return datasource;
    }

    @Override
    protected void bindView(D1DSSchemaItem item, View view, int position) {
        
        ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
        ImageView image = ViewHolder.get(view, R.id.image);
        if(item.picture != null){
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.picture)
                            .withTargetView(image)
                            .fit()
                            .build()
            );
            
        }
        else {
          imageLoader.load(imageLoaderRequest()
                          .withResourceToLoad(R.drawable.ic_ibm_placeholder)
                          .withTargetView(image)
                          .build()
          );
        }
        
        
        TextView title = ViewHolder.get(view, R.id.title);
        
        if (item.text1 != null){
            title.setText(item.text1);
            
        }
        
        TextView subtitle = ViewHolder.get(view, R.id.subtitle);
        
        if (item.text2 != null){
            subtitle.setText(item.text2);
            
        }
    }


    @Override
    public void showDetail(D1DSSchemaItem item, int position) {
        Bundle args = new Bundle();
        args.putInt(Constants.ITEMPOS, position);
        args.putParcelable(Constants.CONTENT, item);
        Intent intent = new Intent(getActivity(), SubjectsDetailActivity.class);
        intent.putExtras(args);

        if (!getResources().getBoolean(R.bool.tabletLayout)) {
            startActivityForResult(intent, Constants.DETAIL);
        } else {
            startActivity(intent);
        }
    }

}

