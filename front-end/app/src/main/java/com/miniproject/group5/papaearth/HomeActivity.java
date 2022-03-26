package com.miniproject.group5.papaearth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button btnTakePhoto;
    private static final int CAMERA_PIC_REQUEST = 1337;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnTakePhoto = findViewById(R.id.btnTakePhoto);

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView sampleText = (TextView) findViewById(R.id.sampleText);
                sampleText.setText("Opening\nCamera");
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sampleText.setText("");
                    }
                }, 3000);
//                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//                startActivity(intent);
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            ImageView imageview = (ImageView) findViewById(R.id.imageView2); //sets imageview as the bitmap
            imageview.setImageBitmap(image);
        }
    }
}