package br.com.ma.android.mazap.modelo;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import br.com.ma.android.mazap.helper.FireBaseConfiguracoes;

/**
 * Created by alex on 05/09/17.
 */

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String id;

    public Usuario (String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario (){}

    public void salvar() {
        //Gravando no banco de dados - Firebase
        DatabaseReference ref = FireBaseConfiguracoes.referenciaFireBase();
        ref.child("usuarios").child( getId() ).setValue( this );
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude //não será gravado no firebase
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Exclude //não será gravado no firebase
    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}
