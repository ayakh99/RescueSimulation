package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import exceptions.SimulationException;
import exceptions.UnitException;
import model.disasters.Infection;
import model.disasters.Injury;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle, WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}

	@Override
	public void treat() {
		getTarget().getDisaster().setActive(false);

		Citizen target = (Citizen) getTarget();
		if (target.getHp() == 0) {
			jobsDone();
			return;
		} else if (target.getBloodLoss() > 0) {
			target.setBloodLoss(target.getBloodLoss() - getTreatmentAmount());
			if (target.getBloodLoss() == 0)
				target.setState(CitizenState.RESCUED);
		}

		else if (target.getBloodLoss() == 0)

			heal();

	}

	/*public void respond(Rescuable r) throws UnitException {
		if(r instanceof Citizen && !canTreat(r)) {
			throw new CannotTreatException(this, r, "Target is already safe.");
		}
		
		if (!isTargetCompatible(r)) {
			throw new IncompatibleTargetException(this, r, "Target cannot be treated by this unit. Please select another unit.");
		}
		
		if (r instanceof Citizen && !(r.getDisaster() instanceof Injury)) {
			throw new CannotTreatException(this, r, "Target cannot be treated by this unit. Please select another unit.");
		}
		
		if (getTarget() != null && ((Citizen) getTarget()).getBloodLoss() > 0 && getState() == UnitState.TREATING)
			reactivateDisaster();
		finishRespond(r);
	}*/
}
