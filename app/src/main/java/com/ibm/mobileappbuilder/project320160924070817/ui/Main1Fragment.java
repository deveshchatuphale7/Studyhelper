

package com.ibm.mobileappbuilder.project320160924070817.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.project320160924070817.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * Main1Fragment menu fragment.
 */
public class Main1Fragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public Main1Fragment(){
        super();
    }

    // Factory method
    public static Main1Fragment newInstance(Bundle args) {
        Main1Fragment fragment = new Main1Fragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Analysis")
            .setIcon(R.drawable.jpg_index1202)
            .setAction(new StartActivityAction(AnalysisActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("About application")
            .setIcon(R.drawable.jpg_aboutus992)
            .setAction(new StartActivityAction(AboutapplicationActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("subjects")
            .setIcon(R.drawable.png_booksicon773)
            .setAction(new StartActivityAction(SubjectsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Notes")
            .setIcon(R.drawable.png_notes872)
            .setAction(new StartActivityAction(NotesActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.main1_item;
    }
}

