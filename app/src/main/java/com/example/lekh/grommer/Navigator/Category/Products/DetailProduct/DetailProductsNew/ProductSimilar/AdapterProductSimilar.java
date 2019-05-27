package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.Navigator.FragmentNovosti.AdapterNovosti;
import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelNovosti;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterProductSimilar extends RecyclerView.Adapter<AdapterProductSimilar.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelProductSimilar> createLists;
    private String myName;
    private String p;
    private  String  textViewFulldescriptionString;
    private String htmlText;
    private LayoutInflater mInflater;

    public AdapterProductSimilar(Context context, RequestManager mGlide, List<ModelProductSimilar> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterProductSimilar.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product_new, viewGroup, false);
        return new AdapterProductSimilar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterProductSimilar.ViewHolder holder, int position) {

        final   ModelProductSimilar modelEventR = createLists.get(position);

        holder.textViewNameNameNew.setText(modelEventR.getName()) ;
        holder.textViewNamePriceNew.setText(modelEventR.getPrice()) ;
        holder.textViewNamePriceoldNew.setText(modelEventR.getPrice()) ;
        holder.textViewNew.setText(modelEventR.getSku()) ;

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewProodNew);

        holder.imageViewProodNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewProductSimilar(modelEventR, holder.getAdapterPosition()); }});

        holder.textViewNameNameNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewProductSimilarName(modelEventR, holder.getAdapterPosition()); }

        });
    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewNameNameNew;
        private TextView textViewNamePriceoldNew;
        private TextView textViewNamePriceNew;
        private TextView textViewNew;
        private ImageView imageViewProodNew;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewNameNameNew = (TextView) itemView.findViewById(R.id.textViewNameNameNew);
            textViewNamePriceoldNew = (TextView) itemView.findViewById(R.id.textViewNamePriceoldNew);
            textViewNamePriceNew = (TextView) itemView.findViewById(R.id.textViewNamePriceNew);
            textViewNew = (TextView) itemView.findViewById(R.id.textViewNew);
            imageViewProodNew = (ImageView) itemView.findViewById(R.id.imageViewProodNew);

        }
    }
    public abstract void onItemClickimageViewProductSimilar (ModelProductSimilar view, int position);
    public abstract void onItemClickimageViewProductSimilarName (ModelProductSimilar view, int position);

}
