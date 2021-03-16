package com.example.personas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends AppCompatActivity {
    private ImageButton btnTelefono, btntelefono2;
    private TextView tel ,tel2;
    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
         tel=(TextView)findViewById(R.id.telefonog);
        tel2=(TextView)findViewById(R.id.texttellu);
        TextView nombreg=(TextView)findViewById(R.id.textnombreg);
        TextView nombrel=(TextView)findViewById(R.id.textNombrel);
        TextView sexog=(TextView)findViewById(R.id.texsexog);
        TextView sexol=(TextView)findViewById(R.id.texsexol);
        TextView edadl=(TextView)findViewById(R.id.texEdadl);
        TextView edadg=(TextView)findViewById(R.id.texEdadg);
        TextView curpg=(TextView)findViewById(R.id.textcurpg);
        TextView curpl=(TextView)findViewById(R.id.curpl);
        TextView correol=(TextView)findViewById(R.id.textcorreol);
        TextView correog=(TextView)findViewById(R.id.textcorreog);
        tel.setText("5527832023");
        tel2.setText("5577987378");
        nombrel.setText("Rojas Zavala Jorge Luis");
        nombreg.setText("Resendiz Zamorano Gabriel");
        sexol.setText(" Masculino");
        sexog.setText(" Masculino");
        edadg.setText(" Edad 20");
        edadl.setText(" Edad 21");
        curpg.setText(" curp REZG000817HDFSMBA8");
        curpl.setText(" curp ROSJ000316HMCJVRA4");
        correol.setText(" rojas17@gmail.com");
        correog.setText(" resendizgabriel19@gmail.com");
        btntelefono2=(ImageButton)findViewById(R.id.imageButton2);
        btntelefono2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tel.getText().toString();
                if(numero !=null){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL_CODE);
                    }else{
                        versionesAnteriores(numero);
                    }
                }
            }
            private void versionesAnteriores (String numero)
            {
                Intent MainActivity = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
                if (verificarPermisos(Manifest.permission.CALL_PHONE)){
                    startActivity(MainActivity);
                }else{
                    Toast.makeText(Datos.this, "Configura los permisos", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnTelefono =(ImageButton)findViewById(R.id.imageButton);
        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = tel2.getText().toString();
                if(numero !=null){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},PHONE_CALL_CODE);
                    }else{
                        versionesAnteriores(numero);
                    }
                }
            }
            private void versionesAnteriores (String numero)
            {
                Intent MainActivity = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
                if (verificarPermisos(Manifest.permission.CALL_PHONE)){
                    startActivity(MainActivity);
                }else{
                    Toast.makeText(Datos.this, "Configura los permisos", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];
                if  (permission.equals(Manifest.permission.CALL_PHONE))
                {
                    if (result== PackageManager.PERMISSION_GRANTED){
                        String NumeroTelefono=tel2.getText().toString();
                        Intent llamada=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+NumeroTelefono));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)return;
                        startActivity(llamada);
                    }
                    else{
                        Toast.makeText(this, "No aceptaste el permiso", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }


    }

    private boolean verificarPermisos (String permiso)
    {
        int resultado = this.checkCallingOrSelfPermission(permiso);
        return resultado == PackageManager.PERMISSION_GRANTED;
    }

 
}