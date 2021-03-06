package com.example.aluno.appveiculo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.appveiculo.dao.UsuarioDAO;
import com.example.aluno.appveiculo.database.DataBase;
import com.example.aluno.appveiculo.model.Administrador;
import com.example.aluno.appveiculo.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    EditText login, senha;
    Button btn, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding();

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(3);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario u = new Usuario(0,"",login.getText().toString(),senha.getText().toString());

                DataBase conect = new DataBase(getApplicationContext());
                u = new UsuarioDAO(conect).findLoginAndSenha(u);

                if ( u == null ){
                    login.setText("");
                    senha.setText("");

                    Toast.makeText(getApplicationContext(),
                            "Login ou senha Incorreta!!!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Intent itn = new Intent();
                    itn.putExtra("usuario",u);
                    if (u instanceof Administrador){
                        setResult(1,itn);
                    }else{
                        setResult(2,itn);
                    }
                    finish();
                }
            }
        });

    }
    private void binding() {
        login = (EditText) findViewById(R.id.edtLogin);
        senha = (EditText) findViewById(R.id.edtSenha);
        btn = (Button) findViewById(R.id.btnLogin);
        btnFechar = (Button) findViewById(R.id.btnFechar);
    }
}
