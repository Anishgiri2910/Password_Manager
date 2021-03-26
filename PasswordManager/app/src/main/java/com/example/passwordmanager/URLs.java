package com.example.passwordmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "urls")
public class URLs{

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "webpage")
    private String Webpage;

    @ColumnInfo(name = "username")
    private String Username;

    @ColumnInfo(name = "password")
    private String Password;

    @ColumnInfo(name = "phoneNumber")
    private String PhoneNumber;

    @ColumnInfo(name = "question1")
    private String Question1;

    @ColumnInfo(name = "answer1")
    private String Answer1;

    @ColumnInfo(name = "question2")
    private String Question2;

    @ColumnInfo(name = "answer2")
    private String Answer2;

    @ColumnInfo(name = "question3")
    private String Question3;

    @ColumnInfo(name = "answer3")
    private String Answer3;

    public URLs(String webpage, String username, String password, String phoneNumber, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
        this.Webpage=webpage;
        this.Username=username;
        this.Password=password;
        this.PhoneNumber=phoneNumber;
        this.Question1=question1;
        this.Answer1=answer1;
        this.Question2=question2;
        this.Answer2=answer2;
        this.Question3=question3;
        this.Answer3=answer3;
    }

    public int getId() {
        return Id;
    }

    public String getWebpage() {
        return this.Webpage;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getQuestion1() {
        return Question1;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public String getQuestion2() {
        return Question2;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public String getQuestion3() {
        return Question3;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public void setId(int id) { this.Id=id; }



    public void setWebpage(String webpage) {
        this.Webpage=webpage;
    }

    public void setUsername(String username) {
        this.Username=username;
    }

    public void setPassword(String password) {
        this.Password=password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber=phoneNumber;
    }

    public void setQuestion1(String question1) {
        this.Question1=question1;
    }

    public void setAnswer1(String answer1) {
        this.Answer1=answer1;
    }

    public void setQuestion2(String question2) {
        this.Question2=question2;
    }

    public void setAnswer2(String answer2) {
        this.Answer2=answer2;
    }

    public void setQuestion3(String question3) {
        this.Question3=question3;
    }

    public void setAnswer3(String answer3) { this.Answer3=answer3;  }

    public URLs(){}
//    public URLs(@NonNull int id, String webpage, String username, String passwrd, String phoneNumber, String question1, String answer1, String question2, String answer2, String question3, String answer3) {
//        this.Id = id;
//        this.Webpage = webpage;
//        this.Username = username;
//        this.Passwrd = passwrd;
//        this.PhoneNumber = phoneNumber;
//        this.Question1 = question1;
//        this.Answer1 = answer1;
//        this.Question1 = question2;
//        this.Answer2 = answer2;
//        this.Question1 = question3;
//        this.Answer3 = answer3;
//    }

}