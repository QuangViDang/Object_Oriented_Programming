package QuanLyNhanSuPhenikaa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees;
    private Scanner scanner;
  
    public EmployeeManager() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
  
    // Thêm nhân viên
    public void addEmployee() {
        System.out.println("Nhập thông tin nhân viên:");
        int id = getNextId();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (dd/mm/yyyy): ");
        Date dob = DateUtil.parseDate(scanner.nextLine());
        System.out.print("Vị trí công việc: ");
        String position = scanner.nextLine();
        System.out.print("Ngày vào làm (dd/mm/yyyy): ");
        Date startDate = DateUtil.parseDate(scanner.nextLine());
        System.out.print("Mức lương: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
  
        Employee employee = new Employee(id, name, dob, position, startDate, salary);
        employees.add(employee);
    }
  
    // Sửa thông tin nhân viên
    public void editEmployee() {
        System.out.print("Nhập ID của nhân viên cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
  
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên có ID là " + id);
            return;
        }
  
        System.out.println("Thông tin nhân viên:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Tên: " + employee.getName());
        System.out.println("Ngày sinh: " + DateUtil.formatDate(employee.getDob()));
        System.out.println("Vị trí công việc: " + employee.getPosition());
        System.out.println("Ngày vào làm: " + DateUtil.formatDate(employee.getStartDate()));
        System.out.println("Mức lương: " + employee.getSalary());
  
        System.out.println("Nhập thông tin mới:");
        System.out.print("Tên (" + employee.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (" + DateUtil.formatDate(employee.getDob()) + "): ");
        Date dob = DateUtil.parseDate(scanner.nextLine(), employee.getDob());
        System.out.print("Vị trí công việc (" + employee.getPosition() + "): ");
        String position= scanner.nextLine();
        System.out.print("Ngày vào làm (" + DateUtil.formatDate(employee.getStartDate()) + "): ");
        Date startDate = DateUtil.parseDate(scanner.nextLine(), employee.getStartDate());
        System.out.print("Mức lương (" + employee.getSalary() + "): ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
  
        employee.setName(name);
        employee.setDob(dob);
        employee.setPosition(position);
        employee.setStartDate(startDate);
        employee.setSalary(salary);
  
        System.out.println("Thông tin nhân viên đã được cập nhật.");
    }
  
    // Xoá thông tin nhân viên
    public void deleteEmployee() {
        System.out.print("Nhập ID của nhân viên cần xoá: ");
        int id = scanner.nextInt();
        scanner.nextLine();
  
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên có ID là " + id);
            return;
        }
  
        System.out.println("Thông tin nhân viên:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Tên: " + employee.getName());
        System.out.println("Ngày sinh: " + DateUtil.formatDate(employee.getDob()));
        System.out.println("Vị trí công việc: " + employee.getPosition());
        System.out.println("Ngày vào làm: " + DateUtil.formatDate(employee.getStartDate()));
        System.out.println("Mức lương: " + employee.getSalary());
  
        System.out.print("Nhập password để xoá thông tin nhân viên: ");
        String password = scanner.nextLine();
        if (!password.equals("password")) {
            System.out.println("Password không đúng.");
            return;
        }
  
        employees.remove(employee);
        System.out.println("Thông tin nhân viên đã được xoá.");
    }
  
    // Xem danh sách nhân viên
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Không có nhân viên nào.");
            return;
        }
  
        System.out.println("Danh sách nhân viên:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId());
            System.out.println("Tên: " + employee.getName());
            System.out.println("Ngày sinh: " + DateUtil.formatDate(employee.getDob()));
            System.out.println("Vị trí công việc: " + employee.getPosition());
            System.out.println("Ngày vào làm: " + DateUtil.formatDate(employee.getStartDate()));
            System.out.println("Mức lương: " + employee.getSalary());
            System.out.println();
        }
    }
  
    // Sắp xếp danh sách nhân viên theo tên
    public void sortEmployeesByName() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
    }
  
    // Sắp xếp danh sách nhân viên theo công việc
    public void sortEmployeesByPosition() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getPosition().compareTo(e2.getPosition());
            }
        });
    }
  
    // Sắp xếp danh sách nhân viên theo ID
    public void sortEmployeesById() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getId() - e2.getId();
            }
        });
    }
  
    // Sắp xếp danh sách nhân viên theo năm sinh
    public void sortEmployeesByDob() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getDob().compareTo(e2.getDob());
            }
        });
    }
  
    // Tìm nhân viên theo ID
    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
  
    // Lấy ID tiếp theo để thêm nhân viên
    private int getNextId() {
        if (employees.isEmpty()) {
            return 1;
        }
        int maxId = employees.get(0).getId();
        for (Employee employee : employees) {
            if (employee.getId() > maxId) {
                maxId = employee.getId();
            }
        }
        return maxId + 1;
    }
}