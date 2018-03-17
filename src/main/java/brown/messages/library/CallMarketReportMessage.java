package brown.messages.library;

import java.util.List;
import java.util.Map;

import brown.accounting.library.Ledger;
import brown.accounting.library.Transaction;
import brown.messages.library.GameReportMessage;

public class CallMarketReportMessage extends GameReportMessage {
  private Ledger ledger;
  
  // void kryo
  public CallMarketReportMessage(){
    this.ledger = null;
  }
  
  public CallMarketReportMessage(Ledger ledger){
    this.ledger = ledger;
  }  

  public List<Transaction> getTransactions() {
    return this.ledger.getList();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ledger == null) ? 0 : ledger.hashCode());
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
    CallMarketReportMessage other = (CallMarketReportMessage) obj;
    if (ledger == null) {
      if (other.ledger != null)
        return false;
    } else if (!ledger.equals(other.ledger))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return "CallMarketReportMessage [ledger=" + ledger + "]";
  }

  // this is already sanitized when generated
  public GameReportMessage sanitize(Integer agent, Map<Integer,Integer> privateToPublic){    
    return this;
    }
}