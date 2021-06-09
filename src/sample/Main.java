package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    MyGymManager myGymManager = new MyGymManager();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {
            //Things the manager can do
            System.out.println("*-----------------------------------*");
            System.out.println("Add member - 1");
            System.out.println("Delete member - 2");
            System.out.println("Print the list of member - 3");
            System.out.println("Sort the members by name - 4");
            System.out.println("Save in file - 5");
            System.out.println("Search member or list of members- 6");
            System.out.println("Enter 7 for exit");

            //Choose what the manager wants to do
            System.out.println("Please choose your option :");
            int o = sc.nextInt();

            if (o == 1) {
                myGymManager.addNewMember();
            } else if (o == 2) {
                myGymManager.deleteMember();
            } else if (o == 3) {
                myGymManager.printList();
            } else if (o == 4) {
                myGymManager.sortItem();
            } else if (o == 5) {
                myGymManager.saveFile();
            } else if (o == 6) {
                myGymManager.searchMember();
            } else if (o == 7){
                break;
            } else {
                System.out.println("Please enter 1,2,3,4,5,6 or 7");
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}