package Business;

import User.*;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Company {
    private String name;
    private HashMap<Project, Pair<User, Integer>> employeeRatings;
    private ArrayList<Project> projects;
    private HashSet<User> employees;

    public Company(String nm) {
        this.name = nm;
        this.employeeRatings = new HashMap<Project, Pair<User, Integer>>();
    }

    public String getName() { return name; }

    public HashMap<Project, Pair<User, Integer>> getRatings() { return employeeRatings; }
    public void addRating(Project p, Pair<User, Integer> r) {
        employeeRatings.put(p, r);
    }
}
