package com.techelevator;

public class Television {

    //variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    //methods
    public void turnOff(){

    isOn = false;

    }
    public void turnOn(){

        isOn = true;
    }

    public void changeChannel(int newChannel) {

     int minChannel = 3;
     int maxChannel = 18;

     if ((isOn) && (newChannel >= minChannel)  &&(newChannel <= maxChannel)) {

    currentChannel = newChannel;
}


}
public void channelUp(){

        int minChannel = 3;
        int maxChannel = 18;

        if ((isOn) && (currentChannel < maxChannel)) {

         currentChannel = currentChannel + 1;
        }

        else if ((isOn)  && (currentChannel == maxChannel)) {

            currentChannel = minChannel;
        }
}
            public void channelDown() {
            int minChannel = 3;
            int maxChannel = 18;

            if ((isOn) && (currentChannel > minChannel)) {

                currentChannel = currentChannel - 1;
            }


            else if ((isOn) && currentChannel == minChannel) {

                currentChannel = maxChannel;
    }
    }
    public void raiseVolume() {

        if ((isOn) && (currentVolume <= 9)) {

            currentVolume = currentVolume + 1;
        }
    }
    public void lowerVolume() {

        if ((isOn) && (currentVolume > 0) && (currentVolume <=10)){

            currentVolume = currentVolume - 1;

        }
    }
    public boolean isOn () {

        return isOn;
    }
    public int getCurrentChannel(){

        return currentChannel;
    }
        public int getCurrentVolume() {

        return currentVolume;
        }

}