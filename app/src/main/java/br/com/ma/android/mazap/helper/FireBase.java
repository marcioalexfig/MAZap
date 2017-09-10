package br.com.ma.android.mazap.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by alex on 05/09/17.
 */

public class FireBase {

    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth autenticacao;

    /**
     * Método que retorna a referencia do Firebase
     * @return
     */
    public static DatabaseReference referenciaFireBase(){

         if (referenciaFirebase == null)
             referenciaFirebase = FirebaseDatabase.getInstance().getReference();

        return referenciaFirebase;
    }

    /**
     * Método que retorna a autenticacao com Firebase
     * @return
     */
    public static FirebaseAuth autenticacaoFirebase(){

        if (autenticacao == null)
            autenticacao = FirebaseAuth.getInstance();

        return autenticacao;
    }


}
