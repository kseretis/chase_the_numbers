import greenfoot.*;
import java.util.*;

/**
 * This class works as a holder for the zones that the enemies/numbers
 * can be spawned
 * Based on Singleton Pattern
 * 
 * @author Seretis Kleanthis
 * @version 1
 * @date 10/6/2022
 */
public class Zones  {
    private static final int ZONE1_STARTING_Y = 155;
    private static final int ZONE2_STARTING_Y = 300;
    private static final int ZONE3_STARTING_Y = 440;
    private static final int ZONE4_STARTING_Y = 580;
    private static final int ZONE_RANGE = 30;
    private static Zones instance = null;
    private static List<Zone> zones = new ArrayList<>();
    // Constructor
    private Zones(){
        initializeZones();
    }
    // Instance
    public static Zones getInstance(){
        if(instance == null)
            instance = new Zones();
        return instance;
    }
    // Initialize the zones
    private void initializeZones(){
        zones.add(new Zone(ZONE1_STARTING_Y, ZONE1_STARTING_Y + ZONE_RANGE, true));
        zones.add(new Zone(ZONE1_STARTING_Y, ZONE1_STARTING_Y + ZONE_RANGE, false));
        zones.add(new Zone(ZONE2_STARTING_Y, ZONE2_STARTING_Y + ZONE_RANGE, true));
        zones.add(new Zone(ZONE2_STARTING_Y, ZONE2_STARTING_Y + ZONE_RANGE, false));
        zones.add(new Zone(ZONE3_STARTING_Y, ZONE3_STARTING_Y + ZONE_RANGE, true));
        zones.add(new Zone(ZONE3_STARTING_Y, ZONE3_STARTING_Y + ZONE_RANGE, false));
        zones.add(new Zone(ZONE4_STARTING_Y, ZONE4_STARTING_Y + ZONE_RANGE, true));
        zones.add(new Zone(ZONE4_STARTING_Y, ZONE4_STARTING_Y + ZONE_RANGE, false));
    }
    // Returns an available zone
    public static Zone lookForRandomAvailableZone(){
        Zone zone;
        do{
            zone = zones.get(Greenfoot.getRandomNumber(zones.size()));
        }while(!zone.isAvailable());
        return zone;
    }
    // Returns an available zone for number
    public static Zone lookForRandomAvailableZoneForNumber(){
        Zone zone;
        do{
            zone = zones.get(Greenfoot.getRandomNumber(zones.size()));
        }while(!zone.isAvailableForNumber());
        return zone;
    }
    // restarts the zones' availability
    public void restartZonesAvailability(){
        for(Zone zone: zones)
            zone.setIsAvailable(true);
    }
}
