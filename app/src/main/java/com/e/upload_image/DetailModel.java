package com.e.upload_image;

public class DetailModel {
  private String name, email, ph_no, area, spinnerCity, spinnerFlor, spinnerBhk,radiogrp;
  //create blank constructer for recycler view me data send kerne ke liye....

  public DetailModel()
     {}

  // create constructer..

  public DetailModel(String name, String email, String ph_no,
                     String area, String spinnerCity, String spinnerFlor, String spinnerBhk, String radiogrp) {

    this.area = area;
    this.email = email;
    this.name = name;
    this.ph_no = ph_no;
    this.spinnerBhk = spinnerBhk;
    this.spinnerCity = spinnerCity;
    this.spinnerFlor = spinnerFlor;
    this.radiogrp = radiogrp;
  }


  // create gettter..
    public String getName() {
        return name;
        }

       public void setName(String name) {
       this.name = name;
       }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPh_no() {
    return ph_no;
  }
  public void setPh_no(String ph_no) {
    this.ph_no = ph_no;
  }

  public String getArea() {
    return area;
  }
  public void setArea(String area) {
    this.area = area;
  }

  public String getSpinnerCity() {
    return spinnerCity;
  }

  public void setSpinnerCity(String spinnerCity) {
    this.spinnerCity = spinnerCity;
  }

  public String getSpinnerFlor() {
    return spinnerFlor;
  }

  public void setSpinnerFlor(String spinnerFlor) {
    this.spinnerFlor = spinnerFlor;
  }

  public String getSpinnerBhk() {
    return spinnerBhk;
  }

  public void setSpinnerBhk(String spinnerBhk) {
    this.spinnerBhk = spinnerBhk;
  }

  public String getRadiogrp() {
    return radiogrp;
  }

  public void setRadiogrp(String radiogrp) {
    this.radiogrp = radiogrp;
  }
}
