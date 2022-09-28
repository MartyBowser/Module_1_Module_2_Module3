package com.techelevator;

public class SquareWall extends RectangleWall{
    int sideLength;

public SquareWall(String name, String color, int sideLength){
    super(name, color, sideLength, sideLength);
}

public String toString(){
    return getName()+ " ("+getLength()+"x"+getHeight()+") square";
}


}

