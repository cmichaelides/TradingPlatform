package brown.platform.market.library; 

import brown.auction.rules.IActivityRule;  
import brown.auction.rules.IAllocationRule; 
import brown.auction.rules.IInformationRevelationPolicy;  
import brown.auction.rules.ITerminationCondition;
import brown.platform.market.IMarketRules;
import brown.auction.rules.IPaymentRule;  
import brown.auction.rules.IQueryRule;

/**  
* Describes all the rules for a particular market.
* 
* @author acoggins 
*/

public abstract class AbsMarketRules implements IMarketRules {
 
  public IAllocationRule aRule;  
  public IPaymentRule pRule;  
  public IQueryRule qRule;  
  public IActivityRule actRule;   
  public IInformationRevelationPolicy infoPolicy; 
  public ITerminationCondition tCondition;   
    
  public AbsMarketRules(IAllocationRule aRule, IPaymentRule pRule, IQueryRule qRule, 
                        IActivityRule oneShotActivity, IInformationRevelationPolicy infoPolicy, ITerminationCondition tCondition) {  
    this.aRule = aRule;   
    this.pRule = pRule;   
    this.qRule = qRule;    
    this.actRule = oneShotActivity;   
    this.infoPolicy = infoPolicy;   
    this.tCondition = tCondition;   
  } 

  @Override 
  public String toString() {  
    return "AbsMarketRules [aRule=" + aRule + ", pRule=" + pRule + ", qRule=" 
        + qRule + ", actRule=" + actRule + ", infoPolicy=" + infoPolicy 
        + ", innerTCondition=" + tCondition + "]"; 
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((aRule == null) ? 0 : aRule.hashCode());
    result = prime * result + ((actRule == null) ? 0 : actRule.hashCode());
    result =
        prime * result + ((infoPolicy == null) ? 0 : infoPolicy.hashCode());
    result = prime * result + ((pRule == null) ? 0 : pRule.hashCode());
    result = prime * result + ((qRule == null) ? 0 : qRule.hashCode());
    result =
        prime * result + ((tCondition == null) ? 0 : tCondition.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbsMarketRules other = (AbsMarketRules) obj;
    if (aRule == null) {
      if (other.aRule != null)
        return false;
    } else if (!aRule.equals(other.aRule))
      return false;
    if (actRule == null) {
      if (other.actRule != null)
        return false;
    } else if (!actRule.equals(other.actRule))
      return false;
    if (infoPolicy == null) {
      if (other.infoPolicy != null)
        return false;
    } else if (!infoPolicy.equals(other.infoPolicy))
      return false;
    if (pRule == null) {
      if (other.pRule != null)
        return false;
    } else if (!pRule.equals(other.pRule))
      return false;
    if (qRule == null) {
      if (other.qRule != null)
        return false;
    } else if (!qRule.equals(other.qRule))
      return false;
    if (tCondition == null) {
      if (other.tCondition != null)
        return false;
    } else if (!tCondition.equals(other.tCondition))
      return false;
    return true;
  }
 
  
} 