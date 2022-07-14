package com.example.nosmoking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nosmokingdb.NewSmokingTipsDB;

import java.util.List;

public class SmokingTipsAdapter extends RecyclerView.Adapter<SmokingTipsAdapter.SmokingTipsHolder>{
    private List<NewSmokingTipsDB> smokingTipsList;
    private LayoutInflater mInflater;
    private Context context;

    public class SmokingTipsHolder extends RecyclerView.ViewHolder{
        public final TextView smokingTipsItem;
        final SmokingTipsAdapter mSmokingTipsAdapter;

        SmokingTipsHolder(View view, SmokingTipsAdapter adapter){
            super(view);
            smokingTipsItem = view.findViewById(R.id.tv_tipsTitle);
            this.mSmokingTipsAdapter = adapter;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    NewSmokingTipsDB smokingTips = smokingTipsList.get(position);
                    Intent intent = new Intent(v.getContext(),SmokingTipsPost.class);
                    intent.putExtra("TIPS_ID", smokingTips.getTipsID());
                    intent.putExtra("TIPS_TITLE", smokingTips.getTipsTitle());
                    intent.putExtra("TIPS_CONTENT", smokingTips.getTipsContent());
                    ((Activity) context).startActivityForResult(intent, 1);
                }
            });
        }
    }

    SmokingTipsAdapter(android.content.Context context, List<NewSmokingTipsDB> smokingTipsList){
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.smokingTipsList = smokingTipsList;
    }


    @NonNull
    @Override
    public SmokingTipsAdapter.SmokingTipsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.smoking_tips_list, parent, false);
        return new SmokingTipsHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SmokingTipsHolder holder, int position) {
        final NewSmokingTipsDB smokingTips = smokingTipsList.get(position);
        holder.smokingTipsItem.setText(smokingTips.tipsTitle);
    }

    @Override
    public int getItemCount() {
        return smokingTipsList.size();
    }
}
