/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jack Nelson
 */


package ucf.assignments;

/*
Import classes as needed

Create class for todo list
{
    Create static array list of toDoLists
    Create class toDoList
    {
        Create string value for toDoList title
        Create array of at least 100 strings for list items
        Create array of at least 100 strings for due dates
        Create array of at least 100 strings for descriptions
        Create array of at least 100 booleans for if item is completed
        Use Arrays.fill function set set all the booleans equal to false such that they are marked incomplete
    }
}

Create class to Add lists to the arraylist of todo lists
{
    Create method for class on corresponding button press
    {
        Create new toDoList
        Create string for title and set it equal to something for test cases
        Read list title user input and set it equal to the title of the new toDoList
        Add list to array list of toDoLists
    }
}

Create class to remove lists from the arraylist of todo lists
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input value for list number and set integer equal to it
        Remove corresponding toDoList from array list of toDoLists
    }
}

Create class to add items to an individual todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input value for list number and set it equal to something for test cases
        Create string to hold string value for the item name and set it equal to something for test cases
        Create string to hold string value for the item description and set it equal to something for test cases
        Create string to hold string value for the item due date and set it equal to something for test cases
        Read user inputs for the corresponding variables and set corresponding variables equal to them
        Change due date string such that it meets the format "YYYY-MM-DD"
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Create for loop where int i = 0
            if corresponding strings are equal to null
                Add user inputed values to the corresponding strings
                Break statement
        Set the variables (string, arrays of strings, array of booleans) equal to the corresponding variables in the blank toDoList
        Use set function in array lists to set the updated toDoList with the new item in the place of the old toDoList
    }
}

Create class to remove items from an individual todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input value for list number and set it equal to something for test cases
        Create integer to hold the input value for item number and set it equal to something for test cases
        Read user inputs for the corresponding variables and set corresponding integers equal to them
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank array variables corresponding to the toDoList variables i.e. arrays of strings, array of booleans
        Create blank toDoList
        Create for loop where int i = 0 and j=0, i++ in for loop (Loop will remove the item)
            If i is not equal to item numbers such that you remove the item
                Copy the copied toDoList values to the blank toDoList array variables (j++ in  this section)
        Set the variables (string, arrays of strings, array of booleans) equal to the corresponding variables in the blank toDoList
        Use set function in array lists to set the updated toDoList with the removed item in the place of the old toDoList
    }
}

Create class to edit titles of a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Create string for new title and set it equal to something for test cases
        Read user input for the list number and new title and set corresponding variables equal to them
        Create variables (arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Set the variables equal to the corresponding variables in the blank toDoList
        Set user inputed title equal to title in new toDoList
        Use set function in array lists to set the updated toDoList with the new title in the place of the old toDoList
    }
}

Create class to edit descriptions of items in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Create integer to hold user input for item number and set it equal to something for test cases
        Create string for new description
        Read user input for the list number, item number, and new description and set corresponding variables equal to them
        Create variables (arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Set user inputed description equal to corresponding string in the copied array of strings for description
        Set the variables equal to the corresponding variables in the blank toDoList
        Use set function in array lists to set the updated toDoList with the new description in the place of the old toDoList
    }
}

Create class to edit due date of items in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Create integer to hold user input for item number and set it equal to something for test cases
        Create string for new due date
        Read user input for the list number, item number, and due date and set corresponding variables equal to them
        Change new due date string such that it meets the format "YYYY-MM-DD"
        Create variables (arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Set user inputed due date equal to corresponding string in the copied array of strings for due date
        Set the variables equal to the corresponding variables in the blank toDoList
        Use set function in array lists to set the updated toDoList with the new due date in the place of the old toDoList
    }
}

Create class to mark items in a todo list as complete
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Create integer to hold user input for item number and set it equal to something for test cases
        Read user input for the list number and item number and set corresponding integers equal to that
        Create variables (arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Set corresponding boolean in the copied array of booleans to true such that it is marked as completed
        Set the variables equal to the corresponding variables in the blank toDoList
        Use set function in array lists to set the updated toDoList with the item marked as completed in the place of the old toDoList
    }
}

Create a class to sort all of the items by due date in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input for the list number and set the integer equal to it
        Create variables (arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create blank toDoList
        Create for loop
        Create outer for loop where int i=0 // This method works because the dates are reordered in the YYYY-MM-DD format
            Create inner for loop where int j=i+1
                If variable strings are not equal to null AND the due date for i is greater than the due date for j
                    Create 3 temporary strings for item, description, and due date and set them equal to the corresponding i in the array of strings
                    Create temporary boolean and set it equal to the corresponding i in the array of booleans
                    Set the arrays of strings at i equal to the arrays of strings at j
                    Set the array of booleans at i equal to the array of booleans at j
                    Set the arrays of strings at j equal to the temporary strings
                    Set the array of booleans at j equal to the temporary boolean
    }
    Set the variables equal to the corresponding variables in the blank toDoList
    Use set function in array lists to set the updated toDoList with the sorted list in the place of the old toDoList
}

Create class to display all of the items in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input for the list number and set integer equal to it
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Print list title
        Create for loop such that int i = 0 (iterate through each element of such that all items are printed)
            If string values are not null
                 Print output for the corresponding elements within arrays in the format item, description, due date
    }
}

Create class to display all of the completed items in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input for the list number and set integer equal to it
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Print list title
        Create for loop such that int i = 0 (iterate through each element of such that all items are printed)
            If string values are not null AND corresponding boolean values for the given i value are true (because loop iterates through all values in the arrays)
                 Print output for the corresponding elements within arrays in the format item, description, due date
    }
}

Create class to display all of the incompleted items in a todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input for the list number and set integer equal to it
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Print list title
        Create for loop such that int i = 0 (iterate through each element of such that all items are printed)
            If string values are not null AND corresponding boolean values for the given i value are false (because loop iterates through all values in the arrays)
                 Print output for the corresponding elements within arrays in the format item, description, due date
    }
}

Create class to save all of the items to external storage for a single todo list
{
    Create method for class on corresponding button press
    {
        Create integer to hold user input for list number and set it equal to something for test cases
        Read user input for the list number and set integer equal to it
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Copy all of the toDoList values for the specified list to specified variables i.e. string, arrays of strings, array of booleans
        Create outfile
        Print list title to outfile
        Create for loop such that int i = 0 (iterate through each element of such that all items are printed)
            If string values are not null
                 Print output to outfile for the corresponding elements within arrays in the format item, description, due date, completed(where true is completed false is incomplete)
    }
}

Create class to save all of the items to external storage for all of the todo lists
{
    Create method for class on corresponding button press
    {
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Create outfile
        Print list title to outfile
        Create integer that equals length of arraylist
        Print string denoting end of individual list to outfile so that you can read it back in later
        Create for loop such that int i = 0 less than length of the arraylist and i++(iterate through each list such that all lists are printed)
            Copy all of the toDoList values for the specified list (j) to specified created variables i.e. string, arrays of strings, array of booleans
            Print list title to outfile
            Create for loop such that int j = 0 (iterate through each element of such that all items are printed)
                If string values are not null
                    Print output to outfile for the corresponding elements within arrays in the format item, description, due date, completed(where true is completed false is incomplete)
            Print string denoting end of individual list to outfile
    }
}

Create class to load a single todo list from storage
{
    Create method for class on corresponding button press
    {
        Create string for user inputed file path and set it equal to something for test cases
        Read user inputed file path and set string equal to it
        Create file variable that will equal the file path
        Create scanner variable
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Set title equal to first string within the file
        Create integer to increase in while loop
        Create while loop such that it ends when the next line in the file is null
            Create string to hold next line
            Read in next line of the file
            Create array of strings to hold separated string
            Separate string based upon ","
            Set corresponding values within the array of string to each variables (item, description, due date, completed)
            Increase integer value
        Create blank toDoList
        Set the variables equal to the corresponding variables in the blank toDoList
        Add new toDoList to array list of toDoLists
        Close the scanner variable
    }
}

Create class to load multiple todo lists from storage
{
    Create method for class on corresponding button press
    {
        Create string for user inputed file path and set it equal to something for test cases
        Read user inputed file path and set string equal to it
        Create file variable that will equal the file path
        Create scanner variable
        Create variables (string, arrays of strings, array of booleans) to hold specified toDoList variables
        Create while loop such that it ends when next line in file is null
            Read next line such that you avoid string denoting the end of individual lists
            Set title equal to first string within the file
            Create integer to increase in while loop
            Create while loop such that it ends when the next line is equal to the string denoting the end of an individual list or is equal to null
                Create string to hold next line
                Read in next line of the file
                Create array of strings to hold separated string
                Separate string based upon ","
                Set corresponding values within the array of string to each variables (item, description, due date, completed)
                Increase integer value
            Create blank toDoList
            Set the variables equal to the corresponding variables in the blank toDoList
            Add new toDoList to array list of toDoLists
        Close the scanner variable
    }
}
*/