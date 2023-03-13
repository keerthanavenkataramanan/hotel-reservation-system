package hotel_reservation;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	 public static Customer[] customer = new Customer[10];
	    public static boolean options = true;

	    public static void main(String[] args) throws IOException {
	    	char ch;
			String emailId=null,password=null,emailIdl=null,passwordl=null;
			do
			{
		    System.out.println("<***>--------Welcome to seashore hotel--------<***>");
			System.out.println("1:register\n 2:login");
			Scanner scanner =new Scanner(System.in);
			System.out.println("enter the option");
	        int option;
			option=scanner.nextInt();
			switch(option)
			{
			case 1: System.out.println("enter the emailId & Password");
					emailId=scanner.next();
					password=scanner.next();
					break;
			case 2: System.out.println("enter the emailId & Password");
					emailIdl=scanner.next();
					passwordl=scanner.next();
					if(emailIdl.equals(emailId) && passwordl.equals(password))
					{
						System.out.println("congratulations login success");
	
	        System.out.println("_________________________________________");
	        RoomBook.initialise(customer);
	        Scanner sc = new Scanner(System.in);
	        
	        while (options) {
	            System.out.println("Enter a to view all room details                :");
	            System.out.println("Enter b to view available rooms                 :");
	            System.out.println("Enter c to add customer to room                 :");
	            System.out.println("Enter d to delete customer from room            :");
	            System.out.println("Enter e to find customer by their id            :");
	            System.out.println("Enter f to insert customer details to the file  :");
	            System.out.println("Enter g to display the receipt                  :");
	            
	            String action = sc.next();

	            // implement the  roomDetails(); 
	            if (action.equalsIgnoreCase("a")) {
	                RoomBook.roomDetails(customer);
	                cont();

	                // implement the addCustomer(); 
	            } else if (action.equalsIgnoreCase("c")) {
	                RoomBook.addcustomer(customer);
	                cont();

	                // implement the emptyRooms(); 
	            } else if (action.equalsIgnoreCase("b")) {
	                RoomBook.emptyRooms(customer);
	                cont();

	                // implement the deleteCustomer(); 
	            } else if (action.equalsIgnoreCase("d")) {
	                RoomBook.deletecustomer(customer);
	                cont();

	                // implement the FileWrite(); 
	            } else if (action.equalsIgnoreCase("f")) {
	                RoomBook.FileWrite(customer);
	                cont();

	                // implement the FileRead(); 
	            } else if (action.equalsIgnoreCase("g")) {
	                RoomBook.FileRead();
	                cont();
	                // implement the  FindCustomer(); 
	            } else if (action.equalsIgnoreCase("e")) {
	                RoomBook.findCustomer(customer);
	                cont();
	                
	            } 
	            else {
	                System.out.println("invalid input. please enter vaild input ");
	                cont();
	            }
	        }
					}
	            else
					System.out.println("incorrect mailid or password");
				break;
		
		default:System.out.println("Enter only 1 or 2");
		break;
		
		}
		System.out.println("do you want to continue with App press y else press n");
		ch=scanner.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	    }
	    public static void cont() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Process again Enter 'P' : ");
	        System.out.println("End Process Enter 'E' : ");
	        String process = sc.next();
	        if (process.equalsIgnoreCase("P")) {
	            options = true;
	        } else if (process.equalsIgnoreCase("E")) {

	            System.out.println("Process terminated");
	            
	            options = false;

	        } else {
	            System.out.println("Enter valid Input(E- end process / P- Continue process)");
	            cont();
	        }
}
}
