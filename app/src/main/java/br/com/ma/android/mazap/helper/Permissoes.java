package br.com.ma.android.mazap.helper;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 07/07/17.
 */

public class Permissoes {
    public static boolean validaPermissoes(int requestCode, Activity activity, String[] permissoes) {

        if (Build.VERSION.SDK_INT >= 23){

            List<String> listaPermissoes = new ArrayList<String>();
            for (String permissao: permissoes) {
                Boolean validaPermissao = ContextCompat.checkSelfPermission(activity, permissao) == PackageManager.PERMISSION_GRANTED;

                if (!validaPermissao){
                     listaPermissoes.add(permissao);
                }

            }

            if (listaPermissoes.isEmpty()) return true;

            String[] arrayPermissoes = new String[listaPermissoes.size()];
            listaPermissoes.toArray(arrayPermissoes);

            ActivityCompat.requestPermissions(activity, arrayPermissoes, requestCode);

        }

        return true;
    }
}
