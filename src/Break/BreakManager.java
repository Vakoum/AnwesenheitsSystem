package Break;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import Shift.Shift;

public class BreakManager {
	
	
	BreakRetriever breakRetriever;
	BreakEditor breakEditor;
	
	public BreakManager() {
		breakRetriever = new BreakRetriever();
		breakEditor = new BreakEditor();
	}
	
	public void startBreak(Shift shift, List<Integer> activeBreakIDs) {
		if(shiftHasActiveBreak(shift, activeBreakIDs) == null) {
			Break _break = new Break(getLowestBreakID(), shift.getShiftID());
			_break.setBreakStart(LocalDateTime.now());
			breakEditor.insertEntity(_break);			
		}
	}
	public Integer endBreak(Shift shift, List<Integer> breakIDs) {
		Break _break = shiftHasActiveBreak(shift, breakIDs);
		if(_break != null) {
			_break.setBreakEnd(LocalDateTime.now());
			breakEditor.updateEntity(_break);
			return _break.getBreakID();
		}
		return null;
	}
	
	public Break shiftHasActiveBreak(Shift shift, List<Integer> activeBreakIDs) {
			for(Integer breakID : activeBreakIDs) {
				for(Break _break : breakRetriever.getEntitys()) {
					if(breakID == _break.getBreakID() && _break.getShiftID() == shift.getShiftID()) {
						return _break;
					}
				}
			}
		return null;
	}
	
	public int getLowestBreakID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Break _break : breakRetriever.getEntitys()) {
			if(_break.getBreakID() == id) {
				return true;
			}
		}
		return false;
	}
}
