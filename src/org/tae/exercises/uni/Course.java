package org.tae.exercises.uni;

import org.tae.exercises.people.Student;
import org.tae.exercises.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String classroom;

    public int getCourseHoursPerWeek() {
        return courseHoursPerWeek;
    }

    private int courseHoursPerWeek;
    private Teacher teacher;
    private List<Student> alumnni;
    
    public Course(String name, String classroom, int courseHoursPerWeek) {
        this.name = name;
        this.classroom = classroom;
        this.courseHoursPerWeek = courseHoursPerWeek;
        alumnni = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getAlumnni() {
        return alumnni;
    }

    public void registerTeacher(Teacher teach){
        this.teacher = teach;
        teacher.addWeekHours(courseHoursPerWeek);
    }

    public void registerStudent(Student fng){
        this.alumnni.add(fng);
    }

    public void displayCourse(){
        System.out.print("**********************");
        System.out.print("****\t Class: " + getName());
        System.out.print("****\t Teacher: " + getTeacher().getName());
        System.out.print("****\t Classroom: " + getClassroom());
        System.out.print("****\t Hours Per Week: " + getCourseHoursPerWeek());
        System.out.println("**********************");
        System.out.println("List of enrolled students:");
        System.out.println("**********************");
        System.out.println("***\t Id \t - \t Name \t - \t Age \t ***");
        for(Student participant: alumnni){
            participant.showYourself();
        }

    }
}
