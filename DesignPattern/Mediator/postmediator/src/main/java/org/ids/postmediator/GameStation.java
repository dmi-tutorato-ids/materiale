package org.ids.postmediator;

// ConcreteColleague
public class GameStation implements Device {
	Mediator m;
	boolean isOn = false;

	public GameStation(Mediator m) {
		this.m = m;
	}

	@Override
	public void turnOn() {
		System.out.println(" - Turning GameStation ON");
		isOn = true;
		m.gameStationTurnedOn();
	}

	@Override
	public void turnOff() {
		System.out.println(" - Turning GameStation OFF");
		isOn = false;
		m.gameStationTurnedOff();
	}

	@Override
	public boolean isOn() {
		return isOn;
	}

}
