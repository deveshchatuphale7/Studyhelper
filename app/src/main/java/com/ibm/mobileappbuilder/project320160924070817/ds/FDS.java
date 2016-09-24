
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
 * "FDS" static data source (bed0e928-cec0-4b2b-99e9-bbafbd943532)
 */
public class FDS implements Datasource<FDSSchemaItem>, Count,
            Pagination<FDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static FDS getInstance(SearchOptions searchOptions){
        return new FDS(searchOptions);
    }

    private FDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<FDSSchemaItem>> listener) {
        listener.onSuccess(FDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<FDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(FDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new FDSSchemaItem());
        }
        else {
	        FDSSchemaItem dc = FDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("FDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return FDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<FDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<FDSSchemaItem> result = new ArrayList<FDSSchemaItem>();
        List<FDSSchemaItem> filteredList = applySearchOptions(FDSItems.ITEMS);
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

    private List<FDSSchemaItem> applySearchOptions(List<FDSSchemaItem> result) {
        List<FDSSchemaItem> filteredList = result;

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

    private List<FDSSchemaItem> applySearch(List<FDSSchemaItem> items, String searchText) {
        List<FDSSchemaItem> filteredList = new ArrayList<>();

        for (FDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<FDSSchemaItem> applyFilters(List<FDSSchemaItem> items, List<Filter> filters) {
        List<FDSSchemaItem> filteredList = new ArrayList<>();

        for (FDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<FDSSchemaItem> filteredList = applySearchOptions(FDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<FDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (FDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(FDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            default:
               return null;
        }
    }
}


