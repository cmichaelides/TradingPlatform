package brown.platform.world.library;

import brown.logging.library.PlatformLogging;
import brown.platform.market.IMarketManager;
import brown.platform.whiteboard.IWhiteboard;
import brown.platform.world.IDomainManager;
import brown.platform.world.IWorld;
import brown.platform.world.IWorldManager;


public class WorldManager implements IWorldManager {

    private IWorld world;
    private boolean lock;

    /**
     * worldManager constructor instantiates world
     */
    public WorldManager() {
        this.lock = false;
    }

    public void createWorld(IDomainManager domain, IMarketManager markets) {
        if (!this.lock) {
            this.world = new World(domain, markets);
            this.lock = true;
        } else {
            PlatformLogging.log("Creation denied: world manager locked.");
        }
    }

    public IWorld getWorld() {
        return this.world;
    }
}