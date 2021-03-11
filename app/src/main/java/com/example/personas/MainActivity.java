package com.example.personas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String usuari,con,con1,usuari1,nombre,correo,tel,ed;
                Intent Nuevo =new Intent(MainActivity.this,Datos.class);
                EditText usu=(EditText) findViewById(R.id.editNombrel);
                EditText contra =(EditText) findViewById(R.id.editContraseñal);
                usuari=usu.getText().toString();
                con=contra.getText().toString();
                Bundle extras = getIntent().getExtras();
                String d1=extras.getString("nombre");
                String d2=extras.getString("usuario");
                String d3=extras.getString("correo");
                String d4=extras.getString("contra");
                String d5=extras.getString("tel");
                String d6=extras.getString("edad");
                con1=d4;
                usuari1=d2;
                nombre=d1;
                correo=d3;
                tel=d5;
                ed=d6;
                if(usu.getText().toString().isEmpty()||contra.getText().toString().isEmpty())
                {
                    dialogo();
                }
                if (usuari.equals(usuari1)&&con.equals(con1))
                {
                    Nuevo.putExtra("nombre",nombre);
                    Nuevo.putExtra("usuario",usuari1);
                    Nuevo.putExtra("correo",correo);
                    Nuevo.putExtra("contra",con1);
                    Nuevo.putExtra("tel",tel);
                    Nuevo.putExtra("edad",ed);
                    startActivity(Nuevo);
                }

                    else {

                    dialogo2();

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