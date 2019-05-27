package com.example.lekh.grommer.Navigator.FragmentHome;

import android.content.Context;
import android.graphics.Paint;
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
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterKategoriiSmoll extends RecyclerView.Adapter<AdapterKategoriiSmoll.ViewHolder> {

    private Context context;
    private RequestManager mGlide;

    private List<ModelCategory> createLists;
    private String myName;
    private String p;

    private LayoutInflater mInflater;

    public AdapterKategoriiSmoll(Context context, RequestManager mGlide, List<ModelCategory> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterKategoriiSmoll.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cat_smoll, viewGroup, false);
        return new AdapterKategoriiSmoll.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterKategoriiSmoll.ViewHolder holder, int position) {

        final   ModelCategory modelEventR = createLists.get(position);

        // holder.textViewCatName.setText(modelEventR.getName());
        myName = modelEventR.getName();

        p = myName.replace("&quot","\"");
        // holder.textViewProdName.setText(modelEventR.getShortname());
        holder.textViewCatName.setText(p);

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewCat);

        holder.imageViewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewCa(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewCatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewNameCa(modelEventR, holder.getAdapterPosition()); }});


    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewCatName;
        private ImageView imageViewCat;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewCatName = (TextView) itemView.findViewById(R.id.textViewNameNameCS);
            imageViewCat = (ImageView) itemView.findViewById(R.id.imageViewProodCS);

        }
    }
    public abstract void onItemClickimageViewCa (ModelCategory view, int position);
    public abstract void onItemClickimageViewNameCa(ModelCategory view, int position);


}
