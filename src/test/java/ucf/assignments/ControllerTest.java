/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jack Nelson
 */

package ucf.assignments;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest
{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void AddTest()
    {
        new_item test = new new_item();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        Controller.toDoList blank = new Controller.toDoList();
        LocalDate date = LocalDate.parse("2021-11-01");
        Controller.toDoList output = new Controller.toDoList();
        output=test.add_item(blank,"1","1",date);
        assertEquals(test_case.item[0],output.item[0]);
        assertEquals(test_case.description[0],output.description[0]);
        assertEquals(test_case.complete[0],output.complete[0]);
        assertEquals(test_case.due_date[0],output.due_date[0]);
    }

    @Test
    public void RemoveTest()
    {
        r_item test = new r_item();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case=test.remove_item(test_case,0);
        Controller.toDoList output = new Controller.toDoList();
        assertEquals(test_case.item[0],output.item[0]);
        assertEquals(test_case.description[0],output.description[0]);
        assertEquals(test_case.complete[0],output.complete[0]);
        assertEquals(test_case.due_date[0],output.due_date[0]);
    }
    @Test
    public void ClearTest()
    {
        clear test = new clear();
        Controller.toDoList test_case = new Controller.toDoList();
        Controller.toDoList output = test.clear_items();
        assertEquals(test_case.item[0],output.item[0]);
        assertEquals(test_case.description[0],output.description[0]);
        assertEquals(test_case.complete[0],output.complete[0]);
        assertEquals(test_case.due_date[0],output.due_date[0]);
    }
    @Test
    public void DescriptionTest()
    {
        new_description test = new new_description();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="0";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        Controller.toDoList sample = new Controller.toDoList();
        sample.item[0]="1";
        sample.description[0]="1";
        sample.complete[0]="incomplete";
        sample.due_date[0]=LocalDate.parse("2021-11-01");
        test_case=test.edit_description(test_case,"1",0);
        assertEquals(sample.description[0],test_case.description[0]);
    }
    @Test
    public void DoDateTest()
    {
        new_doDate test = new new_doDate();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-02");
        Controller.toDoList sample = new Controller.toDoList();
        sample.item[0]="1";
        sample.description[0]="1";
        sample.complete[0]="incomplete";
        sample.due_date[0]=LocalDate.parse("2021-11-01");
        LocalDate date = LocalDate.parse("2021-11-01");
        test_case=test.edit_todoDate(test_case,date,0);
        assertEquals(sample.due_date[0],test_case.due_date[0]);
    }
    @Test
    public void CompleteTest()
    {
        set_complete test = new set_complete();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        Controller.toDoList sample = new Controller.toDoList();
        sample.item[0]="1";
        sample.description[0]="1";
        sample.complete[0]="completed";
        sample.due_date[0]=LocalDate.parse("2021-11-01");
        test_case=test.complete(test_case,0);
        assertEquals(sample.complete[0],test_case.complete[0]);
    }
    @Test
    public void SortTest()
    {
        sort_by_date test = new sort_by_date();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="2";
        test_case.description[0]="2";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-02");
        test_case.item[1]="1";
        test_case.description[1]="1";
        test_case.complete[1]="incomplete";
        test_case.due_date[1]=LocalDate.parse("2021-11-01");
        Controller.toDoList sample = new Controller.toDoList();
        sample.item[0]="1";
        sample.description[0]="1";
        sample.complete[0]="incomplete";
        sample.due_date[0]=LocalDate.parse("2021-11-01");
        sample.item[1]="2";
        sample.description[1]="2";
        sample.complete[1]="incomplete";
        sample.due_date[1]=LocalDate.parse("2021-11-02");
        test_case=test.sort(test_case);
        assertEquals(test_case.item[0],sample.item[0]);
        assertEquals(test_case.description[0],sample.description[0]);
        assertEquals(test_case.complete[0],sample.complete[0]);
        assertEquals(test_case.due_date[0],sample.due_date[0]);
    }
    @Test
    public void DisplayTest()
    {
        String expectedOutput = "1 1 2021-11-01 incomplete\r\n2 2 2021-11-02 incomplete\r\n3 3 2021-11-03 incomplete";
        print print = new print();
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case.item[1]="2";
        test_case.description[1]="2";
        test_case.complete[1]="incomplete";
        test_case.due_date[1]=LocalDate.parse("2021-11-02");
        test_case.item[2]="3";
        test_case.description[2]="3";
        test_case.complete[2]="incomplete";
        test_case.due_date[2]=LocalDate.parse("2021-11-03");
        print.display(test_case);
        assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    public void DisplayIncompleteTest()
    {
        String expectedOutput = "1 1 2021-11-01 incomplete\r\n3 3 2021-11-03 incomplete";
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case.item[1]="2";
        test_case.description[1]="2";
        test_case.complete[1]="completed";
        test_case.due_date[1]=LocalDate.parse("2021-11-02");
        test_case.item[2]="3";
        test_case.description[2]="3";
        test_case.complete[2]="incomplete";
        test_case.due_date[2]=LocalDate.parse("2021-11-03");
        print_incomplete.display_incomplete(test_case);
        assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
    @Test
    public void DisplayCompleteTest()
    {
        String expectedOutput = "1 1 2021-11-01 completed\r\n3 3 2021-11-03 completed";
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="completed";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case.item[1]="2";
        test_case.description[1]="2";
        test_case.complete[1]="incomplete";
        test_case.due_date[1]=LocalDate.parse("2021-11-02");
        test_case.item[2]="3";
        test_case.description[2]="3";
        test_case.complete[2]="completed";
        test_case.due_date[2]=LocalDate.parse("2021-11-03");
        print_complete.display_completed(test_case);
        assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
    @Test
    public void SaveTest()
    {
        String file_name = "list.txt";
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case.item[1]="2";
        test_case.description[1]="2";
        test_case.complete[1]="incomplete";
        test_case.due_date[1]=LocalDate.parse("2021-11-02");
        test_case.item[2]="3";
        test_case.description[2]="3";
        test_case.complete[2]="incomplete";
        test_case.due_date[2]=LocalDate.parse("2021-11-03");
        save_list save_list = new save_list();
        save_list.save(test_case,file_name);
        File file = new File(file_name);
        assertTrue(file.exists());
    }
    @Test
    public void LoadTest() throws FileNotFoundException {
        String file_name = "list.txt";
        Controller.toDoList test_case = new Controller.toDoList();
        test_case.item[0]="1";
        test_case.description[0]="1";
        test_case.complete[0]="incomplete";
        test_case.due_date[0]=LocalDate.parse("2021-11-01");
        test_case.item[1]="2";
        test_case.description[1]="2";
        test_case.complete[1]="incomplete";
        test_case.due_date[1]=LocalDate.parse("2021-11-02");
        save_list save_list = new save_list();
        save_list.save(test_case,file_name);
        load_list load_list = new load_list();
        Controller.toDoList sample = new Controller.toDoList();
        sample=load_list.load(file_name);
        assertEquals(test_case.item[0],sample.item[0]);
        assertEquals(test_case.description[0],sample.description[0]);
        assertEquals(test_case.complete[0],sample.complete[0]);
        assertEquals(test_case.due_date[0],sample.due_date[0]);
        assertEquals(test_case.item[1],sample.item[1]);
        assertEquals(test_case.description[1],sample.description[1]);
        assertEquals(test_case.complete[1],sample.complete[1]);
        assertEquals(test_case.due_date[1],sample.due_date[1]);
    }
}