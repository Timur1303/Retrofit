package kg.app.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import kg.app.retrofit.data.FilmStorage;
import kg.app.retrofit.data.RetrofitBuilder;
import kg.app.retrofit.detail.DetailActivity;
import kg.app.retrofit.models.Film;

public class MainActivity extends AppCompatActivity implements FilmAdapter.Listener {
    FilmAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_cards);
        adapter = new FilmAdapter();
        recyclerView.setAdapter(adapter);
        FilmStorage.getFilmGyId("ebbb6b7c-945c-41ee-a792-de0e43191bd8", new FilmStorage.Result() {
            @Override
            public void onSuccess(Film film) {
                Log.d("tag", film.toString());
            }

            @Override
            public void onFailure(String errorMsg) {
                Log.d("tag", errorMsg);
            }
        });
        FilmStorage.getFilms(new FilmStorage.ResultList() {
            @Override
            public void onSuccess(List<Film> film) {
                Log.e("tag", film.toString());
                adapter.addList(film, MainActivity.this);
            }

            @Override
            public void onFailure(String errorMsg) {
                Log.e("tag", errorMsg);
            }
        });
    }

    @Override
    public void filmClick(Film films) {
        startActivity(new Intent(this, DetailActivity.class).putExtra("id",films.getId()));
    }
}