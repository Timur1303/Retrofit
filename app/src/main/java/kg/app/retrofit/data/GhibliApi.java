package kg.app.retrofit.data;

import java.util.List;

import kg.app.retrofit.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmById(
            @Path("id") String id
    );
}
