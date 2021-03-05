package kg.app.retrofit.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import kg.app.retrofit.R;
import kg.app.retrofit.data.FilmStorage;
import kg.app.retrofit.models.Film;

public class DetailActivity extends AppCompatActivity {
    TextView title, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        title = findViewById(R.id.tv_title);
        desc = findViewById(R.id.tv_desc);
        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            FilmStorage.getFilmGyId(id, new FilmStorage.Result() {
                @Override
                public void onSuccess(Film film) {
                    title.setText(film.getTitle());
                    desc.setText(film.getDescription());
                }

                @Override
                public void onFailure(String errorMsg) {
                    Log.e("TAG", "onFailure: "+errorMsg );
                }
            });
        }
    }
}