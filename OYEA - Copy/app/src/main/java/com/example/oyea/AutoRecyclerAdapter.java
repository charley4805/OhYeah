package com.example.oyea;

import android.content.Context;

import com.google.android.material.snackbar.Snackbar;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class AutoRecyclerAdapter extends RecyclerView.Adapter<AutoRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final List<AutoInfo> mAutos;
    private final LayoutInflater mLayoutInflater;

    public AutoRecyclerAdapter(Context context, List<AutoInfo> autos) {
        mContext = context;
        mAutos = autos;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_auto_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AutoInfo auto = mAutos.get(position);
        holder.mTextAuto.setText(auto.getTitle());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mAutos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextAuto;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextAuto = itemView.findViewById(R.id.text_auto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, mAutos.get(mCurrentPosition).getTitle(),
                            Snackbar.LENGTH_LONG).show();

                }
            });
        }
    }
}







