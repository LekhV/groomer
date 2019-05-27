package com.example.lekh.grommer.Navigator.FragmentAkc;

import com.example.lekh.grommer.Navigator.FragmentNovosti.ModelNovosti;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelAkciiList {
    @SerializedName("actions")
    @Expose
    private List<ModelAkcii> actions = null;

    public List<ModelAkcii> getActions() {
        return actions;
    }

    public void setActions(List<ModelAkcii> actions) {
        this.actions = actions;
    }
}
