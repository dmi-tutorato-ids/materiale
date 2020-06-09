package org.ids.postmediator;

/** abbiamo risolto due problemi:
 *  - ogni device conosce solo il Mediator (il mediator conosce tutti)
 *  - la logica di accensione/spegnimento è ora nel mediator
 *    - ogni colleague incarica il mediator di avvisare gli altri colleague
 *    - comportamento globale è più facile da modificare
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
