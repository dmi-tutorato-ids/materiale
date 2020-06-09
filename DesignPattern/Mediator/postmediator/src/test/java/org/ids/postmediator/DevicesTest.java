package org.ids.postmediator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DevicesTest {
    Mediator m;
    
    Device tv;
    Device gs;
    Device cc;
    
    @Before
    public void reset() {
        m = new Mediator();

        tv = new SmartTv(m);
        gs = new GameStation(m);
        cc = new CronCast(m);

        m.setSmartTv(tv);
        m.setGameStation(gs);
        m.setCronCast(cc);
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
