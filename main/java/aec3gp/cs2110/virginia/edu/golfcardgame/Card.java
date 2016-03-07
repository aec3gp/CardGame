package aec3gp.cs2110.virginia.edu.golfcardgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by student on 5/12/2015.
 */
public class Card {

    String suit;
    int number;
    Bitmap b;
    CardGame.OurView view;
    int height, width;
    int x,y;
    boolean flipped = false;
    Rect hitbox;

    public Card(CardGame.OurView view, Bitmap cards, String input, int num){
        this.view = view;
        this.b = cards;
        this.suit = input;
        this.height = b.getHeight() / 5;
        this.width = b.getWidth() / 13;
        this.x = 100;
        this.y = 100;
        this.number = num;
        Rect rect = new Rect();
        this.hitbox = rect;
    }

    public boolean equals(Card card){
        if(this.number == card.number){
            return true;
        }
        return false;
    }

    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHitbox(Rect newHitbox){
        this.hitbox = newHitbox;
    }
    public Rect getHitbox(){
        return this.hitbox;
    }



}
