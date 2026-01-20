package university.management.system;

    // abstract because we don't want to creat objects here
public abstract class Person { 
    
   //Attributes
    protected String name;//protected because we use it in all inherted class
    protected int id;
    
//Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public int getId() { //getter for id
    return id;
}
//Method
    public abstract void displayDetails(); 
    
}