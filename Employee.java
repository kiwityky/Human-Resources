public class Employee extends Staff implements ICalculator {
    // Thuộc tính: số giờ làm thêm
    double empOTTime;
    int isManager;

    // Khởi tạo đối tượng
    Employee(String empID, String empName, int empAge, double empCoSal, String empFirstDay,
            int empHoliLeave, String empWorkingPart, double empOTTime, int isManager) {
        this.empID = empID;
        this.empName = empName;
        this.empAge = empAge;
        this.empCoSal = empCoSal;
        this.empFirstDay = empFirstDay;
        this.empHoliLeave = empHoliLeave;
        this.empWorkingPart = empWorkingPart;
        this.empOTTime = empOTTime;
        this.isManager = isManager;
    }

    // Trả về lương nhân viên
    public double calculateSalary(double empCoSal, double empOTTime) {
        double salary = empCoSal * 3000000 + empOTTime * 200000;
        return salary;
    }

    // Trả về lương quản lý
    public double calculateSalaryS(double empCoSal, double empPosition) {
        if (empPosition == 1) {
            empPosition = 8000000;
        } else if (empPosition == 2) {
            empPosition = 5000000;
        } else if (empPosition == 3) {
            empPosition = 6000000;
        }
        double salary = empCoSal * 5000000 + empPosition;
        return salary;
    }

    // Hiển thị thông tin nhân viên.
    void displayInformation() {
        double empSalary = calculateSalary(empCoSal, empOTTime);

        System.out.printf("%-20s%-30s%-10s%-20s%-20s%-20s%-30s%-35s%-20s", empID, "| " + empName,
                "| " + empAge, "| " + empCoSal, "| " + empFirstDay, "| " + empHoliLeave, "| " + empWorkingPart,
                "| " + empOTTime, "| " + String.format("%.2f", empSalary));
        System.out.println();
    }
}
