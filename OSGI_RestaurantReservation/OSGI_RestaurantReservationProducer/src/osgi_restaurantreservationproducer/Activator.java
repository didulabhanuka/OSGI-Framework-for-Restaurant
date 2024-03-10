package osgi_restaurantreservationproducer;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Hashtable<String, String> props = new Hashtable<String, String>();
		context.registerService(RestaurantReservationService.class.getName(), new RestaurantReservationServiceImpl(), props);
        System.out.println("Restaurant Reservation Producer Service registered and started successfully");
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Restaurant Reservation Producer Service stopped successfully");	
	}

}
