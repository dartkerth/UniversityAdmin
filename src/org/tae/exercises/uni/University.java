package org.tae.exercises.uni;

import org.tae.exercises.people.Person;
import org.tae.exercises.people.Student;
import org.tae.exercises.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private List<Student> alumnni;
    private List<Teacher> teachingStaff;
    private List<Course> fullCourse;
    public University(String name){
        this.name = name;
        alumnni = new ArrayList<>();
        teachingStaff = new ArrayList<>();
        fullCourse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    /**+
     * CORE FUNTCION to add teachers.
     * @param name
     * @param id
     * @param expYears
     * @param baseSalary
     * @param isFullTime
     */
    public void registerTeacher(String name, String id, int expYears, double baseSalary, boolean isFullTime){
        teachingStaff.add(new Teacher(name,id,expYears,baseSalary,isFullTime));
    }

    /**
     * CORE FUNTCION to add students.
     * @param name
     * @param id
     * @param age
     */
    public void registerStudent(String name, String id, int age){
        alumnni.add(new Student(name,id,age));
    }

    /**
     * function to create a course, needs: name, classroom and hours per week. In addtition you need teacher's and students' ids
     *
     * @param courseName
     * @param classroom
     * @param hoursPerWeek
     * @param teacherID
     * @param studentsId array of students to add to the class
     */
    public void registerCourse(String courseName, String classroom, int hoursPerWeek, String teacherID, String... studentsId){

        /**NEW COURSE CREATION**/
        Course newCourse = new Course(courseName,classroom,hoursPerWeek);

        ////Validation missing!
        /**GOING THROUGH TEACHERS**/
        for(Teacher candidate: teachingStaff){
            if(candidate.getId().equals(teacherID)){
                newCourse.registerTeacher(candidate);
            }
        }
        ////Validation missing!
        /**GOING THROUGH STUDENTS**/
        for (String s : studentsId) {
            for (Student newGuy : alumnni) {
                if (newGuy.getId().equals(s)) {
                    newCourse.registerStudent(newGuy);
                }
            }
        }
        fullCourse.add(newCourse);
    }

    public boolean registerStudentIntoCourse(String studentID, String courseName){
        ////Validation missing!
        for(Student newGuy: alumnni){
            if(newGuy.getId().equals(studentID)){
                for(Course course: fullCourse){
                    if(course.getName().equals(courseName)){
                        course.registerStudent(newGuy);
                    }
                }
            }
        }
        return true;
    }

    public void displayTeachers(){

        System.out.println("***\t Id \t - \t Name \t - \t Experience \t - \t Pay(Salary) \t - \t Full time Teacher \t ***");
        for(Teacher candidate: teachingStaff){
            candidate.showYourself();
        }
        System.out.println("***************");
    }

    public void displayStudents(){

        System.out.println("***\t Id \t - \t Name \t - \t Age \t***");
        for(Student candidate: alumnni){
            candidate.showYourself();
        }
        System.out.println("***************");
    }

    /**
     * Function to display all courses where a student its in, only with its id, need to find something better that going through various for
     * @param studentId
     */
    public void displayAllStudentCourses(String studentId){
        for(Course course: fullCourse){
            for(Student candidate: course.getAlumnni()) {
                if (candidate.getId().equals(studentId)) {
                    course.displayCourse();
                }
            }
        }
    }
    public void displayAllCourses(){
        for(Course course: fullCourse){
                course.displayCourse();
        }
    }
    public void displayCoursesById(String courseId){
        for(Course course: fullCourse){
            if(course.getName().equals(courseId))
                course.displayCourse();
        }
    }
}
