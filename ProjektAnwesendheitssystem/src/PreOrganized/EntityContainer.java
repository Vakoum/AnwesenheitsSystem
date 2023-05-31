package PreOrganized;

import java.util.ArrayList;
import java.util.List;

public class EntityContainer<T> {
	private List<T> entityList;
	
	public EntityContainer() {
		entityList = new ArrayList<T>();
	}
	public void setEmployeeList(List<T> entityList) {
		this.entityList = entityList;
	}
	public List<T> getEmployeeList(){
		return entityList;
	}
}
