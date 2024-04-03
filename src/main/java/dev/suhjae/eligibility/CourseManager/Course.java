package dev.suhjae.eligibility.CourseManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Course.java
 * a basic template of a course with the necessary information
 * @author Hajin, Harold, Alfonso, Aiden, Jacob
 */
public class Course {
    private String courseName;
    private String courseId;
    private int minGradeLevel;
    private String referencedTest;
    private boolean isHighest;
    private int minPredictorScore;
    private boolean isAP;

    private String preReqOne, preReqTwo, preReqThree, preReqFour;
    private HashMap h1, h2, h3, h4;


    /**
     * Creates a new AP course with given information
     * @param courseName Name of the course
     * @param courseId ID of the course
     * @param minGradeLevel The minimum grade to which the course is offered
     * @param referencedTest The type of test score referenced (SAT Total / EBRW / Math)
     * @param isHighest Whether the highest score is referenced to or not
     * @param minPredictorScore Minimum score needed
     * @param preReqOne The first prerequisite course and grade needed
     * @param preReqTwo The second prerequisite course and grade needed
     * @param preReqThree The third prerequisite course and grade needed
     * @param preReqFour The fourth prerequisite course and grade needed
     */
    Course(String courseName, String courseId, int minGradeLevel, String referencedTest, boolean isHighest, int minPredictorScore, String preReqOne, String preReqTwo, String preReqThree, String preReqFour){
        this.courseName = courseName;
        this.courseId = courseId;
        this.minGradeLevel = minGradeLevel;
        this.referencedTest = referencedTest;
        this.isHighest = isHighest;
        this.minPredictorScore = minPredictorScore;
        this.isAP = true;
        this.preReqOne = preReqOne;
        this.preReqTwo = preReqTwo;
        this.preReqThree = preReqThree;
        this.preReqFour = preReqFour;

        if(referencedTest.equals("")) {
            this.isAP = false;
        }

    }

    /**
     * Creates a new course with given information
     * @param courseName name of the course
     * @param courseId ID of the course
     */
    Course(String courseName, String courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.isAP = false;
    }

    /**
     * getPreReqList
     * Organizes pre-requisites of a course into a single ArrayList
     * String array contains information of multiple courses based on String preReq
     * ArrayList contains multiple HashMaps
     * Each HashMap has courseID as key and individual GPA requirement as value
     * @return ArrayList with HashMaps of Prerequisite courses
     */
    public ArrayList<HashMap> getPreReqList(){

        ArrayList<HashMap> coursePreReqList = new ArrayList<HashMap>();

        if (preReqOne != ""){
            String[] preReqOneList = preReqOne.split(" ");
            HashMap h1 = createHashMap(preReqOneList);
            coursePreReqList.add(h1);
        }

        if (preReqTwo != ""){
            String [] preReqTwoList = preReqTwo.split(" ");
            HashMap h2 = createHashMap(preReqTwoList);
            coursePreReqList.add(h2);
        }

        if (preReqThree != ""){
            String [] preReqThreeList = preReqThree.split(" ");
            HashMap h3 = createHashMap(preReqThreeList);
            coursePreReqList.add(h3);
        }

        if (preReqFour != "") {
            String [] preReqFourList = preReqFour.split(" ");
            HashMap h4 = createHashMap(preReqFourList);
            coursePreReqList.add(h4);
        }

        return coursePreReqList;
    }

    /**
     * createHashMap
     * organizes String preReq
     * @param preReqList String array that contains prerequisite courses
     * @return HashMap with courseID as key and individual GPA requirement as value
     */
    private HashMap<String, Double> createHashMap (String[] preReqList) {

        HashMap<String, Double> preReq = new HashMap<String, Double>();
        for (int i = 0; i < preReqList.length; i++){
            preReq.put(preReqList[i].substring(0, 5),Double.parseDouble(preReqList[i].substring(6)));
        }
        return preReq;
    }

    /**
     * getCourseID
     * returns courseID value
     * @return string with the corresponding course ID
     */
    public String getCourseID() {
        return courseId;
    }

    /**
     * getCourseName
     * returns courseName value
     * @return string with the corresponding course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * getMinGradeLevel
     * returns minimum Grade level required for a course
     * @return int with the corresponding minimum grade level
     */
    public int getMinGradeLevel() {
        return minGradeLevel;
    }

    /**
     * isAP
     * returns isAP value
     * @return boolean value indicate whether a course is an AP course or not
     */
    public boolean isAP() {
        return this.isAP;
    }

    /**
     * getSatMinMathScore
     * returns the minimum SAT math score required to take the course
     * @return int value of the minimum SAT math score or -1 if there is no SAT Math requirement
     */
    public int getSatMinMathScore() {
        if(referencedTest.equals("Math")) {
            return minPredictorScore;
        }
        return -1;
    }

    /**
     * getSatMinEBRW
     * returns the minimum SAT EBRW score required to take the course
     * @return int value of the minimum SAT EBRW score or -1 if there is no SAT EBRW requirement
     */
    public int getSatMinEBRW() {
        if(referencedTest.equals("EBRW")) {
            return minPredictorScore;
        }
        return -1;
    }

    /**
     * getMinSatCutOff
     * returns the minimum total SAT score required to take the course
     * @return int value of the minimum total SAT score or -1 if there is no total SAT requirement
     */
    public int getMinSatCutOff() {
        if(referencedTest.equals("Total")) { // check later
            return minPredictorScore;
        }
        return -1;
    }

    /**
     * satReferenceBest
     * returns boolean value on whether the AP course requires highest or recent SAT
     * @return true when the AP course requires the best SAT Score or false when the AP course requires the latest SAT score
     */
    public boolean satReferenceBest() {
        return isHighest;
    }


}