import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sortingPopup extends Home implements ActionListener{
    Boolean sorted = false;
    // list of items to be sorted every cycle
    public static Item[] list;

    // buttons for user input
    JButton compostButton;
    JButton trashButton;

    // counter that keeps track of how many items have been sorted in one cycle
    int counter;
    public static Boolean popEnd = false;

    // code related to checking the score of the player and displaying fun facts
    int location;
    int buttonPressed = 0;
    FunFact factClass;
    FactToScreen fact;

    //sets up the buttons, items, and facts
  public sortingPopup(JButton input, JButton input2){
    compostButton = input;
    trashButton = input2;
    counter = 0;
    factClass = new FunFact();
    ImageIcon compostIcon = new ImageIcon("compostButton.png");
    ImageIcon trashIcon = new ImageIcon("otherButton.png");
    compostButton.addActionListener(this);
    compostButton.setIcon(compostIcon);
    trashButton.addActionListener(this);
    trashButton.setIcon(trashIcon);
    this.setPreferredSize(new Dimension(800,600));
    list = new Item[8];
    for(int i = 0; i < list.length; i++){
      list[i] = randomItem();
    }
    Home.getList(list);
    Thread main = new Thread(new myRunnable());
    main.start();
  }

  //constantly checks to see if user has sorted all the items in on given day 
  //and changes/restarts few variables for the game to work next day
  public class myRunnable implements Runnable{
    public void run(){
        // every cycle, 8 items will need to be sorted
        // popup goes through every item with a description of all the items
        while(true){
            // sorting();
            repaint();
            if (counter > 7) {
              counter = 0;
              popEnd = true;
              pop.setVisible(false);
              garden.setVisible(true);
              Main.frame.setVisible(false);
              Home.score = checkScore();
            }
            try{
          Thread.sleep(10);
        }
      catch(InterruptedException e){}
    }
      }
     
  }

  // randomly assigns an item
  public static Item randomItem(){
    int r = (int) (Math.random() * 40) + 1;
    // r = 30;
    Item i = new Item();
    if (r == 1) {i = new Carrot(320, 180);};
    if (r == 2) {i = new banana(320, 180);};
    if (r == 3) {i = new battery(320, 200);};
    if (r == 4) {i = new halfApizza(320, 180);};
    if (r == 5) {i = new Cup(320, 180);};
    if (r == 6) {i = new spinAch(320, 180);};
    if (r == 7) {i = new Orange(320, 180);};
    if (r == 8) {i = new potato(350, 180);};
    if (r == 9) {i = new Twig(310, 180);};
    if (r == 10) {i = new eggSHell(320, 200);};
    if (r == 11) {i = new cig(350, 200);};
    if (r == 12) {i = new Chips(320, 180);};
    if (r == 13) {i = new book(330, 180);};
    if (r == 14) {i = new can(350, 180);};
    if (r == 15) {i = new teabag(320, 180);};
    if (r == 16) {i = new coffeebean(320, 200);};
    if (r == 17) {i = new bandaid(320, 200);};
    if (r == 18) {i = new bread(330, 200);};
    if (r == 19) {i = new chair(350, 180);};
    if (r == 20) {i = new cheese(320, 180);};
    if (r == 21) {i = new cherry(320, 180);};
    if (r == 22) {i = new chess(320, 180);};
    if (r == 23) {i = new chocolate(320, 180);};
    if (r == 24) {i = new coffeeCup(350, 180);};
    if (r == 25) {i = new dogPoop(350, 180);};
    if (r == 26) {i = new fish(320, 200);};
    if (r == 27) {i = new fork(330, 180);};
    if (r == 28) {i = new waterBottle(330, 180);};
    if (r == 29) {i = new lawEssay(330, 180);};
    if (r == 30) {i = new napkin(350, 180);};
    if (r == 31) {i = new newspaper(310, 180);};
    if (r == 32) {i = new paperStraw(330, 180);};
    if (r == 33) {i = new plasticBag(310, 180);};
    if (r == 34) {i = new plasticStraw(310, 180);};
    if (r == 35) {i = new rose(320, 180);};
    if (r == 36) {i = new shirt(310, 180);};
    if (r == 37) {i = new strawberry(320, 180);};
    if (r == 38) {i = new takeout(330, 180);};
    if (r == 39) {i = new pills(320, 200);};
    if (r == 40) {i = new pizzaBox(310, 180);};
    return i;
  }

  //draws nescessary components for pop up screen
  public void paintComponent(Graphics g){
    g.setColor(new Color(241,246,220));
    g.fillRect(0, 0, 800, 800);
    if (counter <= 7) list[counter].draw(g);
    g.setColor(new Color(102,66,52));
    g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    if (counter <= 7) g.drawString(list[counter].toString(), 340,65);

    fact = new FactToScreen(40, 420, factClass.getFact());
    fact.paint(g);
  }

  //checks which button to see which button player clicked on
  //also changes the classification of item depending on the click 
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == compostButton){
      list[counter].setClassification(1);
      factClass.newFact();
      counter++;
    }
    if(e.getSource() == trashButton){
      list[counter].setClassification(0);
      factClass.newFact();
      counter++;
    }

  }
  //creates a new set of items for the user(s) to sort through
  public static void generateNewList(){
    Item[] toReturn = new Item[8];
    for(int i = 0; i < toReturn.length; i++){
      toReturn[i] = randomItem();
    }
    for(int i = 0; i < toReturn.length; i++){
      Home.list[i] = toReturn[i];
    }
    
   }

   //creating class to draw the facts (from string to graphics)
   class FactToScreen{
    public int x;
    public int y;
    public int i;
    public String a;
  
    public FactToScreen(int pX, int pY, String a){
        this.x = pX;
        this.y = pY;
        this.a = a;
    }
    public void paint(Graphics g){
        g.setColor(new Color(201, 224, 164));
        g.fillRect(0,490,1000,50);


        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        g.drawString(this.a, this.x, this.y);
    }
  }

}
