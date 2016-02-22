package tools.doma2.sample.entity;

import org.seasar.doma.jdbc.entity.*;

public class EmployeeEntityListener implements EntityListener<Employee> {
    public void	preDelete(Employee entity, PreDeleteContext<Employee> context) {
        System.out.println("EmployeeEntityListener::preDelete");
    }
    public void preInsert(Employee entity, PreInsertContext<Employee> context) {
        System.out.println("EmployeeEntityListener::preInsert");
    }
    public void preUpdate(Employee entity, PreUpdateContext<Employee> context) {
        System.out.println("EmployeeEntityListener::preUpdate");
    }
    public void postDelete(Employee entity, PostDeleteContext<Employee> context) {
        System.out.println("EmployeeEntityListener::postDelete");
    }
    public void postInsert(Employee entity, PostInsertContext<Employee> context) {
        System.out.println("EmployeeEntityListener::postInsert");
    }
    public void postUpdate(Employee entity, PostUpdateContext<Employee> context) {
        System.out.println("EmployeeEntityListener::postUpdate");
    }
}
