package com.example.logonrm.persistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSPActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenha;

    private CheckBox cbConectado;

    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);

        cbConectado = (CheckBox) findViewById(R.id.cbConectado);

        btLogin = (Button) findViewById(R.id.btLogin);

        ler();

    }

    //associado a um onClick quando tem uma view
    public void logar(View view) {

        String login = etUsuario.getText().toString();
        String senha = etSenha.getText().toString();

        //limpa quando limpa os dados no settings
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        if(cbConectado.isChecked()) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else {
            e.putString("usuario", login);
            e.putString("senha", senha);
            e.putBoolean("manterConectado", false);
        }
        e.apply();

    }

    public void ler() {

        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        etUsuario.setText(sp.getString("usuario", ""));
        etSenha.setText(sp.getString("senha", ""));

        cbConectado.setChecked(sp.getBoolean("manterConectado", false));

        //String username = sp.getString("username", null);
       // String password = sp.getString("password", null);


    }



}
