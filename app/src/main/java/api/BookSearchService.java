package api;

import models.VolumesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookSearchService {
    @GET("/books/v1/volumes")

    // Calls VolumeResponse with criteria for search
    Call<VolumesResponse>  searchVolumes(
            @Query("q") String query,
            @Query("inauthor") String author,
            @Query("key") String apiKey

    );
}
