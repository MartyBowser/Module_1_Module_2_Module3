package com.techelevator;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;
    private int startingPiecesOfFruit;
    private int getPiecesOfFruitLeft;




public FruitTree(String typeofFruit, int startingPiecesOfFruit) {
this.typeOfFruit = typeofFruit;
this.piecesOfFruitLeft = startingPiecesOfFruit;


}
public String getTypeOfFruit() {return  typeOfFruit;}

    public int getPiecesOfFruitLeft() {return piecesOfFruitLeft;}


    public int getStartingPiecesOfFruit() {
        return startingPiecesOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft>= numberOfPiecesToRemove) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        }else {
            return false;
        }
    }
}