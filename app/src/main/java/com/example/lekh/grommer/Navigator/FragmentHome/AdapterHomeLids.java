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
import com.example.lekh.grommer.Navigator.Category.AdapterCategory;
import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterHomeLids  extends RecyclerView.Adapter<AdapterHomeLids.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelProduct> createLists;
    private String myName;
    private String p;
    private String myPrice;
    private LayoutInflater mInflater;

    public AdapterHomeLids(Context context, RequestManager mGlide, List<ModelProduct> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;

    }

    @Override
    public AdapterHomeLids.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_liders, viewGroup, false);
        return new AdapterHomeLids.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final AdapterHomeLids.ViewHolder holder, int position) {

        final   ModelProduct modelEventR = createLists.get(position);

       // holder.textViewCatName.setText(modelEventR.getName());
        myName = modelEventR.getShortname();
        myPrice = modelEventR.getSpecial();
        p = myName.replace("&quot","\"");
        // holder.textViewProdName.setText(modelEventR.getShortname());
        holder.textViewCatName.setText(p);
        if (myPrice.equals("false")) {
            holder.textViewCatPriceOld.setVisibility(View.GONE);
            holder.textViewCatPrice.setVisibility(View.GONE);
            holder.textViewNamePriceLidssNorm.setVisibility(View.VISIBLE);
            holder.textViewNamePriceLidssNorm.setText(modelEventR.getPrice());

        }else {
            holder.textViewCatPriceOld.setVisibility(View.VISIBLE);
            holder.textViewCatPrice.setVisibility(View.VISIBLE);
            holder.textViewNamePriceLidssNorm.setVisibility(View.GONE);

            holder.textViewCatPrice.setText(modelEventR.getSpecial());
            holder.textViewCatPriceOld.setText(modelEventR.getPrice());
            holder.textViewCatPriceOld.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        holder.textViewArtic.setText(modelEventR.getSku());

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewCat);

        holder.imageViewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewLidss(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewCatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewCatNLidss(modelEventR, holder.getAdapterPosition()); }});




    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewCatPrice;
        private TextView textViewCatPriceOld;
        private TextView textViewCatName;
        private TextView textViewArtic;
        private TextView textViewNamePriceLidssNorm;
        private ImageView imageViewCat;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewCatPrice = (TextView) itemView.findViewById(R.id.textViewNamePriceLidss);
            textViewCatPriceOld = (TextView) itemView.findViewById(R.id.textViewNamePriceLidssold);
            textViewArtic = (TextView) itemView.findViewById(R.id.textViewArtic);
            textViewCatName = (TextView) itemView.findViewById(R.id.textViewNameNameLidss);
            textViewNamePriceLidssNorm = (TextView) itemView.findViewById(R.id.textViewNamePriceLidssNorm);
            imageViewCat = (ImageView) itemView.findViewById(R.id.imageViewProodLidss);

        }
    }
    public abstract void onItemClickimageViewLidss (ModelProduct view, int position);
    public abstract void onItemClickimageViewCatNLidss (ModelProduct view, int position);
}
