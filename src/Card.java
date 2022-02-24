import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.event.MenuDragMouseEvent;
import javax.imageio.ImageIO;

/** represents a playing card that can draw itself. */
//Can use from WarGame
public class Card implements Drawable, Updateable{
    private int suit; //1 = clubs, 2 = spades, 3 = hearts, 4 = diamonds
	private int value; //Ace = 1, ..., Jack = 11, Queen = 12, King = 13
	private boolean color; //True = red, false = black
	private boolean faceUp; //True = face up, false = face down
	private String name;
	private int xCord, yCord;
	private boolean illuminated;
	Image frontImage, backImage;
	public static final int OFFSET_X = 40, OFFSET_Y = 20;
	
	
	public Card(int _suit, int _value) {
		suit = _suit;
		value = _value;
		faceUp = false;
		illuminated = false;

		if (_suit == 1 || _suit == 2)
			color = false;
		else
			color = true;
		
		name += "images/cards/";
		if (suit == 1) 
			name += "c";
		else if (suit == 2) 
			name += "s";
		else if (suit == 3) 
			name += "h";
		else if (suit == 4) 
			name += "d";
		
		if (value == 1) 
			name += "1.png";
		else if (value == 2) 
			name += "2.png";
		else if (value == 3) 
			name += "3.png";
		else if (value == 4) 
			name += "4.png";
		else if (value == 5) 
			name += "5.png";
		else if (value == 6) 
			name += "6.png";
		else if (value == 7) 
			name += "7.png";
		else if (value == 8) 
			name += "8.png";
		else if (value == 9) 
			name += "9.png";
		else if (value == 10) 
			name += "10.png";
		else if (value == 11) 
			name += "j.png";
		else if (value == 12) 
			name += "q.png";
		else if (value == 13) 
			name += "k.png";

		try {
			frontImage = ImageIO.read(new File(name));
			backImage = ImageIO.read(new File("images/cards/b1fv.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean canSwap(Card c) {
		if (color == true) {
			if (c.color == false && this.value - c.value == 1) {
				return true;
			}
		} else if (color == false) {
			if (c.color == true &&  this.value - c.value == 1) {
				return true;
			}
		}
		return false;
	}
	/*
	public void assignImages() {
		try {
			frontImage = ImageIO.read(new File(name));
			backImage = ImageIO.read(new File("images/cards/b1fv.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/

	public void openImage() {
		//TODO
	}

	@Override
	public void update(ActionEvent a) {
		// TODO Auto-generated method stub
		
	}

	public void selected() {
		illuminated = true;
	}

	public void revealed() {
		faceUp = true;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(frontImage, xCord, yCord, null);
	}

	public void setCords(MouseEvent me) {
		xCord = me.getX();
		yCord = me.getY();
	}

	/*
	public void setXLoc(int x) {
	 	xLoc = x;
	}

	public void setYLoc(int y) {
	 	yLoc = y;
	 }
	*/
}

