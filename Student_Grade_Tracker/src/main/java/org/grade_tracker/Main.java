package org.grade_tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name=userInput("Please enter your name: ",scanner);
        String subject=userInput("Enter teaching subject: ",scanner);
        System.out.print("Please total number of students: ");
        Integer totalStudents=scanner.nextInt();

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentScores = new ArrayList<>();
        System.out.println("Hello, "+name+ " we are glad to have you. Please provide your students names and respective scores");

        //GET INDIVIDUAL STUDENTS NAME
        Scanner scanner1=new Scanner(System.in);
        for (int i=0; i<totalStudents;i++){
           String studentName="";
            if (i<0){
                 studentName= userInput("Enter Student Name: ",scanner1);
            }else {
                 studentName= userInput("Next Student Name: ",scanner1);
            }
            studentNames.add(studentName);
        }

        //GET INDIVIDUAL STUDENT SCORES
        System.out.println("-------------------------------------------");
        Scanner scanner2 =  new Scanner(System.in);
        System.out.println("Great job lets proceed to enter student score");
        for(int i=0;i<totalStudents;i++){
            Double studentScore=userInputDou(studentNames.get(i)+": ",scanner2);
            studentScores.add(studentScore);
        }
        scanner2.close();

        //COMPUTE STUDENT TOTAL SCORES
        //CHECK FOR HIGHEST SCORE
        //CHECK FOR LOWEST SCORE
        Double highestScore=studentScores.get(0);
        Integer highestScoreIndex=0;
        Integer lowestScoreIndex=0;
        Double lowestScore=studentScores.get(0);

        Double totalScore =0.0;
        for (int i=0; i<totalStudents;i++){
            totalScore+=studentScores.get(i);
            if (studentScores.get(i)<lowestScore){
                lowestScore=studentScores.get(i);
                lowestScoreIndex=i;
            }
            if (studentScores.get(i)>highestScore){
                highestScore=studentScores.get(i);
                highestScoreIndex=i;
            }
        }

        System.out.println("###################################################");
        System.out.println("###################################################");


        System.out.println("Staff name: "+name);
        System.out.println("Teaching Subject: "+ subject);
        System.out.println("Total Students: "+ totalStudents);

        System.out.println("-------------------------------------------");
        for (int i=0; i<totalStudents;i++){
            System.out.printf("Student Name:  %s, \nStudent Score: %.2f",studentNames.get(i),studentScores.get(i));
            System.out.println();
            System.out.println("************************************************");
        }
        //COMPUTE AVERAGE SCORES
        Double averageScore = totalScore/(double)totalStudents;

        System.out.println("-------------------------------------------------");
        System.out.println("Performance summary");
        System.out.println("-------------------------------------------------");

        System.out.printf("Average Score: %.2f", averageScore);
        System.out.println();
        System.out.println("Highest Score");
        System.out.printf("Student name: %s , Student Score: %.2f",studentNames.get(highestScoreIndex),highestScore);
        System.out.println();
        System.out.println("Lowest Score");
        System.out.printf("Student name: %s, Student Score: %.2f",studentNames.get(lowestScoreIndex),lowestScore);

    }
    static String userInput(String text, Scanner scanner){
        System.out.print(text);
        return scanner.nextLine();
    }
    static Double userInputDou(String text, Scanner scanner){
        System.out.print(text);
        return scanner.nextDouble();
    }

}