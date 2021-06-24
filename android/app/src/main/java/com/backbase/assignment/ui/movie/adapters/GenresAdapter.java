package com.backbase.assignment.ui.movie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Genre;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.view.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.backbase.assignment.globals.Constants.posterUrl;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.GenresViewHolder>
{
    private final List<Genre> mItems;

    public GenresAdapter (List< Genre > mItems )
    {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public GenresViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chip_item, parent, false);

        return new GenresViewHolder( view );
    }

    @Override
    public void onBindViewHolder (@NonNull GenresViewHolder holder, final int position)
    {
        Genre genre = mItems.get ( position );

        holder.tvTitle.setText ( genre.getName () );

        holder.itemView.setOnClickListener (v ->
        {
            // TODO: It would be great a search by genre, doesn't?
        });
    }

    @Override
    public int getItemCount ()
    {
        return mItems != null ? mItems.size () : 0;
    }

    public static class GenresViewHolder extends RecyclerView.ViewHolder
    {

        private final TextView  tvTitle  ;

        public GenresViewHolder (@NonNull View itemView)
        {
            super (itemView);

            tvTitle  = itemView.findViewById (R.id.chip );
        }
    }
}
