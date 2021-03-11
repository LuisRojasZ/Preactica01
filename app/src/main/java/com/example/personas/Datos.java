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
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends AppCompatActivity {
    private ImageButton btnTelefono;
    private TextView tel;
    private final int PHONE_CALL_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Bundle extras = getIntent().getExtras();
        TextView nombre=(TextView)findViewById(R.id.textView8);
        TextView usuario=(TextView)findViewById(R.id.textView10);
        TextView correo=(TextView)findViewById(R.id.textView11);
        TextView contraseña=(TextView)findViewById(R.id.textView12);
        tel=(TextView)findViewById(R.id.textView7);
        TextView edad=(TextView)findViewById(R.id.textView9);
        String d1=extras.getString("nombre");
        String d2=extras.getString("usuario");
        String d3=extras.getString("correo");
        String d4=extras.getString("contra");
        String d5=extras.getString("tel");
        String d6=extras.getString("edad");

        nombre.setText(d1);
        usuario.setText(d2);
        correo.setText(d3);
        contraseña.setText(d4);
        tel.setText(d5);
        edad.setText(d6);
        btnTelefono =(ImageButton)findViewById(R.id.imageButton);
        btnTelefono.setOnClickListener(new View.OnClickListener() {

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
                        String NumeroTelefono=tel.getText().toString();
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