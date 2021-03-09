package com.heart.bean;

import java.util.*;

public class HeartBean {
    private String age;
    private String sex;
    private String ChestPain;
    private String BloodPressure;
	private String Cholestrol;
    private String BloodSugar;
	private String Electrocardiographic;
    private String Thalach;
	private String Exang;
	private String OldPeak;
	private String Slope;
	private String CA;
	private String Thal;
    private String error;
    private Hashtable errors;

    public HeartBean() {
        age = "";
        sex = "";
        ChestPain = "";
        BloodPressure = "";
        Cholestrol = "";
        BloodSugar = "";
        Electrocardiographic = "";
        Thalach = "";
        Exang = "";
        OldPeak="";
        Slope = "";
        CA = "";
        Thal = "";
        error="";
        errors = new Hashtable();
    } public String getAge() {
       return age;
	} public void setAge(String age) {
       this.age = age;
	} public String getSex() {
       return sex;
	} public void setSex(String sex) {
       this.sex = sex;
	} public String getChestPain() {
       return ChestPain;
    } public void setChestPain(String ChestPain) {
       this.ChestPain = ChestPain;
    } public String getBloodPressure() {
       return BloodPressure;
    } public void setBloodPressure(String BloodPressure) {
       this.BloodPressure = BloodPressure;
    } public String getCholestrol() {
       return Cholestrol;
	} public void setCholestrol(String Cholestrol) {
       this.Cholestrol = Cholestrol;
	} public String getBloodSugar() {
       return BloodSugar;
	} public void setBloodSugar(String BloodSugar) {
       this.BloodSugar = BloodSugar;
	} public String getElectrocardiographic() {
       return Electrocardiographic;
	} public void setElectrocardiographic(String Electrocardiographic) {
       this.Electrocardiographic = Electrocardiographic;
	} public String getThalach() {
       return Thalach;
	} public void setThalach(String Thalach) {
       this.Thalach = Thalach;
	} public String getExang() {
       return Exang;
	} public void setExang(String Exang) {
       this.Exang = Exang;
	} public String getOldPeak() {
       return OldPeak;
	} public void setOldPeak(String OldPeak) {
       this.OldPeak = OldPeak;
	} public String getSlope() {
       return Slope;
	} public void setSlope(String Slope) {
       this.Slope = Slope;
	} public String getCA() {
       return CA;
	} public void setCA(String CA) {
       this.CA = CA;
	} public String getThal() {
       return Thal;
	} public void setThal(String Thal) {
       this.Thal = Thal;
	} public String getError() {
	    return error;
	} public String getErrors(String s) {
		String errorMsg =(String)errors.get(s.trim());
	    return (errorMsg == null) ? "":errorMsg;
	} public void setErrors(String key, String msg) {

	} public void setError(String msg) {
	    error=msg;
	} public boolean isValidate() {
       boolean allOk=true;
       if (age.equals("")) {
	       errors.put("age","Age required");
	       age="";
	       allOk=false;
	   } if (sex.equals("")) {
	       errors.put("sex","Sex required");
	       sex="";
	       allOk=false;
	   } if (ChestPain.equals("")) {
	       errors.put("ChestPain","ChestPain required");
	       ChestPain="";
	       allOk=false;
	   } if (BloodPressure.equals("")) {
	       errors.put("BloodPressure","BloodPressure required");
	       BloodPressure="";
	       allOk=false;
	   } if (Cholestrol.equals("")) {
	       errors.put("Cholestrol","Cholestrol required");
	       Cholestrol="";
	       allOk=false;
	   } if (BloodSugar.equals("")) {
	       errors.put("BloodSugar","BloodSugar required");
	       BloodSugar="";
	       allOk=false;
	   } if (Electrocardiographic.equals("")) {
	      errors.put("Electrocardiographic","Electrocardiographic required");
	      Electrocardiographic="";
	      allOk=false;
	   } if (Thalach.equals("")) {
	       errors.put("Thalach","Thalach required");
	       Thalach="";
	       allOk=false;
	   } if (Exang.equals("")) {
	       errors.put("Exang","Exang required");
	       Exang="";
	       allOk=false;
	   } if (OldPeak.equals("")) {
	       errors.put("OldPeak","OldPeak required");
	       OldPeak="";
	       allOk=false;
	   } if (Slope.equals("")) {
	       errors.put("Slope","Slope required");
	       Slope="";
	       allOk=false;
	   } if (CA.equals("")) {
	       errors.put("CA","CA required");
	       CA="";
	       allOk=false;
	   } if (Thal.equals("")) {
	       errors.put("Thal","Thal required");
	       Thal="";
	       allOk=false;
	   }
       return allOk;
    }
}