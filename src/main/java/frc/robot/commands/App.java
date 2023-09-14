// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

public class App {
    public static void main(String[] args) throws Exception {
        int hourOfDay = 20;

        if (hourOfDay < 10){
            System.out.println("Good morning!");
        }
        else if (hourOfDay<15){
            System.out.println("Good day!");
        }
        else if (hourOfDay < 18){
            System.out.println("Good afternoon!");
        }
        else{
            System.out.println("Good evening!");
        }
    }
}