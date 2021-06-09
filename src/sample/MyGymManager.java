package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyGymManager implements GymManager{
    Scene sceneMain,sceneSearch;

    //Initialize arraylist
    ArrayList<DefaultMember> arrayList = new ArrayList();

    @Override
    //addNewMember method
    public void addNewMember() {
        Scanner sc = new Scanner(System.in);

        //Set to add a maximum number of 100 members
        if (arrayList.size() <= 100) {

            //Select member type
            System.out.println("Default members - 1");
            System.out.println("Student members - 2");
            System.out.println("Over 60 members - 3");

            try {
                System.out.println("Please choose the member type :");

                int a = sc.nextInt();

                if (a == 1) {
                    //Default Member details
                    DefaultMember member = new DefaultMember();

                    //take DefaultMember membership number
                    System.out.println("Please enter Default member membership number :");
                    int memRegNum = sc.nextInt();
                    member.setmembershipNumber(memRegNum);

                    //take DefaultMember name
                    System.out.println("Please enter Default Member Name :");
                    String memName = sc.next();
                    member.setName(memName);

                    //take DefaultMember start date
                    System.out.println("Enter start date");
                    System.out.println("Enter year :");
                    int year = Integer.parseInt(sc.next());
                    System.out.println("Enter month :");
                    int month = Integer.parseInt(sc.next());
                    System.out.println("Enter date :");
                    int day = Integer.parseInt(sc.next());
                    Date date1 = new Date();
                    date1.setYear(year);
                    date1.setMonth(month);
                    date1.setDay(day);
                    member.setRegDate(date1);

                    //add defaultmember details to arraylist
                    arrayList.add(member);
                } else if (a == 2) {
                    //StudentMember details
                    StudentMember student = new StudentMember();

                    //take StudentMember membership number
                    System.out.println("Please enter Student member membership number :");
                    int stuRegNum = sc.nextInt();
                    student.setmembershipNumber(stuRegNum);

                    //take StudentMember name
                    System.out.println("Please enter Student member name :");
                    String stuName = sc.next();
                    student.setName(stuName);

                    //take student member school name
                    System.out.println("Please enter student member school name :");
                    String schName = sc.next();
                    student.setSchoolName(schName);

                    //take student membership start date
                    System.out.println("Enter start date");
                    System.out.println("Enter year :");
                    int year = Integer.parseInt(sc.next());
                    System.out.println("Enter month :");
                    int month = Integer.parseInt(sc.next());
                    System.out.println("Enter date :");
                    int day = Integer.parseInt(sc.next());
                    Date date1 = new Date();
                    date1.setYear(year);
                    date1.setMonth(month);
                    date1.setDay(day);
                    student.setRegDate(date1);

                    //add studentmember details to arraylist
                    arrayList.add(student);
                } else if (a == 3) {
                    //Over60Member details
                    Over60Member over60 = new Over60Member();

                    //take over60 member membership number
                    System.out.println("Please enter over60 member membership number :");
                    int ovrRegNum = sc.nextInt();
                    over60.setmembershipNumber(ovrRegNum);

                    //take over60 member name
                    System.out.println("Please enter over 60 member name :");
                    String ovrName = sc.next();
                    over60.setName(ovrName);

                    //take over over60 member age
                    System.out.println("Please enter over 60 member age :");
                    int ovrAge = sc.nextInt();
                    over60.setAge(ovrAge);

                    //take over 60 member membership start date
                    System.out.println("Enter start date");
                    System.out.println("Enter year :");
                    int year = Integer.parseInt(sc.next());
                    System.out.println("Enter month :");
                    int month = Integer.parseInt(sc.next());
                    System.out.println("Enter date :");
                    int day = Integer.parseInt(sc.next());
                    Date date1 = new Date();
                    date1.setYear(year);
                    date1.setMonth(month);
                    date1.setDay(day);
                    over60.setRegDate(date1);

                    //add over60member details to arraylist
                    arrayList.add(over60);
                }
                //error handling
            } catch (Exception e) {
                System.out.println("Please enter 1,2 or 3");
            }
        }
        //If there are 100 members, show that there no spaces
        else {
            System.out.println("There is no spaces to add new member.");
        }
    }

    @Override
    //delete member method
    public void deleteMember() {
        Scanner scanner = new Scanner(System.in);

        //take the membership number manager want to delete
        System.out.println("Enter membership number you want to delete : ");
        int delMembershipNum = scanner.nextInt();

        int delete = 0;
        DefaultMember defaultMember = null;
        for (int i=0; i<arrayList.size(); i++){
            //Delete member details
            if (delMembershipNum == arrayList.get(i).getmembershipNumber()){
                defaultMember = arrayList.get(i);
                arrayList.remove(i);
                delete = 1;
                //show the number of available spaces
                System.out.println("Number of free spaces in the system : "+ (100 - arrayList.size()));
            }
        }
        if (delete == 0){
            System.out.println("Cannot find the membership number you want to delete.");
        }
        //Delete member type
        else {
            if (defaultMember instanceof StudentMember){
                System.out.println("Student Member details Delete Successful.");
            } else if (defaultMember instanceof Over60Member){
                System.out.println("Over 60 Member details Delete Successful.");
            } else {
                System.out.println("Default Member details Delete Successful.");
            }
        }
    }

    @Override
    //print list method
    public void printList() {
        for (int i = 0; i < arrayList.size(); i++ ){

            //print Student member details
            if (arrayList.get(i) instanceof StudentMember ){
                System.out.println("  ");
                System.out.println("Member type : Student Member");
                System.out.println("Student membership number : " + arrayList.get(i).getmembershipNumber());
                System.out.println("Student Name : " + arrayList.get(i).getName());
                System.out.println("Student membership start date :  " + arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear());
                System.out.println("Student school name : " + ((StudentMember) arrayList.get(i)).getSchoolName());
            }

            //print over60 member details
            else if (arrayList.get(i) instanceof Over60Member ){
                System.out.println("  ");
                System.out.println("Member type : Over 60");
                System.out.println("Over 60 member membership number : " + arrayList.get(i).getmembershipNumber());
                System.out.println("Over 60 member Name : " + arrayList.get(i).getName());
                System.out.println("Over 60 member membership start date :  " + arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear());
                System.out.println("Over 60 member age : " + ((Over60Member) arrayList.get(i)).getAge());
            }

            //print default member details
            else {
                System.out.println("  ");
                System.out.println("Member type : Default member");
                System.out.println("Default member membership number : " + arrayList.get(i).getmembershipNumber());
                System.out.println("Default member Name : " + arrayList.get(i).getName());
                System.out.println("Default member membership start date :  " + arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear());
            }
        }
    }

    @Override
    //sort item method
    public void sortItem() {
        ArrayList<String> nameArrayList = new ArrayList();

        for (int i = 0; i < arrayList.size(); i++ ){
            nameArrayList.add(arrayList.get(i).getName());
        }

        for (int i=0; i<arrayList.size();i++){
            System.out.println(nameArrayList.get(i));
        }

        for (int i=0;i<arrayList.size()-1;i++){
            for (int j=0;j<arrayList.size()-1-i;j++){
                if (nameArrayList.get(j).compareTo(nameArrayList.get(j+1) )> 0){
                    String n = nameArrayList.get(j);
                    nameArrayList.set(j, nameArrayList.get(j+1));
                    nameArrayList.set(j+1,n);
                }
            }
        }

        System.out.println(" ");
        System.out.println("--After sort--");
        for (int i=0; i<arrayList.size(); i++){
            System.out.println(nameArrayList.get(i));
        }
    }

    @Override
    //save file method
    public void saveFile() {
        try{
            //save in text file
            FileWriter saveFile = new FileWriter("SaveFile.txt", true);
            BufferedWriter saveFileBuf = new BufferedWriter(saveFile);

            for (int i=0; i<arrayList.size(); i++){

                //save membership number
                saveFileBuf.write("Membership number : " + arrayList.get(i).getmembershipNumber());
                saveFileBuf.newLine();

                //save membership name
                saveFileBuf.write("Member Name : " + arrayList.get(i).getName());
                saveFileBuf.newLine();

                //save school name
                if (arrayList.get(i) instanceof StudentMember ) {
                    saveFileBuf.write("Student school name : " + ((StudentMember) arrayList.get(i)).getSchoolName());
                    saveFileBuf.newLine();
                }
                //save age details
                else if (arrayList.get(i) instanceof Over60Member ) {
                    saveFileBuf.write("Over 60 member age : " + ((Over60Member) arrayList.get(i)).getAge());
                    saveFileBuf.newLine();
                }

                //save membership date
                saveFileBuf.write("Membership start date :  " + arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear());
                saveFileBuf.newLine();
            }
            saveFileBuf.close();
            System.out.println("File saved.");
            //error handling
        }catch (Exception e){
            System.out.println("The file could not be saved.");
        }
    }

    @Override
    //search member method
    public void searchMember() {
        //create new stage
        Stage stageHome = new Stage();
        stageHome.setTitle("My Gym Manager");
        stageHome.setResizable(false);

        //get new anchorpane
        AnchorPane anc01 = new AnchorPane();

        //background image
        Image image01 = new Image("image01.png");
        ImageView viewImage01 = new ImageView();
        viewImage01.setImage(image01);
        viewImage01.setOpacity(0.8);
        viewImage01.setFitHeight(500);
        viewImage01.setFitWidth(700);

        //topic
        Label lb01 = new Label("My Gym Manager");
        lb01.setLayoutX(185);
        lb01.setLayoutY(20);
        lb01.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

        //search bar
        TextField tf01 = new TextField();
        tf01.setLayoutX(190);
        tf01.setLayoutY(110);
        tf01.setPrefWidth(330);
        tf01.setStyle("-fx-background-color : aqua");

        //search button
        Button bt01 = new Button("Search");
        bt01.setLayoutX(275);
        bt01.setLayoutY(160);
        bt01.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt01.setPrefHeight(40);
        bt01.setPrefWidth(150);

        //set action for search button
        bt01.setOnAction(event -> {
            Stage stageSearch = (Stage) bt01.getScene().getWindow();

            //get new anchorpane for search member details
            AnchorPane ancPane02 = new AnchorPane();

            //topic
            Label lbManager = new Label("My Gym Manager");
            lbManager.setLayoutX(140);
            lbManager.setLayoutY(20);
            lbManager.setStyle("-fx-font-size: 42;-fx-text-alignment: center");

            //membership number label
            Label lb02_1 = new Label("Membership Number :");
            lb02_1.setLayoutX(40);
            lb02_1.setLayoutY(120);
            lb02_1.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

            //member name label
            Label lb02_2 = new Label("Name :");
            lb02_2.setLayoutX(40);
            lb02_2.setLayoutY(180);
            lb02_2.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

            //student member school name label
            Label lb02_3 = new Label("School Name :");
            lb02_3.setLayoutX(40);
            lb02_3.setLayoutY(240);
            lb02_3.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

            //over 60 member age label
            Label lb02_4 = new Label("Age :");
            lb02_4.setLayoutX(40);
            lb02_4.setLayoutY(300);
            lb02_4.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

            //membership start date label
            Label lb02_5 = new Label("Membership Start Date :");
            lb02_5.setLayoutX(40);
            lb02_5.setLayoutY(360);
            lb02_5.setStyle("-fx-font-size: 20;-fx-text-alignment: center");

            //textfield for membership number details
            TextField tf02_1 = new TextField();
            tf02_1.setLayoutX(320);
            tf02_1.setLayoutY(120);
            tf02_1.setPrefWidth(200);

            //textfield for member name details
            TextField tf02_2 = new TextField();
            tf02_2.setLayoutX(320);
            tf02_2.setLayoutY(180);
            tf02_2.setPrefWidth(200);

            //textfield for student member school name
            TextField tf02_3 = new TextField();
            tf02_3.setLayoutX(320);
            tf02_3.setLayoutY(240);
            tf02_3.setPrefWidth(200);

            //textfield for over 60 member age
            TextField tf02_4 = new TextField();
            tf02_4.setLayoutX(320);
            tf02_4.setLayoutY(300);
            tf02_4.setPrefWidth(200);

            //textfield for membership start date details
            TextField tf02_5 = new TextField();
            tf02_5.setLayoutX(320);
            tf02_5.setLayoutY(360);
            tf02_5.setPrefWidth(200);

            //get name or membership number of the person who want to search
            String inputText = tf01.getText();

            for (int i=0;i<arrayList.size();i++){
                //search details with membership number
                String strNum = Integer.toString(arrayList.get(i).getmembershipNumber());
                if (inputText.equals(strNum)){

                    //student member details
                    if (arrayList.get(i) instanceof StudentMember ) {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        String school = ((StudentMember) arrayList.get(i)).getSchoolName();
                        tf02_3.setText(school);
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }

                    //over 60 member details
                    else if (arrayList.get(i) instanceof Over60Member ) {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        int age = ((Over60Member) arrayList.get(i)).getAge();
                        tf02_4.setText(String.valueOf(age));
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }

                    //default member details
                    else {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }
                }

                //search details with member name
                else if (inputText.equals(arrayList.get(i).getName())){
                    //student member details
                    if (arrayList.get(i) instanceof StudentMember ) {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        String school = ((StudentMember) arrayList.get(i)).getSchoolName();
                        tf02_3.setText(school);
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }

                    //over 60 member details
                    else if (arrayList.get(i) instanceof Over60Member ) {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        int age = ((Over60Member) arrayList.get(i)).getAge();
                        tf02_4.setText(String.valueOf(age));
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }

                    //default member details
                    else {
                        int memberNum = arrayList.get(i).getmembershipNumber();
                        tf02_1.setText(String.valueOf(memberNum));
                        String name = arrayList.get(i).getName();
                        tf02_2.setText(name);
                        String regDate = arrayList.get(i).getRegDate().getDay()+ "/" +arrayList.get(i).getRegDate().getMonth() + "/" + arrayList.get(i).getRegDate().getYear();
                        tf02_5.setText(regDate);
                    }
                }
            }

            //back button for search result
            Button btBack = new Button("Back");
            btBack.setLayoutX(490);
            btBack.setLayoutY(420);
            btBack.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
            btBack.setPrefHeight(40);
            btBack.setPrefWidth(90);
            btBack.setOnAction(e -> stageHome.setScene(sceneMain));

            //add childrens for search result anchorpane
            ancPane02.getChildren().addAll(lbManager,lb02_1,lb02_2,lb02_3,lb02_4,lb02_5,tf02_1,tf02_2,tf02_3,tf02_4,tf02_5,btBack);

            //add anchorpane to sceneSearch
            sceneSearch=new Scene(ancPane02, 620, 500);
            stageSearch.setScene(sceneSearch);
            stageSearch.setTitle("Search");
            stageSearch.show();
        });

        //button to list of member table view
        Button bt02 = new Button("List of Members");
        bt02.setLayoutX(250);
        bt02.setLayoutY(290);
        bt02.setStyle("-fx-font-size: 20;-fx-text-alignment: center; -fx-background-radius: 20; -fx-background-color: #7FFFD4");
        bt02.setPrefHeight(40);
        bt02.setPrefWidth(200);
        bt02.setOnAction(event -> {
            //Create new stage for table view
            Stage stage = new Stage();
            //get table view
            TableView table01 = new TableView();

            //add membership number for column
            TableColumn<String, DefaultMember> col01 = new TableColumn<>("Membership Number");
            col01.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

            //add name for column
            TableColumn<String, DefaultMember> col02 = new TableColumn<>("Name");
            col02.setCellValueFactory(new PropertyValueFactory<>("name"));

            //add membership start date for column
            TableColumn<String, DefaultMember> col03 = new TableColumn<>("Start Membership Date");
            col03.setCellValueFactory(new PropertyValueFactory<>("date"));

            //add membership type for column
            TableColumn<String, DefaultMember> col04 = new TableColumn<>("Membership Type");
            col04.setCellValueFactory(new PropertyValueFactory<>("type"));

            //add columns to table view
            table01.getColumns().addAll(col01, col02, col03 , col04);

            //add informations to table view columns
            for (DefaultMember defaultMember : arrayList){

                //add over 60 member details
                if (defaultMember instanceof Over60Member){
                    table01.getItems().add(new Over60Member(defaultMember.getmembershipNumber(), defaultMember.getName(), defaultMember.getRegDate(), "Over 60 member"));
                }

                //add student member details
                else if (defaultMember instanceof StudentMember){
                    table01.getItems().add(new StudentMember(defaultMember.getmembershipNumber(), defaultMember.getName(), defaultMember.getRegDate(), "Student member"));
                }

                //add default member details
                else {
                    table01.getItems().add(new DefaultMember(defaultMember.getmembershipNumber(), defaultMember.getName(), defaultMember.getRegDate(),"Default member"));
                }
            }
            //add table view to stage
            stage.setScene(new Scene(table01, 600, 500));
            stage.showAndWait();
        });

        //Button to exit programme
        Button bt06 = new Button("Exit");
        bt06.setLayoutX(305);
        bt06.setLayoutY(410);
        bt06.setStyle("-fx-font-size: 20;-fx-text-alignment: center");
        bt06.setPrefHeight(40);
        bt06.setPrefWidth(90);

        //add childrens to anchorpane
        anc01.getChildren().addAll(viewImage01, lb01, tf01, bt01, bt02, bt06);

        // set action to exit button
        bt06.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) bt06.getScene().getWindow();
                stage.close();
            }
        });

        //add sceneMain to stageHome
        sceneMain=new Scene(anc01, 680, 520);
        stageHome.setScene(sceneMain);
        stageHome.showAndWait();
    }
}