package com.example.lekh.grommer.Navigator.FragmentAkc;

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
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.R;

import java.util.List;


public abstract class AdapterAkciiBig extends RecyclerView.Adapter<AdapterAkciiBig.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelProduct> createLists;
    private String myName;
    private String p;
    private String myPrice;
    private LayoutInflater mInflater;

    public AdapterAkciiBig(Context context, RequestManager mGlide, List<ModelProduct> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterAkciiBig.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_akcii_big, viewGroup, false);
        return new AdapterAkciiBig.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterAkciiBig.ViewHolder holder, int position) {

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
            holder.textViewNamePriceLAkciiNorm.setVisibility(View.VISIBLE);
            holder.textViewNamePriceLAkciiNorm.setText(modelEventR.getPrice()) ;

        }else{    holder.textViewCatPriceOld.setVisibility(View.VISIBLE);
            holder.textViewCatPrice.setVisibility(View.VISIBLE);
            holder.textViewNamePriceLAkciiNorm.setVisibility(View.GONE);
            holder.textViewCatPrice.setText(modelEventR.getSpecial());
            holder.textViewCatPriceOld.setText(modelEventR.getPrice());
            holder.textViewCatPriceOld.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        }

        holder.textViewNamePriceAkciibigArt.setText(modelEventR.getSku()) ;

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewCat);

        holder.imageViewCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewAkcii(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewCatName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewCatNAkcii(modelEventR, holder.getAdapterPosition()); }});


    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewCatPrice;
        private TextView textViewCatPriceOld;
        private TextView textViewCatName;
        private TextView textViewNamePriceAkciibigArt;
        private TextView  textViewNamePriceLAkciiNorm;
        private ImageView imageViewCat;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewCatPrice = (TextView) itemView.findViewById(R.id.textViewNamePriceAkciibig);
            textViewCatPriceOld = (TextView) itemView.findViewById(R.id.textViewNamePriceAkciibigold);
            textViewCatName = (TextView) itemView.findViewById(R.id.textViewNameNameAkciibig);
            textViewNamePriceAkciibigArt = (TextView) itemView.findViewById(R.id.textViewNamePriceAkciibigArt);
            textViewNamePriceLAkciiNorm = (TextView) itemView.findViewById(R.id.textViewNamePriceLAkciiNorm);

            imageViewCat = (ImageView) itemView.findViewById(R.id.imageViewProodAkciibig);

        }
    }
    public abstract void onItemClickimageViewAkcii (ModelProduct view, int position);
    public abstract void onItemClickimageViewCatNAkcii (ModelProduct view, int position);
}
