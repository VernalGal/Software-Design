package edu.cuny.csi.csc330.lab6;

public class QuickPickerException extends Exception {

  public static int UNSET = 0;
  public static int FILENAME_ERROR = 1;
  public static int GAMENAME_ERROR = 2;
  public static int VENDOR_ERROR = 3;
  public static int POOL1_ERROR = 4;
  public static int POOL2_ERROR = 5;

  
  public static String[] MESSAGE = {
      "Eror in code",
      "Can't find properties file",
      "Can't find GameName properties",
      "Can't find Vendor property",
      "Can't find Pool1 property",
      "Can't find Pool2 property",
  };
  
  protected int code;
  
  public QuickPickerException() {
    // TODO Auto-generated constructor stub
  }
  
  public QuickPickerException(String m) {
    super(m);
  }
  
  public QuickPickerException(String message, int code) {
    super(message);
    this.code = code;
  }
  
  public int getCode() {
    return code;
  }
  
  @Override
  public String toString() {
    return "QuickPickerException [code=" + code + ", toString()=" 
        + super.toString() + "]\n" + MESSAGE[code];
  }


  public static void main(String[] args) {
    QuickPickerException qpe = new QuickPickerException("Quick Picker Exception detected ... ");
    System.out.println(qpe);
    
    QuickPickerException qpe1 = new QuickPickerException("QuickPicker Exception detected ...", QuickPickerException.FILENAME_ERROR);
    System.out.println(qpe1);
    
    QuickPickerException qpe2 = new QuickPickerException("QuickPicker Exception detected ...", QuickPickerException.GAMENAME_ERROR);
    System.out.println(qpe2);
    
    QuickPickerException qpe3 = new QuickPickerException("QuickPicker Exception detected ...", QuickPickerException.VENDOR_ERROR);
    System.out.println(qpe3);
    
    QuickPickerException qpe4 = new QuickPickerException("QuickPicker Exception detected ...", QuickPickerException.POOL1_ERROR);
    System.out.println(qpe4);
    
    QuickPickerException qpe5 = new QuickPickerException("QuickPicker Exception detected ...", QuickPickerException.POOL2_ERROR);
    System.out.println(qpe5);
    
    
  }

}
