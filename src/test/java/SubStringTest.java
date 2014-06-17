
public class SubStringTest {

	public static void main(String[] args) {
		
		String departmentName = "演艺九部:快乐宝贝:department_09";
		String departmentSuffix = departmentName.substring(departmentName.lastIndexOf(":")+1);
		System.out.println(departmentSuffix);
	}
}
