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
    //reads facts from out facts.txt file and puts it into an arraylist
    funFactMessage = new ArrayList<String>();
    try{
      File myObj = new File("facts.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        funFactMessage.add(data); 
        counter++;
      }

      //randomly chooses an fact and that is the starting fact 
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

  //returns the fact it is currently storing 
  public String getFact(){
    return this.toReturn;
  }

  //changes the fact statement
  public void newFact(){
    Random rand = new Random();
    messageInt = rand.nextInt(counter);

    this.toReturn = funFactMessage.get(messageInt);
  }
}
