package model.disasters;

import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CitizenAlreadyDeadException;
import exceptions.DisasterException;
import model.people.Citizen;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Disaster implements Simulatable{
	private int startCycle;
	private Rescuable target;
	private boolean active;
	public Disaster(int startCycle, Rescuable target) {
		this.startCycle = startCycle;
		this.target = target;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getStartCycle() {
		return startCycle;
	}
	public Rescuable getTarget() {
		return target;
	}
	public void strike() throws DisasterException
	{
		//try {
			target.struckBy(this);
			active=true;
			/*if(this.target instanceof Citizen)
				throw new CitizenAlreadyDeadException(this, "Citizen is already dead.");
			else {
				throw new BuildingAlreadyCollapsedException(this, "Building is already collapsed.");
			}
			
		}
		catch(DisasterException e) {
			System.out.println(e.getMessage());
		}*/
	}
}
