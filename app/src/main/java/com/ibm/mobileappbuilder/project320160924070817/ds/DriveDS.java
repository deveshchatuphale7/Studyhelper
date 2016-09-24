
package com.ibm.mobileappbuilder.project320160924070817.ds;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.restds.RestDatasource;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.ibm.mobileappbuilder.project320160924070817.R;

import static ibmmobileappbuilder.injectors.ApplicationInjector.getApplicationContext;

/**
 * "DriveDS" data source. (74de1342-bb2f-4131-9508-50c4a7be7a5a)
 */
public class DriveDS extends RestDatasource<DriveDSSchemaItem, DriveDSSchemaItemRest> implements
    Pagination<DriveDSSchemaItem>, Distinct {

    // default page size
    private static final int PAGE_SIZE = 20;

    private Context context;

    public static DriveDS getInstance(SearchOptions searchOptions){
        return new DriveDS(getApplicationContext(), searchOptions);
    }

    private DriveDS(Context context, SearchOptions searchOptions) {
        super(DriveDSSchemaItemRest.class, searchOptions);
        this.context = context;
    }

    @Override
    public void getItems(final Listener<List<DriveDSSchemaItem>> listener) {
                getServiceProxy().getAll(new Callback<List<DriveDSSchemaItem>>() {
            @Override
            public void success(List<DriveDSSchemaItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void getItem(String id, final Listener<DriveDSSchemaItem> listener) {
              // query first item
        getServiceProxy().search(null, null, true, 0, 1, null, new Callback<List<DriveDSSchemaItem>>() {
            @Override
            public void success(List<DriveDSSchemaItem> result, Response response) {
                                if (result.size() > 0) {
                    listener.onSuccess(result.get(0));
                } else {
                    listener.onSuccess(new DriveDSSchemaItem());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void getItems(int pagenum, final Listener<List<DriveDSSchemaItem>> listener) {
        String filter = getFilterQuery(searchOptions);
                getServiceProxy().search(searchOptions.getSearchText(), searchOptions.getSortColumn(), searchOptions.isSortAscending(),
                pagenum, PAGE_SIZE, filter, new Callback<List<DriveDSSchemaItem>>() {
            @Override
            public void success(List<DriveDSSchemaItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public String getServerUrl(){
        return context.getString(R.string.dynamic_url);
    }

    @Override
    protected String getApiKey(){
        String apikey = context.getString(R.string.api_key);
        return "NoApiKey".equals(apikey) ? null : apikey;
    }

    @Override
    protected String getAppId(){
        return context.getString(R.string.app_id);
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String condition = getFilterQuery(searchOptions);
                getServiceProxy().getDistinctValues(searchStr, condition, new Callback<List<String>>() {
            @Override
            public void success(List<String> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }
}


