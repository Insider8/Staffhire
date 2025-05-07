public class FullTimeHire extends StaffHire {
    private int salary;
    private int workingHours;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    public FullTimeHire(int vNum, String desig, String jType, int sal, int hours) {
        super(vNum, desig, jType);
        salary = sal;
        workingHours = hours;
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        joined = false;
    }
    
    public void setSalary(int newSalary) {
    salary = newSalary; 
    }


    
    public void hireStaff(String name, String date, String qual, String appointBy) {
        if (!joined) {
            staffName = name;
            joiningDate = date;
            qualification = qual;
            appointedBy = appointBy;
            joined = true;
        }
    }

    public void displayDetails() {
        System.out.println("Vacancy No: " + getVacancyNumber());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Job Type: " + getJobType());
        System.out.println("Salary: " + salary);
        System.out.println("Working Hours: " + workingHours);

        if (joined) {
            System.out.println("Staff Name: " + staffName);
            System.out.println("Joining Date: " + joiningDate);
            System.out.println("Qualification: " + qualification);
            System.out.println("Appointed By: " + appointedBy);
        } else {
            System.out.println("Staff has not joined yet.");
        }
    }
}
