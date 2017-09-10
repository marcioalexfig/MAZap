package br.com.ma.android.mazap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.ma.android.mazap.R;

public class LoginActivity extends AppCompatActivity {


    private EditText nome;
    private EditText email;
    private EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //DatabaseReference referenciaFirebase = FireBase.referenciaFireBase();

        //referenciaFirebase.child("pontos").setValue(300);

    }

    public void abrirTelaCadastro(View view){

        Intent intent = new Intent(LoginActivity.this, CadastrarActivity.class);
        startActivity(intent);
        finish();

    }

}
