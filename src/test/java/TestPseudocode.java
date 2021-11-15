/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jack Nelson
 */

//Import needed functions, etc.

/*
Create public class for tests
{
    Create PrintStream variable for display tests
    Create ByteArrayOutputStream variable for display tests

    Use @BeforeEach for the display tests
    {
        Set the System.setOut to a new PrintStream that takes the ByteArrayOutPutStream variable
    }
    Use @AfterEach for the display tests
    {
        Set the System.setOut to the PrintStream Variable
    }
    Use @Test to test add items behavior
    Create function
    {
        Create add items class variable: test
        Create toDoList class that running the behavior should equal
        Create toDoList class to hold the output from running the function
        use assertEquals to compare the output running the add items behavior and the expected output
    }
    Use @Test to test remove items behavior
    Create function
    {
        Create remove items class variable: test
        Create toDoList class that running the behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the function
        use assertEquals to compare the output from running the remove items behavior and the expected output
    }
    Use @Test to test clear behavior
    Create function
    {
        Create clear class variable: test
        Create toDoList class that is blank
        Create toDoList class to hold the output from running the clear items function
        use assertEquals to compare the output from running the remove items behavior and the expected output
    }
    Use @Test to test edit titles behavior
    Create function
    {
        Create edit titles class variable: test
        Create toDoList class that running the behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the edit titles function
        use assertEquals to compare the output from running the edit titles behavior and the expected output
    }
    Use @Test to test edit descriptions behavior
    Create function
    {
        Create edit descriptions class variable: test
        Create toDoList class that running the behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the edit descriptions function
        use assertEquals to compare the output from running the edit descriptions behavior and the expected output
    }
    Use @Test to test edit due date behavior
    Create function
    {
        Create edit due dates class variable: test
        Create toDoList class that running behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the edit due date function
        use assertEquals to compare the output from running the edit due dates behavior and the expected output
    }
    Use @Test to test mark items as complete behavior
    Create function
    {
        Create mark items as complete class variable: test
        Create toDoList class that running the behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the complete function
        use assertEquals to compare the output from running the mark items as complete behavior and the expected output
    }
    Use @Test to test sort items by due date behavior
    Create function
    {
        Create sort items by due date variable: test
        Create toDoList class that running the behavior should equal and initialize parts of it
        Create toDoList class to hold the output from running the sort function
        use assertEquals to compare the output from running the edit due dates behavior and the expected output
    }
    Use @Test to test display behavior
    Create function
    {
        Create string for the expected output from calling the behavior
        Create a toDoList an initialize parts of it
        Call the display behavior
        use assertEquals to compare the output from the display behavior to the string
    }
    Use @Test to test display completed items behavior
    Create function
    {
        Create string for the expected output from calling the behavior
        Create a toDoList an initialize parts of it
        Call the completed items display behavior
        use assertEquals to compare the output from the completed items display behavior to the string
    }
    Use @Test to test display incomplete items behavior
    Create function
    {
        Create string for the expected output from calling the behavior
        Create a toDoList an initialize parts of it
        Call the incomplete items display behavior
        use assertEquals to compare the output from the incomplete items display behavior to the string
    }
    Use @Test to test save items for a a to do list
    Create function
    {
        Create a string for the file name
        Create a toDoList variable to save and initialize parts of it
        Create a variable for the save function: test
        Call the function to save the toDoList to the given file name
        use assertTrue to make sure the file exists
    }
    Use @Test to test load a single to do list behavior
    Create function
    {
        Create load variable: test
        Create a string for the file name
        Create a toDoList to give to save
        Save the toDoList
        Create a string for the loaded toDoList
        Load the toDoList to the new string
        use assertEquals to compare the output from the original toDoList to the loaded toDoList
    }
}
 */