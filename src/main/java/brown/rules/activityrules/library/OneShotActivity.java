package brown.rules.activityrules.library;

import brown.market.marketstate.IMarketState;
import brown.messages.library.TradeMessage;
import brown.rules.activityrules.IActivityRule;

public class OneShotActivity implements IActivityRule {

  @Override
  public void isAcceptable(IMarketState state, TradeMessage aBid) {
    // TODO Auto-generated method stub
    boolean acceptable = !(state.getBids().contains(aBid));
    state.setAcceptable(acceptable);
  }
}