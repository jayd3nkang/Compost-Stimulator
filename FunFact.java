import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class FunFact {
  int counter = 0;
  ArrayList <String> funFactMessage;
  String toReturn;
  Scanner myObj;
  File textFile;
  int messageInt;

  public FunFact() {
    funFactMessage = new ArrayList<String>();
    try{
      File myObj = new File("facts.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        funFactMessage.add(data); 
        counter++;
      }

      Random rand = new Random();
      messageInt = rand.nextInt(counter);

      this.toReturn = funFactMessage.get(messageInt);
      myReader.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
  }
    
  }

  public String getFact(){
    return this.toReturn;
  }

  public void newFact(){
    Random rand = new Random();
    messageInt = rand.nextInt(counter);

    this.toReturn = funFactMessage.get(messageInt);
  }
}
