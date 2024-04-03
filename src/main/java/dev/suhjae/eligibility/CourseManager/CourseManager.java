package dev.suhjae.eligibility.CourseManager;

import java.util.ArrayList;
public class CourseManager {

    private String courseName;
    private int courseId;
    private int minGradeLevel;
    private String referencedTest;
    private boolean isHighest;
    private int minPredictorScore;
    private boolean isAP;
    static private ArrayList<Course> courses;
    ArrayList<Course> apCourses = new ArrayList<Course>();
    private String[][] data;

    /**
     * CourseManager
     * Create a new CourseManager instance
     * @param data 2d array of course data
     */
    public CourseManager(String[][] data){
        this.data = data;
        courses = new ArrayList<Course>();
    }

    /**
     * addCourse
     * Add a new course to the ArrayList of courses
     * @param courseName Name of the course
     * @param courseId The ID of the course
     * @param minGradeLevel The minimum grade to which the course is offered
     * @param referencedTest The type of test score referenced (SAT Total / EBRW / Math)
     * @param isHighest Whether the highest score is referenced to or not
     * @param minPredictorScore Minimum score needed
     * @param preReqOne The first prerequisite course and grade needed
     * @param preReqTwo The second prerequisite course and grade needed
     * @param preReqThree The third prerequisite course and grade needed
     * @param preReqFour The fourth prerequisite course and grade needed
     */
    private void addCourse(String courseName, String courseId, int minGradeLevel, String referencedTest, boolean isHighest, int minPredictorScore, String preReqOne, String preReqTwo, String preReqThree, String preReqFour){
        courses.add(new Course(courseName, courseId, minGradeLevel, referencedTest, isHighest, minPredictorScore, preReqOne, preReqTwo, preReqThree, preReqFour));
    }

    /**
     * updateData
     * Update the course database
     * @param array array of courses
     */
    public void updateData(String[][] array){
        //String courseName, int courseId, int minGradeLevel, String referencedTest, boolean isHighest, int minPredictorScore
        courses.clear();
        for (int i = 1; i< array.length; i++){
            if (array[i][4].equals("Highest")){
                isHighest = true;
            }
            else if ((array[i][4]).equals("Recent")){
                isHighest = false;
            }
            addCourse(array[i][0], array[i][1], Integer.parseInt(array[i][2]), array[i][3], isHighest, Integer.parseInt(array[i][5]), array[i][6], array[i][7], array[i][8], array[i][9]);
        }
    }

    /**
     * getAPcourses
     * Get an ArrayList of all AP courses
     * @return ArrayList of AP courses
     */
    public ArrayList getAPcourses() {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).isAP()) {
                apCourses.add(courses.get(i));
            }
        }
        return apCourses;
    }

    /**
     * getCourses
     * Get an ArrayList of all courses
     * @return ArrayList of all courses
     */
    public static ArrayList<Course> getCourses() {

        return courses;
    }

    /**
     * getData
     * Get a 2d array of course data
     * @return 2d array of course data
     */
    public String[][] getData() {
        return data;
    }
}