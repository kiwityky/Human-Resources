public class Manager extends Staff implements ICalculator {
    // Thuộc tính: chức danh
    double empPosition;
    int isManager;

    // Khởi tạo đối tượng
    Manager(String empID, String empName, int empAge, double empCoSal, String empFirstDay,
            int empHoliLeave, String empWorkingPart, double empPosition, int isManager) {
        this.empID = empID;
        this.empName = empName;
        this.empAge = empAge;
        this.empCoSal = empCoSal;
        this.empFirstDay = empFirstDay;
        this.empHoliLeave = empHoliLeave;
        this.empWorkingPart = empWorkingPart;
        this.empPosition = empPosition;
        this.isManager = isManager;
    }

    // Trả về lương quản lý
    public double calculateSalary(double empCoSal, double empPosition) {
        double salary = empCoSal * 5000000 + empPosition;
        return salary;
    }

    // Hiển thị thông tin bao gồm cả chức danh.
    void displayInformation() {
        String empPositionString = "";
        double empSalary = 0;
        if (empPosition == 1) {
            empPositionString = "Business Leader";
            empSalary = calculateSalary(empCoSal, 8000000);
        } else if (empPosition == 2) {
            empPositionString = "Project Leader";
            empSalary = calculateSalary(empCoSal, 5000000);
        } else if (empPosition == 3) {
            empPositionString = "Technical Leader";
            empSalary = calculateSalary(empCoSal, 6000000);
        }
        System.out.printf("%-20s%-30s%-10s%-20s%-20s%-20s%-30s%-35s%-20s", empID, "| " + empName,
                "| " + empAge, "| " + empCoSal, "| " + empFirstDay, "| " + empHoliLeave, "| " + empWorkingPart,
                "| " + empPositionString, "| " + String.format("%.2f", empSalary));
        System.out.println();
    }

}
