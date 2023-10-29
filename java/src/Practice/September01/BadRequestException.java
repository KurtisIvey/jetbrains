package Practice.September01;

// Define a custom checked exception named BadRequestException
public class BadRequestException extends Exception {
    // Constructor for the custom exception, which takes a String message as an argument
    public BadRequestException(String message) {
        // Call the constructor of the superclass (Exception) with the provided message
        super(message);
    }
}
/*
public class BadRequestException extends Exception: This line defines a new class named BadRequestException that
extends the built-in Exception class. By extending Exception, we create a custom checked exception.

public BadRequestException(String message): This is the constructor for the BadRequestException class. It takes a
String parameter named message, which represents the description or reason for the exception.

super(message);: Inside the constructor, the super keyword is used to call the constructor of the
superclass (Exception) and pass the message argument to it. This sets the message for the exception and utilizes
the behavior provided by the Exception class for managing exception messages.

With this custom BadRequestException class, you can throw and catch exceptions with meaningful messages when you
encounter "bad request" situations in your Java code.
 */