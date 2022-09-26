package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    //TODO - implement a buy it now feature where if a bid
    // reaches a certain amount - it immediately returns true
    // and won't take anymore bids
    @Override
    public boolean placeBid(Bid offeredBid) {

        boolean isCurrentWinningBid = false;

        if(getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;

    }
}
