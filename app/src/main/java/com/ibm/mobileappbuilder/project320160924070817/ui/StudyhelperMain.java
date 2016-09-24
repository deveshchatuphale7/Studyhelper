package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import com.ibm.mobileappbuilder.project320160924070817.R;

public class StudyhelperMain extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
                sectionFragments.append(R.id.entry0, Main1Fragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}

