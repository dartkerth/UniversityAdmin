package org.tae.exercises.run;

import org.tae.exercises.people.LastNames;
import org.tae.exercises.people.Names;
import org.tae.exercises.uni.University;

import java.util.Scanner;

public class Begin {


    private static final int numberStudents = 6;
    private static University university;

    public static void main(String[] args) {
        boolean menuStatus = true;
        int menuSelection = 0;
        university = new University("GlobantU");
        setUp();
        university.displayTeachers();
        university.displayAllCourses();

        while(menuStatus){
            System.out.println("Welcome to University "+university.getName()+" Course Management System!");
            System.out.println("What do you need today?");
            System.out.println("1 - Print all the professors with its data \n" +
                    "2 - Course display management\n" +
                    "3 - Create a new student and add it to an existing class\n" +
                    "4 - Create a new class and add a teacher, students and its relevant data\n" +
                    "5 - List all the classes in which a given student is included (hint: search by id)\n" +
                    "6 - Exit\n");
            Scanner scanner = new Scanner(System.in);
            menuSelection = scanner.nextInt();
            scanner.nextLine();

            switch(menuSelection){
                case 1:{
                    university.displayTeachers();
                    break;
                }case 2:{
                    courseDisplayManager();
                    break;
                }case 3:{

                    break;
                }case 4:{

                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    menuStatus = false;
                    break;
                }
                default:{
                    menuStatus = true;
                    break;
                }
            }
        }

    }

    private static void courseDisplayManager(){
        int menuSelection = 0;
        System.out.println("Course display management: ");
        System.out.println();
        System.out.println("1 - Print all the courses \n" +
                "2 - Print a specific course\n");
        Scanner scanner = new Scanner(System.in);
        menuSelection = scanner.nextInt();
        scanner.nextLine();
        switch(menuSelection){
            case 1:{
                university.displayAllCourses();
                break;
            }case 2:{
                university.displayAllStudentCourses("");
                break;
            }
            default:{
                System.out.println("No valid option");
            }
        }
    }
    public static void setUp(){
        for(int i = 0; i < numberStudents; i++) {
            university.registerStudent(Names.values()[(int) (Math.random() * Names.values().length)].name().concat(" ").concat(LastNames.values()[(int) (Math.random() * LastNames.values().length)].name()), "Id"+i, (int) (Math.random() * 25));
        }
        university.registerTeacher(Names.values()[(int) (Math.random() * Names.values().length)].name().concat(" ").concat(LastNames.values()[(int) (Math.random() * LastNames.values().length)].name()), "Id71", 12, 950000, true);
        university.registerTeacher(Names.values()[(int) (Math.random() * Names.values().length)].name().concat(" ").concat(LastNames.values()[(int) (Math.random() * LastNames.values().length)].name()), "Id72", 7, 950000, true);
        university.registerTeacher(Names.values()[(int) (Math.random() * Names.values().length)].name().concat(" ").concat(LastNames.values()[(int) (Math.random() * LastNames.values().length)].name()), "Id73", 2, 95000, false);
        university.registerTeacher(Names.values()[(int) (Math.random() * Names.values().length)].name().concat(" ").concat(LastNames.values()[(int) (Math.random() * LastNames.values().length)].name()), "Id74", 5, 141000, false);

        university.registerCourse("Química","101", 4, "Id72", "Id1","Id2");
        university.registerCourse("Valores Humanos","201", 3, "Id74", "Id0" , "Id3" , "Id5");
        university.registerCourse("Programación 2","501", 7, "Id71", "Id1" , "Id2" , "Id4");
        university.registerCourse("Matemática Avanzada","401", 6, "Id73", "Id3" , "Id4" , "Id5");
        university.registerCourse("Balística","301", 4, "Id72", "Id0" , "Id1" , "Id2");
    }
}
