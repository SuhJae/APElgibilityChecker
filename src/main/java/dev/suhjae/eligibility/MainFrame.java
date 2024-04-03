package dev.suhjae.eligibility;

import dev.suhjae.eligibility.CourseManager.CourseManager;
import dev.suhjae.eligibility.Panels.CoursePanel;
import dev.suhjae.eligibility.Panels.GradePanel;
import dev.suhjae.eligibility.Panels.TestPanel;
import dev.suhjae.eligibility.StudentManager.StudentManager;
//import dev.suhjae.elgibility.EligibilityManager.EligibilityManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * TODO
 * Window for individual course info modification
 * Adding & modifying course / course info
 */

public class MainFrame extends JFrame {
    JTabbedPane tabs;
    JTable table;
    DefaultTableModel tableModel;
    JButton importButton, saveButton;
    //Create CourseManager object here
    //2darraycourses =[][] empty
    static public StudentManager studentManager;
    static public CourseManager courseManager;
//    static public ElegibilityManager eligibilityManager;

    public MainFrame() {
        String testData[][] = {{"Course Name", "Course ID", "Minimum Grade Level to Enroll", "Referenced Test", "Recent or Highest", "Minimum Test Score (SAT)", "Course Requirement #1", "Course Requirement #2", "Course Requirement #3", "Course Requirement #4"},
                {"AP Calculus BC", "10532", "10", "Math", "Highest", "700", "10016@3.75 10002@3.5 10531@3.9 10015@3.4", "10023@3.75", "", ""},
                {"AP Biology", "10434", "10", "Total", "Recent", "1030", "10410@3.75 10400@3.75", "", "", ""},
                {"AP Lang", "10342", "10", "EBRW", "Highest", "680", "10429@3.75", "10001@3.5", "10240@3.75", ""}
        };

        studentManager = new StudentManager();
        courseManager = new CourseManager(testData);
//        eligibilityManager = new EligibilityManager(studentManager, courseManager);

        CoursePanel coursePanel = new CoursePanel(courseManager.getData()); //2darray

        GradePanel gradePanel = new GradePanel(StudentManager.historicalGrade);

        TestPanel testPanel = new TestPanel(StudentManager.testData);

//        EligibilityPanel eligibilityPanel = new EligibilityPanel(eligibilityManager);

        //Construct the CM variable here & pass into array /2d

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFocusable(false);

        tabs = new JTabbedPane();
        tabs.add(coursePanel.getPanel(), "Course Data");
        tabs.add(gradePanel.getPanel(), "Student Grade History");
        tabs.add(testPanel.getPanel(), "Student Test History");
//        tabs.add(eligibilityPanel.getPanel(), "Eligibility Tester");


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(2, 2));
        this.add(tabs);

        this.setVisible(true);

        coursePanel.updateTableData();
        testPanel.updateTableData();
        gradePanel.updateTableData();

        this.requestFocusInWindow();
    }
}