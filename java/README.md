# Java Primer
Everything is an object. The exception is there are a few primatives but they also have object types as well (ex: int -> Integer)

The language is extremely verbose, so.....much.....typing......

Static typing is your friend. There is an option to use var to infer the type if you'd like however convention is typically declaring yourself.

Constants. They are declared with the `final` keyword.

Public/private/protected. Typically don't want any of the data/variables/methods in the class exposed outside of it, they should be private. Public would allow anyone to access that data/method. Protected.....I never really use this one but it allows the item to be publically available at the package level.

Exception handling: try/catch/finally. When making an http request, you will need a try block as it's possible for the request two throw two different classes of exceptions. You could make a single catch block and catch the Generic Exception, or you can make multiple catch blocks off of the same try block to handle each of them differently. The finally block will always run irregardless of an exception being thrown.

Autoboxing, this is something that is only really useful for objects of primatives like (int to Integer), it'll allow for you to just treat the Integer object as if it were a primative. 

String comparison, you can't just do == on a string. The reason for this is java will compare the adresses and not the value of the strings so it will only return true if and only if it's the literal exact same string object. Use the `.equals()` method.

Static variables and methods. This is a variable or method that can be used without instantiation of an object. By being static, the item is shared with all instantiations of the class as well as can be used without instantating the class. The client example has these, all methods are static so we never actually instantate the client class and just use the static methods available.

Collections lib can be basically thought of as a std lib for Java, it has the majority of the typically used data structures and basic algorithms that you'd need like `sort`.

If you use ternaries or lambdas, Java is picky about side effects and it should identify it within the IDE.

Encapsulation is everything since OOP. You have to manually write your getters and setters unlike in ruby where you just set the accessor attribute thingy. (Project Lombok is for just setting an annotation and it'll autogenerate them for you).

Java annotations, they look kinda like `@SuppressWarnings` or `@Bean`, there shouldn't be any in the client side or atleast in this portion for our project.

Java bean. A bean is a class that implements Seriablizable; I don't think this will pop up.

# Design Patterns
These should be the only two that I can think of that may be in the project.

## Singleton
It's a method of guarenteeing that there will only ever be one instance of a class. We shouldn't ever want two http clients for updating for example.

## Factory
A method that takes no parameters and builds out an instance of what you want, all configuration for that instance is handled in the method by reading in properties from a config file, pom, javav properties etc. So calling something like `Factory.getHttpClient()` will then instantiate a HTTP Client