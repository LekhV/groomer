package com.example.lekh.grommer.Navigator.FragmentAkc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterAkcii extends RecyclerView.Adapter<AdapterAkcii.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelAkcii> createLists;
    private String myName;
    private String p;

    private LayoutInflater mInflater;

    public AdapterAkcii(Context context, RequestManager mGlide, List<ModelAkcii> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterAkcii.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_novosti, viewGroup, false);
        return new AdapterAkcii.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterAkcii.ViewHolder holder, int position) {

        final   ModelAkcii modelEventR = createLists.get(position);

        holder.textViewNovostiName.setText(modelEventR.getTitle()) ;
        holder.textViewNo.setText(modelEventR.getHref()) ;
        holder.textViewDataNovosti.setText(modelEventR.getDateAdded()) ;

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewNovosti);

        holder.imageViewNovosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewAkcii(modelEventR, holder.getAdapterPosition()); }});


    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNovostiName;
        private TextView textViewNo;
        private TextView textViewDataNovosti;
        private ImageView imageViewNovosti;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewNovostiName = (TextView) itemView.findViewById(R.id.textViewNovostiName);
            textViewNo = (TextView) itemView.findViewById(R.id.textViewNo);

            textViewDataNovosti = (TextView) itemView.findViewById(R.id.textViewDataNovosti);
            imageViewNovosti = (ImageView) itemView.findViewById(R.id.imageViewNovosti);

        }
    }
    public abstract void onItemClickimageViewAkcii (ModelAkcii view, int position);

}
