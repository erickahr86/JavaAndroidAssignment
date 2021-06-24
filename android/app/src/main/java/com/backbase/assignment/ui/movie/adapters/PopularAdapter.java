package com.backbase.assignment.ui.movie.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backbase.assignment.R;
import com.backbase.assignment.entities.Result;
import com.backbase.assignment.ui.custom.CustomPieChart;
import com.backbase.assignment.ui.movie.view.ItemClickListener;
import com.backbase.assignment.ui.movie.view.OnBottomReachedListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.backbase.assignment.globals.Constants.posterUrl;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder>
{
    private final List< Result > mItems;

    private static ItemClickListener       clickListener;
    private static OnBottomReachedListener bottomReachedListener;

    public PopularAdapter (List< Result > mItems )
    {
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new PopularViewHolder ( view );
    }

    @Override
    public void onBindViewHolder (@NonNull PopularViewHolder holder, final int position)
    {
        Result result = mItems.get ( position );

        Picasso.get().load( posterUrl + result.getPoster_path () )
                .placeholder ( R.drawable.progress_animator )
                .centerInside( ).fit (  )
                .into ( holder.ivPoster ) ;

        holder.rating .setValue ( ( int ) result.getVote_average() );

        holder.tvTitle.setText ( result.getTitle             ()         );
        holder.tvDate .setText ( result.getRelease_date      ()         );
        holder.tvLang .setText ( result.getOriginal_language ().name () );

        holder.itemView.setOnClickListener (v -> clickListener.onItemClick( mItems.get ( position ).getId () ));

        if ( position == mItems.size() - 1 )
        {
            bottomReachedListener.onBottomReached( position );
        }
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

    public void setOnBottomReachedListener ( OnBottomReachedListener onBottomReachedListener )
    {
        bottomReachedListener = onBottomReachedListener;
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder
    {

        private final TextView       tvTitle  ;
        private final ImageView      ivPoster ;
        private final TextView       tvDate   ;
        private final TextView       tvLang   ;
        private final CustomPieChart rating   ;

        public PopularViewHolder (@NonNull View itemView)
        {
            super (itemView);

            ivPoster = itemView.findViewById (R.id.poster        );
            tvTitle  = itemView.findViewById (R.id.title         );
            tvDate   = itemView.findViewById (R.id.releaseDate   );
            tvLang   = itemView.findViewById (R.id.original_lang );
            rating   = itemView.findViewById (R.id.custom_pie_rating );
        }
    }
}
