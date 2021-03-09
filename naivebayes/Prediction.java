package com.heart.naivebayes;

import java.io.*;
//import java.lang.Math;
import java.util.*;

public class Prediction
{
  double a1=0.0d;
  double b1=0.0d;
  double pdf2;
  public double findMean(ArrayList value) {
     double mean = 0.0;
     double sum = 0.0;
     for(int i=0;i<value.size();i++)
     {
        String no= (String)value.get(i);
        double num = Double.valueOf(no);
        sum = sum + num;
	 }
     mean = sum / value.size();
     return mean;
  }

  public double findNominalPDF(int a,int b) {
    a1=Double.valueOf(a);
    b1=Double.valueOf(b);
    pdf2 = a1/b1;
    return pdf2;
  }

  public double findStandardDeviation(ArrayList value, double mean) {
     double sum = 0.0;
     double sd = 0.0;
     int length =  value.size();
     for (int i=0;i< length ; i++)
	 {
	    String no= (String)value.get(i);
        double num =  Double.valueOf(no);
        sum = sum + ((num - mean)*(num - mean));
     }
     sd = Math.sqrt(sum / (length -1));
     return sd;
  }

  public double findNumericalPDF(double value ,double mean , double sd) {
     double pdf = 0.0;
     pdf = (1/(sd * (Math.sqrt( 2* Math.PI)))) * (Math.pow(Math.E, -((Math.pow((value - mean),2))/(2 * Math.pow(sd,2)))));
     return pdf;
  }
}