OOp tries to map code instructions with real world making the code short and easier to understand

wht is oops?
Solving a  problem by creating objects is one of the most popular approaches in programming

wht is DRY?
it stands for do not repeat yourself - focuses on code reusability

Class 
a class is a blueprint for creating objects

Object
an object is an instantiation of a class. when a class is defined a template (info) is defined. memory is allocated only after object instantiation.

How to model a problem in OOPs
we identify the following:
Noun -> class -> Employee
Adjective -> Attributes -> name , age , salary
verb -> Methods -> getSalary(),increment()



OOps Terminology

1. Abstraction:
Hiding internal details - showing only essential info
for ex: use this phone without bothering about how it was made

2. Encapsulation :
the act of putting various components together - in a capsule
ex: laptop is a single entity with wifi+ speaker + storage in a single box

In java, encapsulation simply means that the sensitive data can be hidden from the users


3. Inheritance : The act of deriving new things from existing things

Rickshaw - E-rickshaw
Phone - Smart Phone          Implements DRY! very well 

4. Polymorphism : One entity many forms

Smartphone- Phone 
Smartphone - Calculator


Writing a custom class
we can write a custom class as follows:

public class Employee{
    int id;  Attribute1
    String name;   Attribute 2
}

any real world object= properties+behaviour
object in oops= Attributes + Methods

In one java file there can be only one public class