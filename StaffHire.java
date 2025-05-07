public class StaffHire {
    private int vacancyNumber;
    private String designation;
    private String jobType;

    public StaffHire(int vNum, String desig, String jType) {
        vacancyNumber = vNum;
        designation = desig;
        jobType = jType;
    }

    public int getVacancyNumber() {
        return vacancyNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setVacancyNumber(int vNum) {
        vacancyNumber = vNum;
    }

    public void setDesignation(String desig) {
        designation = desig;
    }

    public void setJobType(String jType) {
        jobType = jType;
    }
}
