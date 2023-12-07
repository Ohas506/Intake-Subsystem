// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  IntakeIO io;

 
  public IntakeSubsystem(IntakeIO io) {
    this.io = io;
   }

  public  CommandBase extendCommand() {
    return new InstantCommand(
        () -> {
          io.extend();
          io.stop();

        },
        this);
  }

  public  CommandBase reverseCommand() {
    return new InstantCommand(
        () -> {
          io.retract();
          io.stop();

        },this
       );
  }
  private void stop() {
   io.setPercentOut(0);

  }
  private void start() {
    io.setPercentOut(1);
 
   }


  public CommandBase outakeCommand() {
    return new RunCommand(
        () -> {
          io.outake();
          io.extend();

        },
        this);
  }

  public CommandBase stopCommand() {
    return new InstantCommand(
        () -> {
          this.stop();
          stop();
        },
        this);
  }
  public CommandBase startCommand() {
    return new InstantCommand(
        () -> {
          this.start();
          stop();
        },
        this);
  }

 

 

  @Override
  public void periodic() {
  
  }
}
