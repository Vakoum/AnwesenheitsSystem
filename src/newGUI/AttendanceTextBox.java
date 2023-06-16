package newGUI;

import java.time.LocalDateTime;

import Shift.*;

public class AttendanceTextBox {
	WindowStateMachine stateMachine;
	ShiftManager shiftManager ;
	public AttendanceTextBox(WindowStateMachine stateMachine) {
		this.stateMachine = stateMachine;
		shiftManager = stateMachine.getShiftManager();
	}
	public String setText() {
		Shift shift = shiftManager.employeeHasActiveShift(stateMachine.getCurrentEmployee());
		String text = "";
		text += "Schicht start: " + LocalDateTime.now();
		return text;
	}
}
