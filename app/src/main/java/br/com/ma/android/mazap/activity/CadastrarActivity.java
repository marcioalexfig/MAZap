package br.com.ma.android.mazap.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import br.com.ma.android.mazap.R;
import br.com.ma.android.mazap.helper.FireBase;
import br.com.ma.android.mazap.modelo.Usuario;

public class CadastrarActivity extends AppCompatActivity {

    EditText nome;
    EditText email;
    EditText senha;
    Button cadastrar;
    FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        nome = (EditText) findViewById(R.id.txt_nome);
        email = (EditText) findViewById(R.id.txt_email);
        senha = (EditText) findViewById(R.id.txt_senha);
        cadastrar = (Button) findViewById(R.id.btn_cadastrar);

        cadastrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (  nome.getText().toString().length()>0
                      && email.getText().toString().length()>0
                        && senha.getText().toString().length()>0 ) {

                    Usuario usuario = new Usuario(nome.getText().toString(), email.getText().toString(), senha.getText().toString());

                    cadastrarUsuario(usuario);


                } else {
                    Toast.makeText(CadastrarActivity.this, "Preencher todos os campos", Toast.LENGTH_LONG).show();
                }



            }
        });


    }

    private boolean cadastrarUsuario(Usuario usuario) {
        try {
            autenticacao = FireBase.autenticacaoFirebase();
            autenticacao.createUserWithEmailAndPassword(
                    usuario.getEmail(),
                    usuario.getSenha()
            ).addOnCompleteListener(CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(CadastrarActivity.this, "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(CadastrarActivity.this, "Ocorreu um erro no Cadastro, tente novamente!", Toast.LENGTH_LONG).show();
                    }
                }
            });

            //Gravando no banco de dados
            DatabaseReference ref = FireBase.referenciaFireBase();
            ref.child("nome_usuario").setValue(usuario.getNome());

        } catch (Exception e){
            Log.e("Erro no Cadastro", e.getLocalizedMessage());
        }

        return true;
    }
}
