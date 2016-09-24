
package com.ibm.mobileappbuilder.project320160924070817.ds;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface DriveDSSchemaItemRest {

    @GET("/74de1342-bb2f-4131-9508-50c4a7be7a5a")
    void getAll(Callback<List<DriveDSSchemaItem>> cb);

    @GET("/74de1342-bb2f-4131-9508-50c4a7be7a5a")
    void search(
            @Query("searchText") String searchText,
            @Query("sortingColumn") String sortingColumn,
            @Query("sortAscending") boolean sortAscending,
            @Query("offset") int pageIndex,
            @Query("blockSize") int blockSize,
            @Query("condition") String condition,
            Callback<List<DriveDSSchemaItem>> cb);

    @GET("/74de1342-bb2f-4131-9508-50c4a7be7a5a/{rowId}")
    void getItem(String rowId, Callback<DriveDSSchemaItem> cb);

    @GET("/74de1342-bb2f-4131-9508-50c4a7be7a5a/distinct/{colName}")
    void getDistinctValues(
        @Path("colName") String colName,
        @Query("condition") String condition,
        Callback<List<String>> cb);
}


