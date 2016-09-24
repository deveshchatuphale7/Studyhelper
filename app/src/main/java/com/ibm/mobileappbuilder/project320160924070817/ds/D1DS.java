
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
 * "D1DS" static data source (b6a58d48-3399-4903-8020-e38e72ee62ef)
 */
public class D1DS implements Datasource<D1DSSchemaItem>, Count,
            Pagination<D1DSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static D1DS getInstance(SearchOptions searchOptions){
        return new D1DS(searchOptions);
    }

    private D1DS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<D1DSSchemaItem>> listener) {
        listener.onSuccess(D1DSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<D1DSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(D1DSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new D1DSSchemaItem());
        }
        else {
	        D1DSSchemaItem dc = D1DSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("D1DSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return D1DSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<D1DSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<D1DSSchemaItem> result = new ArrayList<D1DSSchemaItem>();
        List<D1DSSchemaItem> filteredList = applySearchOptions(D1DSItems.ITEMS);
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

    private List<D1DSSchemaItem> applySearchOptions(List<D1DSSchemaItem> result) {
        List<D1DSSchemaItem> filteredList = result;

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

    private List<D1DSSchemaItem> applySearch(List<D1DSSchemaItem> items, String searchText) {
        List<D1DSSchemaItem> filteredList = new ArrayList<>();

        for (D1DSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.text1, searchText) ||
            FilterUtils.searchInString(item.text2, searchText) ||
            FilterUtils.searchInString(item.text3, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<D1DSSchemaItem> applyFilters(List<D1DSSchemaItem> items, List<Filter> filters) {
        List<D1DSSchemaItem> filteredList = new ArrayList<>();

        for (D1DSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("text1", item.text1, filters) &&
                FilterUtils.applyFilters("text2", item.text2, filters) &&
                FilterUtils.applyFilters("picture", item.picture, filters) &&
                FilterUtils.applyFilters("text3", item.text3, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<D1DSSchemaItem> filteredList = applySearchOptions(D1DSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<D1DSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (D1DSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(D1DSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "text1":
                return item.text1;
            
            case "text2":
                return item.text2;
            
            case "text3":
                return item.text3;
            default:
               return null;
        }
    }
}


