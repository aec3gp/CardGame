package aec3gp.cs2110.virginia.edu.golfcardgame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by student on 5/11/2015.
 */
public class CardGame extends Activity implements View.OnTouchListener {
    OurView view;
    Bitmap background, playingCards, playerOnePlayingCards, playerTwoPlayingCards, playerThreePlayingCards;
    Paint paint;
    float x, y;
    Card card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
    Card card11, card12, card13, card14, card15, card16, card17, card18, card19, card20;
    Card card21, card22, card23, card24, card25, card26, card27, card28, card29, card30;
    Card card31, card32, card33, card34, card35, card36, card37, card38, card39, card40;
    Card card41, card42, card43, card44, card45, card46, card47, card48, card49, card50;
    Card card51, card52, discardCard;
    User user;
    PlayerOne playerOne;
    PlayerTwo playerTwo;
    PlayerThree playerThree;
    Deck deck;
    boolean isCreated = false;
    boolean draw = false;

    @Override
    protected void onPause() {
        super.onPause();
        view.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new OurView(this);
        view.setOnTouchListener(this);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.table);
        playingCards = BitmapFactory.decodeResource(getResources(), R.drawable.playingcards);
        playerOnePlayingCards = BitmapFactory.decodeResource(getResources(), R.drawable.playeroneplayingcards);
        playerTwoPlayingCards = BitmapFactory.decodeResource(getResources(), R.drawable.playertwoplayingcards);
        playerThreePlayingCards = BitmapFactory.decodeResource(getResources(), R.drawable.playerthreeplayingcards);
        setContentView(view);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(32);

    }

    public class OurView extends SurfaceView implements Runnable{

        SurfaceHolder holder;
        boolean isFinished = false;
        boolean start = false;
        boolean discard = false;
        Thread t = null;

        public OurView(Context context){
            super(context);
            holder = getHolder();
        }

        public void run(){
            while(isFinished) {

                if (!holder.getSurface().isValid()) {
                    continue;
                }
                if (!isCreated) {
                    ArrayList<Card> cards = new ArrayList<>();
                    // clubs
                    card1 = new Card(view, playingCards, "c", 1);
                    card2 = new Card(view, playingCards, "c", 2);
                    card3 = new Card(view, playingCards, "c", 3);
                    card4 = new Card(view, playingCards, "c", 4);
                    card5 = new Card(view, playingCards, "c", 5);
                    card6 = new Card(view, playingCards, "c", 6);
                    card7 = new Card(view, playingCards, "c", 7);
                    card8 = new Card(view, playingCards, "c", 8);
                    card9 = new Card(view, playingCards, "c", 9);
                    card10 = new Card(view, playingCards, "c", 10);
                    card11 = new Card(view, playingCards, "c", 11);
                    card12 = new Card(view, playingCards, "c", 12);
                    card13 = new Card(view, playingCards, "c", 13);
                    cards.add(card1);
                    cards.add(card2);
                    cards.add(card3);
                    cards.add(card4);
                    cards.add(card5);
                    cards.add(card6);
                    cards.add(card7);
                    cards.add(card8);
                    cards.add(card9);
                    cards.add(card10);
                    cards.add(card11);
                    cards.add(card12);
                    cards.add(card13);
                    // spades
                    card14 = new Card(view, playingCards, "s", 1);
                    card15 = new Card(view, playingCards, "s", 2);
                    card16 = new Card(view, playingCards, "s", 3);
                    card17 = new Card(view, playingCards, "s", 4);
                    card18 = new Card(view, playingCards, "s", 5);
                    card19 = new Card(view, playingCards, "s", 6);
                    card20 = new Card(view, playingCards, "s", 7);
                    card21 = new Card(view, playingCards, "s", 8);
                    card22 = new Card(view, playingCards, "s", 9);
                    card23 = new Card(view, playingCards, "s", 10);
                    card24 = new Card(view, playingCards, "s", 11);
                    card25 = new Card(view, playingCards, "s", 12);
                    card26 = new Card(view, playingCards, "s", 13);
                    cards.add(card14);
                    cards.add(card15);
                    cards.add(card16);
                    cards.add(card17);
                    cards.add(card18);
                    cards.add(card19);
                    cards.add(card20);
                    cards.add(card21);
                    cards.add(card22);
                    cards.add(card23);
                    cards.add(card24);
                    cards.add(card25);
                    cards.add(card26);
                    // hearts
                    card27 = new Card(view, playingCards, "h", 1);
                    card28 = new Card(view, playingCards, "h", 2);
                    card29 = new Card(view, playingCards, "h", 3);
                    card30 = new Card(view, playingCards, "h", 4);
                    card31 = new Card(view, playingCards, "h", 5);
                    card32 = new Card(view, playingCards, "h", 6);
                    card33 = new Card(view, playingCards, "h", 7);
                    card34 = new Card(view, playingCards, "h", 8);
                    card35 = new Card(view, playingCards, "h", 9);
                    card36 = new Card(view, playingCards, "h", 10);
                    card37 = new Card(view, playingCards, "h", 11);
                    card38 = new Card(view, playingCards, "h", 12);
                    card39 = new Card(view, playingCards, "h", 13);
                    cards.add(card27);
                    cards.add(card28);
                    cards.add(card29);
                    cards.add(card30);
                    cards.add(card31);
                    cards.add(card32);
                    cards.add(card33);
                    cards.add(card34);
                    cards.add(card35);
                    cards.add(card36);
                    cards.add(card37);
                    cards.add(card38);
                    cards.add(card39);
                    // diamonds
                    card40 = new Card(view, playingCards, "d", 1);
                    card41 = new Card(view, playingCards, "d", 2);
                    card42 = new Card(view, playingCards, "d", 3);
                    card43 = new Card(view, playingCards, "d", 4);
                    card44 = new Card(view, playingCards, "d", 5);
                    card45 = new Card(view, playingCards, "d", 6);
                    card46 = new Card(view, playingCards, "d", 7);
                    card47 = new Card(view, playingCards, "d", 8);
                    card48 = new Card(view, playingCards, "d", 9);
                    card49 = new Card(view, playingCards, "d", 10);
                    card50 = new Card(view, playingCards, "d", 11);
                    card51 = new Card(view, playingCards, "d", 12);
                    card52 = new Card(view, playingCards, "d", 13);
                    cards.add(card40);
                    cards.add(card41);
                    cards.add(card42);
                    cards.add(card43);
                    cards.add(card44);
                    cards.add(card45);
                    cards.add(card46);
                    cards.add(card47);
                    cards.add(card48);
                    cards.add(card49);
                    cards.add(card50);
                    cards.add(card51);
                    cards.add(card52);
                    // loading and shuffling the deck
                    Collections.shuffle(cards);
                    Collections.shuffle(cards);
                    Collections.shuffle(cards);
                    deck = new Deck(view, playingCards, cards);
                    ArrayList<Card> topHandUser = new ArrayList<Card>();
                    ArrayList<Card> bottomHandUser = new ArrayList<Card>();
                    topHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandUser.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    user = new User(view, playingCards, topHandUser, bottomHandUser);

                    ArrayList<Card> topHandPlayerOne = new ArrayList<Card>();
                    ArrayList<Card> bottomHandPlayerOne = new ArrayList<Card>();
                    topHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerOne.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    playerOne = new PlayerOne(view, playerOnePlayingCards, topHandPlayerOne, bottomHandPlayerOne);

                    ArrayList<Card> topHandPlayerTwo = new ArrayList<Card>();
                    ArrayList<Card> bottomHandPlayerTwo = new ArrayList<Card>();
                    topHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerTwo.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    playerTwo = new PlayerTwo(view, playerTwoPlayingCards, topHandPlayerTwo, bottomHandPlayerTwo);

                    ArrayList<Card> topHandPlayerThree = new ArrayList<Card>();
                    ArrayList<Card> bottomHandPlayerThree = new ArrayList<Card>();
                    topHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    topHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    bottomHandPlayerThree.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    playerThree = new PlayerThree(view, playerThreePlayingCards, topHandPlayerThree, bottomHandPlayerThree);

                    deck.discard.add(deck.getDeck().get(0));
                    deck.getDeck().remove(0);
                    isCreated = true;
                }
                Canvas c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);

                while (start()) {
                    for (int i = 0; i < user.top.size(); i++) {
                        if (user.top.get(i).getHitbox().contains((int) x, (int) y)) {
                            user.top.get(i).flipped = true;
                        }

                    }
                    for (int i = 0; i < user.bottom.size(); i++) {
                        if (user.bottom.get(i).getHitbox().contains((int) x, (int) y)) {
                            user.bottom.get(i).flipped = true;
                        }

                    }
                    c = holder.lockCanvas();
                    onDraw(c);
                    holder.unlockCanvasAndPost(c);
                }
                start = true;

                Random random = new Random();
                int randomNumber = random.nextInt(4);
                playerOne.turn = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerOne.top.get(randomNumber).flipped = true;
                randomNumber = random.nextInt(4);
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                playerOne.bottom.get(randomNumber).flipped = true;
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerOne.turn = false;


                randomNumber = random.nextInt(4);
                playerTwo.turn = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerTwo.top.get(randomNumber).flipped = true;
                randomNumber = random.nextInt(4);
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                playerTwo.bottom.get(randomNumber).flipped = true;
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerTwo.turn = false;


                randomNumber = random.nextInt(4);
                playerThree.turn = true;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerThree.top.get(randomNumber).flipped = true;
                randomNumber = random.nextInt(4);
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                playerThree.bottom.get(randomNumber).flipped = true;
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
                playerThree.turn = false;
                user.turn = true;

                while (!gameEnded()) {
                    // user turn

                    c = holder.lockCanvas();
                    onDraw(c);
                    holder.unlockCanvasAndPost(c);


                    while (user.turn && user.finalTurn == 1) {
                        for (int i = 0; i < user.top.size(); i++) {
                            if (user.top.get(i).getHitbox().contains((int) x, (int) y) && user.top.get(i).flipped == false && draw == false) {
                                user.top.get(i).flipped = true;
                                user.turn = false;
                                playerOne.turn = true;
                            }
                        }
                        for (int i = 0; i < user.bottom.size(); i++) {
                            if (user.bottom.get(i).getHitbox().contains((int) x, (int) y) && user.bottom.get(i).flipped == false && draw == false) {
                                user.bottom.get(i).flipped = true;
                                user.turn = false;
                                playerOne.turn = true;
                            }
                        }
                        if (deck.hitbox.contains((int) x, (int) y)) {
                            c = holder.lockCanvas();
                            draw = true;
                            onDraw(c);
                            holder.unlockCanvasAndPost(c);
                        }
                        if (deck.discardHitbox.contains((int) x, (int) y) && draw == true) {
                            draw = false;
                            deck.discard.add(0, deck.getDeck().remove(0));
                            c = holder.lockCanvas();
                            onDraw(c);
                            holder.unlockCanvasAndPost(c);
                            user.turn = false;
                            playerOne.turn = true;
                        }
                        if (draw == true) {
                            for (int i = 0; i < user.top.size(); i++) {
                                if (user.top.get(i).getHitbox().contains((int) x, (int) y)) {
                                    deck.discard.add(0, user.top.get(i));
                                    user.top.set(i, deck.getDeck().remove(0));
                                    user.top.get(i).flipped = true;
                                    user.turn = false;
                                    playerOne.turn = true;
                                    draw = false;
                                }
                            }
                            for (int i = 0; i < user.bottom.size(); i++) {
                                if (user.bottom.get(i).getHitbox().contains((int) x, (int) y)) {
                                    deck.discard.add(0, user.bottom.get(i));
                                    user.bottom.set(i, deck.getDeck().remove(0));
                                    user.bottom.get(i).flipped = true;
                                    user.turn = false;
                                    playerOne.turn = true;
                                    draw = false;
                                }
                            }
                        }
                        if (deck.discardHitbox.contains((int) x, (int) y)) {
                            discard = true;
                        }
                        if (discard == true) {
                            for (int i = 0; i < user.top.size(); i++) {
                                if (user.top.get(i).getHitbox().contains((int) x, (int) y)) {
                                    discardCard = user.top.get(i);
                                    user.top.set(i, deck.getDiscard().remove(0));
                                    deck.discard.add(0, discardCard);
                                    user.top.get(i).flipped = true;
                                    user.turn = false;
                                    playerOne.turn = true;
                                    discard = false;
                                }
                            }
                            for (int i = 0; i < user.bottom.size(); i++) {
                                if (user.bottom.get(i).getHitbox().contains((int) x, (int) y)) {
                                    discardCard = user.bottom.get(i);
                                    user.bottom.set(i, deck.getDiscard().remove(0));
                                    deck.discard.add(0, discardCard);
                                    user.bottom.get(i).flipped = true;
                                    user.turn = false;
                                    playerOne.turn = true;
                                    discard = false;
                                }
                            }

                        }
                        if (user.numberFlipped() == 8) {
                            user.finalTurn = 0;
                        }
                        if (playerOne.finalTurn + playerTwo.finalTurn + playerThree.finalTurn != 3 && !user.turn) {
                            for (int y = 0; y < user.top.size(); y++) {
                                user.top.get(y).flipped = true;
                                user.bottom.get(y).flipped = true;
                            }
                            user.finalTurn = 0;
                        }
                    }

                    c = holder.lockCanvas();
                    onDraw(c);
                    holder.unlockCanvasAndPost(c);


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (playerOne.turn == true && playerOne.finalTurn == 1) {
                        // Initially check to see if flipped card can match
                        // Check top

                        for (int i = 0; i < playerOne.top.size(); i++) {
                            if (playerOne.top.get(i).equals(deck.getDiscard().get(0)) && playerOne.top.get(i).flipped && playerOne.turn == true) {
                                if (!playerOne.top.get(i).equals(playerOne.bottom.get(i)) || !playerOne.bottom.get(i).flipped) {
                                    discardCard = playerOne.bottom.get(i);
                                    playerOne.bottom.set(i, deck.getDiscard().remove(0));
                                    deck.discard.add(0, discardCard);
                                    playerOne.bottom.get(i).flipped = true;
                                    playerOne.turn = false;
                                    playerTwo.turn = true;
                                    Log.v("TAG", "Step 1");
                                }
                            }
                        }

                        //Check bottom
                        if (playerOne.turn == true) {
                            for (int i = 0; i < playerOne.bottom.size(); i++) {
                                if (playerOne.bottom.get(i).equals(deck.getDiscard().get(0)) && playerOne.bottom.get(i).flipped && playerOne.turn == true) {
                                    if (!playerOne.bottom.get(i).equals(playerOne.top.get(i)) || !playerOne.top.get(i).flipped) {
                                        discardCard = playerOne.top.get(i);
                                        playerOne.top.set(i, deck.getDiscard().remove(0));
                                        deck.discard.add(0, discardCard);
                                        playerOne.top.get(i).flipped = true;
                                        playerOne.turn = false;
                                        playerTwo.turn = true;
                                    }
                                }
                            }
                        }

                        //Check the hand of the next person.
                        //If the other person can make a match, the player will take it
                        //It will replace it with any card that isn't already matched

                        if (playerOne.turn == true) {
                            for (int i = 0; i < playerTwo.top.size(); i++) {
                                if (playerTwo.top.get(i).equals(deck.getDiscard().get(0)) && playerTwo.top.get(i).flipped) {
                                    if (!playerTwo.top.get(i).equals(playerTwo.bottom.get(i)) || !playerTwo.bottom.get(i).flipped) {
                                        for (int y = 0; y < 3; y++) {
                                            if (!playerOne.top.get(y).equals(playerOne.bottom.get(y)) && playerOne.bottom.get(y).flipped && playerOne.top.get(y).flipped && playerOne.turn) {
                                                discardCard = playerOne.top.get(y);
                                                playerOne.top.set(y, deck.getDiscard().remove(0));
                                                deck.discard.add(0, discardCard);
                                                playerOne.top.get(y).flipped = true;
                                                playerOne.turn = false;
                                                playerTwo.turn = true;
                                                Log.v("TAG", "Step 2");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (playerOne.turn && playerOne.numberFlipped() < 7) {
                            for (int i = 0; i < playerOne.top.size(); i++) {
                                if (!playerOne.top.get(i).flipped && playerOne.turn) {
                                    playerOne.top.get(i).flipped = true;
                                    playerOne.turn = false;
                                    playerTwo.turn = true;
                                    Log.v("TAG", "Step 3");
                                }
                            }
                            for (int i = 0; i < playerOne.bottom.size(); i++) {
                                if (!playerOne.bottom.get(i).flipped && playerOne.turn) {
                                    playerOne.bottom.get(i).flipped = true;
                                    playerOne.turn = false;
                                    playerTwo.turn = true;
                                    Log.v("TAG", "Step 4");
                                }
                            }
                        }
                        if (playerOne.turn) {
                            for (int i = 0; i < playerOne.top.size(); i++) {
                                if (playerOne.top.get(i).equals(deck.getDeck().get(0)) && playerOne.top.get(i).flipped && playerOne.turn) {
                                    if (!playerOne.bottom.get(i).flipped || !playerOne.bottom.equals(playerOne.top.get(i))) {
                                        draw = true;
                                        c = holder.lockCanvas();
                                        onDraw(c);
                                        holder.unlockCanvasAndPost(c);
                                        draw = false;
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        deck.discard.add(0, playerOne.bottom.get(i));
                                        playerOne.bottom.set(i, deck.getDeck().get(0));
                                        playerOne.bottom.get(i).flipped = true;
                                        playerOne.turn = false;
                                        playerTwo.turn = true;
                                        Log.v("TAG", "Step 5");
                                    }
                                }
                            }

                        for (int i = 0; i < playerOne.bottom.size(); i++) {
                            if (playerOne.bottom.get(i).equals(deck.getDeck().get(0)) && playerOne.bottom.get(i).flipped && playerOne.turn) {
                                if (!playerOne.top.get(i).flipped || !playerOne.top.equals(playerOne.bottom.get(i))) {
                                    draw = true;
                                    c = holder.lockCanvas();
                                    onDraw(c);
                                    holder.unlockCanvasAndPost(c);
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    draw = false;
                                    deck.discard.add(0, playerOne.top.get(i));
                                    playerOne.top.set(i, deck.getDeck().get(0));
                                    playerOne.top.get(i).flipped = true;
                                    playerOne.turn = false;
                                    playerTwo.turn = true;
                                    Log.v("TAG", "Step 6");
                                }
                            }
                        }
                        }
                        if (playerOne.turn) {
                            draw = true;
                            c = holder.lockCanvas();
                            onDraw(c);
                            holder.unlockCanvasAndPost(c);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            draw = false;
                            deck.discard.add(0, deck.getDeck().remove(0));
                            playerOne.turn = false;
                            playerTwo.turn = true;
                            Log.v("TAG", "Step 7");
                        }
                        if (playerOne.numberFlipped() == 8) {
                            playerOne.finalTurn = 0;
                            Log.v("TAG", "Step 8");
                        }
                        if (user.finalTurn + playerTwo.finalTurn + playerThree.finalTurn != 3) {
                            for (int y = 0; y < playerOne.top.size(); y++) {
                                playerOne.top.get(y).flipped = true;
                                playerOne.bottom.get(y).flipped = true;
                                Log.v("TAG", "Step 9");
                            }
                            playerOne.finalTurn = 0;
                        }


                    }

                    c = holder.lockCanvas();
                    onDraw(c);
                    holder.unlockCanvasAndPost(c);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // playerTwo turn

                    if(playerTwo.turn == true && playerTwo.finalTurn == 1){
                        // Initially check to see if flipped card can match
                        // Check top
                        for(int i = 0; i < playerTwo.top.size(); i++){
                            if(playerTwo.top.get(i).equals(deck.getDiscard().get(0)) && playerTwo.top.get(i).flipped && playerTwo.turn == true){
                                if(!playerTwo.top.get(i).equals(playerTwo.bottom.get(i)) || !playerTwo.bottom.get(i).flipped){
                                    discardCard = playerTwo.bottom.get(i);
                                    playerTwo.bottom.set(i, deck.getDiscard().remove(0));
                                    deck.discard.add(0,discardCard);
                                    playerTwo.bottom.get(i).flipped = true;
                                    playerTwo.turn = false;
                                    playerThree.turn = true;
                                }
                            }
                        }

                        //Check bottom
                        if(playerTwo.turn == true){
                            for(int i = 0; i < playerTwo.bottom.size(); i++){
                                if(playerTwo.bottom.get(i).equals(deck.getDiscard().get(0)) && playerTwo.bottom.get(i).flipped && playerTwo.turn == true){
                                    if(!playerTwo.bottom.get(i).equals(playerTwo.top.get(i)) || !playerTwo.top.get(i).flipped){
                                        discardCard = playerTwo.top.get(i);
                                        playerTwo.top.set(i, deck.getDiscard().remove(0));
                                        deck.discard.add(0,discardCard);
                                        playerTwo.top.get(i).flipped = true;
                                        playerTwo.turn = false;
                                        playerThree.turn = true;
                                    }
                                }
                            }
                        }

                        //Check the hand of the next person.
                        //If the other person can make a match, the player will take it
                        //It will replace it with any card that isn't already matched

                        if(playerTwo.turn == true){
                            for(int i = 0; i < playerThree.top.size(); i++){
                                if(playerThree.top.get(i).equals(deck.getDiscard().get(0)) && playerThree.top.get(i).flipped){
                                    if(!playerThree.top.get(i).equals(playerThree.bottom.get(i)) || !playerThree.bottom.get(i).flipped){
                                        for(int y = 0; y < 3; y++){
                                            if(!playerTwo.top.get(y).equals(playerTwo.bottom.get(y)) && playerTwo.bottom.get(y).flipped && playerTwo.top.get(y).flipped && playerTwo.turn){
                                                discardCard = playerTwo.top.get(y);
                                                playerTwo.top.set(y, deck.getDiscard().remove(0));
                                                deck.discard.add(0,discardCard);
                                                playerTwo.top.get(y).flipped = true;
                                                playerTwo.turn = false;
                                                playerThree.turn = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(playerTwo.turn && playerTwo.numberFlipped() < 7){
                            for(int i = 0; i < playerTwo.top.size(); i++){
                                if(!playerTwo.top.get(i).flipped && playerTwo.turn){
                                    playerTwo.top.get(i).flipped = true;
                                    playerTwo.turn = false;
                                    playerThree.turn = true;
                                }
                            }
                            for(int i = 0; i < playerTwo.bottom.size(); i++){
                                if(!playerTwo.bottom.get(i).flipped && playerTwo.turn){
                                    playerTwo.bottom.get(i).flipped = true;
                                    playerTwo.turn = false;
                                    playerThree.turn = true;
                                }
                            }
                        }
                        if(playerTwo.turn) {
                            for (int i = 0; i < playerTwo.top.size(); i++) {
                                if (playerTwo.top.get(i).equals(deck.getDeck().get(0)) && playerTwo.top.get(i).flipped && playerTwo.turn) {
                                    if (!playerTwo.bottom.get(i).flipped || !playerTwo.bottom.equals(playerTwo.top.get(i))) {
                                        draw = true;
                                        c = holder.lockCanvas();
                                        onDraw(c);
                                        holder.unlockCanvasAndPost(c);
                                        draw = false;
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        deck.discard.add(0, playerTwo.bottom.get(i));
                                        playerTwo.bottom.set(i, deck.getDeck().get(0));
                                        playerTwo.bottom.get(i).flipped = true;
                                        playerTwo.turn = false;
                                        playerThree.turn = true;
                                    }
                                }
                            }

                            for (int i = 0; i < playerTwo.bottom.size(); i++) {
                                if (playerTwo.bottom.get(i).equals(deck.getDeck().get(0)) && playerTwo.bottom.get(i).flipped && playerTwo.turn) {
                                    if (!playerTwo.top.get(i).flipped || !playerTwo.top.equals(playerTwo.bottom.get(i))) {
                                        draw = true;
                                        c = holder.lockCanvas();
                                        onDraw(c);
                                        holder.unlockCanvasAndPost(c);
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        draw = false;
                                        deck.discard.add(0, playerTwo.top.get(i));
                                        playerTwo.top.set(i, deck.getDeck().get(0));
                                        playerTwo.top.get(i).flipped = true;
                                        playerTwo.turn = false;
                                        playerThree.turn = true;
                                    }
                                }
                            }
                        }
                        if(playerTwo.turn){
                            draw = true;
                            c = holder.lockCanvas();
                            onDraw(c);
                            holder.unlockCanvasAndPost(c);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            draw = false;
                            deck.discard.add(0,deck.getDeck().remove(0));
                            playerTwo.turn = false;
                            playerThree.turn = true;
                        }
                        if(playerTwo.numberFlipped() == 8){
                            playerTwo.finalTurn = 0;
                        }
                        if(user.finalTurn + playerOne.finalTurn + playerThree.finalTurn != 3){
                            for(int y = 0; y < playerTwo.top.size(); y++){
                                playerTwo.top.get(y).flipped = true;
                                playerTwo.bottom.get(y).flipped = true;
                            }
                            playerTwo.finalTurn = 0;
                        }


                    }

                    c = holder.lockCanvas();
                    onDraw(c);
                    holder.unlockCanvasAndPost(c);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // playerThree Turn

                    if(playerThree.turn == true && playerThree.finalTurn == 1){
                        // Initially check to see if flipped card can match
                        // Check top
                        for(int i = 0; i < playerThree.top.size(); i++){
                            if(playerThree.top.get(i).equals(deck.getDiscard().get(0)) && playerThree.top.get(i).flipped && playerThree.turn == true){
                                if(!playerThree.top.get(i).equals(playerThree.bottom.get(i)) || !playerThree.bottom.get(i).flipped){
                                    discardCard = playerThree.bottom.get(i);
                                    playerThree.bottom.set(i, deck.getDiscard().remove(0));
                                    deck.discard.add(0,discardCard);
                                    playerThree.bottom.get(i).flipped = true;
                                    playerThree.turn = false;
                                    user.turn = true;
                                }
                            }
                        }

                        //Check bottom
                        if(playerThree.turn == true){
                            for(int i = 0; i < playerThree.bottom.size(); i++){
                                if(playerThree.bottom.get(i).equals(deck.getDiscard().get(0)) && playerThree.bottom.get(i).flipped && playerThree.turn == true){
                                    if(!playerThree.bottom.get(i).equals(playerThree.top.get(i)) || !playerThree.top.get(i).flipped){
                                        discardCard = playerThree.top.get(i);
                                        playerThree.top.set(i, deck.getDiscard().remove(0));
                                        deck.discard.add(0,discardCard);
                                        playerThree.top.get(i).flipped = true;
                                        playerThree.turn = false;
                                        user.turn = true;
                                    }
                                }
                            }
                        }

                        //Check the hand of the next person.
                        //If the other person can make a match, the player will take it
                        //It will replace it with any card that isn't already matched

                        if(playerThree.turn == true){
                            for(int i = 0; i < user.top.size(); i++){
                                if(user.top.get(i).equals(deck.getDiscard().get(0)) && user.top.get(i).flipped){
                                    if(!user.top.get(i).equals(user.bottom.get(i)) || !user.bottom.get(i).flipped){
                                        for(int y = 0; y < 3; y++){
                                            if(!playerThree.top.get(y).equals(playerThree.bottom.get(y)) && playerThree.bottom.get(y).flipped && playerThree.top.get(y).flipped && playerThree.turn){
                                                discardCard = playerThree.top.get(y);
                                                playerThree.top.set(y, deck.getDiscard().remove(0));
                                                deck.discard.add(0,discardCard);
                                                playerThree.top.get(y).flipped = true;
                                                playerThree.turn = false;
                                                user.turn = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if(playerThree.turn && playerThree.numberFlipped() < 7){
                            for(int i = 0; i < playerThree.top.size(); i++){
                                if(!playerThree.top.get(i).flipped && playerThree.turn){
                                    playerThree.top.get(i).flipped = true;
                                    playerThree.turn = false;
                                    user.turn = true;
                                }
                            }
                            for(int i = 0; i < playerThree.bottom.size(); i++){
                                if(!playerThree.bottom.get(i).flipped && playerThree.turn){
                                    playerThree.bottom.get(i).flipped = true;
                                    playerThree.turn = false;
                                    user.turn = true;
                                }
                            }
                        }
                        if(playerThree.turn) {
                            for (int i = 0; i < playerThree.top.size(); i++) {
                                if (playerThree.top.get(i).equals(deck.getDeck().get(0)) && playerThree.top.get(i).flipped && playerThree.turn) {
                                    if (!playerThree.bottom.get(i).flipped || !playerThree.bottom.equals(playerThree.top.get(i))) {
                                        draw = true;
                                        c = holder.lockCanvas();
                                        onDraw(c);
                                        holder.unlockCanvasAndPost(c);
                                        draw = false;
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        deck.discard.add(0, playerThree.bottom.get(i));
                                        playerThree.bottom.set(i, deck.getDeck().get(0));
                                        playerThree.bottom.get(i).flipped = true;
                                        playerThree.turn = false;
                                        user.turn = true;
                                    }
                                }
                            }

                            for (int i = 0; i < playerThree.bottom.size(); i++) {
                                if (playerThree.bottom.get(i).equals(deck.getDeck().get(0)) && playerThree.bottom.get(i).flipped && playerThree.turn) {
                                    if (!playerThree.top.get(i).flipped || !playerThree.top.equals(playerThree.bottom.get(i))) {
                                        draw = true;
                                        c = holder.lockCanvas();
                                        onDraw(c);
                                        holder.unlockCanvasAndPost(c);
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        draw = false;
                                        deck.discard.add(0, playerThree.top.get(i));
                                        playerThree.top.set(i, deck.getDeck().get(0));
                                        playerThree.top.get(i).flipped = true;
                                        playerThree.turn = false;
                                        user.turn = true;
                                    }
                                }
                            }
                        }
                        if(playerThree.turn){
                            draw = true;
                            c = holder.lockCanvas();
                            onDraw(c);
                            holder.unlockCanvasAndPost(c);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            draw = false;
                            deck.discard.add(0,deck.getDeck().remove(0));
                            playerThree.turn = false;
                            user.turn = true;
                        }
                        if(playerThree.numberFlipped() == 8){
                            playerThree.finalTurn = 0;
                        }
                        if(user.finalTurn + playerOne.finalTurn + playerTwo.finalTurn != 3){
                            for(int y = 0; y < playerTwo.top.size(); y++){
                                playerThree.top.get(y).flipped = true;
                                playerThree.bottom.get(y).flipped = true;
                            }
                            playerThree.finalTurn = 0;
                        }

                        c = holder.lockCanvas();
                        onDraw(c);
                        holder.unlockCanvasAndPost(c);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }

                }
                c = holder.lockCanvas();
                onDraw(c);
                holder.unlockCanvasAndPost(c);
            }
        }
        protected void onDraw(Canvas canvas) {
            Rect src = new Rect(0, 0, background.getWidth(), background.getHeight());
            Rect dst = new Rect(0, 0, view.getWidth(), view.getHeight());
            canvas.drawBitmap(background, src, dst, null);
            user.onDraw(canvas);
            playerOne.onDraw(canvas);
            playerTwo.onDraw(canvas);
            playerThree.onDraw(canvas);
            deck.onDraw(canvas);

            int userPointsX = view.getWidth() / 2;
            int userPointsY = view.getHeight() - (2 * card1.getHeight());
            int playerOnePointsX = 0;
            int playerOnePointsY = (view.getHeight() / 2) - (2 * card1.getWidth());
            int playerTwoPointsX = view.getWidth() / 2;
            int playerTwoPointsY = (3 * card1.getHeight()) - 50;
            int playerThreePointsX = view.getWidth();
            int playerThreePointsY = (view.getHeight() / 2) - (2 * card1.getWidth());
            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Player One Points: " + playerOne.holeScore(), playerOnePointsX, playerOnePointsY, paint);
            paint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText("Player Three Points: " + playerThree.holeScore(), playerThreePointsX, playerThreePointsY, paint);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("User Points: " + user.holeScore(), userPointsX, userPointsY, paint);
            canvas.drawText("Player Two Points: " + playerTwo.holeScore(), playerTwoPointsX, playerTwoPointsY, paint);

            if(draw == true){

                deck.draw(canvas);
            }
            if(start() && start == false){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Flip over two cards", positionX, positionY, paint);
            }
            if(user.turn == true){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Turn: User", positionX, positionY, paint);

            }
            if(playerOne.turn == true){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Turn: Player One", positionX, positionY, paint);
            }
            if(playerTwo.turn == true){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Turn: Player Two", positionX, positionY, paint);
            }
            if(playerThree.turn == true){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Turn: Player Three", positionX, positionY, paint);
            }
            if(gameEnded()){
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setTextAlign(Paint.Align.CENTER);
                paint.setTextSize(32);
                int positionX = view.getWidth() / 2;
                int positionY = (view.getHeight() / 2) + card1.getHeight();
                canvas.drawText("Game Over", positionX, positionY, paint);
            }
        }

        public void pause(){
            isFinished = false;
            while(true){
                try{
                    t.join(); // blocks current thread until the receiver finishes its execution and dies
                }catch(InterruptedException e){
                    e.printStackTrace();

                }
                break;
            }
            t = null;
        }
        public void resume(){
            isFinished = true;
            t = new Thread(this);  // uses run method
            t.start();

        }
        public boolean gameEnded(){
            int number = user.getFinalTurn() + playerOne.getFinalTurn() + playerTwo.getFinalTurn() + playerThree.getFinalTurn();
            if(number == 0){
                return true;
            }
            return false;
        }
        public boolean start(){
            int num = 0;
            for(int i = 0; i < user.top.size(); i++){
                if(user.top.get(i).flipped == true){
                    num += 1;
                }

            }
            for(int i = 0; i < user.bottom.size(); i++){
                if(user.bottom.get(i).flipped == true){
                    num += 1;
                }

            }
            if(num == 2){
                return false;
            }
            else{
                return true;
            }
        }

    }
}
