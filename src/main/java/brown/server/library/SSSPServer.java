package brown.server.library; 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import brown.market.preset.AbsMarketPreset;
import brown.market.preset.library.LemonadeRules;
import brown.market.preset.library.SSSPRules;
import brown.setup.library.LemonadeSetup;
import brown.tradeable.ITradeable;
import brown.tradeable.library.MultiTradeable;
import brown.value.config.AbsValueConfig;
import brown.value.config.LemonadeConfig;
import brown.value.config.SSSPConfig;

/**
 * Use this class to run the server side of your game.
 * Just edit the rules to the game that you'd like to play.
 * 
 * This is the only file the server-side user should have to edit.
 * 
 * hmm... what to do about special registrations?
 * repeated registrations?
 */
public class SSSPServer {

  public static void main(String[] args) throws InterruptedException {
    List<AbsMarketPreset> allMarkets = new ArrayList<AbsMarketPreset>();
    List<AbsValueConfig> allValInfo = new ArrayList<AbsValueConfig>();
    
    //create tradeables
    Set<ITradeable> allTradeables = new HashSet<ITradeable>(); 
    for (int i = 0; i < 3; i++) {
      allTradeables.add(new MultiTradeable(i, 1)); //just one copy of each good for now
    }
    
    //valuations and rules
    allValInfo.add(new SSSPConfig(allTradeables));
    allMarkets.add(new SSSPRules());
    
    new RunServer(2121, new LemonadeSetup()).runGame(allMarkets, allValInfo, 1000.0, null);
  }
  
}