package com.example.lekh.grommer.Navigator.Category.PodCategory;

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
import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterPodCategory extends RecyclerView.Adapter<AdapterPodCategory.ViewHolder> {

    private Context context;
    private RequestManager mGlide;
    private List<ModelCategory> createLists;
    private LayoutInflater mInflater;
    public AdapterPodCategory(Context context, List<ModelCategory> createLists, RequestManager mGlide) {
        this.mInflater = LayoutInflater.from(context);
        this.createLists = createLists;
        this.mGlide = mGlide;
    }

    @Override
    public AdapterPodCategory.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup, false);
        return new AdapterPodCategory.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterPodCategory.ViewHolder holder, int position) {

        final   ModelCategory modelEventR = createLists.get(position);

        holder.textViewCatName.setText(modelEventR.getName());
        //holder.textViewCatId.setText(modelEventR.getParentId());

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewCat);

        holder.imageViewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewPod(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewCatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewPod(modelEventR, holder.getAdapterPosition()); }});
    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewCatName;
     //   private TextView textViewCatId;

        private ImageView imageViewCat;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewCatName = (TextView) itemView.findViewById(R.id.textViewCatName);
          //  textViewCatId = (TextView) itemView.findViewById(R.id.textViewCatId);

            imageViewCat = (ImageView) itemView.findViewById(R.id.imageViewCat);

        }
    }
    public abstract void onItemClickimageViewPod (ModelCategory view, int position);
    public abstract void onItemClickimageViewCatN (ModelCategory view, int position);

}
