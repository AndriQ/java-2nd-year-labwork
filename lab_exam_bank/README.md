# OOSE Lab Exam Bank

# Task One - Design Decisions

# In this task I used the Factory and Composite Design Pattern. Factory pattern provides a way of creating objects without having to show the instantiation logic to the client. This means that if the process of creating the object is complicated, new methods need to be added or other changes are required in the future like (we want to avoid the bank class being amended if a new role is added or the csv format changes), these changes are encapsulated in the factory and there is no need for client code to change. 

# Composite Pattern enables to compose objects into a tree structure to represent part-whole hierarchies like traders within groups and subgroups. This pattern also allows to perform the same operations on all traders which makes the client code easier to understand and allows for a simpler process of adding new traders, subgroups and further subgroups. 

# Task Two - Design Decisions

# Due to implementing the Composite Design Pattern, I was able to easily iterate over all the groupMembers in the group. If the entry was a Trader I printed their balance, if the entry was a TraderGroupComposite, I recursively called the checkBalances method on the group which would print the balance of each Trader in the group. This recursion allowed to iterate through all subgroups within a group and check the balances of all traders including team leads.
# In the TraderGroupComposite class, the groupMembers list is private which means it can only be accessed/modified within the same class. Other classes can call the checkBalances method and the add method which adds new entries like traders or subgroups.

# Task Four - Design Decisions

# In this task I used the Observer Design Pattern to notify observers if a traders balance has exceeded the limits. I made TraderCompositeObserver implement the Observer interface and TraderAssetDeskSubject implement the Subject interface. This design pattern allows for observers to be easily added or removed which means if a team lead were to be fired, the removeObserver method can be called in the TraderAssetDeskSubject class. 
# I implemented this design pattern many ways and this was the only way I was able to make it work, where only the team lead of the trader is notified of an exceeding balance. To notify the team lead, if the trade method is called and traderAssetDesk has been created, trader.checkBalanceAndNotify() can be called which will check the balance of the trader against the limits set in the traderAssetDesk class and notify the team leader if required.