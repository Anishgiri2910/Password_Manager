package com.example.passwordmanager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class UrlListAdapter extends RecyclerView.Adapter<UrlListAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<URLs> mUrls; // Cached copy of words
    private OnItemClickListner listner;

    UrlListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mUrls != null) {
            URLs current = mUrls.get(position);
            holder.wordItemView.setText(current.getWebpage());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    public URLs getUrlAtPosition (int position) {
        return mUrls.get(position);
    }


    void setUrl(List<URLs> urls){
        mUrls = urls;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mUrls != null)
            return mUrls.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView wordItemView;

        private ViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.webpageTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION) {
                        listner.onItemClick(mUrls.get(position));
                    }
                }
            });

        }
    }
    public interface OnItemClickListner{
        void onItemClick(URLs url);
    }
    public void setOnItemClickListner(OnItemClickListner listner){
        this.listner=listner;
    }
}
