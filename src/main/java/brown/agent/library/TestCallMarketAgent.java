package brown.agent.library;


import brown.agent.AbsCallMarketAgent;
import brown.bid.library.BidDirection;
import brown.bid.library.CancelBid;
import brown.bid.library.TwoSidedBid;
import brown.bidbundle.library.CancelBundle;
import brown.bidbundle.library.TwoSidedBidBundle;
import brown.channels.library.CallMarketChannel;
import brown.exceptions.AgentCreationException;
import brown.logging.Logging;
import brown.messages.library.BankUpdateMessage;
import brown.messages.library.CallMarketReportMessage;
import brown.messages.library.GameReportMessage;
import brown.setup.library.CallMarketSetup;

public class TestCallMarketAgent extends AbsCallMarketAgent {
   private BidDirection direction;
   private Double price;
   private Integer quantity;
   
  
  public TestCallMarketAgent(String host, int port, String name, BidDirection direction, Double price, Integer quantity)
      throws AgentCreationException {
    super(host, port, new CallMarketSetup(), name);
    this.direction = direction;
    this.price = price;
    this.quantity = quantity;
  }
  
  @Override
  public void onCallMarket(CallMarketChannel cmChannel) {
    cmChannel.bid(this, new TwoSidedBidBundle(new TwoSidedBid(this.direction, this.price, this.quantity)));
    Logging.log("Orderbook: " + cmChannel.getOrderBook().toString());
    if (this.direction == BidDirection.SELL){
      Logging.log("AGENT " + this.ID + "selling at " + this.price);      
      this.price = this.price+1; 
    } else {
      Logging.log("AGENT " + this.ID + " bidding at " + this.price);            
      if (this.price <= 27){
        Logging.log("AGENT " + this.ID + " canceling buys at " + 28);
        // Cancel all buys 27 and above
        cmChannel.bid(this,new CancelBundle(new CancelBid(this.direction, 28)));
      }
      this.price = this.price-1;       
    }
  }  

  @Override
  public void onBankUpdate(BankUpdateMessage bankUpdate) {
    Logging.log("BANKUPDATE: Agent: " + this.ID + ", " + bankUpdate.toString());
  }

  @Override
  public void onGameReport(GameReportMessage gameReport) {
    Logging.log("Game report received");
    if (gameReport instanceof CallMarketReportMessage) {
      Logging.log("size: " + ((CallMarketReportMessage) gameReport).getTransactions().size());
    } else {
      Logging.log(gameReport.toString());      
    }
  } 
  
  public static void main(String[] args) throws AgentCreationException {
    new TestCallMarketAgent("localhost", 2121,"Buy30bot1",BidDirection.BUY,30.,1);    
      while(true){}      
  }  
}
