
package com.ibm.mobileappbuilder.project320160924070817.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.project320160924070817.R;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.D1DSSchemaItem;
import com.ibm.mobileappbuilder.project320160924070817.ds.D1DS;

public class SubjectsDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<D1DSSchemaItem> implements ShareBehavior.ShareListener  {

    private Datasource<D1DSSchemaItem> datasource;
    public static SubjectsDetailFragment newInstance(Bundle args){
        SubjectsDetailFragment fr = new SubjectsDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public SubjectsDetailFragment(){
        super();
    }

    @Override
    public Datasource<D1DSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = D1DS.getInstance(new SearchOptions());
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
        return R.layout.subjectsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final D1DSSchemaItem item, View view) {
        if (item.text1 != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.text1);
            
        }
        if (item.text2 != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.text2);
            
        }
        
        if(item.picture != null){
            ImageView view2 = (ImageView) view.findViewById(R.id.view2);
            ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.picture)
                            .withTargetView(view2)
                            .build()
            );
            
        }
        if (item.text3 != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.text3);
            
        }
    }

    @Override
    protected void onShow(D1DSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        D1DSSchemaItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.text1 != null ? item.text1 : "" ) + "\n" +
                    (item.text2 != null ? item.text2 : "" ) + "\n" +
                    (item.text3 != null ? item.text3 : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

