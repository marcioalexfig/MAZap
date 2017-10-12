package br.com.ma.android.mazap.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.ma.android.mazap.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConversaFragment extends Fragment {

    TextView txtExemplo;

    public ConversaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentoBase = inflater.inflate(R.layout.fragment_conversa, container, false);


        return fragmentoBase;
    }

}
