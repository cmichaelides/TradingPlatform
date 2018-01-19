package brown.rules;

import brown.market.marketstate.ICompleteState;

public interface IInformationRevelationPolicy {
  
  public void handleInfo();

  public void setReport(ICompleteState state);

  public void reset();

}