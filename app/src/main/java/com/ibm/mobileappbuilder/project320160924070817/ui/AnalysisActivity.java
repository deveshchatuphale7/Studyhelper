
package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.project320160924070817.R;

import ibmmobileappbuilder.ui.BaseDetailActivity;
/**
 * AnalysisActivity chart screen
 */
public class AnalysisActivity extends BaseDetailActivity {


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);        
        
        getSupportActionBar ().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.analysisActivity));
    }   

    // DetailActivity interface

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return AnalysisFragment.class;
    }

}


