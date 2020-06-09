package org.ids.premediator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DevicesTest {
    Device tv;
    Device gs;
    Device cc;
    
    @Before
    public void reset() {
        tv = new SmartTv();
        gs = new GameStation();
        cc = new CronCast();

        // Inject Dependencies for tv
        tv.setGameStation(gs);
        tv.setCronCast(cc);

        // Inject Dependencies for gs
        gs.setSmartTv(tv);
        gs.setCronCast(cc);

        // Inject Dependencies for cc
        cc.setSmartTv(tv);
        cc.setGameStation(gs);
    }

    @Test
    public void testTurningGameStationON() {
        // method to test
        gs.turnOn();
        
        assertTrue(gs.isOn());
        assertTrue(tv.isOn());
    }

    @Test
    public void testTurningCronCastON_givenGameStationON() {
        // getting to target state
        gs.turnOn();
        
        // method to test
        cc.turnOn();
        
        assertTrue(cc.isOn());
        assertTrue(tv.isOn());
        assertTrue(!gs.isOn());
    }

    @Test
    public void testTurningSmartTvOFF_givenCronCastOrGameStationON() {
        // getting to target state
        cc.turnOn();
        gs.turnOn();

        // method to test
        tv.turnOff();

        assertTrue(!cc.isOn());
        assertTrue(!gs.isOn());
        assertTrue(!tv.isOn());
    }
}
