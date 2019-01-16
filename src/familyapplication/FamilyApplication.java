/**
 * This is a small application designed to get from the user the data of
 * a family that consists of a father, a mother, a son and a daughter. It sorts them by age 
 * and then print them in descending order (from oldest to youngest). It then prints
 * in the same order everyone's age in 2050 and a message according to their favorite season.
 */
package familyapplication;

import java.util.Scanner;

/**
 * @author Xrysa
 */
public class FamilyApplication {
        
    public static void main(String[] args) {
        
        String who;

        Person father;
        Person mother;
        Person son;
        Person daughter;
        
        Person[] familyOrderedByAge;
        
        // Welcome the user:
        System.out.println("Welcome to the family Application!");
        
        // Ask the user to enter the information about every family member:
        who = "father";
        father = gatherInfo(who);
        
        who = "mother";
        mother = gatherInfo(who);
        
        who = "son";
        son = gatherInfo(who);
        
        who = "daughter";
        daughter= gatherInfo(who);
        
        // Family order by age in descending order (oldest to youngest):
        familyOrderedByAge = orderByAge(father, mother, son, daughter);
        
        System.out.println("\nThe data you entered ordered by age (in descending order), are the following: \n");
        // Print all the data ordered by age (in descending order):
        for(int i = 0; i < 4; i++){
            familyOrderedByAge[i].printInfo();
        }
        
        System.out.println("\nAges in 2050 will be: \n");
        // Print everyone's age in 2050 in descending order (oldest to youngest):
        for(int i = 0; i < 4; i++){
            familyOrderedByAge[i].printAgeIn2050();
        }
        
        System.out.println("\nEveryone's preference according to their favorite season: \n");
        // Print the relative message according to everyone's favorite season in descending order according to their age(oldest to youngest):
        for(int i = 0; i < 4; i++){
            familyOrderedByAge[i].printMessageAccordingToSeason();
        }              
        
    }
    
    
   /**
    * This is a method that is used in order to create an object from the class Person based on user input.
    * It is designed to make some necessary checks in order to gather from the user correct data and provide them to the constructor.
    * The parameter (who) refers to the role of the person in the family (father, mother, son, daughter).
    */
    public static Person gatherInfo(String who){
        
        Scanner sc = new Scanner(System.in);
                
        System.out.println("\nEnter " + who + "'s first name: ");
        String firstName = sc.nextLine();
                
        System.out.println("\nEnter " + who + "'s last name: ");
        String lastName = sc.nextLine();
                
        int age;
        do{
            System.out.println("\nEnter " + who + "'s age: ");
            age = sc.nextInt();
            String bugsolving = sc.nextLine();  /* Consume newline left-over (This is a solution suggested online 
                           for the problem that occurs when using sc.nextLine(); after using sc.nextInt(); where it skips a line. ) */
            if ((age < 0) || (age >= 123)){
                System.out.println("\nThe age you entered seems to be wrong. ");
            }
        } while((age < 0) || (age >= 123));
        
        String sex;
        if(who.equals("father") || who.equals("son")){
            do{
                System.out.println("\nEnter " + who + "'s sex (male/female): ");
                sex = sc.nextLine();
                sex = sex.trim();
                if (!(sex.toLowerCase().equals("male"))){
                    System.out.println("\nThe sex you entered seems to be wrong. \n" + "The " + who + " can only be a male!");
                }
            } while (!(sex.toLowerCase().equals("male")));
        }else{
            do{
                System.out.println("\nEnter " + who + "'s sex (male/female): ");
                sex = sc.nextLine();
                sex = sex.trim();
                if (!(sex.toLowerCase().equals("female"))){
                    System.out.println("\nThe sex you entered seems to be wrong. \n" + "The " + who + " can only be a female!");
                }
            } while (!(sex.toLowerCase().equals("female")));
        }
        
        String favoriteSeason;
        do{
            System.out.println("\nEnter " + who + "'s favorite season: ");
            favoriteSeason = sc.nextLine();
            favoriteSeason = favoriteSeason.trim();
            favoriteSeason = favoriteSeason.substring(0, 1).toUpperCase() + favoriteSeason.substring(1).toLowerCase();
            if (!(favoriteSeason.equals("Winter") || favoriteSeason.equals("Autumn") 
                || favoriteSeason.equals("Spring") || favoriteSeason.equals("Summer"))){
                System.out.println("The season you entered seems to be wrong. \nYou must enter one of the following: \nWinter, Autumn, Spring, Summer.");
            }
        } while (!(favoriteSeason.equals("Winter") || favoriteSeason.equals("Autumn") 
                || favoriteSeason.equals("Spring") || favoriteSeason.equals("Summer")));
        
        
        Person person = new Person(who, firstName, lastName, age, sex, favoriteSeason);
        return person;
    }
    
    
   /**
    * This is a method that takes as parameters the members of the family, which are 4 objects of the class Person 
    * and sorts them by age, going from the oldest to the youngest. 
    * It returns an array of those 4 person objects in descending order.
    */
    public static Person[] orderByAge(Person father, Person mother, Person son, Person daughter){
        
        Person[] family = {father, mother, son, daughter};
        Person aPerson;
        
        // Reordering the family according to age:
        for (int x = 1; x < family.length; x++){
            for(int i = 0; i < (family.length - 1); i++){
                if(family[i+1].getAge() > family[i].getAge()){
                    aPerson = family[i];
                    family[i] = family[i+1];
                    family[i+1] = aPerson;
                }
            }
        }              
        return family;        
    }
    
}
