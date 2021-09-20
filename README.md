# DemoApplication

Requirements:
-JDK> = 1.8

-Maven> = 3.8.2

1)Download the zip version of the project
2)Extract the project to another folder
3)cd DemoApplication-master/DemoApplication
4)Run the compile command: -mvn package
5)Launch the execution command: -mvn exec:java -Dexec.mainClass=net.codejava.DemoApp


🅴🅽🅹🅾🆈 🆃🅷🅴 🅶🅰🅼🅴!

DESCRIPTION:

The application does nothing but make available 8 commands managed by a single exception that depends on the program input.

The commands are as follows:

1. Add Person (id, firstName, lastName)
2. Edit Person (firstName, lastName)
3. Delete Person (id)
4. Add Address to person (id, street, city, state, postalCode)
5. Edit Address (street, city, state, postalCode)
6. Delete Address (id)
7. Count Number of Persons
8. List Persons

Every time you execute a command the program will end and to continue performing actions you have to restart it.
SQLite is used as a database.

I hope you have fun.
