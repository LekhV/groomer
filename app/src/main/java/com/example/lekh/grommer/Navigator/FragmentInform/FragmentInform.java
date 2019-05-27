package com.example.lekh.grommer.Navigator.FragmentInform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lekh.grommer.Navigator.Category.PodCategory.ActivityPodCategory;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivityGarant;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivityObmIVoz;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivityOtpr;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivityProfKon;
import com.example.lekh.grommer.Navigator.FragmentInform.FragmentInformDetail.ActivitySkidka;
import com.example.lekh.grommer.R;

public class FragmentInform extends Fragment {

    private Button buttonSkidka;
    private Button buttonOtpr;
    private Button buttonGarant;
    private Button buttonProf;
    private Button buttonObmen;

    public FragmentInform() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fragment_inform, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_inform, container, false);
        buttonSkidka = retView.findViewById(R.id.buttonSkidka);
        buttonSkidka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSk = new Intent(getContext(), ActivitySkidka.class);
                startActivity(intentSk);
            }
        });

        buttonOtpr = retView.findViewById(R.id.buttonOtpr);
        buttonOtpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSk = new Intent(getContext(), ActivityOtpr.class);
                startActivity(intentSk);
            }
        });


        buttonGarant = retView.findViewById(R.id.buttonGarant);
        buttonGarant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSk = new Intent(getContext(), ActivityGarant.class);
                startActivity(intentSk);
            }
        });
        buttonProf = retView.findViewById(R.id.buttonProf);
        buttonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSk = new Intent(getContext(), ActivityProfKon.class);
                startActivity(intentSk);
            }
        });
        buttonObmen = retView.findViewById(R.id.buttonObmen);
        buttonObmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSk = new Intent(getContext(), ActivityObmIVoz.class);
                startActivity(intentSk);
            }
        });

        return retView;

    }
}
