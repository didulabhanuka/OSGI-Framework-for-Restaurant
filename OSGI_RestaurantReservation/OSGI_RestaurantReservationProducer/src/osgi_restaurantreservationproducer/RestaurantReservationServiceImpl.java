package osgi_restaurantreservationproducer;

import java.util.ArrayList;
import java.util.Collections;

public class RestaurantReservationServiceImpl implements RestaurantReservationService {

	float sTotalTableCharge,oTotalTableCharge,pTotalTableCharge,fTotalTableCharge = (float) 0.0;
	
	@Override
	public String LoginVerification(String username, String password) {
		if((username.equals("Manager")) && (password.equals("Admin@restaurant")))
    	{
			return "Manager";
		}
		else if((username.equals("ResvAgent")) && (password.equals("ResvAgent@restaurnat")))
		{
			return "ResvAgent";
		}else
		{
			return "Invalid";
		}
	}
	
/*ResvAgent*/	
	
	@Override
	public void ReservSandardTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedStandardTables) {
		// TODO Auto-generated method stub
		
		if(noOfTables <= available_sTables.size()) {
			for (int i = 0; i < noOfTables; i++) {
				String table = available_sTables.remove(0);
                BookedStandardTables.add(table);
            }
			sTotalTableCharge = noOfTables * 2000;
			
			Collections.sort(BookedStandardTables);
			Collections.sort(available_sTables);
			
			System.out.println("\n~~~ Reservation Details ~~~");
			System.out.println("Customer Name           : " +cName);
			System.out.println("Customer Contact Number : " +cContact);
			System.out.println("No. of Guests           : " +cGuests);
			System.out.println("Special Requests        : " +specialRequests);
			System.out.println("Reserved Table(s)       : " +BookedStandardTables);
			System.out.println("Total Amount            : " +sTotalTableCharge);
			
			System.out.println("\n~~~ Available Standard Tables ~~~");
			System.out.println(available_sTables);
			
		}
		else {
			System.out.println("\nSorry, There aren't Enough Standard Tables to Complete the Reservation.");
		
		}	
	}

	@Override
	public void ReservOutdoorTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedOutdoorTables) {
		// TODO Auto-generated method stub
		
		if(noOfTables <= available_oTables.size()) {
			for(int i=0; i<noOfTables; i++) {
				String table = available_oTables.remove(0);
				BookedOutdoorTables.add(table);
				
			}
			oTotalTableCharge = noOfTables * 2500;
			
			Collections.sort(BookedOutdoorTables);
			Collections.sort(available_oTables);
			
			System.out.println("\n~~~ Reservation Details ~~~");
			System.out.println("Customer Name           : " +cName);
			System.out.println("Customer Contact Number : " +cContact);
			System.out.println("No. of Guests           : " +cGuests);
			System.out.println("Special Requests        : " +specialRequests);
			System.out.println("Reserved Table(s)       : " +BookedOutdoorTables);
			System.out.println("Total Amount            : " +oTotalTableCharge);
			
			System.out.println("\n~~~ Available Outdoor Tables ~~~");
			System.out.println(available_oTables);
			
		}
		else {
			System.out.println("\nSorry, There aren't Enough Outdoor Tables to Complete the Reservation.");
		
		}
	}

	@Override
	public void ReservPrivateTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedPrivateTables) {
		// TODO Auto-generated method stub
		
		if(noOfTables <= available_pTables.size()) {
			for(int i=0; i<noOfTables; i++) {
				String table = available_pTables.remove(0);
				BookedPrivateTables.add(table);
				
			}
			pTotalTableCharge = noOfTables * 4000;
			
			Collections.sort(BookedPrivateTables);
			Collections.sort(available_pTables);
			
			System.out.println("\n~~~ Reservation Details ~~~");
			System.out.println("Customer Name           : " +cName);
			System.out.println("Customer Contact Number : " +cContact);
			System.out.println("No. of Guests           : " +cGuests);
			System.out.println("Special Requests        : " +specialRequests);
			System.out.println("Reserved Table(s)       : " +BookedPrivateTables);
			System.out.println("Total Amount            : " +pTotalTableCharge);
			
			System.out.println("\n~~~ Available Private Tables ~~~");
			System.out.println(available_pTables);
			
		}
		else {
			System.out.println("\nSorry, There aren't Enough Private Tables to Complete the Reservation.");
		
		}
	}

	@Override
	public void ReservFamilyTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedFamilyTables) {
		// TODO Auto-generated method stub
		
		if(noOfTables <= available_fTables.size()) {
			for(int i=0; i<noOfTables; i++) {
				String table = available_fTables.remove(0);
				BookedFamilyTables.add(table);
				
			}
			fTotalTableCharge = noOfTables * 3500;
			
			Collections.sort(BookedFamilyTables);
			Collections.sort(available_fTables);
			
			System.out.println("\n~~~ Reservation Details ~~~");
			System.out.println("Customer Name           : " +cName);
			System.out.println("Customer Contact Number : " +cContact);
			System.out.println("No. of Guests           : " +cGuests);
			System.out.println("Special Requests        : " +specialRequests);
			System.out.println("Reserved Table(s)       : " +BookedFamilyTables);
			System.out.println("Total Amount            : " +fTotalTableCharge);
			
			System.out.println("\n~~~ Available Family Tables ~~~");
			System.out.println(available_fTables);
			
		}
		else {
			System.out.println("\nSorry, There aren't Enough Family Tables to Complete the Reservation.");
		
		}		
	}

	@Override
	public void cancelReservation(String tableType, String tableNumber, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedStandardTables, ArrayList<String> BookedOutdoorTables, ArrayList<String> BookedPrivateTables, ArrayList<String> BookedFamilyTables) {
		// TODO Auto-generated method stub 
		
		if(tableType.equalsIgnoreCase("Standard")) {
			if(BookedStandardTables.contains(String.valueOf(tableNumber))) {
	            BookedStandardTables.remove(String.valueOf(tableNumber));  // Remove the table from the booked tables list
	            available_sTables.add(String.valueOf(tableNumber)); // Add the table back to the available tables list
	            System.out.println("\nReservation for Standard Table " + tableNumber + " has been canceled.");
	            
	        } else {
	            System.out.println("\nTable " + tableNumber + " is not booked or does not exist.");
	            
	        }
		}
		else if(tableType.equalsIgnoreCase("Outdoor")) {
			if(BookedOutdoorTables.contains(String.valueOf(tableNumber))) {
	            BookedOutdoorTables.remove(String.valueOf(tableNumber));
	            available_oTables.add(String.valueOf(tableNumber));
	            System.out.println("\nReservation for Outdoor Table " + tableNumber + " has been canceled.");
	            
	        } else {
	            System.out.println("\nTable " + tableNumber + " is not booked or does not exist.");
	            
	        }	
		}
		else if(tableType.equalsIgnoreCase("Private")) {
			if(BookedPrivateTables.contains(String.valueOf(tableNumber))) {
	            BookedPrivateTables.remove(String.valueOf(tableNumber));
	            available_pTables.add(String.valueOf(tableNumber));
	            System.out.println("\nReservation for Private Table " + tableNumber + " has been canceled.");
	        
			} else {
	            System.out.println("\nTable " + tableNumber + " is not booked or does not exist.");
	            
	        }
		}
		else if(tableType.equalsIgnoreCase("Family")) {
			if(BookedFamilyTables.contains(String.valueOf(tableNumber))) {
	            BookedFamilyTables.remove(String.valueOf(tableNumber));
	            available_fTables.add(String.valueOf(tableNumber));
	            System.out.println("\nReservation for Family Table " + tableNumber + " has been canceled.");
	            
	        } else {
	            System.out.println("\nTable " + tableNumber + " is not booked or does not exist.");
	            
	        }
		}
		else {
			System.out.println("\nTable Type Is Not Available");
			
		}
 		
	}
	

/*Manager*/	
	
	@Override
	public void displayReservedTablesAndSales(ArrayList<String> bookedStandardTables, ArrayList<String> bookedOutdoorTables, ArrayList<String> bookedPrivateTables, ArrayList<String> bookedFamilyTables) {
		// TODO Auto-generated method stub
		
		System.out.println("\n~~~ Day Report ~~~");
		System.out.println("\n~~~ Reserved Tables ~~~");
	    System.out.println("Standard Tables: " + bookedStandardTables);
	    System.out.println("Outdoor Tables: " + bookedOutdoorTables);
	    System.out.println("Private Tables: " + bookedPrivateTables);
	    System.out.println("Family Tables: " + bookedFamilyTables);

	    float totalSales = sTotalTableCharge + oTotalTableCharge + pTotalTableCharge + fTotalTableCharge ;
	    System.out.println("\nTotal Sales: " + totalSales);	
	}

	@Override
	public void AddStandardTable(int noOfTables, ArrayList<String> available_sTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        String table = "S" + String.format("%02d", available_sTables.size() + 1);
	        available_sTables.add(table);
	    }
	    System.out.println("\nAdded " + noOfTables + " table(s) to the standard table(s).");
	    Collections.sort(available_sTables);
	    System.out.println("Available Standard Tables : " + available_sTables);
	
	}

	@Override
	public void AddOutdoorTable(int noOfTables, ArrayList<String> available_oTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        String table = "OD" + String.format("%02d", available_oTables.size() + 1);
	        available_oTables.add(table);
	    }
	    System.out.println("\nAdded " + noOfTables + " table(s) to the standard table(s).");
	    Collections.sort(available_oTables);
	    System.out.println("Available Standard Tables : " + available_oTables);
	    
	}

	@Override
	public void AddPrivateTable(int noOfTables, ArrayList<String> available_pTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        String table = "P" + String.format("%02d", available_pTables.size() + 1);
	        available_pTables.add(table);
	    }
	    System.out.println("\nAdded " + noOfTables + " table(s) to the standard table(s).");
	    Collections.sort(available_pTables);
	    System.out.println("Available Standard Tables : " + available_pTables);
		
	}

	@Override
	public void AddFamilyTable(int noOfTables, ArrayList<String> available_fTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        String table = "F" + String.format("%02d", available_fTables.size() + 1);
	        available_fTables.add(table);
	    }
	    System.out.println("\nAdded " + noOfTables + " table(s) to the standard table(s).");
	    Collections.sort(available_fTables);
	    System.out.println("Available Standard Tables : " + available_fTables);
		
	}

	@Override
	public void RemoveStandardTable(int noOfTables, ArrayList<String> available_sTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        if (!available_sTables.isEmpty()) {
	            available_sTables.remove(available_sTables.size() - 1);
	        } else {
	            System.out.println("\nNo more Standard Tables to remove.");
	            break;
	        }
	    }
	    System.out.println("\nRemoved " + noOfTables + " Standard Table(s).");
	    Collections.sort(available_sTables);
	    System.out.println("Available Standard Tables : " + available_sTables);
		
	}

	@Override
	public void RemoveOutdoorTable(int noOfTables, ArrayList<String> available_oTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        if (!available_oTables.isEmpty()) {
	            available_oTables.remove(available_oTables.size() - 1);
	        } else {
	            System.out.println("\nNo more Outdoor Tables to remove.");
	            break;
	        }
	    }
	    System.out.println("\nRemoved " + noOfTables + " Outdoor Table(s).");
	    Collections.sort(available_oTables);
	    System.out.println("Available Standard Tables : " + available_oTables);
	    
	}

	@Override
	public void RemovePrivateTable(int noOfTables, ArrayList<String> available_pTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        if (!available_pTables.isEmpty()) {
	            available_pTables.remove(available_pTables.size() - 1);
	        } else {
	            System.out.println("\nNo more Private Tables to remove.");
	            break;
	        }
	    }
	    System.out.println("\nRemoved " + noOfTables + " Private Table(s).");
	    Collections.sort(available_pTables);
	    System.out.println("Available Standard Tables : " + available_pTables);
		
	}

	@Override
	public void RemoveFamilyTable(int noOfTables, ArrayList<String> available_fTables) {
		// TODO Auto-generated method stub
		for (int i = 0; i < noOfTables; i++) {
	        if (!available_fTables.isEmpty()) {
	            available_fTables.remove(available_fTables.size() - 1);
	        } else {
	            System.out.println("\nNo more Family Tables to remove.");
	            break;
	        }
	    }
	    System.out.println("\nRemoved " + noOfTables + " Family Table(s).");
	    Collections.sort(available_fTables);
	    System.out.println("Available Standard Tables : " + available_fTables);
	
	}
}
