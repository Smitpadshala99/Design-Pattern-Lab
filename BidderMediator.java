import java.util.*;

//  Auctioning
//  Bidders-colleagues
//  Mediator-Auctioner

interface MediatorEntity {
    public void registerBidder(CollegueEntity_Bidder bd);
    public void searchHighestBidAmount();
}
abstract class CollegueEntity_Bidder {
    MediatorEntity md;
    String bName;
    int bPrice;
    public CollegueEntity_Bidder(MediatorEntity md, String bName) {
        this.md = md;
        this.bName = bName;
        //this.bPrice = bPrice;  // in the bidding price time tp time chage so don't put here (bid amount)
    }
    @Override
    public String toString() {
        return "Bidder name: "+bName+" giving bidAmount: "+bPrice;
    }
    abstract public void bidAmount(int amount);
}
class Bidder1 extends CollegueEntity_Bidder {

    public Bidder1(MediatorEntity md, String bName) {
        super(md, bName);
    }

    @Override
    public void bidAmount(int amount) {
        bPrice = amount;
    }
}
class AuctionerMediator implements MediatorEntity {

    List<CollegueEntity_Bidder> ls = new ArrayList<CollegueEntity_Bidder>();
    @Override
    public void registerBidder(CollegueEntity_Bidder bd) {
        ls.add(bd);
    }

    @Override
    public void searchHighestBidAmount() {
        int maxBid = 0;
        CollegueEntity_Bidder b = null;
        for(CollegueEntity_Bidder cb : ls) {
            if(cb.bPrice > maxBid) {
                maxBid = cb.bPrice;
                b = cb;
            }
        }
        System.out.println("Winner of the auctioning is: " + b);
    }
}
class BidderMediator {
    public static void main(String[] args) {
        MediatorEntity m1 = new AuctionerMediator();
        CollegueEntity_Bidder b1 = new Bidder1(m1, "Bidder1");
        CollegueEntity_Bidder b2 = new Bidder1(m1, "Bidder2");
        CollegueEntity_Bidder b3 = new Bidder1(m1, "Bidder3");
        
        // CollegueEntity_Bidder b4 = new Bidder1(m1, "Bidder1");
        System.out.println("Welcome all Bidder for auctioning event:");

        m1.registerBidder(b1);
        m1.registerBidder(b2);
        m1.registerBidder(b3);

        b1.bidAmount(5000);
        b2.bidAmount(2000);
        b3.bidAmount(6000);
        b2.bidAmount(7000);

        m1.searchHighestBidAmount();
    }
}