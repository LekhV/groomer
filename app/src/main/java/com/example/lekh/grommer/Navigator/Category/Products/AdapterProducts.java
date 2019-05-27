package com.example.lekh.grommer.Navigator.Category.Products;

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
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterProducts  extends RecyclerView.Adapter<AdapterProducts.ViewHolder> {

    private Context context;
    private RequestManager mGlide;

    private List<ModelProduct> createLists;
    private String myName;
    private String p;

    private LayoutInflater mInflater;
    public AdapterProducts(Context context, List<ModelProduct> createLists, RequestManager mGlide) {
        this.mInflater = LayoutInflater.from(context);
        this.createLists = createLists;
        this.mGlide = mGlide;
    }

    @Override
    public AdapterProducts.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new AdapterProducts.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterProducts.ViewHolder holder, int position) {

        final   ModelProduct modelEventR = createLists.get(position);

        myName = modelEventR.getShortname();

        p = myName.replace("&quot","\"");
       // holder.textViewProdName.setText(modelEventR.getShortname());
        holder.textViewProdName.setText(p);
        holder.textViewProdDet.setText(modelEventR.getPrice());
        //holder.textViewCatId.setText(modelEventR.getCategoryId());
        // holder.textViewCatIdP.setText(modelEventR.getParentId());

        holder.textViewProdDetOld.setText(modelEventR.getPrice());
        holder.textViewProdDetOld.setPaintFlags( Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewProd);

        holder.imageViewProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewProd(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewProdName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewProdN(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewProdDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewProdDet(modelEventR, holder.getAdapterPosition()); }});



    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewProdName;
        private TextView  textViewProdDet;
        private TextView  textViewProdDetOld;

        private ImageView imageViewProd;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewProdName = (TextView) itemView.findViewById(R.id.textViewProdName);
            textViewProdDet = (TextView) itemView.findViewById(R.id.textViewProdPrice);
            textViewProdDetOld = (TextView) itemView.findViewById(R.id.textViewNamePriceProdold);

            imageViewProd = (ImageView) itemView.findViewById(R.id.imageViewProd);

        }
    }
    public abstract void onItemClickimageViewProd (ModelProduct view, int position);
    public abstract void onItemClickimageViewProdN (ModelProduct view, int position);
    public abstract void onItemClickimageViewProdDet (ModelProduct view, int position);


}
