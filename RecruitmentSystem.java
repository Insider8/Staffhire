import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecruitmentSystem {
    private JFrame frame;
    private JTextField txtVacancyNo, txtDesignation, txtJobType, txtName, txtDate, txtQual, txtAppointed,
            txtSalary, txtHours, txtWages, txtWorkingHrs, txtShifts, txtDisplayIndex;
    private JButton btnAddFull, btnAddPart, btnSetSalary, btnSetShift, btnTerminate, btnDisplay, btnClear;

    private ArrayList<StaffHire> staffList;

    public RecruitmentSystem() {
        frame = new JFrame("Recruitment System");
        frame.setLayout(new GridLayout(18, 2));

        staffList = new ArrayList<>();

        // Input fields
        txtVacancyNo = new JTextField();
        txtDesignation = new JTextField();
        txtJobType = new JTextField();
        txtName = new JTextField();
        txtDate = new JTextField();
        txtQual = new JTextField();
        txtAppointed = new JTextField();
        txtSalary = new JTextField();
        txtHours = new JTextField();
        txtWages = new JTextField();
        txtWorkingHrs = new JTextField();
        txtShifts = new JTextField();
        txtDisplayIndex = new JTextField();

        // Adding labels and fields to frame
        frame.add(new JLabel("Vacancy Number:")); frame.add(txtVacancyNo);
        frame.add(new JLabel("Designation:")); frame.add(txtDesignation);
        frame.add(new JLabel("Job Type:")); frame.add(txtJobType);
        frame.add(new JLabel("Staff Name:")); frame.add(txtName);
        frame.add(new JLabel("Joining Date:")); frame.add(txtDate);
        frame.add(new JLabel("Qualification:")); frame.add(txtQual);
        frame.add(new JLabel("Appointed By:")); frame.add(txtAppointed);
        frame.add(new JLabel("Salary (Full-Time):")); frame.add(txtSalary);
        frame.add(new JLabel("Weekly Hours (Full-Time):")); frame.add(txtHours);
        frame.add(new JLabel("Wages Per Hour (Part-Time):")); frame.add(txtWages);
        frame.add(new JLabel("Working Hours (Part-Time):")); frame.add(txtWorkingHrs);
        frame.add(new JLabel("Shifts (Part-Time):")); frame.add(txtShifts);
        frame.add(new JLabel("Display Index:")); frame.add(txtDisplayIndex);

        // Buttons
        btnAddFull = new JButton("Add Full Time Staff"); frame.add(btnAddFull);
        btnAddPart = new JButton("Add Part Time Staff"); frame.add(btnAddPart);
        btnSetSalary = new JButton("Set Salary"); frame.add(btnSetSalary);
        btnSetShift = new JButton("Set Shifts"); frame.add(btnSetShift);
        btnTerminate = new JButton("Terminate Part Time"); frame.add(btnTerminate);
        btnDisplay = new JButton("Display Details"); frame.add(btnDisplay);
        btnClear = new JButton("Clear Fields"); frame.add(btnClear);

        // Button actions
        btnAddFull.addActionListener(e -> addFullTimeHire());
        btnAddPart.addActionListener(e -> addPartTimeHire());
        btnSetSalary.addActionListener(e -> setFullTimeSalary());
        btnSetShift.addActionListener(e -> setPartTimeShifts());
        btnTerminate.addActionListener(e -> terminatePartTimeHire());
        btnDisplay.addActionListener(e -> displayStaff());
        btnClear.addActionListener(e -> clearFields());

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addFullTimeHire() {
    try {
        int vacancyNo = Integer.parseInt(txtVacancyNo.getText());
        String designation = txtDesignation.getText();
        String jobType = txtJobType.getText();
        String name = txtName.getText();
        String date = txtDate.getText();
        String qualification = txtQual.getText();
        String appointedBy = txtAppointed.getText();
        int salary = Integer.parseInt(txtSalary.getText());
        int hours = Integer.parseInt(txtHours.getText());

        
        FullTimeHire fullHire = new FullTimeHire(vacancyNo, designation, jobType, salary, hours);

        
        fullHire.hireStaff(name, date, qualification, appointedBy);

        staffList.add(fullHire);
        JOptionPane.showMessageDialog(frame, "Full-time staff added successfully.");
    } 
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
    }
    }


    private void addPartTimeHire() {
    try {
        int vacancyNo = Integer.parseInt(txtVacancyNo.getText());
        String designation = txtDesignation.getText();
        String jobType = txtJobType.getText();
        int workingHours = Integer.parseInt(txtWorkingHrs.getText());
        int wagePerHour = Integer.parseInt(txtWages.getText());
        String shift = txtShifts.getText();

        PartTimeHire partHire = new PartTimeHire(vacancyNo, designation, jobType, workingHours, wagePerHour, shift);

        String name = txtName.getText();
        String date = txtDate.getText();
        String qualification = txtQual.getText();
        String appointedBy = txtAppointed.getText();

        partHire.hireStaff(name, date, qualification, appointedBy);
        staffList.add(partHire);

        JOptionPane.showMessageDialog(frame, "Part-time staff added successfully.");
    } 
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
    }
    }


    private void setFullTimeSalary() {
    try {
        int vacancyNo = Integer.parseInt(txtVacancyNo.getText());
        int salary = Integer.parseInt(txtSalary.getText());

        for (StaffHire staff : staffList) {
            if (staff instanceof FullTimeHire && staff.getVacancyNumber() == vacancyNo) {
                ((FullTimeHire) staff).setSalary(salary);
                JOptionPane.showMessageDialog(frame, "Salary updated.");
                return;
            }
        }

        JOptionPane.showMessageDialog(frame, "No full-time staff found with that vacancy number.");
    } 
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
    }
    }



    private void setPartTimeShifts() {
        try {
            int vacancyNo = Integer.parseInt(txtVacancyNo.getText());
            String shift = txtShifts.getText();
            for (StaffHire staff : staffList) {
                if (staff instanceof PartTimeHire && staff.getVacancyNumber() == vacancyNo) {
                    ((PartTimeHire) staff).setShifts(shift);
                    JOptionPane.showMessageDialog(frame, "Shift updated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "No part-time staff found with that vacancy number.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
        }
    }

    private void terminatePartTimeHire() {
        try {
            int vacancyNo = Integer.parseInt(txtVacancyNo.getText());
            for (StaffHire staff : staffList) {
                if (staff instanceof PartTimeHire && staff.getVacancyNumber() == vacancyNo) {
                    ((PartTimeHire) staff).terminateStaff();
                    JOptionPane.showMessageDialog(frame, "Part-time staff terminated.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "No part-time staff found with that vacancy number.");
        } 
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage());
        }
    }

    private void displayStaff() {
    try {
        int index = Integer.parseInt(txtDisplayIndex.getText());
        
        // Check if index is valid
        if (index >= 0 && index < staffList.size()) {
            StaffHire staff = staffList.get(index);  // Get the staff object
            
            // Display details depending on whether it's a FullTimeHire or PartTimeHire
            if (staff instanceof FullTimeHire) {
                ((FullTimeHire) staff).displayDetails();  // Cast to FullTimeHire and call displayDetails
            } else if (staff instanceof PartTimeHire) {
                ((PartTimeHire) staff).displayDetails();  // Cast to PartTimeHire and call displayDetails
            }
        }
        else {
            JOptionPane.showMessageDialog(frame, "Invalid index.");  // Index is out of range
        }
    } 
    catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Display index must be a number.");  // Handle invalid input
    }
    }


    private void clearFields() {
        txtVacancyNo.setText(""); txtDesignation.setText(""); txtJobType.setText(""); txtName.setText("");
        txtDate.setText(""); txtQual.setText(""); txtAppointed.setText(""); txtSalary.setText("");
        txtHours.setText(""); txtWages.setText(""); txtWorkingHrs.setText(""); txtShifts.setText(""); txtDisplayIndex.setText("");
    }
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecruitmentSystem::new);
    }
}
