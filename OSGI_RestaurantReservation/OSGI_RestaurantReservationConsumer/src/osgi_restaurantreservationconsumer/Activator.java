package osgi_restaurantreservationconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import osgi_restaurantreservationproducer.RestaurantReservationService;
import osgi_restaurantreservationproducer.RestaurantReservationServiceImpl;


public class Activator implements BundleActivator {

	private static BundleContext context = null;
	
	//The Service tacker object
	private ServiceTracker m_tracker = null;

	static BundleContext getContext() {
		return context;
	}

	@SuppressWarnings("unused")
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		m_tracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+RestaurantReservationService.class.getName()+")"+"(Language=*))"),null);
		m_tracker.open();
	    System.out.println("Restaurant Consumer Service start successfully");
	    
	    try {
	    	String username, password, actor, agentCtrl, cNotes = null, cReservedTable, cName = null, adminCtrl, TableCtrl, addTable, removeTable ;
	    	String tableType = null;
	    	int cContact = 0, cGuests = 0, noOfTables = 0;
	    	
	    	ArrayList<String> AvailableStandardTables = new ArrayList<String>();
	    	ArrayList<String> AvailableOutdoorTables = new ArrayList<String>();
	    	ArrayList<String> AvailablePrivateTables = new ArrayList<String>();
	    	ArrayList<String> AvailableFamilyTables  = new ArrayList<String>();
	    	
	    	ArrayList<String> BookedStandardTables = new ArrayList<String>();
	    	ArrayList<String> BookedOutdoorTables = new ArrayList<String>();
	    	ArrayList<String> BookedPrivateTables = new ArrayList<String>();
	    	ArrayList<String> BookedFamilyTables  = new ArrayList<String>();
	    	
	    	AvailableFamilyTables.add("F01");
	    	AvailableFamilyTables.add("F02");
	    	AvailableFamilyTables.add("F03");
	    	
	    	AvailablePrivateTables.add("P01");
	    	AvailablePrivateTables.add("P02");
	    	
	    	AvailableOutdoorTables.add("OD01");
	    	AvailableOutdoorTables.add("OD02");
	    	AvailableOutdoorTables.add("0D03");
	    	AvailableOutdoorTables.add("OD04");
	    	
	    	AvailableStandardTables.add("S01");
	    	AvailableStandardTables.add("S02");
	    	AvailableStandardTables.add("S03");
	    	AvailableStandardTables.add("S04");
	    	AvailableStandardTables.add("S05");
	    	 
	    	RestaurantReservationService restaurantService = new RestaurantReservationServiceImpl();
	    	Scanner scan = new Scanner(System.in);
	    	
	    	while(true) {
	    		
	    		System.out.println("\n~~~~~~~~~~~~~~~~ Login ~~~~~~~~~~~~~~~~");
				System.out.print("Enter UserName : ");
				username = scan.next();
				
				if(username.equals("end")){
					System.out.println("Ending The service ");
					break;	
				}
				
				System.out.print("Enter Password : ");
				password = scan.next();
								
				actor = restaurantService.LoginVerification(username, password);
				
/*Manager*/		if(actor == "Manager") {                                                
			    	System.out.println("\n~~~~~~~~~~~~ Welcome Manager ~~~~~~~~~~~~\n");
			    	
			    	System.out.print("Type 'Report' For check day report | Type 'TableCtrl' For add or remove tables : ");
					adminCtrl = scan.next();
					
					if (adminCtrl.equalsIgnoreCase("Report")) {
						restaurantService.displayReservedTablesAndSales(BookedStandardTables, BookedOutdoorTables, BookedPrivateTables, BookedFamilyTables);
						
					}
					else if (adminCtrl.equalsIgnoreCase("TableCtrl")) {
						System.out.print("\nType 'Add' to add new table | Type 'Remove' to remove a table : ");
						TableCtrl = scan.next();
						
						if (TableCtrl.equalsIgnoreCase("add")) {
							System.out.print("Enter type of table you wish to add [Standard |Outdoor |Private |Family ] : ");
							addTable = scan.next();
							
							System.out.print("Enter no. of tables you wish to add : ");
							noOfTables = scan.nextInt();
							
							
							if(addTable.equalsIgnoreCase("Standard")) {
								restaurantService.AddStandardTable(noOfTables, AvailableStandardTables);
								
							}
							else if(addTable.equalsIgnoreCase("Outdoor")) {
								restaurantService.AddOutdoorTable(noOfTables, AvailableOutdoorTables);
								
							}
							else if(addTable.equalsIgnoreCase("Private")) {
								restaurantService.AddPrivateTable(noOfTables, AvailablePrivateTables);
								
							}
							else if(addTable.equalsIgnoreCase("Family")) {
								restaurantService.AddFamilyTable(noOfTables, AvailableFamilyTables);
								
							}
							else {
								System.out.println("Table Type Is Not Available");
									
							}	
							
						}
						else if (TableCtrl.equalsIgnoreCase("remove")) {
							System.out.print("\nEnter type of table you wish to remove [Standard |Outdoor |Private |Family ] : ");
							removeTable = scan.next();
							
							System.out.print("Enter no. of tables you wish to remove : ");
							noOfTables = scan.nextInt();
							
							if(removeTable.equalsIgnoreCase("Standard")) {
								restaurantService.RemoveStandardTable(noOfTables, AvailableStandardTables);
								
							}
							else if(removeTable.equalsIgnoreCase("Outdoor")) {
								restaurantService.RemoveOutdoorTable(noOfTables, AvailableOutdoorTables);
								
							}
							else if(removeTable.equalsIgnoreCase("Private")) {
								restaurantService.RemovePrivateTable(noOfTables, AvailablePrivateTables);
								
							}
							else if(removeTable.equalsIgnoreCase("Family")) {
								restaurantService.RemoveFamilyTable(noOfTables, AvailableFamilyTables);
								
							}
							else {
								System.out.println("Table Type Is Not Available");
									
							}
							
						}
						else {
							
						}
					}		    	
		    	}
/*ResvAgent*/	else if(actor == "ResvAgent") {
					System.out.println("\n~~~~~~~~~~~~ Welcome Reservation Agent ~~~~~~~~~~~~\n");
					
					System.out.println("~~~ Prices ~~~");
			    	System.out.println("Standard Table        : Rs.2000.00" );
			    	System.out.println("Outdoor Table         : Rs.2500.00" );
			    	System.out.println("Private Dining Tables : Rs.4000.00" );
			    	System.out.println("Family-style Tables   : Rs.3500.00\n" );
			    	
			    	System.out.println("~~~ Available Tables ~~~");
			    	System.out.println("Available Standard Tables       : " +AvailableStandardTables);
			    	System.out.println("Available Outdoor Tables        : " +AvailableOutdoorTables);
			    	System.out.println("Available Private Dining Tables : " +AvailablePrivateTables);
			    	System.out.println("Available Family-style Tables   : " +AvailableFamilyTables + "\n");
			    	
			    	System.out.print("Type 'reservation' For make reservation | Type 'cancelation' For cancel reservation : ");
					agentCtrl = scan.next();
					
					if(agentCtrl.equalsIgnoreCase("Reservation")) {
						System.out.print("\nCustomer Name : ");
						cName = scan.next();
						
						System.out.print("Customer Contact : ");
						cContact = scan.nextInt();
						
						System.out.print("No of Guests: ");
						cGuests = scan.nextInt();
						
						System.out.print("Enter Table Type [Standard |Outdoor |Private |Family ] : ");
						tableType = scan.next();
						
						System.out.print("Enter No. of Tables : ");
						noOfTables = scan.nextInt();
						
						System.out.print("Aditional Note : ");
						cNotes = scan.next();
	

						if(tableType.equalsIgnoreCase("Standard")) {
							restaurantService.ReservSandardTable(cName, cContact, cGuests, cNotes, noOfTables, AvailableStandardTables, AvailableOutdoorTables, AvailablePrivateTables, AvailableFamilyTables, BookedStandardTables);

						}
						else if(tableType.equalsIgnoreCase("Outdoor")) {
							restaurantService.ReservOutdoorTable(cName, cContact, cGuests, cNotes, noOfTables, AvailableStandardTables, AvailableOutdoorTables, AvailablePrivateTables, AvailableFamilyTables, BookedOutdoorTables);
								
						}
						else if(tableType.equalsIgnoreCase("Private")) {
							restaurantService.ReservPrivateTable(cName, cContact, cGuests, cNotes, noOfTables, AvailableStandardTables, AvailableOutdoorTables, AvailablePrivateTables, AvailableFamilyTables, BookedPrivateTables);
								
						}
						else if(tableType.equalsIgnoreCase("Family")) {
							restaurantService.ReservFamilyTable(cName, cContact, cGuests, cNotes, noOfTables, AvailableStandardTables, AvailableOutdoorTables, AvailablePrivateTables, AvailableFamilyTables, BookedFamilyTables);
								
						}
						else {
							System.out.println("Table Type Is Not Available");
								
						}	
					}
					else if(agentCtrl.equalsIgnoreCase("Cancelation")) {
						System.out.print("\nEnter Table Type [Standard |Outdoor |Private |Family ] : ");
						tableType = scan.next();
						
						System.out.print("Enter Table Number to Cancle The Reservation : ");
						cReservedTable = scan.next();
						
						restaurantService.cancelReservation(tableType, cReservedTable, noOfTables, AvailableStandardTables, AvailableOutdoorTables, AvailablePrivateTables, AvailableFamilyTables, BookedStandardTables, BookedOutdoorTables, BookedPrivateTables, BookedFamilyTables);
						
					}
					else {
						System.out.println("Invalid Input");
					}
				}
				else {
					System.out.println("Ivalid Input");
				}
	    	}
	    }
	    catch(Exception e) {
	    	// TODO: handle exception
	    }
	    
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Restaurant Consumer Service stopped successfully");
		Activator.context = null;
	}

}
