package frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenixpro.hardware.TalonFX;



 
public class IntakeReal implements IntakeIO{
   private final TalonFX motor = new TalonFX(Constants.intakeID);
   private final DoubleSolenoid piston = new DoubleSolenoid( PneumaticsModuleType.REVPH,
   Constants.intakeSolenoidForwardID,
   Constants.intakeSolenoidBackwardID);

   


    
    @Override
    public IntakeIOInputs updateInputs() {
        
    
        IntakeIOInputs inputs = new IntakeIOInputs();
       inputs.speedRPS = motor.getVelocity().getValue();
       inputs .currentAmps = motor.getTorqueCurrent().getValue();
       inputs.percentOut = motor.getSupplyVoltage().getValue();
       return inputs;

    }

    @Override
    public void extend() {
        piston.set(Value.kForward);
        this.setPercentOut(-1.0);
        
    }
    @Override
    public void outake() {
        piston.set(Value.kForward);
        this.setPercentOut(-1.0);
        
    }
    @Override
    public void retract() {
        piston.set(Value.kReverse);
        this.setPercentOut(1.0);
        
    }
    @Override
    public void stop(){ 
        this.setPercentOut(0);
      }

    @Override
    public void setPercentOut(double percentOut) {
     motor.set(1);
    
   
        
    }
    
}
