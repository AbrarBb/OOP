#include <iostream>
using namespace std;

// Base class - Person
class Person 
{
protected:
    string name;
    int age;

public:
    // Constructor to initialize name and age
    Person(string n, int a) : name(n), age(a) {}

    // Method to display details about the person
    void displayDetails() 
    {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
    }
};

// Derived class - Student (inherits from Person)
class Student : public Person 
{
private:
    string schoolName;

public:
    // Constructor to initialize name, age, and school name
    Student(string n, int a, string s) : Person(n, a), schoolName(s) {}

    // Method to display details about the student (overrides the base class method)
    void displayDetails() 
    {
        Person::displayDetails();  // Call base class displayDetails
        cout << "School: " << schoolName << endl;
    }
};

int main() {

    Person person1("John Doe", 30);

    Student student1("Alice Smith", 20, "Green Valley High School");

    // Display details of the Person and Student
    cout << "Person Details:" << endl;
    person1.displayDetails();

    cout << "\nStudent Details:" << endl;
    student1.displayDetails();

    return 0;
}
