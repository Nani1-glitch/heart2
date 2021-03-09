package com.heart.naivebayes;

import com.heart.naivebayes.Detection;
import com.heart.naivebayes.Prediction;

import java.io.*;
import java.util.*;

public class Calculation
{
   double pdfMale0,pdfMale1,pdfFemale0,pdfFemale1;
   double pdfCPType10,pdfCPType11,pdfCPType0,pdfCPType1,pdfCPNa0,pdfCPNa1,pdfCPAy0,pdfCPAy1;
   double pdfBSGt0,pdfBSGt1,pdfBSLt0,pdfBSLt1;
   double pdfResNL0,pdfResNL1,pdfResABN0,pdfResABN1,pdfResHy0,pdfResHy1;
   double pdfExY0,pdfExY1,pdfExN0,pdfExN1;
   double pdfSlopeUs0,pdfSlopeUs1,pdfSlopeFt0,pdfSlopeFt1,pdfSlopeDs0,pdfSlopeDs1;
   double pdfCA0Bv0,pdfCA0Bv1,pdfCA1Bv0,pdfCA1Bvl,pdfCA2Bv0,pdfCA2Bvl,pdfCA3Bv0,pdfCA3Bvl;
   double pdfTalNL0,pdfTalNL1,pdfTalFD0,pdfTalFD1,pdfTalRD0,pdfTalRD1;
   double pdfDiagnosis0,pdfDiagnosis1;

   double meanAgeD0,meanAgeD1;
   double meanBpD0,meanBpD1;
   double meanCholesterolD0,meanCholesterolD1;
   double meanThalachD0,meanThalachD1;
   double meanOldpeakD0,meanOldpeakD1;

   double stdAgeD0,stdAgeD1;
   double stdBloodPressureD0,stdBloodPressureD1;
   double stdCholesterolD0,stdCholesterolD1;
   double stdThalachD0,stdThalachD1;
   double stdOldpeakD0,stdOldpeakD1;

   Detection d2 = new Detection();
   Prediction p2 = new Prediction();

                /**Nominal attributes Calculation**/
  public double setPdfMale0()                                      /**Sex PDF**/
  {
    pdfMale0 = p2.findNominalPDF(d2.setMale0(),d2.setDiagnosis0());
    return pdfMale0;
  }
  public double setPdfMale1()
  {
    pdfMale1 = p2.findNominalPDF(d2.setMale0(),d2.setDiagnosis1());
    return pdfMale1;
  }
  public double setPdfFemale0()
  {
    pdfFemale0 = p2.findNominalPDF(d2.setFemale0(),d2.setDiagnosis0());
    return pdfFemale0;
  }
  public double setPdfFemale1()
  {
    pdfFemale1 = p2.findNominalPDF(d2.setFemale1(),d2.setDiagnosis1());
    return pdfFemale1;
  }

  public double setPdfCPType10()                             /**ChestPain PDF**/
  {
    pdfCPType10 = p2.findNominalPDF(d2.setCP10(),d2.setDiagnosis0());
    return pdfCPType10;
  }
  public double setPdfCPType11()
  {
    pdfCPType11 = p2.findNominalPDF(d2.setCP11(),d2.setDiagnosis1());
    return pdfCPType11;
  }
  public double setPdfCPType0()
  {
    pdfCPType0 = p2.findNominalPDF(d2.setCP20(),d2.setDiagnosis0());
    return pdfCPType0;
  }
  public double setPdfCPType1()
  {
    pdfCPType1 = p2.findNominalPDF(d2.setCP21(),d2.setDiagnosis1());
    return pdfCPType1;
  }
  public double setPdfCPNa0()
  {
    pdfCPNa0 = p2.findNominalPDF(d2.setCP30(),d2.setDiagnosis0());
    return pdfCPNa0;
  }
  public double setPdfCPNa1()
  {
    pdfCPNa1 = p2.findNominalPDF(d2.setCP31(),d2.setDiagnosis1());
    return pdfCPNa1;
  }
  public double setPdfCPAy0()
  {
    pdfCPAy0 = p2.findNominalPDF(d2.setCP40(),d2.setDiagnosis0());
    return pdfCPAy0;
  }
  public double setPdfCPAy1()
  {
    pdfCPAy1 = p2.findNominalPDF(d2.setCP41(),d2.setDiagnosis1());
    return pdfCPAy1;
  }

  public double setPdfBSGt0()                               /**BloodSugar PDF**/
  {
    pdfBSGt0 = p2.findNominalPDF(d2.setBSG0(),d2.setDiagnosis0());
    return pdfBSGt0;
  }
  public double setPdfBSGt1()
  {
    pdfBSGt1 = p2.findNominalPDF(d2.setBSG1(),d2.setDiagnosis1());
    return pdfBSGt1;
  }
  public double setPdfBSLt0()
  {
    pdfBSLt0 = p2.findNominalPDF(d2.setBSL0(),d2.setDiagnosis0());
    return pdfBSLt0;
  }
  public double setPdfBSLt1()
  {
    pdfBSLt1 = p2.findNominalPDF(d2.setBSL1(),d2.setDiagnosis1());
    return pdfBSLt1;
  }

  public double setPdfResNL0()                                 /**Restang PDF**/
  {
    pdfResNL0 = p2.findNominalPDF(d2.setRestecgNL0(),d2.setDiagnosis0());
    return pdfResNL0;
  }
  public double setPdfResNL1()
  {
    pdfResNL1 = p2.findNominalPDF(d2.setRestecgNL1(),d2.setDiagnosis1());
    return pdfResNL1;
  }
  public double setPdfResABN0()
  {
    pdfResABN0 = p2.findNominalPDF(d2.setRestecgABN0(),d2.setDiagnosis0());
    return pdfResABN0;
  }
  public double setPdfResABN1()
  {
    pdfResABN1 = p2.findNominalPDF(d2.setRestecgABN1(),d2.setDiagnosis1());
    return pdfResABN1;
  }
  public double setPdfResHy0()
  {
    pdfResHy0 = p2.findNominalPDF(d2.setRestecgHY0(),d2.setDiagnosis0());
    return pdfResHy0;
  }
  public double setPdfResHy1()
  {
    pdfResHy1 = p2.findNominalPDF(d2.setRestecgHY1(),d2.setDiagnosis1());
    return pdfResHy1;
  }

  public double setPdfExY0()                                     /**Exang PDF**/
  {
    pdfExY0 = p2.findNominalPDF(d2.setExangY0(),d2.setDiagnosis0());
    return pdfExY0;
  }
  public double setPdfExY1()
  {
    pdfExY1 = p2.findNominalPDF(d2.setExangY1(),d2.setDiagnosis1());
    return pdfExY1;
  }
  public double setPdfExN0()
  {
    pdfExN0 = p2.findNominalPDF(d2.setExangN0(),d2.setDiagnosis0());
    return pdfExN0;
  }
  public double setPdfExN1()
  {
    pdfExN1 = p2.findNominalPDF(d2.setExangN1(),d2.setDiagnosis1());
    return pdfExN1;
  }

  public double setPdfSlopeUs0()                                 /**Slope PDF**/
  {
    pdfSlopeUs0 = p2.findNominalPDF(d2.setSlopeUS0(),d2.setDiagnosis0());
    return pdfSlopeUs0;
  }
  public double setPdfSlopeUs1()
  {
    pdfSlopeUs1 = p2.findNominalPDF(d2.setSlopeUS1(),d2.setDiagnosis1());
    return pdfSlopeUs1;
  }
  public double setPdfSlopeFt0()
  {
    pdfSlopeFt0 = p2.findNominalPDF(d2.setSlopeF0(),d2.setDiagnosis0());
    return pdfSlopeFt0;
  }
  public double setPdfSlopeFt1()
  {
    pdfSlopeFt1 = p2.findNominalPDF(d2.setSlopeF0(),d2.setDiagnosis1());
    return pdfSlopeFt1;
  }
  public double setPdfSlopeDs0()
  {
    pdfSlopeDs0 = p2.findNominalPDF(d2.setSlopeDS0(),d2.setDiagnosis0());
    return pdfSlopeDs0;
  }
  public double setPdfSlopeDs1()
  {
    pdfSlopeDs1 = p2.findNominalPDF(d2.setSlopeDS1(),d2.setDiagnosis1());
    return pdfSlopeDs1;
  }

  public double setPdfCA0Bv0()                                      /**CA PDF**/
  {
    pdfCA0Bv0 = p2.findNominalPDF(d2.setCA0BV0(),d2.setDiagnosis0());
    return pdfCA0Bv0;
  }
  public double setPdfCA0Bv1()
  {
    pdfCA0Bv1 = p2.findNominalPDF(d2.setCA0BV1(),d2.setDiagnosis1());
    return pdfCA0Bv1;
  }
  public double setPdfCA1Bv0()
  {
    pdfCA1Bv0 = p2.findNominalPDF(d2.setCA1BV0(),d2.setDiagnosis0());
    return pdfCA1Bv0;
  }
  public double setPdfCA1Bvl()
  {
    pdfCA1Bvl = p2.findNominalPDF(d2.setCA1BV1(),d2.setDiagnosis1());
    return pdfCA1Bvl;
  }
  public double setPdfCA2Bv0()
  {
    pdfCA2Bv0 = p2.findNominalPDF(d2.setCA2BV0(),d2.setDiagnosis0());
    return pdfCA2Bv0;
  }
  public double setPdfCA2Bvl()
  {
    pdfCA2Bvl = p2.findNominalPDF(d2.setCA2BV1(),d2.setDiagnosis1());
    return pdfCA2Bvl;
  }
  public double setPdfCA3Bv0()
  {
    pdfCA3Bv0 = p2.findNominalPDF(d2.setCA3BV0(),d2.setDiagnosis0());
    return pdfCA3Bv0;
  }
  public double setPdfCA3Bvl()
  {
    pdfCA3Bvl = p2.findNominalPDF(d2.setCA3BV1(),d2.setDiagnosis1());
    return pdfCA3Bvl;
  }

  public double setPdfTalNL0()                                    /**Thal PDF**/
  {
    pdfTalNL0 = p2.findNominalPDF(d2.setThalNL0(),d2.setDiagnosis0());
    return pdfTalNL0;
  }
  public double setPdfTalNL1()
  {
    pdfTalNL1 = p2.findNominalPDF(d2.setThalNL1(),d2.setDiagnosis1());
    return pdfTalNL1;
  }
  public double setPdfTalFD0()
  {
    pdfTalFD0 = p2.findNominalPDF(d2.setThalFD0(),d2.setDiagnosis0());
    return pdfTalFD0;
  }
  public double setPdfTalFD1()
  {
    pdfTalFD1 = p2.findNominalPDF(d2.setThalFD1(),d2.setDiagnosis1());
    return pdfTalFD1;
  }
  public double setPdfTalRD0()
  {
    pdfTalRD0 = p2.findNominalPDF(d2.setThalRD0(),d2.setDiagnosis0());
    return pdfTalRD0;
  }
  public double setPdfTalRD1()
  {
    pdfTalRD1 = p2.findNominalPDF(d2.setThalRD1(),d2.setDiagnosis1());
    return pdfTalRD1;
  }

  public double setPdfDiagnosis0()                           /**Diagnosis PDF**/
  {
    pdfDiagnosis0 = p2.findNominalPDF(d2.setDiagnosis0(),297);
    return pdfDiagnosis0;
  }
  public double setPdfDiagnosis1()
  {
    pdfDiagnosis1 = p2.findNominalPDF(d2.setDiagnosis1(),297);
    return pdfDiagnosis1;
  }
                 /**Numerical attributes Calculation**/

  /** ---   To Find Numerical Mean Values   --- **/

  public double setMeanAgeD0(){                                   /**Age Mean**/
   meanAgeD0= p2.findMean(d2.setAgeD0());
   return meanAgeD0;
  }
  public double setMeanAgeD1(){
   meanAgeD1= p2.findMean(d2.setAgeD1());
   return meanAgeD1;
  }

  public double setMeanBloodPressureD0(){               /**BloodPressure Mean**/
   meanBpD0= p2.findMean(d2.setBloodPressureD0());
   return meanBpD0;
  }
  public double setMeanBloodPressureD1(){
   meanBpD1= p2.findMean(d2.setBloodPressureD1());
   return meanBpD1;
  }

  public double setMeanCholesterolD0(){                   /**Cholesterol Mean**/
   meanCholesterolD0= p2.findMean(d2.setCholesterolD0());
   return meanCholesterolD0;
  }
  public double setMeanCholesterolD1(){
   meanCholesterolD1= p2.findMean(d2.setCholesterolD1());
   return meanCholesterolD1;
  }

  public double setMeanThalachD0(){                           /**Thalach Mean**/
   meanThalachD0= p2.findMean(d2.setThalachD0());
   return meanThalachD0;
  }
  public double setMeanThalachD1(){
   meanThalachD1= p2.findMean(d2.setThalachD1());
   return meanThalachD1;
  }

  public double setMeanOldpeakD0(){                           /**Oldpeak Mean**/
   meanOldpeakD0= p2.findMean(d2.setOldpeakD0());
   return meanOldpeakD0;
  }
  public double setMeanOldpeakD1(){
   meanOldpeakD1= p2.findMean(d2.setOldpeakD1());
   return meanOldpeakD1;
  }

  /** ----    To Find Numerical Standard Deviation Values   --- **/

  public double setStdAgeD0(){                                     /**Age STD**/
      stdAgeD0 = p2.findStandardDeviation(d2.setAgeD0(),setMeanAgeD0());
      return stdAgeD0;
  }
  public double setStdAgeD1(){
      stdAgeD1 = p2.findStandardDeviation(d2.setAgeD1(),setMeanAgeD1());
      return stdAgeD1;
  }

  public double setStdBloodPressureD0() {                /**BloodPressure STD**/
      stdBloodPressureD0 = p2.findStandardDeviation(d2.setBloodPressureD0(),setMeanBloodPressureD0());
      return stdBloodPressureD0;
  }
  public double setStdBloodPressureD1() {
      stdBloodPressureD1 = p2.findStandardDeviation(d2.setBloodPressureD1(),setMeanBloodPressureD1());
      return stdBloodPressureD1;
  }

  public double setStdCholesterolD0(){                     /**Cholesterol STD**/
      stdCholesterolD0 = p2.findStandardDeviation(d2.setCholesterolD0(),setMeanCholesterolD0());
      return stdCholesterolD0;
  }
  public double setStdCholesterolD1(){
      stdCholesterolD1 = p2.findStandardDeviation(d2.setCholesterolD1(),setMeanCholesterolD1());
      return stdCholesterolD1;
  }

  public double setStdThalachD0(){                             /**Thalach STD**/
      stdThalachD0 = p2.findStandardDeviation(d2.setThalachD0(),setMeanThalachD0());
      return stdThalachD0;
  }
  public double setStdThalachD1(){
      stdThalachD1 = p2.findStandardDeviation(d2.setThalachD1(),setMeanThalachD1());
      return stdThalachD1;
  }

  public double setStdOldpeakD0(){                             /**Oldpeak STD**/
      stdOldpeakD0 = p2.findStandardDeviation(d2.setOldpeakD0(),setMeanOldpeakD0());
      return stdAgeD0;
  }
  public double setStdOldpeakD1(){
      stdOldpeakD1 = p2.findStandardDeviation(d2.setOldpeakD1(),setMeanOldpeakD1());
      return stdOldpeakD1;
  }
}