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

    public Company() {
        // stub
    }

    public String getName() {
        // stub
        return null;
    }

    public String getRatings() {
        // stub
        return null;
    }
}
