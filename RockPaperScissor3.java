/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rose.examproject;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class RockPaperScissor3 {
    public static void main(String[] args) {
        //declare variable
        String yourAnswer;
        /* a do-while loop is used here so the program will execute several times if conditions
        are met.
        */
        do{   
        //call first method
        rockPaperScissors();           
    
        Scanner inputReader = new Scanner(System.in);//scanner for user input
        System.out.println("");//allows for space
        System.out.println("Do you want to play again? Type (y) for yes or (n) for no");//display to console
            yourAnswer = inputReader.nextLine(); 
        //insert conditions to see if do while loop should continue on second round of games  
        if (yourAnswer.equalsIgnoreCase("n")){
            System.out.println("***************THANKS FOR PLAYING***************");
        }
        }        
        while (yourAnswer.equalsIgnoreCase("y"));
    }
        static void rockPaperScissors(){
       //first method, but not main, assigns values to other methods, variables for totals are declared
        Scanner inputReader = new Scanner(System.in);
        //declare ints to be stored     
        int gamesCompleted = 1;
        int gamesRequested;
        int userWins = 0;
        int computerWins = 0;
        int tieGames = 0;
        int[] total;
                
        System.out.println("----------LET'S PLAY ROCK, PAPER, SCISSORS----------");                    
        System.out.println("How many games would you like to play? No more than 10 please?");
            gamesRequested = inputReader.nextInt();
            inputReader.nextLine();                 
        //insert conditions for while loop 
        if (gamesRequested > 10 || gamesRequested <= 0){
            System.out.println("Your entry is not valid! NO GAME!!!");
        }
        while (gamesRequested <= (10) && gamesCompleted <= gamesRequested){
            
        
            System.out.println("---------------GAME #: " + gamesCompleted + "----------------");
        //assigns value to String in subseuent method  
        String userWeapon = promptUserWeapon(); 
        String computerWeapon = promptComputerWeapon();
        //assigns value to total
        total = getResults(userWeapon, computerWeapon,userWins, computerWins, tieGames);
        gamesCompleted ++; //accrue games as completed
        userWins = total[0]; //stores wins
        computerWins = total[1];
        tieGames = total[2];
        }//print overall winner to console
        System.out.println("-------------TOTAL NUMBER OF WINS-------------");
        if (gamesCompleted > (0)){
        System.out.println("User Won:     " + userWins);
        System.out.println("Computer Won: " + computerWins);
        System.out.println("Games Tied:   " + tieGames);
        //insert conditions for total
        }if (userWins > computerWins){
            System.out.println("-----------YOU'RE THE OVERALL WINNER!------------");
            
        }else if (computerWins > userWins){
            System.out.println("--------THE COMPUTER IS THE OVERALL WINNER--------");
            
        }else{
            System.out.println("IT'S AN OVERALL TIE!");
        }
        }
    static String promptComputerWeapon(){
        //random array to get computer weapon; method is not"void", therefore a return is required
        Random randomWeapon = new Random();
        String[] weaponArray = {"Rock", "Paper", "Scissors"};
        return weaponArray[randomWeapon.nextInt(weaponArray.length)];   
    }       
    static String promptUserWeapon()  { 
        Scanner inputReader = new Scanner (System.in);//scanner for user input of weapon
        System.out.println("Choose 1 for Rock, 2 for Paper, and 3 for Scissors");
            int userWeaponNum = inputReader.nextInt();
            inputReader.nextLine();
        //use of switch statement, converted from if/else if   
        switch (userWeaponNum) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";//use of default switch case to prevent another return statelent
            default:
                return "Scissors";
        }
    }
    /**Sets user's weapon
     * @param userWeapon a String containing choice of weapon
     * Sets computer's weapon
     * @param computer weapon a String containing random choice of computer's weapon
     *  int allows for tally of wins
     * @param userWins, accrues user wins
     * @param computerWins, accrues computer wins
     * @total An array for return of total wins
     * @return returns tally of wins, does not display, calculated in method rockPaperScissors
     */
    static int[] getResults(String userWeapon, String computerWeapon, int userWins, int computerWins,int tieGames) {
        System.out.println("You chose:      " + userWeapon);//display to console
        System.out.println("Computer chose: " + computerWeapon);//display to console
        //insert conditions for winner of each game and tally for total   
        if(userWeapon.equals("Scissors")&& computerWeapon.equals("Scissors")){
            System.out.println("IT'S A TIE!");
            tieGames++;
        }else if (userWeapon.equals ("Scissors") && computerWeapon.equals("Rock")){
            System.out.println("COMPUTER WON!");
            computerWins++;
        }else if (userWeapon.equals("Scissors") && computerWeapon.equals("Paper")){
            System.out.println("YOU WON!");
            userWins++;
        } 
        if (userWeapon.equals("Paper")&& computerWeapon.equals("Paper")){
            System.out.println("IT'S A TIE!");
            tieGames++;
        }else if (userWeapon.equals ("Paper") && computerWeapon.equals("Scissors")){
            System.out.println("COMPUTER WON!");
            computerWins++;
        }else if (userWeapon.equals ("Paper") && computerWeapon.equals("Rock")){
            System.out.println("YOU WON!");
            userWins++;  
        }
        if (userWeapon.equals("Rock")&& computerWeapon.equals("Rock")){
            System.out.println("IT'S A TIE!");
            tieGames++;
        }else if (userWeapon.equals ("Rock")&& computerWeapon.equals("Paper")){
            System.out.println("COMPUTER WON!");
            computerWins++;
        }else if (userWeapon.equals("Rock") && computerWeapon.equals("Scissors")){
            System.out.println("YOU WON!");
            userWins ++;
        }//tally wins, use of array to return a total
        int[] total ={userWins, computerWins, tieGames};
        //return value to method static void rockPaperScissors
        return total;
        }
         
        
}
        
        


                
                        
            
         

    
        

               
        


            
      
      
        
        
       
        

        
        