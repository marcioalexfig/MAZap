package br.com.ma.android.mazap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import br.com.ma.android.mazap.R;
import br.com.ma.android.mazap.helper.FireBase;


public class MainActivity extends AppCompatActivity {

    private Button btnSair;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSair = (Button) findViewById(R.id.btn_sair);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacao = FireBase.autenticacaoFirebase();
                autenticacao.signOut();
                abrirTelaLogin();
            }
        });

    }

    private void abrirTelaLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
