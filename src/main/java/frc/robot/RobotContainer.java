package frc.robot;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Intake.IntakeReal;
import frc.robot.subsystems.Intake.IntakeSubsystem;
public class RobotContainer {
IntakeSubsystem intakeSubsystem = new IntakeSubsystem(
  new IntakeReal()  
);
private final CommandXboxController controller =
    new CommandXboxController(OperatorConstants.driverControllerPort); 
private final CommandXboxController operator =
    new CommandXboxController(OperatorConstants.operatorControllerPort);
private void ControllerBindings(){
controller
.rightStick()
.whileTrue(
intakeSubsystem.reverseCommand()
);

controller
.leftStick()
.whileTrue(
intakeSubsystem.extendCommand()
);

controller
.rightBumper()
.whileTrue(
intakeSubsystem.outakeCommand()
);

controller
.leftTrigger()
.whileTrue(
intakeSubsystem.startCommand()
);

controller
.rightTrigger()
.whileTrue(
intakeSubsystem.stopCommand()
);
}


      }