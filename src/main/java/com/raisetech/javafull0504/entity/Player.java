package com.raisetech.javafull0504.entity;

public class Player {
    // [players] table colomns.
    // Object creation on the Java side.
    private int id;
    private String name;
    private int age;
    private String state;

    // Constructor
    // コンストラクタは生成時の初期化を行う
    public Player(int id, String name, int age, String state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
    }

    //Getters and Setters.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getState() {
        return state;
    }

}
