package com.example.swagger.model;

public class Student {
    private String id;
    private String name;

    public static Builder builder() {
        return new Builder();
    }
    public Student() {
    }

    private Student(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public static final class Builder{
        private String id;
        private String name;

        public Builder id(String id){
            this.id=id;
            return this;
        }
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
