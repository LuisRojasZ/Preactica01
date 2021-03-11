package com.example.personas;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Personas {

    private Array[] datos= new Array[2];
    private  String Nombre;
    private  String Correo;
    private  String Contaseña;
    private  String Edad;
    private  String Telefono;
    private  String Usuario;
    private  String Ususariol;
    private  String Contraseñal;

    public Personas() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContaseña() {
        return Contaseña;
    }

    public void setContaseña(String contaseña) {
        Contaseña = contaseña;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getUsusariol() {
        return Ususariol;
    }

    public void setUsusariol(String ususariol) {
        Ususariol = ususariol;
    }

}
