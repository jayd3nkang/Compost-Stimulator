import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sortingPopup extends Home implements ActionListener{
    static JFrame frame;
    Boolean sorted = false;
    Carrot carrot;
    // list of items to be sorted every cycle
    Item[] list;
    JButton compostButton;
    JButton trashButton;
    int counter = 0;
    //double placeboC = 0.0;

  public sortingPopup(JButton input, JButton input2){
    compostButton = input;
    trashButton = input2;
    //button.setText("COMPOSTABLE");
    ImageIcon compostIcon = new ImageIcon("compostButton.png");
    ImageIcon trashIcon = new ImageIcon("trashButton.png");
    compostButton.addActionListener(this);
    compostButton.setIcon(compostIcon);
    trashButton.addActionListener(this);
    trashButton.setIcon(trashIcon);
    this.setPreferredSize(new Dimension(800,600));

    list = new Item[8];
    for(int i = 0; i < list.length; i++){
      list[i] = randomItem();
    }


    Thread main = new Thread(new myRunnable());
    main.start();
  }

  public class myRunnable implements Runnable{
    public void run(){
        // every cycle, 8 items will need to be sorted
        // popup goes through every item with a description of all the items
        // list = new Item[8];
        // for (int i = 0; i < list.length; i++){
        //     list[i] = randomItem();
        // }
        while(true){
            sorting();
            repaint();
            try{
          Thread.sleep(100);
        }
      catch(InterruptedException e){}
    }
      }
     
  }
  public void sorting(){
    // check if the user is clicking the right button
  }

  public Item randomItem(){
    int r = (int) (Math.random() * 16) + 1;
    Item i = new Item();
    if (r == 1) {i = new Carrot(0, 0);};
    if (r == 2) {i = new banana(0, 0);};
    if (r == 3) {i = new battery(0, 0);};
    if (r == 4) {i = new halfApizza(0, 0);};
    if (r == 5) {i = new Cup(0, 0);};
    if (r == 6) {i = new spinAch(0, 0);};
    if (r == 7) {i = new Orange(0, 0);};
    if (r == 8) {i = new potato(0, 0);};
    if (r == 9) {i = new Twig(0, 0);};
    if (r == 10) {i = new eggSHell(0, 0);};
    if (r == 11) {i = new cig(0, 0);};
    if (r == 12) {i = new Chips(0, 0);};
    if (r == 13) {i = new book(0, 0);};
    if (r == 14) {i = new can(0, 0);};
    if (r == 15) {i = new CSteabag(0, 0);};
    if (r == 16) {i = new coffeebean(0, 0);};
    return i;
  }

  public void paintComponent(Graphics g){
    g.setColor(new Color(200,210,200));
    g.fillRect(0, 0, 800, 500);
    list[counter].draw(g);
    //list[counter].draw(g);
    // ImageIcon compostButton = new ImageIcon("compostButton.png");
    // ImageIcon trashButton = new ImageIcon("trashButton.png");
    // Image cb = compostButton.getImage();
    // Image tb = trashButton.getImage();
    // g.drawImage(cb, 50, 250, this);
    // g.drawImage(tb, 450, 250, this);
    // for (int i = 0; i < list.length; i++){
    //   list[i].x = 400 - (list[i].w/2);
    //   list[i].y = 30;
    //   list[i].draw(g);
    //   System.out.println(list[i].toString());
    //   while (sorted){}
    // }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //int counter = 0;
    // TODO Auto-generated method stub
    if(e.getSource() == compostButton){
      //placeboC+=0.5;
      counter++;
      System.out.println("compost button clicked");
      // if(counter > 2){
      //   System.exit(1);
      // }
    }
    if(e.getSource() == trashButton){
      counter++;
      System.out.println("trash button clicked");

    }
    //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }

}
