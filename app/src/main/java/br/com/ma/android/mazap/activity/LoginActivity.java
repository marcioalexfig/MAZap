package br.com.ma.android.mazap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.ma.android.mazap.R;
import br.com.ma.android.mazap.helper.FireBaseConfiguracoes;
import br.com.ma.android.mazap.modelo.Usuario;

public class LoginActivity extends AppCompatActivity {


    private EditText email;
    private EditText senha;
    private Button btnLogar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.txt_email);
        senha = (EditText) findViewById(R.id.txt_senha);
        btnLogar = (Button) findViewById(R.id.btn_logar);

        verificarUsuarioLogado();


        btnLogar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                validarLogin();
            }
        });


    }

    private void validarLogin() {
        autenticacao = FireBaseConfiguracoes.autenticacaoFirebase();
        autenticacao.signInWithEmailAndPassword(
                this.usuario.getEmail(),
                this.usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    abrirTelaInicial();
                } else {
                    Toast.makeText(LoginActivity.this, "Erro ao logar, tente novamente!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Verifica se o usuario está logado e se não estiver, carrega a tela de logion normalmente
     * se o mesmo estiver logado, será redirecionado para a tela principal
     */
    public void verificarUsuarioLogado(){
        autenticacao = FireBaseConfiguracoes.autenticacaoFirebase();
        if (autenticacao.getCurrentUser() != null){
            abrirTelaInicial();
        }
    }

    /**
     * Abre a tela principal
     */
    private void abrirTelaInicial() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Abre a tela de cadastro
     * @param view
     */
    public void abrirTelaCadastro(View view){

        Intent intent = new Intent(LoginActivity.this, CadastrarActivity.class);
        startActivity(intent);
        finish();

    }

}
