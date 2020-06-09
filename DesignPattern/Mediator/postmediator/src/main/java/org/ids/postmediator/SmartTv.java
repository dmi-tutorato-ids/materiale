package org.ids.postmediator;

// ConcreteColleague
public class SmartTv implements Device {
	Mediator m;
	boolean isOn = false;

	public SmartTv(Mediator m) {
		this.m = m;
	}

	@Override
	public void turnOn() {
		System.out.println(" - Turning SmartTv ON");
		isOn = true;
		m.smartTvTurnedOn();
	}

	@Override
	public void turnOff() {
		System.out.println(" - Turning SmartTv OFF");
		isOn = false;
		m.smartTvTurnedOff();
	}

	@Override
	public boolean isOn() {
		return isOn;
	}

}
