
package com.ibm.mobileappbuilder.project320160924070817.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface Drive1DSSchemaItemRest {

    @GET("/ba81d172-62b9-4bef-9864-e4fd361d83ea")
    void getAll(Callback<List<Drive1DSSchemaItem>> cb);

    @GET("/ba81d172-62b9-4bef-9864-e4fd361d83ea")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<Drive1DSSchemaItem>> cb);

    @GET("/ba81d172-62b9-4bef-9864-e4fd361d83ea/{rowId}")
    void getItem(String rowId, Callback<Drive1DSSchemaItem> cb);

    @GET("/ba81d172-62b9-4bef-9864-e4fd361d83ea/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}


