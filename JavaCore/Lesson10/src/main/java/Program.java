import controller.DepartmentController;
import entity.Department;

import java.util.List;

public class Program {
    public static void main(String[] args) throws Exception {
        DepartmentController departmentController = new DepartmentController();

        List<Department> departments = departmentController.getAllDepartments();
        departments.forEach(department -> System.out.println(department));
//
        Department department = departmentController.getDepartmentById(1);
        System.out.println(department.getName());

//        Department department = new Department("Language AI");
//        System.out.println(departmentController.createDepartment(department));

//        Department departmentUpadte = new Department("dasd");
//        System.out.println(departmentController.updateDepartment(1,departmentUpadte));D
//        boolean departmentDelete = departmentController.deleteDepartment(3);
//        System.out.println(departmentController.deleteDepartment(3));
    }
}