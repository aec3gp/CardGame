package aec3gp.cs2110.virginia.edu.golfcardgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by student on 5/22/2015.
 */
public class PlayerTwo {

    Bitmap cards;
    CardGame.OurView view;
    int height, width, x, y, finalTurn;
    ArrayList<Card> top, bottom;
    boolean turn;

    public PlayerTwo(CardGame.OurView view, Bitmap b, ArrayList<Card> topHand, ArrayList<Card> bottomHand){
        this.view = view;
        this.cards = b;
        this.height = this.view.getHeight();
        this.width = this.view.getWidth() / 2;
        this.top = topHand;
        this.bottom = bottomHand;
        this.finalTurn = 1;
        this.turn = false;
    }

    public void onDraw(Canvas canvas){

        for(int i = 0; i < 4; i++){

            int suitNumber = 0;
            if(this.top.get(i).suit.equals("h")){
                suitNumber = 4;
            }
            if(this.top.get(i).suit.equals("d")){
                suitNumber = 3;
            }
            if(this.top.get(i).suit.equals("c")){
                suitNumber = 2;
            }
            if(this.top.get(i).suit.equals("s")){
                suitNumber = 1;
            }

            Rect src = new Rect((13 - this.top.get(i).number) * this.top.get(i).getWidth(), suitNumber * this.top.get(i).getHeight(), ((13 - this.top.get(i).number) * this.top.get(i).getWidth()) + this.top.get(i).getWidth(), (suitNumber * this.top.get(i).getHeight()) + this.top.get(i).getHeight()); // srcY
            if( i == 0){
                x = this.width + (this.top.get(i).getWidth());
                y = this.top.get(i).getHeight();
            }
            if( i == 1){
                x = this.width;
                y = this.top.get(i).getHeight();
            }
            if( i == 2){
                x = this.width - (this.top.get(i).getWidth());
                y = this.top.get(i).getHeight();
            }
            if( i == 3){
                x = this.width - (2 * this.top.get(i).getWidth());
                y = this.top.get(i).getHeight();
            }
            Rect dst = new Rect(x, y, this.top.get(i).getWidth() + x, this.top.get(i).getHeight() + y); // x , y, x + width, y + height
            this.top.get(i).setHitbox(dst);
            if(this.top.get(i).flipped == true){
                canvas.drawBitmap(cards, src, dst, null);
            }
            else{
                src = new Rect(12 * top.get(i).width, 0, 13 * top.get(i).width, top.get(i).getHeight());
                canvas.drawBitmap(cards, src, dst, null);
            }

        }
        for(int i = 0; i < 4; i++){

            int suitNumber = 0;
            if(this.bottom.get(i).suit.equals("h")){
                suitNumber = 4;
            }
            if(this.bottom.get(i).suit.equals("d")){
                suitNumber = 3;
            }
            if(this.bottom.get(i).suit.equals("c")){
                suitNumber = 2;
            }
            if(this.bottom.get(i).suit.equals("s")){
                suitNumber = 1;
            }

            Rect src = new Rect((13 - this.bottom.get(i).number) * this.bottom.get(i).getWidth(), suitNumber * this.bottom.get(i).getHeight(), ((13 - this.bottom.get(i).number) * this.bottom.get(i).getWidth()) + this.bottom.get(i).getWidth(), suitNumber * this.bottom.get(i).getHeight() + this.bottom.get(i).getHeight()); // srcY
            if( i == 0){
                x = this.width + (this.top.get(i).getWidth());
                y = 0;
            }
            if( i == 1){
                x = this.width;
                y = 0;
            }
            if( i == 2){
                x = this.width - (this.top.get(i).getWidth());
                y = 0;
            }
            if( i == 3){
                x = this.width - (2 * this.top.get(i).getWidth());
                y = 0;
            }
            Rect dst = new Rect(x, y, this.top.get(i).getWidth() + x, this.top.get(i).getHeight() + y); // x , y, x + width, y + height
            this.bottom.get(i).setHitbox(dst);
            if(this.bottom.get(i).flipped == true){
                canvas.drawBitmap(cards, src, dst, null);
            }
            else{
                src = new Rect(12 * top.get(i).width, 0, 13 * top.get(i).width, top.get(i).getHeight());
                canvas.drawBitmap(cards, src, dst, null);
            }

        }

    }
    public int numberFlipped(){
        int num = 0;
        for(int i =0; i < this.top.size(); i++){
            if(this.top.get(i).flipped){
                num += 1;
            }
        }
        for(int y =0; y < this.bottom.size(); y++){
            if(this.bottom.get(y).flipped){
                num += 1;
            }
        }
        return num;
    }
    public int holeScore(){
        int score = 0;
        for(int i =0; i < this.top.size(); i++){
            if(this.top.get(i).flipped && !this.top.get(i).equals(this.bottom.get(i))){
                if(this.top.get(i).number >= 10 && this.top.get(i).number < 13){
                    score += 10;
                }
                else if(this.top.get(i).number == 13){
                    score += 0;
                }
                else{
                    score += this.top.get(i).number;
                }
            }
        }
        for(int y =0; y < this.bottom.size(); y++){
            if(this.bottom.get(y).flipped && !this.top.get(y).equals(this.bottom.get(y))){
                if(this.bottom.get(y).number >= 10 && this.bottom.get(y).number < 13){
                    score += 10;
                }
                else if(this.bottom.get(y).number == 13){
                    score += 0;
                }
                else{
                    score += this.bottom.get(y).number;
                }
            }
        }
        return score;
    }
    public int getFinalTurn(){
        return this.finalTurn;
    }
    public void setFinalTurn(int finalT){
        this.finalTurn = finalT;
    }
}
