package aec3gp.cs2110.virginia.edu.golfcardgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by student on 5/23/2015.
 */
public class Deck {
    Bitmap cards;
    CardGame.OurView view;
    int height, width, x, y;
    ArrayList<Card> deck;
    Rect hitbox, discardHitbox;
    ArrayList<Card> discard = new ArrayList<Card>();

    public Deck(CardGame.OurView view, Bitmap b, ArrayList<Card> topHand){
        this.view = view;
        this.cards = b;
        this.deck = topHand;
        this.height = view.getHeight();
        this.width = view.getWidth();
        hitbox = new Rect((this.width / 2) - (b.getWidth() / 26), (this.height / 2) - (b.getHeight() / 10), (this.width / 2) - (b.getWidth() / 26)+ (b.getWidth() / 13), (this.height / 2) - (b.getHeight() / 10) + (b.getHeight() / 5) );
        this.discardHitbox = new Rect((this.width / 2) - (3 *(b.getWidth() / 26)), (this.height / 2) - (b.getHeight() / 10), (this.width / 2) - (3 *(b.getWidth() / 26)) + b.getWidth() / 13, (this.height / 2) - (b.getHeight() / 10) + (b.getHeight() / 5));
    }
    public void draw(Canvas canvas){
        int suitNumber = 0;
        if(this.deck.get(0).suit.equals("h")){
            suitNumber = 0;
        }
        if(this.deck.get(0).suit.equals("d")){
            suitNumber = 1;
        }
        if(this.deck.get(0).suit.equals("c")){
            suitNumber = 2;
        }
        if(this.deck.get(0).suit.equals("s")){
            suitNumber = 3;
        }

        Rect src = new Rect( (this.deck.get(0).number -1 ) * this.deck.get(0).width ,suitNumber * this.deck.get(0).height , (this.deck.get(0).number -1 ) * this.deck.get(0).width + this.deck.get(0).width, this.deck.get(0).height + (suitNumber * this.deck.get(0).height)); // srcY

        x = (this.width / 2) + (this.deck.get(0).getWidth() / 2);
        y = this.height / 2 - (this.deck.get(0).getHeight() / 2);

        Rect dst = new Rect(x, y, this.deck.get(0).getWidth() + x, this.deck.get(0).getHeight() + y); // x , y, x + width, y + height
        this.deck.get(0).setHitbox(dst);
        this.deck.get(0).flipped = true;
        canvas.drawBitmap(cards, src, dst, null);

    }
    public void onDraw(Canvas canvas){
        Rect src = new Rect(0 ,4 * (cards.getHeight() / 5) ,cards.getWidth() / 13, cards.getHeight());
        canvas.drawBitmap(cards, src, this.hitbox, null);
        if(this.discard.size() > 0){
            int suitNumber = 0;
            if(this.discard.get(0).suit.equals("h")){
                suitNumber = 0;
            }
            if(this.discard.get(0).suit.equals("d")){
                suitNumber = 1;
            }
            if(this.discard.get(0).suit.equals("c")){
                suitNumber = 2;
            }
            if(this.discard.get(0).suit.equals("s")){
                suitNumber = 3;
            }

            Rect srx = new Rect( (this.discard.get(0).number -1 ) * this.discard.get(0).width ,suitNumber * this.discard.get(0).height , (this.discard.get(0).number -1 ) * this.discard.get(0).width + this.discard.get(0).width, this.discard.get(0).height + (suitNumber * this.discard.get(0).height)); // srcY

            x = (this.width / 2) - (this.deck.get(0).getWidth() / 2);
            y = this.height / 2 - (this.deck.get(0).getHeight() / 2);

            Rect dst = new Rect(x, y, this.deck.get(0).getWidth() + x, this.deck.get(0).getHeight() + y); // x , y, x + width, y + height
            this.discard.get(0).flipped = true;
            canvas.drawBitmap(cards, srx, this.discardHitbox, null);
        }
    }
    public ArrayList<Card> getDiscard(){
        return this.discard;
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
}
