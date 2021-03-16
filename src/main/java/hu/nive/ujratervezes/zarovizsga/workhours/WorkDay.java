package hu.nive.ujratervezes.zarovizsga.workhours;

public class WorkDay {
    private String name;
    private String date;
    private int hours;

    public WorkDay(String name, String date, int hours) {
        this.name = name;
        this.date = date;
        this.hours = hours;
    }

    public WorkDay() {
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return  name + ": " + date;
    }
}
