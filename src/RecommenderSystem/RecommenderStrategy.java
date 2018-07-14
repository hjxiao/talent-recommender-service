package RecommenderSystem;

import Business.*;
import User.User;

public interface RecommenderStrategy {
    /*

     */
    int analyzeMatch(Project p, User u);
}
