# talent-recommender-service

This project presents the design of a talent recommender system. The design is depicted through a UML class diagram and implemented in Java. 

Comments regarding the UML class diagram:
- Associations are used in lieu of concrete fields per OO conventions
	- For example, Users are composed of a set of Skills

Assumptions:
- Each project has at most one owner
	- The owner cannot be changed post-assignment
- Requirements are flexible; users can be assigned to a project without meeting all requirements
  based on priority
- Applicants are prioritized by match score
	- Applicants with the same score are arbitrarily prioritized

