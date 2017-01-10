package com.example.pr_idi.mydatabaseexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 5/1/2017.
 */

public class Frag_modificar_nota extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.modificar_nota, container, false);
        return myView;
    }
}
