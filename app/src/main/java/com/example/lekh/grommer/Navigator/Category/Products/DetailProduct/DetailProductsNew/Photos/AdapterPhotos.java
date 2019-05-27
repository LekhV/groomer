package com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.Photos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductRelated.AdapterProductRelated;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ProductSimilar.ModelProductSimilar;
import com.example.lekh.grommer.R;

import java.util.List;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public abstract class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelProductSimilar.Image> createLists;
    private String myName;
    private String p;
    private  String  textViewFulldescriptionString;
    private String htmlText;
    private LayoutInflater mInflater;

    public AdapterPhotos(Context context, RequestManager mGlide, List<ModelProductSimilar.Image> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterPhotos.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new AdapterPhotos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterPhotos.ViewHolder holder, int position) {

        final ModelProductSimilar.Image modelEventR = createLists.get(position);

        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getBig())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewProodNewPhot);

      /*  holder.imageViewProodNewPhot.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override public void onPhotoTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onPhotoTap :  x =  " + x + ";" + " y = " + y,
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageViewProodNewPhot.setOnViewTapListener(new OnViewTapListener() {
            @Override public void onViewTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onViewTap", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageViewProodNewPhot.setOnLongClickListener(new View.OnLongClickListener() {
            @Override public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        holder.imageViewProodNewPhot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewPhotos(modelEventR, holder.getAdapterPosition()); }});

*/

        holder.imageViewProodNewPhot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewPhotos(modelEventR, holder.getAdapterPosition()); }});
    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private ImageView imageViewProodNewPhot;


        public ViewHolder(View itemView) {
            super(itemView);

            imageViewProodNewPhot = (ImageView) itemView.findViewById(R.id.imageViewProodNewPhot);

        }
    }
    public abstract void onItemClickimageViewPhotos (ModelProductSimilar.Image view, int position);



}
