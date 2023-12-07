package frc.robot.subsystems.Intake;


public interface IntakeIO {
    public static class IntakeIOInputs {
        public boolean isExtended = false;
        public double speedRPS = 0;
        public double percentOut = 0;
        public double currentAmps = 0;
      }
    
      public abstract IntakeIOInputs updateInputs();
    
      public abstract void extend();
      public abstract void stop();
      public abstract void outake();
      public abstract void retract();
    
      public abstract void setPercentOut(double percentOut);
    }
