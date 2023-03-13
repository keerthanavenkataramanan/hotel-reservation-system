package hotel_reservation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RoomBook {
	
	   public static Scanner sc = new Scanner(System.in);
	   public static Queue<Customer> q = new LinkedList<Customer>();

	    public static void roomDetails(Customer[] cust) {
	        for (Customer mn : cust) {
	            if (mn.getCsId().equals("")) {
	                System.out.println("Room number: " + mn.getRoomNo() + " is Empty");
	            } else 
	            {
	                System.out.println(" Room number: " + mn.getRoomNo() + " occupied by Customer name: " + mn.getCsName() + " in Id: " + mn.getCsId());
	            }
	        }
	    }
	    public static void initialise(Customer[] cust) {
	        int cnt = 1;
	        for (int i = 0; i < cust.length; i++) {
	            Customer mn = new Customer();
	            cust[i] = mn;
	            {
	                mn.setCsId("");
	                mn.setCsName("");
	                mn.setRoomNo(cnt);
	            }
	            cnt++;
	        }
	    }
	    public static void emptyRooms(Customer[] cust) {
	        for (Customer mn : cust) {
	            if (mn.getCsId().equals("")) {
	                System.out.println();
	                System.out.println("Room number: " + mn.getRoomNo() + " is available");
	            }
	        }
	    }
	    public static void addcustomer(Customer[] cust) {
	        boolean again = true;
	        while (again) {
	            Customer newcust = new Customer();
	            try {
	                System.out.println("Please enter Customer id: ");
	                String id = sc.next();
	                newcust.setCsId(id);
                    
	                System.out.println("Please enter Customer name: ");
	                String name = sc.next();
	                newcust.setCsName(name);
	                
	                System.out.println("Enter amount {single cot-500/double cot-1000}: ");
                    int cost = sc.nextInt();
                    newcust.setCsCost(cost);
                    
                    System.out.println("How many meals do you want to add: ");
	                int meal = sc.nextInt();
	                newcust.setCsMeal(meal);
	                
	                System.out.println("Enter the cost of one meal: ");
	                int mealcost = sc.nextInt();
	                newcust.setCsMealcost(mealcost);
	                
	                int total = (meal*mealcost);
	                newcust.setTotal(total);
	                
	                System.out.println("Please enter a Room number: ");
	                int room = sc.nextInt();
	                
	                if (room < 1 || room > 10) {
	                    System.out.println("Invalid input. room numbers are between 1 - 10 : ");
	                } else {
	                    newcust.setRoomNo(room);

	                    cust[room - 1] = (newcust);
	                   System.out.println("customer added successfully"); 
	                }
	                System.out.println("do you want process again: ");
	                System.out.println("Enter y to continue/ N to stop booking : ");
	                String ag = sc.next();
	                if (ag.equalsIgnoreCase("y")) {
	                    again = true;
	                } else if (ag.equalsIgnoreCase("n")) {
	                    again = false;
	                } else {
	                    System.out.println("Invalid input. please enter valid input ");
	                    again = true;
	                }
	            } catch (Exception ex) {
	                System.out.println("Please enter valid data");
	            }
	        }
	    }
	    public static void deletecustomer(Customer[] cust) {
	        boolean again = true;
	        while (again) {
	            System.out.println("Please enter a Room number to delete: ");
	            int room = sc.nextInt();
	            if (room < 1 && room > 10) {
	                System.out.println("Invalid input. room numbers are from 1 - 10 : ");
	            } else {
	                for (Customer remove : cust) {

	                    if (remove.getRoomNo() == room) {
	                        if (remove.getCsId().equals("")) {
	                            System.out.println("Room is already empty");
	                        } else {
	                            System.out.println("Deleted Successfully");
	                            System.out.println("Room no " + remove.getRoomNo() + " is now empty");
	                            remove.setCsName("");
	                            remove.setCsId("");
	                        }
	                    }
	                }
	            }
	            System.out.println("do you want process again: ");
	            System.out.println("Enter y to continue/ N to end delete : ");
	            String ag = sc.next();
	            if (ag.equalsIgnoreCase("y")) {
	                again = true;
	            } else if (ag.equalsIgnoreCase("n")) {
	                again = false;
	            } else {
	                System.out.println("Invalid input. please enter valid input ");
	                again = true;
	            }
	        }
	    }
	    public static void FileWrite(Customer[] cust) {
	        try (FileWriter f = new FileWriter("D:\\hotel\\Customer.txt", true)) {
	            //data write to file

	            DateFormat dateFormat = new SimpleDateFormat(" yyyy/MM/dd ");
	            Date date = new Date();
	            //f.write("\n-----RECEIPT-----"+"\n--Check in date and time--:" + date);
	
	            for (Customer file : cust) {
	                if (file.getCsId().isEmpty()) {
	                	
	                    
	                } else {
	                    f.write("\n-----RECEIPT-----"+"\n--Check in date and time--:" + date);
	                    f.write("\n--Room No--:" + file.getRoomNo() + "\n--Customer name--:" + file.getCsName() + "\n--Customer id--:" + file.getCsId());
	                    f.write("\n--Room cost--:" +file.getCsCost()+"\n--Meal count--:"+file.getCsMeal()+"\n--Meal cost--:"+file.getTotal()+"\n--Total amount--:"+(file.getCsCost()+file.getTotal()));  
	                }
	            }
	            System.out.println("Record created successfully on " + date);

	        } catch (Exception e) {
	            System.out.println("Error with file writing" + e.getMessage().toString());

	        } finally {
	            System.out.println("file write process terminated");
	        }
	    }    
		public static void FileRead() throws IOException {
	        FileReader file;
	        file = new FileReader("D:\\hotel\\Customer.txt");
	        try {
	            BufferedReader reader = new BufferedReader(file);

	            String line = reader.readLine();
	            while (line != null) {
	                line = reader.readLine();
	                System.out.println(line);
	            }
	        } catch (FileNotFoundException ex) {
	            System.out.println("File not found. please check");
	        } finally {
	            file.close();
	        }
	    }
	    public static void findCustomer(Customer[] cust) {
	        System.out.println("Enter Customer id to find customer");
	        String id = sc.next();
	        boolean found = false;
	        for (Customer find : cust) {
	            if (find.getCsId().equals(id)) {
	                System.out.println("----Customer named " + find.getCsName() + " in id " + find.getCsId() + " is in room Number----" + find.getRoomNo());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No customer in id " + id);
	        }
	    }
}
