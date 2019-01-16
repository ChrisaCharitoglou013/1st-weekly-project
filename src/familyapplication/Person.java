
package familyapplication;

/**
 * @author Xrysa
 */
public class Person {
    // The initial values are way different than the accepted ones for each field, so that it is obvious if an object still has the default values.
    private String role = "Unknown";  // Accepted values: father, mother, son, daughter. No need to check for validity as this is not a user input.
    private String firstName = "Unknown";
    private String lastName = "Unknown";
    private int age = 999; // Accepted values: integers in the range [0 - 123) because an infand can be less than a year old, and according to wikipedia the oldest person ever is reported to have died a few months before reaching the age of 123.
    private String sex = "Unknown"; // Accepted values: male, female
    private String favoriteSeason = "Unknown"; // Accepted values: Winter, Autumn, Spring, Summer.
    
    /**
     * Constructors
     * Some of the checks and tasks performed by the second constructor are similar with those performed by FamilyApplication.gatherInfo(who) method.
     * This is because the constructor is designed to make all the validity checks and some necessary modifications in order to  
     * be able to function properly, even if it is used with some other data entry method that may not have already performed those checks 
     * before passing the data to the constructor. The same applies to the relative setters.
     */
    public Person(){
    }
    
    public Person(String role, String firstName, String lastName, int age, String sex, String favoriteSeason){
        
        this.role = role;
        
        firstName = firstName.trim();
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        
        lastName = lastName.trim();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        
        if (age >= 0 && age < 123){
            this.age = age;
        }
        
        sex = sex.trim().toLowerCase();
        if(role.equals("father") || role.equals("son")){
            if (sex.equals("male")){
                this.sex = sex;
            }
        }else if(role.equals("mother") || role.equals("daughter")){
            if (sex.equals("female")){
                this.sex = sex;
            }
        }
        
        
        favoriteSeason = favoriteSeason.trim();
        favoriteSeason = favoriteSeason.substring(0, 1).toUpperCase() + favoriteSeason.substring(1).toLowerCase();
        if (favoriteSeason.equals("Winter") || favoriteSeason.equals("Autumn") 
                || favoriteSeason.equals("Spring") || favoriteSeason.equals("Summer")){
            this.favoriteSeason = favoriteSeason;
        }
    }
    
    // Setters and Getters
    
     public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public void setFirstName(String firstName){
        firstName = firstName.trim();
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        lastName = lastName.trim();
        this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setAge(int age){
        if (age >= 0 && age < 123){
            this.age = age;
        }
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setSex(String sex){
        sex = sex.trim().toLowerCase();
        if (sex.equals("male") || sex.equals("female")){
            this.sex = sex;
        }
    }
    
    public String getSex(){
        return this.sex;
    }
    
    public void setFavoriteSeason(String favoriteSeason){
        favoriteSeason = favoriteSeason.trim();
        favoriteSeason = favoriteSeason.substring(0, 1).toUpperCase() + favoriteSeason.substring(1).toLowerCase();
        if (favoriteSeason.equals("Winter") || favoriteSeason.equals("Autumn") 
                || favoriteSeason.equals("Spring") || favoriteSeason.equals("Summer")){
            this.favoriteSeason = favoriteSeason;
        }
    }
    
    public String getFavoriteSeason(){
        return this.favoriteSeason;
    }
    
    // A method to print a person's information
    public void printInfo(){
        String noun;
        String pronoun;
        if (role.equals("father")||role.equals("son")){
            noun = "He";
            pronoun = "his";
        }else{
            noun = "She";
            pronoun = "her";
        }
        String role = this.role.substring(0, 1).toUpperCase() + this.role.substring(1);
        System.out.println(role + ": " + firstName + " " + lastName + " is " + age + " years old. " + noun + " is " + sex + " and " + pronoun +" favorite season is "+ favoriteSeason + "!");
    }
    
    // A method to print a person's age in 2050.
    public void printAgeIn2050(){
        int age = this.age + (2050 - 2018);
        System.out.println( firstName + "'s age in 2050 will be " + age + " years old." );
    }
    
    // A method to print a certain message according to a person's favorite season.
    public void printMessageAccordingToSeason(){
        String favoriteSeason = this.favoriteSeason.toUpperCase();
        
        switch(favoriteSeason){
            case "WINTER":
                System.out.println(firstName + " likes snow");
                break;
            case "AUTUMN":
                System.out.println(firstName + " likes rain");
                break;
            case "SPRING":
                System.out.println(firstName + " likes flowers");
                break;
            case "SUMMER":
                System.out.println(firstName + " likes swimming");
                break;
            default:    // Not needed. It's here just to check that everything runs smoothly.
                System.out.println("Something went wrong!"); 
        }
    }
}
