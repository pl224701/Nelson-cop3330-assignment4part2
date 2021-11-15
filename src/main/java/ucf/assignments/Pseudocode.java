/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jack Nelson
 */


package ucf.assignments;

/*
Import classes as needed

Create class for todo list
{
    Create public toDoList
    Create class toDoList
    {
        Create array of at least 100 strings for list items
        Create array of at least 100 LocalDates for due dates
        Create array of at least 100 strings for descriptions
        Create array of at least 100 strings for if item is completed
    }
    Create @FXML variables to correspond to the buttons and textfields within the FXML file
    Create functions that correspond to behaviors OnAction within the FXML file. This is so that you can set the OnAction part of the FXML file in Scene Builder to the functions
    In each of these functions take in the user input if needed from the GUI/FXML file and use variables to hold them such as Strings, ints, and LocalDates.
    Then in each function call the corresponding behavior class and if needed set the public toDoList equal to the output from the behavior classes
}

Create class to add items to an individual todo list
{
    Create method for the class that takes in a toDoList 2 strings and a LocalDate and returns a toDoList
    {
        Create variables for the corresponding parts of a toDoList (3 arrays of strings and 1 array of LocalDates)
        Set these variables equal to their corresponding part of the given toDoList
        Create a toDoList variable
        Create a for loop
        {
            If one of the parts of the toDoList is equal to null
            {
                Copy over the given strings and local date to the corresponding array value within the 2 corresponding arrays of strings and array of LocalDates
                Set the array of strings corresponding to whether the item is completed to incomplete at the given array value
                break the loop using break
            }
        }
        Set the variables equal to the corresponding parts of the toDoList variable
        return toDoList
    }
}

Create class to remove items from an individual todo list
{
    Create method for the class that takes in a toDoList and an integer and returns a toDoList
    {
        Create variables for the corresponding parts of a toDoList (3 arrays of strings and 1 array of LocalDates)
        Set these variables equal to their corresponding part of the given toDoList
        Create another set of variables corresponding to the parts of a toDoList
        Create a toDoList variable
        Create a for loop (int i = 0, int j=0 ;i<100;i++) with two variables but only one being increased by the loop itself
        {
            If i is not equal to the given item number
            {
                Copy over the given strings and local date to the corresponding array value within the 3 corresponding arrays of strings and array of LocalDates
                Increase j by one
            }
        }
        Set the variables equal to the corresponding parts of the toDoList variable
        return toDoList
    }
}

Create class to clear all items from an individual todo list
{
    Create method for the class that returns a toDoList
    {
        Create a empty toDoList
        return the empty toDoList
    }
}

Create class to edit descriptions of items in a todo list
{
    Create method for the class that takes in a toDoList, a string, and an integer and returns a toDoList
    {
        Set the String value within the toDoLists array of descriptions at the corresponding array value that is the given integer to the string
        return the toDoList
    }
}

Create class to edit due date of items in a todo list
{
    Create method for the class that takes in a toDoList, a LocalDate, and an integer and returns a toDoList
    {
        Set the LocalDate value within the toDoLists array of due dates at the corresponding array value that is the given integer to the LocalDate
        return the toDoList
    }
}

Create class to mark items in a todo list as complete
{
    Create method for the class that takes in a toDoList, and an integer and returns a toDoList
    {
        Set the string value within the toDoLists array of complete at the corresponding array value that is the given integer to "completed"
        return the toDoList
    }
}

Create a class to sort all of the items by due date in a todo list
{
    Create method for the class that takes in a toDoList and returns a toDoList
    {
        Create three string variables and one LocalDate variable that are meant to hold variables
        Create a for loop (int i = 0; i<100; i++)
        {
            Create another for loop (int j=i+1;j<100;j++)
            {
                if the next items within the toDoLoop are not null
                {
                    if the due date for the corresponding j within the array of due dates is further in the future than the one corresponding to i
                    {
                        Copy over the corresponding i variables in the arrays to the holding variables
                        Set the toDoLists variables at array iteration i to array iteration j
                        Set the array iteration j to the holding variables
                    }
                }
            }
        }
        return the toDoList
    }

}

Create class to display all of the items in a todo list
{
    Create method for the class that takes in a toDoList
    {
        Create for loop(int i = 0;i<100;i++)
        {
            if the current iteration of variables (i) within the toDoList is not equal to null
            {
                Display the current iteration of variables by printing them to the console
            }
        }
        Print a new line so there is space between different printed lists/list item sets
    }
}

Create class to display all of the completed items in a todo list
{
    Create method for the class that takes in a toDoList
    {
        Create for loop(int i = 0;i<100;i++)
        {
            if the current iteration of variables (i) within the toDoList is not equal to null
            {
                if the current item (i) is completed
                {
                    Display the current iteration of variables by printing them to the console
                }
            }
        }
        Print a new line so there is space between different printed lists/list item sets
    }
}

Create class to display all of the incomplete items in a todo list
{
    Create method for the class that takes in a toDoList
    {
        Create for loop(int i = 0;i<100;i++)
        {
            if the current iteration of variables (i) within the toDoList is not equal to null
            {
                if the current item (i) is incomplete
                {
                    Display the current iteration of variables by printing them to the console
                }
            }
        }
        Print a new line so there is space between different printed lists/list item sets
    }
}

Create class to save a todo List
{
    Create method for the class that takes in a toDoList and a string
    {
        Create an file variable, outfile
        Check if the outfile exists, if it doesn't create a new one with the string as its name
        Create a PrintWriter variable
        Create a for loop (int i=0;i<100;i++)
        {
            if the current iteration of variables in the toDoList is not equal to null
            {
                print the variables into the outfile separated by a comma
            }
        }
        close the outfile
    }
}


Create class to load a todo List
{
    Create method for the class that takes in a string and returns a toDoList
    {
        Create a toDoList to hold the loaded toDoList
        Create a file variable with the string as its input
        Create a scanner variable
        Create an array of strings to read in the file
        Create a pattern to sort through the file as its read in
        Create a string
        Create an integer i thats starts at 0
        Create a while loop such that the next line in the file is not null
        {
            Set the array of strings equal to the next line within the file
            Increment i by one
        }
        Create an array of strings: temp
        Create an integer j that starts at 0
        Create variables corresponding to the variables in a toDoList
        Create a while loop
        {
            Set the array of strings equal to array of strings read in by the file but split based on a comma
            For the last loaded variable by the temp array, if the item contains complete set it to "complete" and if it contains incomplete set it to "incomplete" to get rid of new lines on the string
            Copy corresponding variables within temp to the corresponding variables as per the toDoList
            Increment j by one
        }
        Set the corresponding variables for the toDoList equal to the variables within the toDoList
        return the toDoList
    }
}
*/