
import java.util.ArrayList;


/** A Pile is a collection of cards.  This needs to be
 * Drawable because it will be shown on the GUI. Put code
 * here that ALL Piles share.  The ways in which Piles are 
 * different belong in the subclasses.  The draw method should 
 * be implemented here.  Updateable may have empty implementation.
 * You WILL write subclasses of Pile
 */
public abstract class Pile implements Drawable, Updateable {
    //comment
    
    private int x, y; 
    private ArrayList<Card> list; 
    public abstract boolean canAddCard(Card c);
    // private int numCards;
    // private int maxCards; 


    public Pile(int x, int y){
        // this.numCards = numCards; 
        // this.maxCards = maxCards;
        this.x = x;
        this.y = y;
    }

    private int getX(){
        return x;
    }

    private int getY(){
        return y; 
    }

    public int getSize(){
        return list.size();
    }

    //shuffle 
    public void shuffle() {
          if (this.getSize() < 2){
              return;
          }
  
          if (this.getSize() == 2 ){
              boolean heads;
              if(Math.random() < 0.5){
                  heads = true;
              }
              else{
                  heads = false;
              }
              if(heads = true){ 
                  int firstCard = 0;
                  int secondCard = 1;
                  Card temp = list.get(firstCard);
                  list.set(firstCard, list.get(secondCard)); 
                  list.set(secondCard, temp); 
              }
          }
  
          if(this.getSize() > 2){
              for(int x = 0; x < (list.size() * 2); x++){
                  int firstCard = (int)(Math.random() * list.size());
                  int secondCard = (int)(Math.random() * list.size());
                  while(firstCard == secondCard){
                      secondCard = (int)(Math.random() * list.size());
                  }
                  Card temp = list.get(firstCard);
                  list.set(firstCard, list.get(secondCard)); 
                  list.set(secondCard, temp); 
              }
          }
  
              // two different variables (firstCard and secondCard), check if they are same, if not, then swap them 
      }
        
      

    // private int getnumCards(){
    //     return numCards;
    // }

    // private int maxCards(){
    //     return maxCards;
    // }


}