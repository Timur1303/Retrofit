package kg.app.retrofit.data;

import android.util.Log;

import java.util.List;

import kg.app.retrofit.models.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {

    public static void getFilmGyId(String id, Result result) {
        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                } else {
                    result.onFailure(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                result.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void getFilms(ResultList result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                } else {
                    result.onFailure(String.valueOf(response.code()));
                }
                Log.e("TAG", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
                result.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public interface Result {
        void onSuccess(Film film);

        void onFailure(String errorMsg);
    }

    public interface ResultList {
        void onSuccess(List<Film> film);

        void onFailure(String errorMsg);
    }
}
