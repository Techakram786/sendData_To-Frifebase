package com.e.upload_image;

import android.net.Uri;

public class ModalClass {

    String imagename;
    Uri image;
//its make for data send to recycler view....
    public ModalClass() {
    }


    public ModalClass(String imagename, Uri image) {
        this.imagename = imagename;
        this.image = image;
    }


    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}