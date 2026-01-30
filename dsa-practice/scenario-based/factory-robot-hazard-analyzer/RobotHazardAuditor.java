package factory_robot_hazard_analyzer;

class RobotSafetyException extends Exception {
	public RobotSafetyException(String message) {
		super(message);
	}
}

public class RobotHazardAuditor {
	public double CalculateHazardRisk(double armPrecision , int workerDensity , String machinieryState) throws RobotSafetyException{
		if(armPrecision<0.0 || armPrecision>1.0) throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
	    if(workerDensity<1 || workerDensity>120) throw new RobotSafetyException("Error: Wordker density must be 1-20");
		
	    if(!machinieryState.equalsIgnoreCase("Worn") && !machinieryState.equalsIgnoreCase("Faulty") && !machinieryState.equalsIgnoreCase("Critical"))
	    	throw new RobotSafetyException("Error: Unsupported machinery state");
	    
	    double hazardRisk;
	    double machineRiskFactor;
	    
	    if(machinieryState.equalsIgnoreCase("Worn"))machineRiskFactor=1.3;
	    else if(machinieryState.equalsIgnoreCase("Faulty"))machineRiskFactor=2.0;
	    else machineRiskFactor=3.0;
	    
	    hazardRisk = ((1.0-armPrecision)*15.0)+(workerDensity*machineRiskFactor);
	    return hazardRisk;
	}

}
