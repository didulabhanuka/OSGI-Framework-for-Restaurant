package osgi_restaurantreservationproducer;

import java.util.ArrayList;

public interface RestaurantReservationService {
	public String LoginVerification(String username, String password);
	
	//ResvAgent
	public void ReservSandardTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedStandardTables);
	public void ReservOutdoorTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedOutdoorTables);
	public void ReservPrivateTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedPrivateTables);
	public void ReservFamilyTable(String cName, int cContact, int cGuests, String specialRequests, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedFamilyTables);
    public void cancelReservation(String tableType, String tableNumber, int noOfTables, ArrayList<String> available_sTables, ArrayList<String> available_oTables, ArrayList<String> available_pTables, ArrayList<String> available_fTables, ArrayList<String> BookedStandardTables, ArrayList<String> BookedOutdoorTables, ArrayList<String> BookedPrivateTables, ArrayList<String> BookedFamilyTables);
    
    //Manager
    public void displayReservedTablesAndSales(ArrayList<String> bookedStandardTables, ArrayList<String> bookedOutdoorTables, ArrayList<String> bookedPrivateTables, ArrayList<String> bookedFamilyTables);
    public void AddStandardTable(int noOfTables, ArrayList<String> available_sTables);
    public void AddOutdoorTable(int noOfTables, ArrayList<String> available_oTables);
    public void AddPrivateTable(int noOfTables, ArrayList<String> available_pTables);
    public void AddFamilyTable(int noOfTables, ArrayList<String> available_fTables);
    public void RemoveStandardTable(int noOfTables, ArrayList<String> available_sTables);
    public void RemoveOutdoorTable(int noOfTables, ArrayList<String> available_oTables);
    public void RemovePrivateTable(int noOfTables, ArrayList<String> available_pTables);
    public void RemoveFamilyTable(int noOfTables, ArrayList<String> available_fTables);
}
