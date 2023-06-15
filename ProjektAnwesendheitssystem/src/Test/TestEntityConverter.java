package Test;
import PreOrganized.*;

public class TestEntityConverter {

	public static void main(String[] args) {
		EmployeeConverter converter = new EmployeeConverter();
		System.out.println(converter.getEntitys().get(1).getEmployeeID());
	}

}
