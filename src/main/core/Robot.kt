package org.example


import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.CommandScheduler

class Robot : TimedRobot() {

    private lateinit var robotContainer: RobotContainer
    private var autonomousCommand: Command? = null

    override fun robotInit() {
        robotContainer = RobotContainer()
    }

    override fun robotPeriodic() {
        CommandScheduler.getInstance().run()
    }

    override fun autonomousInit() {
        autonomousCommand = robotContainer.autonomousCommand
        autonomousCommand?.schedule()
    }

    override fun teleopInit() {
        autonomousCommand?.cancel()
    }
}
