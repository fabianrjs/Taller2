package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Camara extends AppCompatActivity {

    ImageView imagen;

    String cameraPermission = Manifest.permission.CAMERA;
    String galleryPermission = Manifest.permission.READ_EXTERNAL_STORAGE;
    int idCameraPermission = 2;
    int idGalleryPermission = 3;

    //Codes for external activities
    private static final int IMAGE_PICKER_REQUEST = 0;
    private static final int CAMERA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        imagen = findViewById(R.id.imageView);
    }

    public void galleryImage(){
        if( ActivityCompat.checkSelfPermission(this, galleryPermission) == PackageManager.PERMISSION_GRANTED ){
            Intent pickImage = new Intent(Intent.ACTION_PICK);
            pickImage.setType("image/*");
            startActivityForResult(pickImage, IMAGE_PICKER_REQUEST);
        }
    }

    public void cameraImage(){
        if( ActivityCompat.checkSelfPermission(this, cameraPermission) == PackageManager.PERMISSION_GRANTED ){
            Log.i("PERMISSION_APP", "Inside camera image method");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        }
    }

    public void cameraPressed(View v){
        if( ActivityCompat.checkSelfPermission(this, cameraPermission) != PackageManager.PERMISSION_GRANTED ){
            requestPermission(this, cameraPermission, "Tomar fotos", idCameraPermission);
        }else{
            cameraImage();
        }
    }

    public void galleryPressed(View v){
        if( ActivityCompat.checkSelfPermission(this, galleryPermission) != PackageManager.PERMISSION_GRANTED ){
            requestPermission(this, galleryPermission, "Subir Imagenes", idGalleryPermission);
        }else{
            galleryImage();
        }
    }

    private void requestPermission(Activity context, String permission, String justificacion, int id){
        if(ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
            if( ActivityCompat.shouldShowRequestPermissionRationale(context, permission) ){
                Toast.makeText(context, justificacion, Toast.LENGTH_LONG).show();
            }
            ActivityCompat.requestPermissions(context, new String[]{permission}, id);
        }
    }

}