package com.backbase.assignment.ui.movie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.movie.view.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.backbase.assignment.globals.Constants.posterUrl;

public class PlayingNowAdapter extends RecyclerView.Adapter<PlayingNowAdapter.PlayingNowViewHolder>
{
    private final List< Result > mItems  ;
    private static ItemClickListener clickListener;

    public PlayingNowAdapter( List< Result > mItems )
    {
        this.mItems = mItems  ;
    }

    @NonNull
    @Override
    public PlayingNowViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_poster_item, parent, false);

        return new PlayingNowViewHolder( view );
    }

    @Override
    public void onBindViewHolder (@NonNull PlayingNowViewHolder holder, final int position)
    {
        Result result = mItems.get ( position );

        Picasso.get().load( posterUrl + result.getPoster_path () )
                .placeholder ( R.drawable.progress_animator )
                .centerCrop  ( ).fit (  )
                .into ( holder.ivPoster ) ;

        holder.itemView.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick (View v)
            {
                clickListener.onItemClick( mItems.get ( position ).getId () );
            }
        });
    }

    @Override
    public int getItemCount ()
    {
        return mItems != null ? mItems.size () : 0;
    }

    public void setClickListener( ItemClickListener itemClickListener )
    {
        clickListener = itemClickListener;
    }

    public static class PlayingNowViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView ivPoster;

        public PlayingNowViewHolder (@NonNull View itemView)
        {
            super (itemView);

            ivPoster = itemView.findViewById (R.id.iv_photo);
        }
    }
}
