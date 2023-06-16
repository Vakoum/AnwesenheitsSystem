package Shift;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Break.Break;
import Break.BreakManager;
import Employee.Employee;

public class ShiftManager {
	private List<Integer> activeShiftIDs;
	private List<Integer> activeBreakIDs;
	
	private BreakManager breakManager;
	
	private ShiftRetriever shiftRetriever;
	private ShiftEditor shiftEditor;
		
	public ShiftManager() {
		activeShiftIDs = new ArrayList<Integer>();
		activeBreakIDs = new ArrayList<Integer>();

		shiftRetriever = new ShiftRetriever();
		shiftEditor = new ShiftEditor();
		breakManager = new BreakManager();
	}
	
	public void startShift(Employee employee) {
		if(employeeHasActiveShift(employee) == null) {
			Shift shift = new Shift(getLowestShiftID(), employee.getEmployeeID());
			shift.setShiftStart(LocalDateTime.now());
			activeShiftIDs.add(shift.getShiftID());
			shiftEditor.insertEntity(shift);										
		}
	}
	
	public void endShift(Employee employee) {
		Shift shift = employeeHasActiveShift(employee);
		System.out.println("test ");
		if(shift != null) {
			shift.setShiftEnd(LocalDateTime.now());
			shiftEditor.updateEntity(shift);
			activeShiftIDs.remove(shift.getShiftID());
		}
	}
	
	public void startBreak(Employee employee) {
		Shift shift = employeeHasActiveShift(employee);
		if(shift != null) {
			activeBreakIDs.add(breakManager.getLowestBreakID());
			breakManager.startBreak(shift, activeBreakIDs);
			
		}
	}
	public void endBreak(Employee employee) {
		Shift shift = employeeHasActiveShift(employee);
		if(shift != null) {
			Integer breakID = breakManager.endBreak(shift, activeBreakIDs);
			if(breakID != null) {
				activeBreakIDs.remove(breakID);
			}
		}
	}
	

	
	
	public int getLowestShiftID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Shift shift : shiftRetriever.getEntitys()) {
			if(shift.getShiftID() == id) {
				return true;
			}
		}
		return false;
	}
	
	public Shift employeeHasActiveShift(Employee employee) {
		for(Integer shiftID : activeShiftIDs) {
			for(Shift shift : shiftRetriever.getEntitys()) {
				if(shift.getShiftID() == shiftID && employee.getEmployeeID() == shift.getEmployeeID()) {
					return shift;
				}
			}
		}
		return null;
	}
	
	public Break getShiftHasActiveBreak(Employee employee) {
		Shift shift = employeeHasActiveShift(employee);
		if(shift != null) {
			return breakManager.shiftHasActiveBreak(shift, activeBreakIDs);
		}
		return null;
	}
}