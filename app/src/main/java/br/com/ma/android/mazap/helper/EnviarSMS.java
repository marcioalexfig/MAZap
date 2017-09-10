package br.com.ma.android.mazap.helper;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Random;

import br.com.ma.android.mazap.R;
import br.com.ma.android.mazap.activity.LoginActivity;

public class EnviarSMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


        // Validando as permissoes para a tela
        //Permissoes.validaPermissoes(1, this, permissoesNecessarias);

        // campos e botoes
        /*
        nome = (EditText) findViewById(R.id.txtNome);
        codPais = (EditText) findViewById(R.id.txtCodPais);
        codCidade = (EditText) findViewById(R.id.txtCodCidade);
        numero = (EditText) findViewById(R.id.txtNumero);

        cadastrar = (Button) findViewById(R.id.btnCadastrar);

        //Mascara para os campos da tela
        SimpleMaskFormatter maskTelefone =  new SimpleMaskFormatter("NNNNN-NNNN");
        MaskTextWatcher maskWTel = new MaskTextWatcher(numero, maskTelefone);
        numero.addTextChangedListener(maskWTel);

        SimpleMaskFormatter maskCodPais =  new SimpleMaskFormatter("+NN");
        MaskTextWatcher maskWCodPais = new MaskTextWatcher(codPais, maskCodPais);
        codPais.addTextChangedListener(maskWCodPais);

        SimpleMaskFormatter maskCodCidade =  new SimpleMaskFormatter("NN");
        MaskTextWatcher maskWCodCidade = new MaskTextWatcher(codCidade, maskCodCidade);
        codCidade.addTextChangedListener(maskWCodCidade);
        */


        //cadastrar.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
                //String txnome = nome.getText().toString();

                /**
                 * Concatenação de telefone e retirada de caracteres especiais
                 */
                //StringBuilder txtel = new StringBuilder();
                //txtel
                        //.append(codPais.getText().toString().replace("+",""))
                        //.append(codCidade.getText().toString())
                        //.append(numero.getText().toString().replace("-",""));


                /**
                 * Geração de token
                 */
                /*
                //TODO - Geracao de token no backend, tirar o randomico e colocar num servidor via webservice.
                Random ramdomico = new Random();
                int numRandomico = ramdomico.nextInt(9999-1000)+1000;
                String token = String.valueOf(numRandomico);
                //********************************************************************************************
                */
                /**
                 * Guardando dados de usuário em preferencias do android  para validação
                 */
                //Preferencias pref = new Preferencias( LoginActivity.this );
                //pref.salvarUsuarioPref(txnome,txtel.toString(),token);


                /**
                 * Envio de SMS
                 */

                //String msgConfirmacao = "Token MAZap: "+ token;
                //boolean smsEnviado = enviaSMS("+" + txtel.toString(), msgConfirmacao);


                //if (smsEnviado) {
                    //Intent intent = new Intent(LoginActivity.this, ValidadorActivity.class);
                    //startActivity(intent);
                   // finish();
                //} else {
                   // Toast.makeText(LoginActivity.this, "Ocorreu um erro ao enviar o SMS, tente novamente!!", Toast.LENGTH_LONG);
                //}


                //boolean smsEnviado = enviaSMS("+5554", msgConfirmacao);
                //HashMap<String, String> teste = pref.dadosUsuario();
                //Log.i("teste: ",teste.toString());

            //}
        //});
    //}

    /**
     * Métodos para envio de SMS - permissoes precisam ser solicvitadas senão não funciona
     * @param telefone
     * @param mensagem
     * @return
     */
    private boolean enviaSMS(String telefone, String mensagem) {
        try{
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(telefone, null,mensagem,null,null);
            Log.i("SMS: ","MENSAGEM ENVIADA COM SUCESSO!");
            return true;
        }catch(Exception e){
            Log.e("SMS: ",e.getLocalizedMessage().toString());
            return false;
        }
    }

    /**
     * sobrescrevendo o metodo original
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for( int resultado : grantResults ){

            if( resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }

        }

    }

    /**
     * Alertando o usuário que é importante aceitar as permissões
     */
    private void alertaValidacaoPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões negadas");
        builder.setMessage("Para usar este aplicativo é necessário aceitar as permissões");
        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialogo = builder.create();
        dialogo.show();
    }





}
