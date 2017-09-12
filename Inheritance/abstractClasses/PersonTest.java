package abstractClasses;
/**
 * This program demonstrate abstract classes
 * @version 1.01 2004-02-21
 * @author Zehua Wang
 */
 public class PersonTest
 {
    Person[] people = new Person[2];
    
    //fill the people array with Student and Employee objects
    people[0] = new Employee("Harry",50000,1989,10,1);
    people[1] = new Student("Maria","computer science);
     
     //print out names and description of all Person bojects
     for(int i=0; i<people.length;i++)
     {
      System.out.println(people[i].getName() + ", " + people[i].getDescription());
      }
 }
