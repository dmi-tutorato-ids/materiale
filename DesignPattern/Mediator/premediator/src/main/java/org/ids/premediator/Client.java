package org.ids.premediator;

/** abbiamo due problemi:
 *  - ogni device deve conoscere gli altri due
 *  - la logica di accensione/spegnimento degli altri device è sparsa tra più classi
 *    - comportamento globale difficile da comprendere
 *    - comportamento globale difficile da modificare
 */
public class Client {
    public static void main( String[] args ) {
        Device tv = new SmartTv();
        Device gs = new GameStation();
        Device cc = new CronCast();

        // Inject Dependencies for tv
        tv.setGameStation(gs);
        tv.setCronCast(cc);

        // Inject Dependencies for gs
        gs.setSmartTv(tv);
        gs.setCronCast(cc);

        // Inject Dependencies for cc
        cc.setSmartTv(tv);
        cc.setGameStation(gs);

        gs.turnOn();    // should also turn on the tv
        cc.turnOn();    // should also turn off the gs
        tv.turnOff();   // should also turn off both the cc and the gs
    }
}
