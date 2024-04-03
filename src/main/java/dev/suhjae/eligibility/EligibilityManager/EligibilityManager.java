package dev.suhjae.eligibility.EligibilityManager;

import dev.suhjae.eligibility.CourseManager.Course;
import dev.suhjae.eligibility.CourseManager.CourseManager;
import dev.suhjae.eligibility.StudentManager.Student;
import dev.suhjae.eligibility.StudentManager.StudentManager;

import java.util.ArrayList;

public class EligibilityManager {
    CourseManager courseManager;
    StudentManager studentManager;
    ArrayList<Course> apCourses;
    ArrayList<Student> students;

    private boolean checkCourseElegibility(Student student, Course course) {
        return true;
    }

    private ArrayList<Course> getEligibleCourses(Student student) {
        return null;
    }

    EligibilityManager(CourseManager courseManager, StudentManager studentManager) {
        this.courseManager = courseManager;
        this.studentManager = studentManager;
    }


    //Method that runs automatically
    public String[][] Go() {
        return null;
    }


}

