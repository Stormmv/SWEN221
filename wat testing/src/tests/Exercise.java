package tests;

public class Exercise{
	  public static void main(String[] arg){
	    new Derived();
	    System.out.println(Log.log);
	    assert Log.log.equals("[???]");
	  }
	}