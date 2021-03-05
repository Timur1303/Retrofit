package kg.app.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.app.retrofit.models.Film;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {

    private List<Film> films = new ArrayList<>();
    private Listener listener;

    public void addList(List<Film> fm, Listener listener) {
        this.listener = listener;
        films.addAll(fm);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new FilmHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        holder.bind(films.get(position));

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class FilmHolder extends RecyclerView.ViewHolder {

        private TextView textView;


        public FilmHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.filmClick(films.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Film film) {
            textView.setText(film.getTitle());
        }
    }


    public interface Listener {
        void filmClick(Film films);
    }
}
