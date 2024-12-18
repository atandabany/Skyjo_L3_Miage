package fr.pantheonsorbonne.miage.skyjo2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Round {
    
    Deck deck; 
    Deque<Card> poubelle ;
    List<Player> players;
    
    public Round(List<Player> players){
        deck=new Deck();
        this.players=players;
        poubelle=new LinkedList<Card>();
        poubelle.push(deck.piocher());

        for (Player player:players){
            Hand newHand= new Hand(deck);
            KnownHand newKnownHand=new KnownHand(newHand, poubelle);
            player.hand=newHand;
            player.knownHand=newKnownHand;
            player.poubelle=this.poubelle;
            player.deck=this.deck;

        }
    }

    public void playRound(){
        while (!isOverRound()) {
            
            for(Player player : players){
                System.out.println("\n"+"C'est au tour de "+player.getName()+"\n");
                player.jouer();
            }
        }
    }

    public boolean isOverRound(){
        for(Player player : players){
            if(player.knownHand.nbKnownCard() == 12){
                return true;
            }
        }
        return false;
    }

    public void setFirstPlayer(){
        Player firstPlayer = players.get(0);
        for(Player player : players){

        }
    }
    


}