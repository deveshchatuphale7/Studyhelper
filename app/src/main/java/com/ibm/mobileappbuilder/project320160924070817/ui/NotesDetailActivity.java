

package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ibmmobileappbuilder.ui.BaseDetailActivity;

/**
 * NotesDetailActivity detail activity
 */
public class NotesDetailActivity extends BaseDetailActivity {
  
  	@Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return NotesDetailFragment.class;
    }
}


