/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jack Nelson
 */


package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    public toDoList lists = new toDoList();

    static class toDoList
    {
        String[] item = new String[100];
        LocalDate[] due_date = new LocalDate[100];
        String[] description = new String[100];
        String[] complete = new String[100];
    }
    @FXML
    private TextField item_name;
    @FXML
    private TextField item_description;
    @FXML
    private DatePicker item_date;
    @FXML
    private TextField Item_Number1;
    @FXML
    private TextField Item_Number2;
    @FXML
    private TextField new_description;
    @FXML
    private TextField Item_Number3;
    @FXML
    private DatePicker new_date;
    @FXML
    private TextField Item_Number4;
    @FXML
    private TextField file_name;
    @FXML
    private TextField file_path;
    public void add_item(ActionEvent event)
    {
        String item = item_name.getText();
        String description = item_description.getText();
        LocalDate date = item_date.getValue();
        new_item add_item = new new_item();
        lists = add_item.add_item(lists,item,description,date);
    }
    public void clear_items(ActionEvent event)
    {
        clear clear = new clear();
        lists = clear.clear_items();
    }
    public void remove_item(ActionEvent event)
    {
        String temp = Item_Number1.getText();
        int item_number = Integer.parseInt(temp);
        r_item remove_item = new r_item();
        lists = remove_item.remove_item(lists,item_number);
    }
    public void edit_description(ActionEvent event)
    {
        new_description edit_description = new new_description();
        String temp = Item_Number2.getText();
        int item_number = Integer.parseInt(temp);
        String description = new_description.getText();
        lists = edit_description.edit_description(lists, description,item_number);
    }
    public void edit_todoDate(ActionEvent event)
    {
        new_doDate edit_todoDate = new new_doDate();
        String temp = Item_Number3.getText();
        int item_number = Integer.parseInt(temp);
        LocalDate date = new_date.getValue();
        lists = edit_todoDate.edit_todoDate(lists,date,item_number);
    }
    public void complete(ActionEvent event)
    {
        set_complete completed = new set_complete();
        String temp = Item_Number4.getText();
        int item_number = Integer.parseInt(temp);
        lists = completed.complete(lists,item_number);
    }
    public void sort(ActionEvent event)
    {
        sort_by_date sort_by_date = new sort_by_date();
        sort_by_date.sort(lists);
    }
    public void display(ActionEvent event)
    {
        print print = new print();
        print.display(lists);
    }
    public void display_completed(ActionEvent event)
    {
        print_complete print = new print_complete();
        print_complete.display_completed(lists);
    }
    public void display_incomplete(ActionEvent event)
    {
        print_incomplete print = new print_incomplete();
        print.display_incomplete(lists);
    }
    public void save(ActionEvent event)
    {
        save_list save_list = new save_list();
        String name = file_name.getText();
        save_list.save(lists,name);
    }
    public void load(ActionEvent event) throws FileNotFoundException {
        load_list load_list = new load_list();
        String name = file_path.getText();
        lists=load_list.load(name);
    }
}

class new_item extends Controller
{
    toDoList add_item(toDoList lists, String item_name, String item_description, LocalDate date)
    {
        String[] items = new String[100];
        LocalDate[] due_dates = new LocalDate[100];
        String[] descriptions = new String[100];
        String[] completed = new String[100];
        items = lists.item;
        due_dates = lists.due_date;
        descriptions = lists.description;
        completed = lists.complete;
        toDoList list = new toDoList();
        for (int i = 0; i < 100; i++) {
            if (items[i] == null) {
                items[i] = item_name;
                due_dates[i] = date;
                descriptions[i] = item_description;
                completed[i]="incomplete";
                break;
            }
        }

        list.item = items;
        list.due_date = due_dates;
        list.description = descriptions;
        list.complete = completed;
        return list;
    }
}

class r_item extends Controller
{
    toDoList remove_item(toDoList lists, int item_number)
    {
        String[] items = new String[100];
        LocalDate[] due_dates = new LocalDate[100];
        String[] descriptions = new String[100];
        String[] completed = new String[100];
        items = lists.item;
        due_dates = lists.due_date;
        descriptions = lists.description;
        completed = lists.complete;
        toDoList list_copy = new toDoList();
        String[] copy1 = new String[100];
        LocalDate[] copy2 = new LocalDate[100];
        String[] copy3 = new String[100];
        String[] copy4 = new String[100];
        for (int i = 0, j = 0; i < 100; i++) {
            if (i != item_number) {
                copy1[j] = items[i];
                copy2[j] = due_dates[i];
                copy3[j] = descriptions[i];
                copy4[j] = completed[i];
                j++;
            }
        }
        list_copy.item = copy1;
        list_copy.due_date = copy2;
        list_copy.description = copy3;
        list_copy.complete = copy4;
        return list_copy;
    }
}

class clear extends Controller
{
    toDoList clear_items()
    {
        toDoList list = new toDoList();
        return list;
    }
}

class new_description extends Controller
{
    toDoList edit_description(toDoList lists, String new_description, int item_number)
    {
        lists.description[item_number] = new_description;
        return lists;
    }
}

class new_doDate extends Controller
{
    toDoList edit_todoDate(toDoList lists,LocalDate date,int item_number)
    {
        lists.due_date[item_number]=date;
        return lists;
    }
}

class set_complete extends Controller
{
    toDoList complete(toDoList lists, int item_number)
    {
        lists.complete[item_number] = "completed";
        return lists;
    }
}

class sort_by_date extends Controller
{
    toDoList sort(toDoList lists)
    {
        LocalDate temp1;
        String temp2;
        String temp3;
        String temp4;
        for(int i = 0; i<100;i++)
        {
            for(int j = i+1; j<100;j++)
            {
                if(lists.item[i]!=null && lists.item[j]!=null)
                {
                    if(lists.due_date[i].compareTo(lists.due_date[j])>0)
                    {
                        temp1=lists.due_date[i];
                        temp2=lists.item[i];
                        temp3=lists.description[i];
                        temp4=lists.complete[i];
                        lists.due_date[i]=lists.due_date[j];
                        lists.item[i]=lists.item[j];
                        lists.description[i]=lists.description[j];
                        lists.complete[i]=lists.complete[j];
                        lists.due_date[j]=temp1;
                        lists.item[j]=temp2;
                        lists.description[j]=temp3;
                        lists.complete[j]=temp4;
                    }
                }
            }
        }
        return lists;
    }
}

class print extends Controller
{
    public static void display(toDoList lists)
    {
        for(int i=0; i<100; i++)
        {
            if(lists.item[i]!=null)
            {
                System.out.println(lists.item[i]+" "+lists.description[i]+" "+lists.due_date[i]+" "+lists.complete[i]);
            }
        }
        System.out.println();
    }
}

class print_complete extends Controller
{
    public static void display_completed(toDoList lists)
    {
        for(int i=0; i<100; i++)
        {
            if(lists.item[i]!=null)
            {
                if(Objects.equals(lists.complete[i], "completed"))
                {
                    System.out.println(lists.item[i]+" "+lists.description[i]+" "+lists.due_date[i]+" "+lists.complete[i]);
                }
            }
        }
        System.out.println();
    }
}

class print_incomplete extends Controller
{
    public static void display_incomplete(toDoList lists)
    {
        for(int i=0; i<100; i++)
        {
            if(lists.item[i]!=null)
            {
                if(Objects.equals(lists.complete[i], "incomplete"))
                {
                    System.out.println(lists.item[i]+" "+lists.description[i]+" "+lists.due_date[i]+" "+lists.complete[i]);
                }
            }
        }
        System.out.println();
    }
}

class save_list extends Controller
{
    void save(toDoList lists, String file_name)
    {
        try
        {
            File outfile = new File(file_name);
            if(!outfile.exists())
            {
                outfile.createNewFile();
            }
            PrintWriter pw = new PrintWriter(outfile);
            for(int i=0; i<100;i++)
            {
                if(lists.item[i]!=null)
                    pw.println(lists.item[i]+","+lists.description[i]+","+lists.due_date[i]+","+lists.complete[i]);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class load_list extends Controller
{
    toDoList load(String file_name) throws FileNotFoundException {
        toDoList list = new toDoList();
        File file = new File(file_name);
        Scanner sc = new Scanner(file);
        String[] read_in = new String[100];
        Pattern pat = Pattern.compile(".*\\R|.+\\z");
        String line;
        int i = 0;
        while((line=sc.findWithinHorizon(pat,0))!=null)
        {
            read_in[i]=line;
            i++;
        }
        int j=0;
        String[] temp;
        String[] items = new String[100];
        String[] descriptions = new String[100];
        LocalDate[] due_dates = new LocalDate[100];
        String[] completed = new String[100];
        while(read_in[j]!=null)
        {
            temp = read_in[j].split(",");
            if(temp[3].contains("completed"))
            {
                temp[3]="completed";
            }
            if(temp[3].contains("incomplete"))
            {
                temp[3]="incomplete";
            }
            items[j]=temp[0];
            descriptions[j]=temp[1];
            due_dates[j]= LocalDate.parse(temp[2]);
            completed[j]=temp[3];
            j++;
        }
        list.item=items;
        list.description=descriptions;
        list.due_date=due_dates;
        list.complete=completed;
        return list;
    }
}