package org.tae.exercises.people;

public class Teacher extends Person implements CalculableSalary{
    private int expYears;
    private double baseSalary;
    private boolean isFullTime;
    private float hoursPerWeek;

    public Teacher(String name, String id, int expYears, double baseSalary, boolean isFullTime) {
        this.setName(name);
        this.setId(id);
        this.expYears = expYears;
        this.baseSalary = baseSalary;
        this.isFullTime = isFullTime;
        this.hoursPerWeek = 0;
    }

    public void addWeekHours(int hours){
        this.hoursPerWeek += hours;
    }

    public double calculateActualSalary(){
        if(isFullTime) {
            return baseSalary * (expYears * salaryMultiplier);
        }else{
            return baseSalary * hoursPerWeek;
        }

    }
    public int getExpYears() {
        return expYears;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public void showYourself() {
        StringBuilder message = new StringBuilder();
        message.append("***\t ");
        message.append(getId());
        message.append("\t - \t");
        message.append(getName());
        message.append("\t - \t");
        message.append(getExpYears());
        message.append("\t***");
        message.append(calculateActualSalary());
        message.append("\t***");
        message.append(((isFullTime()) ? "Yes" : "No"));
        message.append("\t***");
        System.out.println(message.toString());
    }
}
