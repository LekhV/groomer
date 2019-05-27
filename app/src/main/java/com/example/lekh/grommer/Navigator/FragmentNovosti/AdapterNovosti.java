package com.example.lekh.grommer.Navigator.FragmentNovosti;

import android.content.Context;
import android.graphics.Paint;
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
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.Navigator.FragmentAkc.AdapterAkciiBig;
import com.example.lekh.grommer.R;

import java.util.List;

public abstract class AdapterNovosti extends RecyclerView.Adapter<AdapterNovosti.ViewHolder> {
    private Context context;
    private RequestManager mGlide;

    private List<ModelNovosti> createLists;
    private String myName;
    private String p;
    private  String  textViewFulldescriptionString;
    private String htmlText;
    private LayoutInflater mInflater;

    public AdapterNovosti(Context context, RequestManager mGlide, List<ModelNovosti> createLists) {
        this.context = context;
        this.mGlide = mGlide;
        this.createLists = createLists;
    }

    @Override
    public AdapterNovosti.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_novosti, viewGroup, false);
        return new AdapterNovosti.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterNovosti.ViewHolder holder, int position) {

        final   ModelNovosti modelEventR = createLists.get(position);
/*
        htmlText =  "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "</head><body>";


        htmlText += textViewFulldescriptionString + "</body></html>";
        holder.textContentNovostiDes.loadData(htmlText, "text/html; charset=UTF-8", null);
*/
           // textViewFulldescriptionString = modelEventR.getDescription();
           // p = textViewFulldescriptionString.replace("&quot, style=, <h2, text-align: center;","\"");
            holder.textViewNo.setText(modelEventR.getHref());


        holder.textViewNovostiName.setText(modelEventR.getTitle()) ;
        holder.textViewDataNovosti.setText(modelEventR.getDateAdded()) ;




        Glide.with(holder.itemView.getContext())
                .load(createLists.get(position)
                        .getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewNovosti);

        holder.imageViewNovosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickimageViewNovosti(modelEventR, holder.getAdapterPosition()); }});


    }

    @Override
    public int getItemCount() {
        return createLists == null? 0 : createLists.size(); }


    public class ViewHolder extends RecyclerView.ViewHolder { //implements View.OnClickListener{

        private TextView textViewNovostiName;
        private TextView textViewDataNovosti;
        private WebView textContentNovostiDes;
        private TextView textViewNo;
        private ImageView imageViewNovosti;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewNovostiName = (TextView) itemView.findViewById(R.id.textViewNovostiName);
            textViewDataNovosti = (TextView) itemView.findViewById(R.id.textViewDataNovosti);
            textContentNovostiDes = (WebView) itemView.findViewById(R.id.textContentNovostiDes);
            textViewNo = (TextView) itemView.findViewById(R.id.textViewNo);
            imageViewNovosti = (ImageView) itemView.findViewById(R.id.imageViewNovosti);

        }
    }
    public abstract void onItemClickimageViewNovosti (ModelNovosti view, int position);

}
