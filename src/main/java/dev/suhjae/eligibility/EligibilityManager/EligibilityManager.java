package dev.suhjae.eligibility.EligibilityManager;

import dev.suhjae.eligibility.CourseManager.Course;
import dev.suhjae.eligibility.CourseManager.CourseManager;
import dev.suhjae.eligibility.StudentManager.Student;
import dev.suhjae.eligibility.StudentManager.StudentManager;

import java.util.ArrayList;
import java.util.HashMap;

public class EligibilityManager {
    CourseManager courseManager;
    StudentManager studentManager;
    ArrayList<Course> apCourses;
    ArrayList<Student> students;

    /**
     * checkCourseEligibility
     * Compare student's conditions and course's requirements.
     * @param student object of Student class
     * @param course object of Course class
     * @return whether the student is eligible for this course or not.
     */
    private boolean checkCourseEligibility(Student student, Course course) {
        //Checking if student meets the minimum grade level.
        boolean isEligible = Integer.parseInt(student.getGradeLevel()) >= course.getMinGradeLevel();

        //Checking if student meets the minimum test score requirement.
        String testType = course.getReferencedTest(); //Need to tell the Course team to add this method of returning referenced test type (string).
        if (course.satReferenceBest()) {    //if course requires highest score
            if (testType.equals("Math")) {
                if (Integer.parseInt(student.getMaxSATMath()) >= course.getSatMinMathScore()) //Need to tell Student team to add getMaxSATMath().
                    isEligible = true;
                else if (Integer.parseInt(student.getMaxPSATMath()) >= course.getSatMinMathScore()) //Need to tell Student team to add getMaxPSATMath().
                    isEligible = true;
                else
                    return false;
            }
            else if (testType.equals("EBRW")) {
                if (Integer.parseInt(student.getMaxSATEBRW()) >= course.getSatMinEBRW()) //Need to tell Student team to add getMaxSATEBRW().
                    isEligible = true;
                else if (Integer.parseInt(student.getMaxPSATEBRW()) >= course.getSatMinEBRW()) //Need to tell Student team to add getMaxPSATEBRW().
                    isEligible = true;
                else
                    return false;
            }
            else {      //if test type is total
                if (Integer.parseInt(student.getMaxSATTotal()) >= course.getMinSatCutOff())
                    isEligible = true;
                else if (Integer.parseInt(student.getMaxPSATTotal()) >= course.getMinSatCutOff())
                    isEligible = true;
                else
                    return false;
            }
        }
        else {      //if course is requiring recent score
            if (testType.equals("Math")) {
                if (Integer.parseInt(student.getRecentSATMath()) >= course.getSatMinMathScore()) //Need to tell Student team to add getRecentSATMath().
                    isEligible = true;
                else if (Integer.parseInt(student.getRecentPSATMath()) >= course.getSatMinMathScore()) //Need to tell Student team to add getRecentPSATMath().
                    isEligible = true;
                else
                    return false;
            }
            else if (testType.equals("EBRW")) {
                if (Integer.parseInt(student.getRecentSATEBRW()) >= course.getSatMinEBRW()) //Need to tell Student team to add getRecentSATEBRW().
                    isEligible = true;
                else if (Integer.parseInt(student.getRecentPSATEBRW()) >= course.getSatMinEBRW()) //Need to tell Student team to add getRecentPSATEBRW().
                    isEligible = true;
                else
                    return false;
            }
            else {      //if test type is total
                if (Integer.parseInt(student.getRecentSATTotal()) >= course.getMinSatCutOff())
                    isEligible = true;
                else if (Integer.parseInt(student.getRecentPSATTotal()) >= course.getMinSatCutOff())
                    isEligible = true;
                else
                    return false;
            }
        }

        //Checking if student taken the prerequisite courses with the minimum grades.
        //Need to tell the course team to change the return type of this method to ArrayList<HashMap<String, Double>> instead of ArrayList<HashMap>.
        ArrayList<HashMap<String, Double>> prerequisiteList = course.getPreReqList();
        for (HashMap<String, Double> preReq : prerequisiteList) {
            //Will be added.
        }

        return isEligible;
    }

    private ArrayList<Course> getEligibleCourses(Student student) {
       for (Course apCourse: apCourses){
           if (checkCourseElegibility(student, apCourse)){
               apCourses.add(apCourse);
           }
       }
       return apCourses;

    EligibilityManager(CourseManager courseManager, StudentManager studentManager) {
        this.courseManager = courseManager;
        this.studentManager = studentManager;
    }


    //Method that runs automatically
    public String[][] Go() {
        return null;
    }


}

