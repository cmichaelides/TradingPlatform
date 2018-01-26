package brown.market;

import java.util.Collection;
import java.util.List;

import brown.accounting.library.Ledger;
import brown.market.library.Market;
import brown.market.preset.AbsMarketPreset;
import brown.tradeable.ITradeable;

/**
 * market manager.
 * @author andrew
 *
 */
public interface IMarketManager {
  
  /**
   * Closes a market and tells it to convert if applicable
   * @param server
   * @param ID
   * @param closingState
   */
  public void close(Integer ID);

  /**
   * Opens a market
   * @param market
   * @return
   */
  public boolean open(AbsMarketPreset rules, Integer marketID, List<ITradeable> tradeables);


  /**
   * Gets the ledger for this market ID
   * @param ID
   * @return
   */
  public Ledger getLedger(Integer ID);

  /**
   * Gets the market for this ID
   * @param ID
   * @return
   */
  public Market getMarket(Integer ID);

  /**
   * Gets all of the auctions
   * @return
   */
  public Collection<Market> getAuctions();

  /**
   * 
   * @param marketID
   */
  public void update(Integer marketID);
  
  /**
   * 
   * @return
   */
  public boolean anyMarketsOpen();

  /**
   * 
   */
  public void reset();
}