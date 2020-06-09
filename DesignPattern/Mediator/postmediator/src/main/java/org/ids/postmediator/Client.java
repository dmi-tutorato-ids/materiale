package org.ids.postmediator;

/** abbiamo due problemi:
 *  - ogni device deve conoscere gli altri due
 *  - la logica di accensione/spegnimento degli altri device è sparsa tra più classi
 *    - comportamento globale difficile da comprendere
 *    - comportamento globale difficile da modificare
 */
public class Client {
    public static void main( String[] args ) {
        Mediator m = new Mediator();

        Device tv = new SmartTv(m);
        Device gs = new GameStation(m);
        Device cc = new CronCast(m);

        m.setSmartTv(tv);
        m.setGameStation(gs);
        m.setCronCast(cc);

        gs.turnOn();    // should also turn on the tv
        cc.turnOn();    // should also turn off the gs
        tv.turnOff();   // should also turn off both the cc and the gs
    }
}
