package com.example.personas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button agregar = (Button) findViewById(R.id.btnRegistro);
        Button Iniciar = (Button) findViewById(R.id.BtnIniciar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Nuevo =new Intent(MainActivity.this,Registro.class);
                startActivity(Nuevo);
            }
        });

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String usuari, con;
                EditText usu = (EditText) findViewById(R.id.editNombrel);
                EditText contra = (EditText) findViewById(R.id.editContraseñal);
                usuari = usu.getText().toString();
                con = contra.getText().toString();
                int pos = Personas.datoscorrectos(usuari,con);
                if(pos==-1)
                {
                   dialogo2();
               }
               else {
                       Intent  nuevo = new Intent(MainActivity.this,Datos.class);
                startActivity(nuevo);
                usu.setText("");
                contra.setText("");
                }

            }

        });
    }

    public AlertDialog dialogo()
    {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Falta De Datos");
        builder.setMessage("ingrese datos");
        builder.setNegativeButton("ok",null);
        builder.create();
        return builder.show();
    }

    public AlertDialog dialogo2()
    {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Datos eroneos");
        builder.setMessage("Usuario O contraseña incorrecto");
        builder.setNegativeButton("ok",null);
        builder.create();
        return builder.show();
    }
}