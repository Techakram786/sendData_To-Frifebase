package com.e.upload_image;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.util.ArrayList;
import java.util.List;

public class Upload_Images extends AppCompatActivity {

    private static final int IMAGE_CODE = 1;
    Button selectBtn;
    RecyclerView recyclerView;
    List<ModalClass> modalClassList;
    CustomAdapter customAdapter;

    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__images);
        getSupportActionBar().setTitle("Upload_Images");
        selectBtn = findViewById(R.id.select_btn);
        recyclerView = findViewById(R.id.recycler_img);

       // recyclerView.setHasFixedSize(true
           recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mStorageRef = FirebaseStorage.getInstance( ).getReference( );
        modalClassList = new ArrayList<>( );
        //BUTTON.....
        selectBtn.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( );
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, IMAGE_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == IMAGE_CODE && resultCode == RESULT_OK) {

            if (data.getClipData( ) != null) {

                int totalitem = data.getClipData( ).getItemCount( );

                for (int i = 0; i < totalitem; i++) {

                    Uri imageUri = data.getClipData( ).getItemAt(i).getUri( );
                    String imagename = getFileName(imageUri);

                    ModalClass modalClass = new ModalClass(imagename, imageUri);
                    modalClassList.add(modalClass);


                    StorageReference mRef = mStorageRef.child("image").child(imagename);

                    mRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>( ) {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(Upload_Images.this, "Done", Toast.LENGTH_SHORT).show( );

                        }
                    }).addOnFailureListener(new OnFailureListener( ) {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Upload_Images.this, "Fail" + e.getMessage( ), Toast.LENGTH_SHORT).show( );
                        }
                    });


                }

                customAdapter = new CustomAdapter(Upload_Images.this, modalClassList);
                recyclerView.setAdapter(customAdapter);


            } else if (data.getData( ) != null) {
                Toast.makeText(this, "single_image_selected", Toast.LENGTH_SHORT).show( );
            }

        }

    }


    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}
