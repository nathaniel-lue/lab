# OOSE Lab Exam Bank

# Task One - Design Decisions

# I made the choice to use two design patterns in my implementation: The factory design pattern and the Composite Design pattern


# The reason i chose to use the factory design pattern was because the question stated that the bank class should not be amended
# if the format of the csv file was changed which suits this design pattern

# The reason i chose to use the composite design pattern was because it let me add both trader groups and traders to the trader groups
# by making them implement an interface.


# Task Two - Design Decisions

# I decided to use recursion to check the balance of every trader in a group. I did this so my program would be able to deal with multiple levels
# of trader groups within trader groups.


# Task Four - Design Decisions

# I decided to use a observer design pattern to notify the Team leads as the observer design patter is useful for dealing with information being
# sent and recieved. I had to change the trader factory so that every person is given a team lead.