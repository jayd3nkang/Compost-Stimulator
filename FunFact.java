import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class FunFact {
  int counter = 0;
  String funFactMessage;
  Scanner myObj;
  File textFile;
  public FunFact() {
    try{
      textFile = new File("facts.txt");
      myObj = new Scanner(textFile);
      this.funFactMessage = myObj.nextLine();
      
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }

  public String getMessage(){
    return this.funFactMessage;
  }

  public void newMessage(){
    this.funFactMessage = myObj.nextLine();
  }
}
