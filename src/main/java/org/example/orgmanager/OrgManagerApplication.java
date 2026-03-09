package org.example.orgmanager;

import org.example.orgmanager.domain.Department;
import org.example.orgmanager.domain.Employee;
import org.example.orgmanager.repository.DepartmentRepository;
import org.example.orgmanager.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrgManagerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrgManagerApplication.class, args);
        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        //부서 정보 저장
        Department d1 = new Department("인사팀", "2F");
        Department d2 = new Department("개발팀", "3F");

        departmentRepository.save(d1);
        departmentRepository.save(d2);

        //사원 정보 저장
        Employee e1 = new Employee("김지원", 7000, LocalDate.of(2018,3,9), d1);
        Employee e2 = new Employee("이주안", 3500, LocalDate.of(2024,5,3), d2);
        Employee e3 = new Employee("신효정", 5000, LocalDate.of(2019,12,15), d2);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);

        //모든 사원 정보 출력
        System.out.println("*****전체 사원 출력*****");
        List<Employee> allEmployee = employeeRepository.findAll();

        for (Employee employee : allEmployee) {
            System.out.println("사원 번호: " + employee.getId());
            System.out.println("사원 이름: " + employee.getName());
            System.out.println("급여: " + employee.getSalary());
            System.out.println("입사일: " + employee.getHireDate());
            System.out.println("부서 번호: " + employee.getDepartment().getId());
            System.out.println("부서 이름: " + employee.getDepartment().getName());
            System.out.println("부서 위치: " + employee.getDepartment().getLocation());
            System.out.println("********************");
        }

        // 검색 사원 정보 출력
        System.out.println("*****검색 사원 출력*****");
        List<Employee> result = employeeRepository.findByNameOrderBySalaryDesc("김지원");

        for (Employee employee : result) {
            System.out.println("사원 번호: " + employee.getId());
            System.out.println("사원 이름: " + employee.getName());
            System.out.println("급여: " + employee.getSalary());
            System.out.println("입사일: " + employee.getHireDate());
            System.out.println("부서 번호: " + employee.getDepartment().getId());
            System.out.println("부서 이름: " + employee.getDepartment().getName());
            System.out.println("부서 위치: " + employee.getDepartment().getLocation());
            System.out.println("********************");
        }
    }
}
