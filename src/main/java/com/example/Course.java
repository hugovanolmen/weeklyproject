package com.example;

import java.util.UUID;

public class Course {

    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getCourseId(){
        return courseId;
    }

    public void setCourseId(String courseId){
        this.courseId = courseId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getMoneyEarned(){
        return money_earned;
    }

    public void setMoneyEarned(double money_earned){
        this.money_earned = money_earned;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + name + ", Price: " + price +
               ", Money Earned: " + money_earned + ", Teacher: " + (teacher != null ? teacher.getName() : "None");
    }

}
