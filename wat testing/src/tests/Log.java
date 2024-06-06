package tests;

class Log{ public static String log=""; }
class Base{
  static final String myName= "Base_of_"+Derived.myName1+"_"+Derived.myName2;
  Base(){
    Log.log+=Base.myName;
  }
}
class Derived extends Base{
  static String theName(){ return "Derived1"; }
  final static String myName1= theName();
  final static String myName2= "Derived2";
}