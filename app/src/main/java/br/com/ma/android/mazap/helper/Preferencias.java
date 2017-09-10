package br.com.ma.android.mazap.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by alex on 06/07/17.
 */

public class Preferencias {


    private static final String CHAVE_NOME = "nome";
    private static final String CHAVE_TOKEN = "token";
    private static final String CHAVE_TELEFONE = "telefone";
    private Context contexto;
    private SharedPreferences pref;
    private final String NOME_ARQUIVO = "dados_token.preferences";
    //APENAS ESTE APP ACESSA MODE 0
    private final int MODE = 0;
    private SharedPreferences.Editor editor;



    public Preferencias (Context contextoParam) {
        contexto = contextoParam;
        pref = contexto.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = pref.edit();

    }

    public void salvarUsuarioPref (String nome, String telefone, String token) {
        editor.putString(CHAVE_NOME, nome);
        editor.putString(CHAVE_TELEFONE, telefone);
        editor.putString(CHAVE_TOKEN, token);
        editor.commit();
    }

    public HashMap<String, String> dadosUsuario() {
        HashMap<String, String> hash = new HashMap<>();
        hash.put(CHAVE_NOME, pref.getString(CHAVE_NOME, null));
        hash.put(CHAVE_TELEFONE, pref.getString(CHAVE_TELEFONE, null));
        hash.put(CHAVE_TOKEN, pref.getString(CHAVE_TOKEN, null));
        return hash;

    }

}
