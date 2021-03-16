package com.example.personas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button Agregar=(Button) findViewById(R.id.btnRegistrar);
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom,usu,core,con,tel,ed;
                EditText nombre=(EditText) findViewById(R.id.editNombre);
                EditText usuario=(EditText) findViewById(R.id.editUsuario);
                EditText correo=(EditText) findViewById(R.id.editCorreo);
                EditText contraseña=(EditText) findViewById(R.id.editContrseña);
                EditText telefono=(EditText) findViewById(R.id.editTelefono);
                EditText edad=(EditText) findViewById(R.id.editEdad);
                nom=nombre.getText().toString();
                usu=usuario.getText().toString();
                core=correo.getText().toString();
                con=contraseña.getText().toString();
                tel=telefono.getText().toString();
                ed=edad.getText().toString();
                Personas nuevo = new Personas();
                if(nombre.getText().toString().isEmpty()||usuario.getText().toString().isEmpty()||correo.getText().toString().isEmpty()||contraseña.getText().toString().isEmpty()||telefono.getText().toString().isEmpty()||edad.getText().toString().isEmpty())
                {

                    dialogo();
                }else
                if (Personas.verificar(usu)==-1) {
                    nuevo.setUsario(usu);
                    nuevo.setContraseña(con);
                    ListaUsuario.agregar(nuevo);
                    dialogo2();
                    usuario.setText("");
                    nombre.setText("");
                    correo.setText("");
                    contraseña.setText("");
                    telefono.setText("");
                    edad.setText("");
                }else {
                    dialogo3();
                    usuario.setText("");
                }


            }
        });

    }

    public  AlertDialog dialogo()
    {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Falta De Datos");
        builder.setMessage("ingrese datos");
        builder.setNegativeButton("ok",null);
        builder.create();
        return builder.show();
    }

    public  AlertDialog dialogo2()
    {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Usuarios");
        builder.setMessage("Usuario Guardado");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent  nuevo = new Intent(Registro.this,MainActivity.class);
                startActivity(nuevo);
            }
        });
        builder.create();
        return builder.show();
    }
    public  AlertDialog dialogo3()
    {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setTitle("Usuarios");
        builder.setMessage("Usuario Existente Ingrese otro usuario");
        builder.setNegativeButton("ok",null);
        builder.create();
        return builder.show();
    }
}