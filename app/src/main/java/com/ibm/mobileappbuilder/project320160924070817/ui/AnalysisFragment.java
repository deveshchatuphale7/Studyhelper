
package com.ibm.mobileappbuilder.project320160924070817.ui;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.util.ColorUtils;
import ibmmobileappbuilder.util.StringUtils;

import android.widget.TextView;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.project320160924070817.ds.AnalysisgraphDSSchemaItem;
import com.ibm.mobileappbuilder.project320160924070817.ds.AnalysisgraphDS;

import static ibmmobileappbuilder.analytics.injector.PageViewBehaviorInjector.pageViewBehavior;

public class AnalysisFragment extends ibmmobileappbuilder.charts.ui.BarChartFragment<AnalysisgraphDSSchemaItem> {

    private Datasource<AnalysisgraphDSSchemaItem> datasource;
    private SearchOptions searchOptions;

    public static AnalysisFragment newInstance(Bundle args){
        AnalysisFragment fragment = new AnalysisFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public AnalysisFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
    }

    @Override
      protected Datasource<AnalysisgraphDSSchemaItem> getDatasource() {
        if (datasource != null) {
          return datasource;
        }
          searchOptions = SearchOptions.Builder.searchOptions().build();
         datasource = AnalysisgraphDS.getInstance(searchOptions);
            return datasource;
      }

    @Override
    public void loadChart(List<AnalysisgraphDSSchemaItem> items) {
        if (items.size() != 0) {

            setChartTitle("Analysis");
            setXAxisLabel("Horizontal Axis");

            List<String> XAxisValues = new ArrayList<String>();
            for (AnalysisgraphDSSchemaItem item : items) {
                XAxisValues.add((item.month != null) ? item.month : "");
            }
            setXAxisValues(XAxisValues);

            List<Number> series;
            
            series = new ArrayList<Number>();
            for (AnalysisgraphDSSchemaItem item : items){
                //StringToNumber is used to maintain backward compatibility with older apps
                series.add(StringUtils.StringToNumber(item.attendence.toString()));
            }
            addSeries(series, Color.parseColor("#17B9ED"), "Attendence");
        }
    }
}

