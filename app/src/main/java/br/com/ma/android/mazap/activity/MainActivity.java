package br.com.ma.android.mazap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import br.com.ma.android.mazap.R;
import br.com.ma.android.mazap.helper.FireBaseConfiguracoes;


public class MainActivity extends AppCompatActivity {

    private Toolbar mnToolbar;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnToolbar = (Toolbar) findViewById(R.id.toolbar);
        mnToolbar.setTitle("MAZap");
        setSupportActionBar( mnToolbar );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    private void abrirTelaLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.item_sair:
                sair();
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void sair(){
        autenticacao = FireBaseConfiguracoes.autenticacaoFirebase();
        autenticacao.signOut();
        abrirTelaLogin();
    }


}
