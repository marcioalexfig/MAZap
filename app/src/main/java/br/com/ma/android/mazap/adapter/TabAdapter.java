package br.com.ma.android.mazap.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.ma.android.mazap.fragment.ContatoFragment;
import br.com.ma.android.mazap.fragment.ConversaFragment;

/**
 * Created by alex on 05/10/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter {


        private String[] tituloAbas = {"COVERSAS", "CONTATOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragmento = null;
        switch (position){
            case 0 :
                fragmento = new ConversaFragment();
                break;
            case 1 :
                fragmento = new ContatoFragment();
                break;
        }
        return fragmento;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }
    @Override
    public CharSequence getPageTitle(int position){
        return tituloAbas[position];
    }
}
