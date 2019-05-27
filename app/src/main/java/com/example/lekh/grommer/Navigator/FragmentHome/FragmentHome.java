package com.example.lekh.grommer.Navigator.FragmentHome;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lekh.grommer.Navigator.Category.ActivityCategory;
import com.example.lekh.grommer.Navigator.Category.AdapterCategory;
import com.example.lekh.grommer.Navigator.Category.CategoryNew.ActivityCategoryNew;
import com.example.lekh.grommer.Navigator.Category.ModelCategory;
import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.Category.Products.ActivityProducts;
import com.example.lekh.grommer.Navigator.Category.Products.AdapterProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.ActivityDetailProducts;
import com.example.lekh.grommer.Navigator.Category.Products.DetailProduct.DetailProductsNew.ActivityDetailsProductNew;
import com.example.lekh.grommer.Navigator.Category.Products.ModelListProducts;
import com.example.lekh.grommer.Navigator.Category.Products.ModelProduct;
import com.example.lekh.grommer.Navigator.FragmentAkc.AdapterAkciiBig;
import com.example.lekh.grommer.Navigator.FragmentLiders.FragmentLiders;
import com.example.lekh.grommer.R;
import com.example.lekh.grommer.Retrofit.RetrofitCategory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentHome extends Fragment {

    private  boolean isUpdate;

    private String catrgotyId = "212";

    private String catrgotyId2 = "1411";
    private String productIdId;
    private String nameProductDetail;

    private String productIdIdLids;
    private String nameProductDetailLids;
    private List<ModelProduct> mModelProductLids;
    private List<ModelProduct> mModelProductAkcii;

    private List<ModelListProducts> mModelListProductsLids;
    private String pageNo = "2";

    private List<ModelCategory> mModelCategory;
    private ModelCategory modelCategory;
    private AdapterKategoriiSmoll adapterCategory;
    private String parentId;
    private String name;

    private AdapterHomeLids mAdapter;
    private AdapterAkciiBig adapterAkciiBig;

    private LinearLayoutManager layoutManager1;
    private LinearLayoutManager layoutManagerAkcii;

    private RecyclerView recyclerViewLids;
    private RecyclerView recyclerViewAkcii;

    private Button buttonKat;
    private Button buttonLid;

    private ImageView buttonfb;
    private ImageView buttonutyb;
    private ImageView buttoninst;
    private ImageView buttontrlrg;

    private TextView noteView;

    private Button buttonall;
    private Button buttonall2;
    private Button buttonall3;
    private Button buttonAkc;

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
        View retView = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        mModelProductLids = new ArrayList<>();
        mModelProductAkcii = new ArrayList<>();
        mModelListProductsLids = new ArrayList<>();

        mModelCategory = new ArrayList<>();
        modelCategory = new ModelCategory();



        recyclerViewLids = retView.findViewById(R.id.recyclerViewLid);
        recyclerViewAkcii= retView.findViewById(R.id.recyclerViewAkcc);
        userGetProductLids();
        userGetProductLidsAcii();
        //userGetCategory();
        buttonKat = retView.findViewById(R.id.buttonKat);
        buttonKat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCategoryNew fragmentBusinessesFragment = new ActivityCategoryNew();
                FragmentManager fragmentManagerBusinessesFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesFragment = fragmentManagerBusinessesFragment.beginTransaction();
                fragmentTransactionBusinessesFragment.replace(R.id.flContent, fragmentBusinessesFragment);
                fragmentTransactionBusinessesFragment.commit();
            }
        });

        buttonall3 = retView.findViewById(R.id.buttonall3);
        buttonall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCategoryNew fragmentBusinessesFragment = new ActivityCategoryNew();
                FragmentManager fragmentManagerBusinessesFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesFragment = fragmentManagerBusinessesFragment.beginTransaction();
                fragmentTransactionBusinessesFragment.replace(R.id.flContent, fragmentBusinessesFragment);
                fragmentTransactionBusinessesFragment.commit();
            }
        });

        buttonLid = retView.findViewById(R.id.buttonLid);
        buttonLid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLiders fragmentConnectionsFragment = new FragmentLiders();
                FragmentManager fragmentManagerConnectionsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();
            }
        });

        buttonall = retView.findViewById(R.id.buttonall);
        buttonall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLiders fragmentConnectionsFragment = new FragmentLiders();
                FragmentManager fragmentManagerConnectionsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();
            }
        });

        buttonall2 = retView.findViewById(R.id.buttonall2);
        buttonall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLiders fragmentConnectionsFragment = new FragmentLiders();
                FragmentManager fragmentManagerConnectionsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();
            }
        });

        buttonAkc = retView.findViewById(R.id.buttonAkc);
        buttonAkc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLiders fragmentConnectionsFragment = new FragmentLiders();
                FragmentManager fragmentManagerConnectionsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();
            }
        });
        RecyclerView imageGridView = retView.findViewById(R.id.recyclerViewKat2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        imageGridView.setLayoutManager(gridLayoutManager);

        adapterCategory = new AdapterKategoriiSmoll(getContext(), Glide.with(this), mModelCategory) {

            @Override
            public void onItemClickimageViewCa(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

            @Override
            public void onItemClickimageViewNameCa(ModelCategory view, int position) {
                parentId = mModelCategory.get(position).getCategoryId();
                name = mModelCategory.get(position).getName();
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId",parentId);
                intentKat.putExtra("name",name);
                startActivity(intentKat);
            }

        };
        imageGridView.setAdapter(adapterCategory);

        noteView = (TextView) retView.findViewById(R.id.noteview);
        //noteView.setText(someContent);
        Linkify.addLinks(noteView, Linkify.ALL);

        buttonfb = retView.findViewById(R.id.imageViewsocial_fb);
        buttonfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groomer.com.ua/"));
                startActivity(browserIntent);
            }
        });

        buttonutyb = retView.findViewById(R.id.imageViewsocial_youtube);
        buttonutyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC9VakcpQGecqrpQpJMirUwA"));
                startActivity(browserIntent);
            }
        });

        buttoninst = retView.findViewById(R.id.imageViewsocial_istagram);
        buttoninst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/groomer.com.ua/"));
                startActivity(browserIntent);
            }
        });

        buttontrlrg = retView.findViewById(R.id.imageViewsocial_telegram);
        buttontrlrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/groomerua"));
                startActivity(browserIntent);
            }
        });


        textViewCatNameMashinki = retView.findViewById(R.id.textViewCatNameMashinki1);
        textViewCatNameMashinki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","9");
                intentKat.putExtra("name","Машинки и аксессуары");
                startActivity(intentKat);
            }
        });

        imageViewCatMashinki = retView.findViewById(R.id.imageViewCatMashinki1);
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

        textViewCatNameNog = retView.findViewById(R.id.textViewCatNameNog1);
        textViewCatNameNog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","210");
                intentKat.putExtra("name","Ножницы для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatNog = retView.findViewById(R.id.imageViewCatNog1);
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

        textViewCatNameFenu = retView.findViewById(R.id.textViewCatNameFenu1);
        textViewCatNameFenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","166");
                intentKat.putExtra("name","Фены для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatFenu = retView.findViewById(R.id.imageViewCatFenu1);
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

        textViewCatNameObor = retView.findViewById(R.id.textViewCatNameObor1);
        textViewCatNameObor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18839");
                intentKat.putExtra("name","Оборудование для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatObor = retView.findViewById(R.id.imageViewCatObor1);
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

        textViewCatNameAkcec = retView.findViewById(R.id.textViewCatNameAkcec1);
        textViewCatNameAkcec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","1");
                intentKat.putExtra("name","Аксессуары для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatAkcec = retView.findViewById(R.id.imageViewCatAkcec1);
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

        textViewCatNameKosm = retView.findViewById(R.id.textViewCatNameKosm1);
        textViewCatNameKosm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","14");
                intentKat.putExtra("name","Косметика для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatKosm = retView.findViewById(R.id.imageViewCatKosm1);
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

        imageViewCatKreat = retView.findViewById(R.id.imageViewCatKreat1);
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
        textViewCatNameKreat = retView.findViewById(R.id.textViewCatNameKreat1);
        textViewCatNameKreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Креативный груминг");
                startActivity(intentKat);
            }
        });

        textViewCatNameUtug = retView.findViewById(R.id.textViewCatNameUtug1);
        textViewCatNameUtug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","18840");
                intentKat.putExtra("name","Утюжки и плойки для груминга");
                startActivity(intentKat);
            }
        });
        imageViewCatUtug = retView.findViewById(R.id.imageViewCatUtug1);
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

        textViewCatNameYkrash = retView.findViewById(R.id.textViewCatNameYkrash1);
        textViewCatNameYkrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKat = new Intent(getContext(), ActivityPodCategory.class);
                intentKat.putExtra("parentId","206");
                intentKat.putExtra("name","Украшения для животных");
                startActivity(intentKat);
            }
        });
        imageViewCatYkrash = retView.findViewById(R.id.imageViewCatYkrash1);
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

    private void userGetProductLids() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("bestseller")
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();
                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            mModelProductLids.size();
                            mModelProductLids = modelListProductsList.getProducts();
                            mAdapter = new AdapterHomeLids(getContext(),Glide.with(getContext()),mModelProductLids) {
                                @Override
                                public void onItemClickimageViewLidss(ModelProduct view, int position) {
                                    productIdIdLids = mModelProductLids.get(position).getProductId();
                                    nameProductDetailLids = mModelProductLids.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdIdLids);
                                    intentKat.putExtra("nameProductDetail",nameProductDetailLids);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewCatNLidss(ModelProduct view, int position) {
                                    productIdIdLids = mModelProductLids.get(position).getProductId();
                                    nameProductDetailLids = mModelProductLids.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdIdLids);
                                    intentKat.putExtra("nameProductDetail",nameProductDetailLids);
                                    startActivity(intentKat);
                                }


                            };

                            layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                            recyclerViewLids.setLayoutManager(layoutManager1);

                            recyclerViewLids.setAdapter(mAdapter);

                           /* recyclerViewLids.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                @Override
                                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                                    int first = layoutManager1.findFirstVisibleItemPosition();
                                    int last2 = layoutManager1.findLastVisibleItemPosition();
                                    int count = recyclerView.getChildCount();
                                    int adapt = mAdapter.getItemCount();
                                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                                            && ( adapt <= pageN )
                                            && (pageN/20 > 1)){
                                        int ost = adapt%20;
                                        int pS =  (adapt/20) - ost + 2 ;
                                        String pSString = String.valueOf(pS);
                                        getNextPage(pSString);
                                        isUpdate = true;
                                    }
                                    super.onScrollStateChanged(recyclerView, newState);
                                }

                                @Override
                                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                                    super.onScrolled(recyclerView, dx, dy);
                                }
                            });*/
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {

                    }
                });
    }

   /* private void getNextPage(String pageS) {
        String page = pageS;
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProd(catrgotyId,page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
                            mModelProductLids.addAll(response.body().getProducts());
                            mModelProductLids.size();
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {
                        isUpdate = false;
                    }
                });

    }*/

    private void userGetProductLidsAcii() {

        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("action")
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts modelListProductsList = response.body();

                            modelListProductsList.getProductTotal();
                            final int pageN = Integer.parseInt(modelListProductsList.getProductTotal());
                            mModelProductAkcii.size();
                            mModelProductAkcii = modelListProductsList.getProducts();
                            adapterAkciiBig = new AdapterAkciiBig(getContext(),Glide.with(getContext()),mModelProductAkcii) {
                                @Override
                                public void onItemClickimageViewAkcii(ModelProduct view, int position) {
                                    productIdId = mModelProductAkcii.get(position).getProductId();
                                    nameProductDetail = mModelProductAkcii.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }

                                @Override
                                public void onItemClickimageViewCatNAkcii(ModelProduct view, int position) {
                                    productIdId = mModelProductAkcii.get(position).getProductId();
                                    nameProductDetail = mModelProductAkcii.get(position).getName();
                                    Intent intentKat = new Intent(getContext(), ActivityDetailsProductNew.class);
                                    intentKat.putExtra("productIdId",productIdId);
                                    intentKat.putExtra("nameProductDetail",nameProductDetail);
                                    startActivity(intentKat);
                                }


                            };

                            layoutManagerAkcii = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                            recyclerViewAkcii.setLayoutManager(layoutManagerAkcii);

                            recyclerViewAkcii.setAdapter(adapterAkciiBig);

                            recyclerViewAkcii.addOnScrollListener(new RecyclerView.OnScrollListener() {
                                @Override
                                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                                    int first = layoutManagerAkcii.findFirstVisibleItemPosition();
                                    int last2 = layoutManagerAkcii.findLastVisibleItemPosition();
                                    int count = recyclerView.getChildCount();
                                    int adapt = adapterAkciiBig.getItemCount();
                                    if (newState == RecyclerView.SCROLL_STATE_IDLE
                                            && ( adapt <= pageN )
                                            && (pageN/20 > 1)){
                                        int ost = adapt%20;
                                        int pS =  (adapt/20) - ost + 2 ;
                                        String pSString = String.valueOf(pS);
                                        getNextPageAkcii(pSString);
                                        isUpdate = true;
                                    }
                                    super.onScrollStateChanged(recyclerView, newState);
                                }

                                @Override
                                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                                    super.onScrolled(recyclerView, dx, dy);
                                }
                            });
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {

                    }
                });
    }

    private void getNextPageAkcii(String pageS) {
        String page = pageS;
        RetrofitCategory
                .getInstance()
                .getApi()
                .getIdProdLid("action",page)
                .enqueue(new Callback<ModelListProducts>() {
                    @Override
                    public void onResponse(@NonNull Call<ModelListProducts> call,
                                           @NonNull Response<ModelListProducts> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            ModelListProducts mModelProductAdd = response.body();
                            mModelProductAkcii.addAll(response.body().getProducts());
                            mModelProductAkcii.size();
                            adapterAkciiBig.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ModelListProducts> call, @NonNull Throwable t) {
                        isUpdate = false;
                    }
                });

    }
   /* private void userGetCategory() {
        RetrofitCategory
                .getInstance()
                .getApi()
                .userGetCategory()
                .enqueue(new Callback<List<ModelCategory>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<ModelCategory>> call,
                                           @NonNull Response<List<ModelCategory>>response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<ModelCategory> modelCategoryList = response.body();

                            modelCategoryList.size();
                            for (int i = 0; i < modelCategoryList.size(); i++) {
                                modelCategory = response.body().get(i);
                                if (modelCategory.getParentId().equals( "0" )){

                                    modelCategoryList.get(i).getCategoryId();
                                    mModelCategory.add(modelCategory);
                                    adapterCategory.notifyDataSetChanged();

                                }}
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<ModelCategory>> call, @NonNull Throwable t) {

                    }
                });
    }*/
}

