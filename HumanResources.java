import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class HumanResources {

    // Phương thức in header dùng chung
    public static void printFormat() {
        System.out.printf("%-20s%-30s%-10s%-20s%-20s%-20s%-30s%-35s%-20s", "Mã nhân viên", "| Tên nhân viên",
                "| Tuổi", "| HS Lương", "| Ngày vào làm", "| Ngày nghỉ phép", "| Bộ phận",
                "| Số giờ làm thêm/Chức vụ", "| Lương");
        System.out.println();
    }

    // Phương thức tìm kiếm tên - tính năng 5
    public static void searchMethod1(ArrayList<Employee> employee, String option) {
        // Lặp qua toàn mảng để hiện danh sách
        Employee empAL;
        // Hiển thị nhân viên thường trước
        for (int i = 0; i < employee.size(); i++) {
            empAL = employee.get(i);
            Employee empManage = new Employee(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                    empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                    empAL.isManager);
            if (empManage.isManager == 0 && empManage.empName.contains(option)) {
                empManage.displayInformation();
            } else {
                continue;
            }
        }
        // Hiển thị nhân viên quản lý sau
        for (int i = 0; i < employee.size(); i++) {
            empAL = employee.get(i);
            Manager empManage = new Manager(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                    empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                    empAL.isManager);
            if (empManage.isManager == 1 && empManage.empName.contains(option)) {
                empManage.displayInformation();
            } else {
                continue;
            }
        }
    }

    // Phương thức tìm kiếm ID - tính năng 5
    public static void searchMethod2(ArrayList<Employee> employee, String option) {
        // Lặp qua toàn mảng để hiện danh sách
        Employee empAL;
        // Hiển thị nhân viên thường trước
        for (int i = 0; i < employee.size(); i++) {
            empAL = employee.get(i);
            Employee empManage = new Employee(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                    empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                    empAL.isManager);
            if (empManage.isManager == 0 && empManage.empID.contains(option)) {
                empManage.displayInformation();
            } else {
                continue;
            }
        }
        // Hiển thị nhân viên quản lý sau
        for (int i = 0; i < employee.size(); i++) {
            empAL = employee.get(i);
            Manager empManage = new Manager(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                    empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                    empAL.isManager);
            if (empManage.isManager == 1 && empManage.empID.contains(option)) {
                empManage.displayInformation();
            } else {
                continue;
            }
        }
    }

    // Phương thức tạo mảng chứa giá trị lương của tất cả nhân viên - tính năng 6,7
    public static ArrayList<Double> createSalaries(ArrayList<Employee> employee) {
        // Header
        System.out.println("Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần");
        printFormat();
        // Sắp xếp bảng lương
        ArrayList<Double> salaries = new ArrayList<Double>();
        Employee empAL1;

        for (int i = 0; i < employee.size(); i++) {
            empAL1 = employee.get(i);
            if (empAL1.isManager == 0) {
                salaries.add(empAL1.calculateSalary(empAL1.empCoSal, empAL1.empOTTime));
            } else if (empAL1.isManager == 1) {
                salaries.add(empAL1.calculateSalaryS(empAL1.empCoSal, empAL1.empOTTime));
            }
        }
        return salaries;
    }

    // Phương thức in ra bảng kết quả - tính năng 6,7
    public static void resultSalaries(ArrayList<Employee> employee, ArrayList<Double> salaries) {
        // Tạo một danh sách mảng mới theo bảng lương đã sắp
        ArrayList<Employee> empSorted = new ArrayList<Employee>();
        Employee empAL2;
        Employee empAL;
        // Clone employee
        ArrayList<Employee> cloneEmployee = new ArrayList<Employee>();
        cloneEmployee = (ArrayList<Employee>) employee.clone();
        for (int j = 0; j < salaries.size(); j++) {
            for (int i = 0; i < cloneEmployee.size(); i++) {
                empAL2 = cloneEmployee.get(i);
                // Chỉ cần giá trị trong mảng lương đã sắp
                // bằng với 1 trong 2 điều kiện thì sẽ add
                // nhân viên vào danh sách được sắp xếp -empSorted
                boolean condition1 = (salaries.get(j) == empAL2.calculateSalary(empAL2.empCoSal,
                        empAL2.empOTTime));
                boolean condition2 = (salaries.get(j) == empAL2.calculateSalaryS(empAL2.empCoSal,
                        empAL2.empOTTime));
                if (condition1 || condition2) {
                    empSorted.add(empAL2);
                    cloneEmployee.remove(i);
                    break;
                }
            }
        }
        // In ra
        for (int i = 0; i < empSorted.size(); i++) {
            empAL = empSorted.get(i);
            if (empAL.isManager == 0) {
                Employee empManage = new Employee(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                        empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                        empAL.isManager);
                empManage.displayInformation();
            } else {
                Manager empManage = new Manager(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                        empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                        empAL.isManager);
                empManage.displayInformation();
            }
        }
        salaries.clear();
        empSorted.clear();
    }

    // Hàm main chạy chương trình
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in, "UTF-8");
        ArrayList<Integer> department = new ArrayList<Integer>();
        ArrayList<Employee> employee = new ArrayList<Employee>();
        while (true) {
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
            System.out.println("2. Hiển thị các bộ phận trong công ty.");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
            System.out.println("4. Thêm nhân viên mới vào công ty.");
            System.out.println("5. Tìm kiếm nhân viên theo tên hoặc mã nhân viên.");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
            System.out.println("0. Thoát chương trình.");
            System.out.print("Lựa chọn của bạn: ");
            // Lựa chọn đầu tiên - các tính năng của chương trình
            int choice1st = sc.nextInt();
            // Tính năng 1
            if (choice1st == 1) {
                // In bảng danh sách nhân viên
                // Header
                printFormat();
                for (int i = 0; i < 200; i++) {
                    System.out.print("-");
                }
                System.out.println();
                // Body
                // Lặp qua toàn mảng để hiện danh sách
                Employee empAL;
                // Hiển thị nhân viên thường trước
                for (int i = 0; i < employee.size(); i++) {
                    empAL = employee.get(i);
                    Employee empManage = new Employee(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                            empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                            empAL.isManager);
                    if (empManage.isManager == 0) {
                        empManage.displayInformation();
                    } else {
                        continue;
                    }
                }
                // Hiển thị nhân viên quản lý sau
                for (int i = 0; i < employee.size(); i++) {
                    empAL = employee.get(i);
                    Manager empManage = new Manager(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                            empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                            empAL.isManager);
                    if (empManage.isManager == 1) {
                        empManage.displayInformation();
                    } else {
                        continue;
                    }
                }
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 2
            else if (choice1st == 2) {
                // Số lượng nhân viên trong các bộ phận
                int HC = Collections.frequency(department, 1);
                int IT = Collections.frequency(department, 2);
                int MKT = Collections.frequency(department, 3);
                // In bảng bộ phận
                System.out.printf("%-25s%-25s%-25s", "Mã bộ phận", "| Tên bộ phận", "| Số lượng nhân viên hiện tại\n");
                Department depManage1 = new Department("HC", "Hành chính nhân sự", HC);
                depManage1.toString();
                Department depManage2 = new Department("IT", "Công nghệ thông tin", IT);
                depManage2.toString();
                Department depManage3 = new Department("MKT", "Marketing", MKT);
                depManage3.toString();
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 3
            else if (choice1st == 3) {
                String[] depArrays = { "Hành chính nhân sự", "Công nghệ thông tin", "Marketing" };
                for (String depArray : depArrays) {
                    // Header
                    System.out.println(depArray);
                    for (int i = 0; i < 50; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
                    printFormat();
                    // Body
                    // Lặp qua toàn mảng để hiện danh sách
                    Employee empAL;
                    // Hiển thị nhân viên thường trước
                    for (int i = 0; i < employee.size(); i++) {
                        empAL = employee.get(i);
                        Employee empManage = new Employee(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                                empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                                empAL.isManager);
                        if (empManage.isManager == 0 && empManage.empWorkingPart.equals(depArray)) {
                            empManage.displayInformation();
                        } else {
                            continue;
                        }
                    }
                    // Hiển thị nhân viên quản lý sau
                    for (int i = 0; i < employee.size(); i++) {
                        empAL = employee.get(i);
                        Manager empManage = new Manager(empAL.empID, empAL.empName, empAL.empAge, empAL.empCoSal,
                                empAL.empFirstDay, empAL.empHoliLeave, empAL.empWorkingPart, empAL.empOTTime,
                                empAL.isManager);
                        if (empManage.isManager == 1 && empManage.empWorkingPart.equals(depArray)) {
                            empManage.displayInformation();
                        } else {
                            continue;
                        }
                    }
                    System.out.println();
                }
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 4
            else if (choice1st == 4) {
                System.out.println("1. Thêm nhân viên thông thường.");
                System.out.println("2. Thêm nhân viên cấp quản lý (có thêm chức vụ).");
                System.out.print("Bạn chọn: ");
                // Lựa chọn thứ 2 - khi thêm nhân viên với 2 trường hợp
                int choice2nd = sc.nextInt();
                if (choice2nd == 1) {
                    System.out.print("Nhập mã nhân viên: ");
                    String empID = sc.next();
                    System.out.print("Nhập tên nhân viên: ");
                    // Vì sc.nextLine là một \n nên phải dùng thêm một sc.next() để sử dụng được
                    String partOfEmpName = sc.next();
                    String empName = sc.nextLine();
                    empName = partOfEmpName + empName;
                    System.out.print("Nhập tuổi nhân viên: ");
                    int empAge = sc.nextInt();
                    System.out.print("Nhập hệ số lương của nhân viên: ");
                    double empCoSal = sc.nextDouble();
                    System.out.print("Nhập ngày vào làm của nhân viên: ");
                    String empFirstDay = sc.next();
                    System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                    int empHoliLeave = sc.nextInt();
                    System.out.println("1. HC - Hành chính nhân sự");
                    System.out.println("2. IT - Công nghệ thông tin");
                    System.out.println("3. MKT - Marketing");
                    System.out.print("Bạn chọn bộ phận: ");
                    // Lựa chọn thứ 3 - bộ phận
                    int choice3rd = sc.nextInt();

                    // Xác định bộ phận
                    String empWorkingPart = "";
                    if (choice3rd == 1) {
                        empWorkingPart = "Hành chính nhân sự";
                    } else if (choice3rd == 2) {
                        empWorkingPart = "Công nghệ thông tin";
                    } else if (choice3rd == 3) {
                        empWorkingPart = "Marketing";
                    }

                    // Lựa chọn số giờ tăng ca
                    System.out.print("Nhập số giờ làm thêm: ");
                    double empOTTime = sc.nextDouble();
                    // Biến tự thêm để xác định nhân viên hay quản lý
                    int isManager = 0;
                    // Thêm bộ phận vào AL department
                    department.add(choice3rd);
                    // Thêm nhân viên thường vào AL
                    Employee emp = new Employee(empID, empName, empAge, empCoSal, empFirstDay, empHoliLeave,
                            empWorkingPart, empOTTime, isManager);
                    employee.add(emp);
                    System.out.println("Bạn đã thêm nhân viên thường thành công!!!");
                } else if (choice2nd == 2) {
                    System.out.print("Nhập mã nhân viên: ");
                    String empID = sc.next();
                    System.out.print("Nhập tên nhân viên: ");
                    // Vì sc.nextLine là một \n nên phải dùng thêm một sc.next() để sử dụng được
                    String partOfEmpName = sc.next();
                    String empName = sc.nextLine();
                    empName = partOfEmpName + empName;
                    System.out.print("Nhập tuổi nhân viên: ");
                    int empAge = sc.nextInt();
                    System.out.print("Nhập hệ số lương của nhân viên: ");
                    double empCoSal = sc.nextDouble();
                    System.out.print("Nhập ngày vào làm của nhân viên: ");
                    String empFirstDay = sc.next();
                    System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                    int empHoliLeave = sc.nextInt();

                    System.out.println("1. HC - Hành chính nhân sự");
                    System.out.println("2. IT - Công nghệ thông tin");
                    System.out.println("3. MKT - Marketing");
                    System.out.print("Bạn chọn bộ phận: ");
                    // Lựa chọn thứ 3 - bộ phận
                    int choice3rd = sc.nextInt();

                    // Xác định bộ phận
                    String empWorkingPart = "";
                    if (choice3rd == 1) {
                        empWorkingPart = "Hành chính nhân sự";
                    } else if (choice3rd == 2) {
                        empWorkingPart = "Công nghệ thông tin";
                    } else if (choice3rd == 3) {
                        empWorkingPart = "Marketing";
                    }

                    // Lựa chọn chức danh
                    System.out.println("Chức danh:");
                    System.out.println("1. Business Leader");
                    System.out.println("2. Project Leader");
                    System.out.println("3. Technical Leader");
                    System.out.print("Nhập chức danh: ");
                    int empPosition = sc.nextInt();
                    // Biến tự thêm để xác định nhân viên hay quản lý
                    int isManager = 1;
                    // Thêm bộ phận vào AL department
                    department.add(choice3rd);
                    // Thêm nhân viên quản lý vào AL
                    Employee emp = new Employee(empID, empName, empAge, empCoSal, empFirstDay, empHoliLeave,
                            empWorkingPart, empPosition, isManager);
                    employee.add(emp);
                    System.out.println("Bạn đã thêm nhân viên cấp quản lý thành công!!!\n");
                }
                for (int i = 0; i < 200; i++) {
                    System.out.print("-");
                }
                System.out.println();
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 5
            else if (choice1st == 5) {
                System.out.println("1. Tìm nhân viên bằng tên.");
                System.out.println("2. Tìm nhân viên bằng mã nhân viên.");
                System.out.print("Bạn chọn: ");
                int choice4th = sc.nextInt();
                String name;
                String ID;
                System.out.println();
                if (choice4th == 1) {
                    System.out.println("Nhập tên nhân viên cần tìm: ");
                    name = sc.next();
                    printFormat();
                    searchMethod1(employee, name);
                    System.out.println();
                } else if (choice4th == 2) {
                    System.out.println("Nhập mã nhân viên cần tìm: ");
                    ID = sc.next();
                    printFormat();
                    searchMethod2(employee, ID);
                    System.out.println();
                }
                // Footer
                for (int i = 0; i < 200; i++) {
                    System.out.print("-");
                }
                System.out.println();
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 6
            else if (choice1st == 6) {
                // Tạo mảng chứa lương nhân viên
                ArrayList<Double> salaries = createSalaries(employee);
                // Thuật toán sắp xếp lương giảm dần
                Collections.sort(salaries, (o1, o2) -> o2.compareTo(o1));
                // Chạy kết quả
                resultSalaries(employee, salaries);
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 7
            else if (choice1st == 7) {
                // Tạo mảng chứa lương nhân viên
                ArrayList<Double> salaries = createSalaries(employee);
                // Thuật toán sắp xếp lương tăng dần
                Collections.sort(salaries, (o1, o2) -> o1.compareTo(o2));
                // Chạy kết quả
                resultSalaries(employee, salaries);
                // Mở lại menu ban đầu
                continue;
            }
            // Tính năng 0
            else if (choice1st == 0) {
                break;
            }
        }
        sc.close();
    }
}
