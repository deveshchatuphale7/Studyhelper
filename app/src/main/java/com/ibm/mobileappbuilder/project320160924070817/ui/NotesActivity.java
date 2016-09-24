

package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.project320160924070817.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * NotesActivity list activity
 */
public class NotesActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.notesActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return NotesFragment.class;
    }

}

