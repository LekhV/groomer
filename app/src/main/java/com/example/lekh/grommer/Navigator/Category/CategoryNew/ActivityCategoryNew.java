package com.example.lekh.grommer.Navigator.Category.CategoryNew;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.Category.Products.ActivityProducts;
import com.example.lekh.grommer.R;

public class ActivityCategoryNew extends Fragment {

    private TextView textViewCatNameMashinki;
    private ImageView imageViewCatMashinki;

    private TextView textViewCatNameNog;
    private ImageView imageViewCatNog;

    private TextView textViewCatNameFenu;
    private ImageView imageViewCatFenu;

    private TextView textViewCatNameObor;
    private ImageView imageViewCatObor;

    private TextView textViewCatNameAkcec;
    private ImageView imageViewCatAkcec;

    private TextView textViewCatNameKosm;
    private ImageView imageViewCatKosm;

    private TextView textViewCatNameKreat;
    private ImageView imageViewCatKreat;

    private TextView textViewCatNameUtug;
    private ImageView imageViewCatUtug;

    private TextView textViewCatNameYkrash;
    private ImageView imageViewCatYkrash;

   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.activity_category_new, container, false);

        textViewCatNameMashinki = retView.findViewById(R.id.textViewCatNameMashinki);
        textViewCatNameMashinki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","9");
                intentKat.putExtra("name","Машинки и аксессуары");
                startActivity(intentKat);
            }
        });

        imageViewCatMashinki = retView.findViewById(R.id.imageViewCatMashinki);
        imageViewCatMashinki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","9");
                intentKat.putExtra("name","Машинки и аксессуары");
                startActivity(intentKat);
            }
    });
        imageViewCatMashinki.setImageResource(R.drawable.mash);

        textViewCatNameNog = retView.findViewById(R.id.textViewCatNameNog);
        textViewCatNameNog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","210");
                intentKat.putExtra("name","Ножницы для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatNog = retView.findViewById(R.id.imageViewCatNog);
        imageViewCatNog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","210");
                intentKat.putExtra("name","Ножницы для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatNog.setImageResource(R.drawable.nog);

        textViewCatNameFenu = retView.findViewById(R.id.textViewCatNameFenu);
        textViewCatNameFenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","166");
                intentKat.putExtra("name","Фены для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatFenu = retView.findViewById(R.id.imageViewCatFenu);
        imageViewCatFenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","166");
                intentKat.putExtra("name","Фены для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatFenu.setImageResource(R.drawable.fenu);

        textViewCatNameObor = retView.findViewById(R.id.textViewCatNameObor);
        textViewCatNameObor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18839");
                intentKat.putExtra("name","Оборудование для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatObor = retView.findViewById(R.id.imageViewCatObor);
        imageViewCatObor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18839");
                intentKat.putExtra("name","Оборудование для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatObor.setImageResource(R.drawable.obor);

        textViewCatNameAkcec = retView.findViewById(R.id.textViewCatNameAkcec);
        textViewCatNameAkcec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","1");
                intentKat.putExtra("name","Аксессуары для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatAkcec = retView.findViewById(R.id.imageViewCatAkcec);
        imageViewCatAkcec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","1");
                intentKat.putExtra("name","Аксессуары для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatAkcec.setImageResource(R.drawable.akcec);

        textViewCatNameKosm = retView.findViewById(R.id.textViewCatNameKosm);
        textViewCatNameKosm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","14");
                intentKat.putExtra("name","Косметика для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatKosm = retView.findViewById(R.id.imageViewCatKosm);
        imageViewCatKosm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","14");
                intentKat.putExtra("name","Косметика для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatKosm.setImageResource(R.drawable.kosm);

        imageViewCatKreat = retView.findViewById(R.id.imageViewCatKreat);
        imageViewCatKreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Креативный груминг");
                startActivity(intentKat);
            }
        });
        imageViewCatKreat.setImageResource(R.drawable.kreat);
        textViewCatNameKreat = retView.findViewById(R.id.textViewCatNameKreat);
        textViewCatNameKreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Креативный груминг");
                startActivity(intentKat);
            }
        });

        textViewCatNameUtug = retView.findViewById(R.id.textViewCatNameUtug);
        textViewCatNameUtug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Утюжки и плойки для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatUtug = retView.findViewById(R.id.imageViewCatUtug);
        imageViewCatUtug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Утюжки и плойки для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatUtug.setImageResource(R.drawable.utig);

        textViewCatNameYkrash = retView.findViewById(R.id.textViewCatNameYkrash);
        textViewCatNameYkrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","206");
                intentKat.putExtra("name","Украшения для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatYkrash = retView.findViewById(R.id.imageViewCatYkrash);
        imageViewCatYkrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityProducts.class);
                intentKat.putExtra("catrgotyId","206");
                intentKat.putExtra("nameP","Украшения для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatYkrash.setImageResource(R.drawable.ykr);



        return retView;
    }
}
