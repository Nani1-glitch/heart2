package com.heart.naivebayes;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Detection
{
  static Hashtable map = new Hashtable();
  static String key = "";
  static final Integer ONE = new Integer(1);
  static ArrayList Age = new ArrayList();
    static ArrayList AgeD0 = new ArrayList();
    static ArrayList AgeD1 = new ArrayList();
  static ArrayList Sex = new ArrayList();
  static ArrayList ChestPain = new ArrayList();
  static ArrayList BloodPressure = new ArrayList();
    static ArrayList BloodPressureD0 = new ArrayList();
    static ArrayList BloodPressureD1 = new ArrayList();
  static ArrayList Cholesterol = new ArrayList();
    static ArrayList CholesterolD0 = new ArrayList();
    static ArrayList CholesterolD1 = new ArrayList();
  static ArrayList BloodSugar = new ArrayList();
  static ArrayList Restecg = new ArrayList();
  static ArrayList Thalach = new ArrayList();
    static ArrayList ThalachD0 = new ArrayList();
    static ArrayList ThalachD1 = new ArrayList();
  static ArrayList Exang = new ArrayList();
  static ArrayList Oldpeak = new ArrayList();
    static ArrayList OldpeakD0 = new ArrayList();
    static ArrayList OldpeakD1 = new ArrayList();
  static ArrayList Slope = new ArrayList();
  static ArrayList CA = new ArrayList();
  static ArrayList Thal = new ArrayList();
  static ArrayList Height = new ArrayList();
  static ArrayList Weight = new ArrayList();
  static ArrayList Diagnosis = new ArrayList();

  static int k,l,m,n;
  static int a=0,b=0,c=0,d=0;
  private int maleD0,femaleD0 = 0,maleD1 = 0,femaleD1 = 0;
  private int type1_anginaD0 = 0,type1_anginaD1 = 0,type_anginaD0 = 0,type_anginaD1 = 0,non_anginaD0 =0,non_anginaD1 =0,asymptomaticD0 =0,asymptomaticD1 =0;
  private int gt_120D0 =0,gt_120D1 =0,lt_120D0 =0,lt_120D1 =0;
  private int normalD0 =0,normalD1 =0,abnormalityD0 =0,abnormalityD1 =0,hypertrophyD0 =0,hypertrophyD1 =0;
  private int yesD0 =0,yesD1 =0,noD0 =0,noD1 =0;
  private int unslopingD0 =0,unslopingD1 =0,flatD0 =0,flatD1 =0,downslopingD0 =0,downslopingD1 =0;
  private int blood_vessel0D0 = 0,blood_vessel1D0 = 0,blood_vessel2D0 = 0,blood_vessel3D0 = 0, blood_vessel0D1 = 0,blood_vessel1D1 = 0,blood_vessel2D1 = 0,blood_vessel3D1 =0;
  private int normal2D0 = 0,fixed_defectD0 = 0,reversible_defectD0 = 0,normal2D1 = 0,fixed_defectD1 = 0,reversible_defectD1 = 0;
  private int result0=0,result1 = 0;

  public static void read()                            /**Read Dataset Values**/
  {
     try
     {
        FileReader fr = new FileReader("D:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\WEB-INF\\dataset\\HeartDataset.dat");
        BufferedReader br = new BufferedReader(fr);
        String line="";
        clearArrayList();
        while (line != null)
        {
           processLine(line, map);
           line = br.readLine();
           k=0;
           l=0;
           m=0;
           n=0;
        }
     }
     catch(Exception e2)
     {
        System.out.println(e2.toString());
     }
  }

  public static void processLine(String line, Map map)      /**Add datas in ArrayList**/
  {
    StringTokenizer st = new StringTokenizer(line);

    while (st.hasMoreTokens())
    {
      String one = st.nextToken();
      if(k==0){
        Age.add(one);
        k=1;
      } else if(k==1) {
        Cholesterol.add(one);
        k=2;
      } else if(k==2) {
        Exang.add(one);
        k=3;
      } else {
        Thal.add(one);
      }
      String two = st.nextToken();
      if(l==0) {
        Sex.add(two);
        l=1;
      } else if(l==1) {
        BloodSugar.add(two);
        l=2;
      } else if(l==2) {
        Oldpeak.add(two);
        l=3;
      } else {
        Height.add(two);
      }
      String three = st.nextToken();
      if(m==0) {
        ChestPain.add(three);
        m=1;
      } else if(m==1) {
        Restecg.add(three);
        m=2;
      } else if(m==2) {
        Slope.add(three);
        m=3;
      } else {
        Weight.add(three);
      }
      String four = st.nextToken();
      if(n==0) {
        BloodPressure.add(four);
        n=1;
      } else if(n==1) {
        Thalach.add(four);
        n=2;
      } else if(n==2) {
        CA.add(four);
        n=3;
      } else {
        Diagnosis.add(four);
      }
    }
  }

  public void findAge() {                     /**Add datas into Age ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        String str = (String)Age.get(i);
        if(aa.equals("0"))
        {
          AgeD0.add(str);
        }
        else
        {
          AgeD1.add(str);
        }
    }
  }
  public ArrayList setAgeD0()
  {
     findAge();
     return AgeD0;
  }
  public ArrayList setAgeD1()
  {
     findAge();
     return AgeD1;
  }

  public void findSex() {                     /**Add datas into Sex ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)Sex.get(i);
            if(str.equals("1.0"))
            {
               maleD0=maleD0+1;
            }
            else
            {
               femaleD0++;
            }
        }
        else if(aa.equals("1"))
        {
            String str = (String)Sex.get(i);
            if(str.equals("1.0"))
            {
               maleD1++;
            }
            else
            {
               femaleD1++;
            }
        }
     }
  }
  public int setMale0()
  {
    findSex();
    return maleD0;
  }
  public int setMale1()
  {
    findSex();
    return maleD1;
  }
  public int setFemale0()
  {
    findSex();
    return femaleD0;
  }
  public int setFemale1()
  {
    findSex();
    return femaleD1;
  }

  public void findChestPain() {         /**Add datas into ChestPain ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)ChestPain.get(i);
            if(str.equals("1.0"))
            {
               type1_anginaD0++;
            }
            else if(str.equals("2.0"))
            {
               type_anginaD0++;
            }
            else if(str.equals("3.0"))
            {
               non_anginaD0++;
            }
            else {
              asymptomaticD0++;
            }
        }
        else
        {
            String str = (String)ChestPain.get(i);
            if(str.equals("1.0"))
            {
               type1_anginaD1++;
            }
            else if(str.equals("2.0"))
            {
               type_anginaD1++;
            }
            else if(str.equals("3.0"))
            {
               non_anginaD1++;
            }
            else {
              asymptomaticD1++;
            }
        }
     }
  }
  public int setCP10()
  {
   findChestPain();
   return type1_anginaD0;
  }
  public int setCP11()
  {
   findChestPain();
   return type1_anginaD1;
  }
  public int setCP20()
  {
   findChestPain();
   return type_anginaD0;
  }
  public int setCP21()
  {
   findChestPain();
   return type_anginaD1;
  }
  public int setCP30()
  {
   findChestPain();
   return non_anginaD0;
  }
  public int setCP31()
  {
   findChestPain();
   return non_anginaD1;
  }
  public int setCP40()
  {
   findChestPain();
   return asymptomaticD0;
  }
  public int setCP41()
  {
   findChestPain();
   return asymptomaticD1;
  }

  public void findBloodPressure() { /**Add datas into BloodPressure ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        String str = (String)BloodPressure.get(i);
        if(aa.equals("0"))
        {
          BloodPressureD0.add(str);
        }
        else
        {
          BloodPressureD1.add(str);
        }
    }
  }
  public ArrayList setBloodPressureD0()
  {
     findBloodPressure();
     return BloodPressureD0;
  }
  public ArrayList setBloodPressureD1()
  {
     findBloodPressure();
     return BloodPressureD1;
  }

  public void findCholesterol() {     /**Add datas into Cholesterol ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        String str = (String)Cholesterol.get(i);
        if(aa.equals("0"))
        {
          CholesterolD0.add(str);
        }
        else
        {
          CholesterolD1.add(str);
        }
    }
  }
  public ArrayList setCholesterolD0()
  {
     findCholesterol();
     return CholesterolD0;
  }
  public ArrayList setCholesterolD1()
  {
     findCholesterol();
     return CholesterolD1;
  }

  public void findBloodSugar() {       /**Add datas into BloodSugar ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)BloodSugar.get(i);
            if(str.equals("1.0"))
            {
               gt_120D0++;
            }
            else
            {
               lt_120D0++;
            }
        }
        else if(aa.equals("1"))
        {
            String str = (String)BloodSugar.get(i);
            if(str.equals("1.0"))
            {
               gt_120D1++;
            }
            else
            {
               lt_120D1++;
            }
        }
     }
  }
  public int setBSG0()
  {
   findBloodSugar();
   return gt_120D0;
  }
  public int setBSG1()
  {
   findBloodSugar();
   return gt_120D1;
  }
  public int setBSL0()
  {
   findBloodSugar();
   return lt_120D0;
  }
  public int setBSL1()
  {
   findBloodSugar();
   return lt_120D1;
  }

  public void findRestecg() {             /**Add datas into Restecg ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)Restecg.get(i);
            if(str.equals("0.0"))
            {
               normalD0++;
            }
            else if(str.equals("1.0"))
            {
               abnormalityD0++;
            }
            else if(str.equals("2.0"))
            {
               hypertrophyD0++;
            }
        }
        else
        {
            String str = (String)Restecg.get(i);
            if(str.equals("0.0"))
            {
               normalD1++;
            }
            else if(str.equals("1.0"))
            {
               abnormalityD1++;
            }
            else if(str.equals("2.0"))
            {
               hypertrophyD1++;
            }
        }
    }
  }
  public int setRestecgNL0()
  {
   findRestecg();
   return normalD0;
  }
  public int setRestecgNL1()
  {
   findRestecg();
   return normalD1;
  }
  public int setRestecgABN0()
  {
   findRestecg();
   return abnormalityD0;
  }
  public int setRestecgABN1()
  {
   findRestecg();
   return abnormalityD1;
  }
  public int setRestecgHY0()
  {
   findRestecg();
   return hypertrophyD0;
  }
  public int setRestecgHY1()
  {
   findRestecg();
   return hypertrophyD1;
  }

  public void findThalach() {             /**Add datas into Thalach ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        String str = (String)Thalach.get(i);
        if(aa.equals("0"))
        {
          ThalachD0.add(str);
        }
        else
        {
          ThalachD1.add(str);
        }
    }
  }
  public ArrayList setThalachD0()
  {
     findThalach();
     return ThalachD0;
  }
  public ArrayList setThalachD1()
  {
     findThalach();
     return ThalachD1;
  }


  public void findExang() {                 /**Add datas into Exang ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)Exang.get(i);
            if(str.equals("1.0"))
            {
               yesD0++;
            }
            else
            {
               noD0++;
            }
        }
        else
        {
            String str = (String)Exang.get(i);
            if(str.equals("1.0"))
            {
               yesD1++;
            }
            else
            {
               noD1++;
            }
        }
     }
  }
  public int setExangY0()
  {
   findExang();
   return yesD0;
  }
  public int setExangY1()
  {
   findExang();
   return yesD1;
  }
  public int setExangN0()
  {
   findExang();
   return noD0;
  }
  public int setExangN1()
  {
   findExang();
   return noD1;
  }

  public void findOldpeak() {             /**Add datas into Oldpeak ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        String str = (String)Oldpeak.get(i);
        if(aa.equals("0"))
        {
          OldpeakD0.add(str);
        }
        else
        {
          OldpeakD1.add(str);
        }
    }
  }
  public ArrayList setOldpeakD0()
  {
     findOldpeak();
     return OldpeakD0;
  }
  public ArrayList setOldpeakD1()
  {
     findOldpeak();
     return OldpeakD1;
  }


  public void findSlope() {                 /**Add datas into Slope ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
        String aa = (String)Diagnosis.get(i);
        if(aa.equals("0"))
        {
            String str = (String)Slope.get(i);
            if(str.equals("1.0"))
            {
               unslopingD0++;
            }
            else if(str.equals("2.0"))
            {
               flatD0++;
            }
            else if(str.equals("3.0"))
            {
               downslopingD0++;
            }
        }
        else
        {
            String str = (String)Slope.get(i);
            if(str.equals("1.0"))
            {
               unslopingD1++;
            }
            else if(str.equals("2.0"))
            {
               flatD1++;
            }
            else if(str.equals("3.0"))
            {
               downslopingD1++;
            }
        }
    }
  }

  public int setSlopeUS0()
  {
   findSlope();
   return unslopingD0;
  }
  public int setSlopeUS1()
  {
   findSlope();
   return unslopingD1;
  }
  public int setSlopeF0()
  {
   findSlope();
   return flatD0;
  }
  public int setSlopeF1()
  {
    findSlope();
   return flatD1;
  }
  public int setSlopeDS0()
  {
   findSlope();
   return downslopingD0;
  }
  public int setSlopeDS1()
  {
   findSlope();
   return downslopingD1;
  }

  public void findCA() {                       /**Add datas into CA ArrayList**/
    for(int i=0;i<Diagnosis.size();i++)
    {
    String aa = (String)Diagnosis.get(i);
    if(aa.equals("0"))
        {

       String str = (String)CA.get(i);
       if(str.equals("0.0")) {
           blood_vessel0D0++;
       } else if(str.equals("1.0")) {
           blood_vessel1D0++;
       } else if(str.equals("2.0")) {
           blood_vessel2D0++;
       } else if(str.equals("3.0")){
           blood_vessel3D0++;
       }
    } else
    {

       String str = (String)CA.get(i);
       if(str.equals("0.0")) {
           blood_vessel0D1++;
       } else if(str.equals("1.0")) {
           blood_vessel1D1++;
       } else if(str.equals("2.0")) {
           blood_vessel2D1++;
       } else if(str.equals("3.0")){
           blood_vessel3D1++;
       }

      }
    }
  }
  public int setCA0BV0()
  {
   findCA();
   return blood_vessel0D0;
  }
  public int setCA0BV1()
  {
   findCA();
   return blood_vessel0D1;
  }
  public int setCA1BV0()
  {
   findCA();
   return blood_vessel1D0;
  }
  public int setCA1BV1()
  {
   findCA();
   return blood_vessel1D1;
  }
  public int setCA2BV0()
  {
   findCA();
   return blood_vessel2D0;
  }
  public int setCA2BV1()
  {
   findCA();
   return blood_vessel2D1;
  }
  public int setCA3BV0()
  {
   findCA();
   return blood_vessel3D0;
  }
  public int setCA3BV1()
  {
   findCA();
   return blood_vessel3D1;
  }

  public void findThal() {                   /**Add datas into Thal ArrayList**/
  for(int i=0;i<Diagnosis.size();i++)
  {
    String aa = (String)Diagnosis.get(i);
    if(aa.equals("0"))
    {
      String str = (String)Thal.get(i);
       if(str.equals("3.0")) {
           normal2D0++;
       } else if(str.equals("6.0")) {
           fixed_defectD0++;
       } else if(str.equals("7.0")) {
           reversible_defectD0++;
       }
    }else
    {
      String str = (String)Thal.get(i);
       if(str.equals("3.0")) {
           normal2D1++;
       } else if(str.equals("6.0")) {
           fixed_defectD1++;
       } else if(str.equals("7.0")) {
           reversible_defectD1++;
       }
    }
  }
  }
  public int setThalNL0()
  {
   findThal();
   return normal2D0;
  }
  public int setThalNL1()
  {
   findThal();
   return normal2D1;
  }
  public int setThalFD0()
  {
   findThal();
   return fixed_defectD0;
  }
  public int setThalFD1()
  {
   findThal();
   return fixed_defectD1;
  }
  public int setThalRD0()
  {
   findThal();
   return reversible_defectD0;
  }
  public int setThalRD1()
  {
   findThal();
   return reversible_defectD1;
  }


  public ArrayList findHeight() {          /**Add datas into Height ArrayList**/
      return Height;
  }

  public ArrayList findWeight() {          /**Add datas into Weight ArrayList**/
      return Weight;
  }

  public void findDiagnosis() {         /**Add datas into Diagnosis ArrayList**/
  for(int i=0;i<Diagnosis.size();i++)
    {
       String str = (String)Diagnosis.get(i);
       if(str.equals("0")) {
           result0++;
       } else {
           result1++;
       }
    }
  }

  public int setDiagnosis0()
  {
    findDiagnosis();
    return result0;
  }
  public int setDiagnosis1()
  {
    findDiagnosis();
    return result1;
  }

  public static void clearArrayList(){          /**Clear all ArrayList values**/
     Age.clear();
      AgeD0.clear();
      AgeD1.clear();
     Sex.clear();
     ChestPain.clear();
     BloodSugar.clear();
     BloodPressure.clear();
      BloodPressureD0.clear();                         /** --- Numerical --- **/
      BloodPressureD1.clear();                                      //--- (1)Age
     Cholesterol.clear();                                 //--- (4)BloodPressure
      CholesterolD0.clear();                                //--- (5)Cholesterol
      CholesterolD1.clear();                                    //--- (8)Thalach
     Restecg.clear();                                          //--- (10)Oldpeak
     Thalach.clear();
      ThalachD0.clear();
      ThalachD1.clear();
     Exang.clear();                                      /** --- Nominal --- **/
     Oldpeak.clear();                                               //--- (2)Sex
      OldpeakD0.clear();                                      //--- (3)ChestPain
      OldpeakD1.clear();                                      //---(6)BloodSugar
     Slope.clear();                                              //---(7)Restang
     CA.clear();                                                   //---(9)Exang
     Thal.clear();                                               //--- (11)Slope
     Height.clear();                                                //--- (12)CA
     Weight.clear();                                              //--- (13)Thal
     Diagnosis.clear();                                      //--- (16)Diagnosis
  }
}