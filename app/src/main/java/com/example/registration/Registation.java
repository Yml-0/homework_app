package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.registration.databinding.ActivityNextBinding;
import com.example.registration.databinding.ActivityRegistationBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Registation extends AppCompatActivity implements View.OnClickListener {

   final String TAG = "STA";

    ActivityNextBinding binding;

    public static final int ACTION_IMAGE_CAPTURE_REQUEST_CODE = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String email = getIntent().getStringExtra("email");
        binding.textX.setText("Привет, " + email + "!");

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registration:
                finish();
                break;
            case R.id.take_photo:
                Intent photoPickerIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoPickerIntent, ACTION_IMAGE_CAPTURE_REQUEST_CODE);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent image) {
        super.onActivityResult(requestCode, resultCode, image);

        switch (requestCode) {
            case ACTION_IMAGE_CAPTURE_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK)
                {
                    Bitmap photo = (Bitmap) image.getExtras().get("data");
                    binding.photo.setImageBitmap(photo);
                    Log.v(TAG, "Load image");
                }

        }
    }
}