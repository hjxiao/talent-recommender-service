package RecommenderSystem;

import Business.*;
import User.User;

public interface RecommenderStrategy {

    /*
    Purpose:
    Params:
        - a, b : Pair<User, Integer> - the applicants to be compared
    Returns:
        - An integer match score greater than or equal to 0
    Throws: -
     */
    int analyzeMatch(Project p, User u);
}
