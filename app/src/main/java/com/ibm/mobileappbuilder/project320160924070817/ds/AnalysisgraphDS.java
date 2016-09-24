
package com.ibm.mobileappbuilder.project320160924070817.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "AnalysisgraphDS" static data source (b74f372e-7af4-434b-b44d-c68db308edd7)
 */
public class AnalysisgraphDS implements Datasource<AnalysisgraphDSSchemaItem>, Count,
            Pagination<AnalysisgraphDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static AnalysisgraphDS getInstance(SearchOptions searchOptions){
        return new AnalysisgraphDS(searchOptions);
    }

    private AnalysisgraphDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<AnalysisgraphDSSchemaItem>> listener) {
        listener.onSuccess(AnalysisgraphDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<AnalysisgraphDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(AnalysisgraphDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new AnalysisgraphDSSchemaItem());
        }
        else {
	        AnalysisgraphDSSchemaItem dc = AnalysisgraphDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("AnalysisgraphDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return AnalysisgraphDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<AnalysisgraphDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<AnalysisgraphDSSchemaItem> result = new ArrayList<AnalysisgraphDSSchemaItem>();
        List<AnalysisgraphDSSchemaItem> filteredList = applySearchOptions(AnalysisgraphDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<AnalysisgraphDSSchemaItem> applySearchOptions(List<AnalysisgraphDSSchemaItem> result) {
        List<AnalysisgraphDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<AnalysisgraphDSSchemaItem> applySearch(List<AnalysisgraphDSSchemaItem> items, String searchText) {
        List<AnalysisgraphDSSchemaItem> filteredList = new ArrayList<>();

        for (AnalysisgraphDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.month, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<AnalysisgraphDSSchemaItem> applyFilters(List<AnalysisgraphDSSchemaItem> items, List<Filter> filters) {
        List<AnalysisgraphDSSchemaItem> filteredList = new ArrayList<>();

        for (AnalysisgraphDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("month", item.month, filters) &&
                FilterUtils.applyFilters("attendence", item.attendence, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<AnalysisgraphDSSchemaItem> filteredList = applySearchOptions(AnalysisgraphDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<AnalysisgraphDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (AnalysisgraphDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(AnalysisgraphDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "month":
                return item.month;
            default:
               return null;
        }
    }
}


