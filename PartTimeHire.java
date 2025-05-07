public class PartTimeHire extends StaffHire {
    private int workingHours;
    private int wagePerHour;
    private String shift;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    private boolean terminated;

    public PartTimeHire(int vNum, String desig, String jType, int hours, int wage, String shiftTime) {
        super(vNum, desig, jType);
        workingHours = hours;
        wagePerHour = wage;
        shift = shiftTime;  
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        joined = false;
        terminated = false;
    }

    public void hireStaff(String name, String date, String qual, String appointBy) {
        if (!joined) {
            staffName = name;
            joiningDate = date;
            qualification = qual;
            appointedBy = appointBy;
            joined = true;
            terminated = false;
        }
        else {
            System.out.println("Staff is already hired.");
        }
    }

    public void terminateStaff() {
        if (joined && !terminated) {
            staffName = "";
            joiningDate = "";
            qualification = "";
            appointedBy = "";
            joined = false;
            terminated = true;
            System.out.println("Staff has been terminated.");
        } 
        else {
            System.out.println("No staff to terminate or already terminated.");
        }
    }

    public void updateShift(String newShift) {
        if (!joined) {
            shift = newShift;
            System.out.println("Shift updated.");
        } 
        else {
            System.out.println("Cannot update shift after staff has joined.");
        }
    }
    
    public void setShifts(String newShift) {
    shift = newShift;  // Directly use the instance variable without 'this'
    }


    public void displayDetails() {
        System.out.println("Vacancy Number: " + getVacancyNumber());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Job Type: " + getJobType());
        System.out.println("Working Hours: " + workingHours);
        System.out.println("Wage Per Hour: " + wagePerHour);
        System.out.println("Shift: " + shift);
        
        if (joined) {
            System.out.println("Staff Name: " + staffName);
            System.out.println("Joining Date: " + joiningDate);
            System.out.println("Qualification: " + qualification);
            System.out.println("Appointed By: " + appointedBy);
            System.out.println("Joined: Yes");
            System.out.println("Terminated: No");
        } 
        else if (terminated) {
            System.out.println("Joined: No");
            System.out.println("Terminated: Yes");
        } 
        else {
            System.out.println("Staff has not yet been hired.");
        }
    }
}
