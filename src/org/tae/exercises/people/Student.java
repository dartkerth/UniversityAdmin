package org.tae.exercises.people;

public class Student extends Person {
    private int age;

    public Student(String name, String id, int age) {
        setName(name);
        setId(id);
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public void showYourself() {
        StringBuilder message = new StringBuilder();
        message.append("***\t ");
        message.append(getId());
        message.append("\t - \t");
        message.append(getName());
        message.append("\t - \t");
        message.append(getAge());
        message.append("\t***");
        System.out.println(message.toString());
    }
}
