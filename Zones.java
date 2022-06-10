import java.util.*;

/**
 * Write a description of class Zones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zones  {
    private static final int ZONE1_STARTING_Y = 155;
    private static final int ZONE2_STARTING_Y = 300;
    private static final int ZONE3_STARTING_Y = 440;
    private static final int ZONE4_STARTING_Y = 580;
    private static final int ZONE_RANGE = 30;
    private static Zones instance = null;
    private static List<Zone> zones = new ArrayList<>();
    
    private Zones(){
        initializeZones();
    }
    
    public static Zones getInstance(){
        if(instance == null)
            instance = new Zones();
        return instance;
    }
    
    private void initializeZones(){
        Zone zone2 = new Zone(ZONE4_STARTING_Y, ZONE4_STARTING_Y + ZONE_RANGE, false);
        zones.add(zone2);
    }
    
    public Zone lookForAvailableZone(){
        for(Zone zone: zones){
            if(zone.isAvailable())
                return zone;
        }
        return null;
    }
    
}
