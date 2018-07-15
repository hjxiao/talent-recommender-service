package DataModel;

import User.*;
import javafx.util.Pair;

import java.util.Comparator;

public class ApplicantComparator implements Comparator<Pair<User, Integer>> {

    /*
    Purpose: Orders two applicants based on their match score.
    Params:
        - a, b : Pair<User, Integer> - the applicants to be compared
    Returns:
        - negative if applicant "a" is stronger than "b"
        - zero if both applicants have the same match score
        - positive if applicant "a" is weaker than "b"
    Throws: -
     */
    public int compare(Pair<User, Integer> a, Pair<User, Integer> b) {
        if (a.getValue() < b.getValue()) {
            return -1;
        } else if (a.getValue() == b.getValue()) {
            return 0;
        }

        return 1;
    }
}
