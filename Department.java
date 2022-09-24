public class Department {
    String depID;
    String depName;
    int numberOfEmp;

    // Khởi tạo đối tượng
    Department(String depID, String depName, int numberOfEmp) {
        this.depID = depID;
        this.depName = depName;
        this.numberOfEmp = numberOfEmp;
    }

    public String toString() {
        System.out.printf("%-25s%-25s%-25s", depID, "| " + depName, "| " + numberOfEmp);
        System.out.println();
        return "Completed";
    }
}
