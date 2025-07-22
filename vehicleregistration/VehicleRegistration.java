package vehicleregistration;
import car.Car;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class VehicleRegistration {

	private static final String CARS_FILE = "car.ser";
	private static ArrayList<Car> cars = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String make = null;
		String model = null;
		String vinNo = null;
		String licensePlate = null;
		int year = 0;
		
		cars = loadCars();
		
		System.out.print("\r                        ==================================================================\n"
				+ "                                    Hello, welcome to my vehicle registration platform.\n"
				+ "                                       Congrats on the new wheels by the way!!\n"
				+ "                       ==================================================================\n\n"
				+ "  What is your name? ");
		String name = scanner.nextLine();
		int choice = 0;
		
		System.out.println("\n  It's nice to know your name " + name + "!!");
		
		do {
			System.out.println("\n\n                        =================================================================="
					+ "\n                                             What do you want to do today?"
					+ "\n                        =================================================================="
					+ "\n\n                       PLEASE CHOOSE ONE OF THE FOLLOWING OPTIONS: "
					+ "\n                          (1)Capture vehicle details"
					+ "\n                          (2) View vehicle report"
					+ "\n                          (3) Exit");
			
			choice = scanner.nextInt();
			//scanner.nextLine();
			
			switch(choice){
				case 1:
					if(scanner.hasNextLine()) {
						System.out.print("Please enter make of the car: ");
						make = scanner.next();
						
						System.out.print("Please enter model of the car: ");
						model = scanner.next();
						
						System.out.print("Please enter vin number: ");
						while(true) {
							vinNo = scanner.next();
							if(vinNo.length() != 17) {
								System.out.println("A vin number has 17 characters. Please enter correct vin number.");
							}else {
								break;
							}
						}
						
						System.out.println("Please enter the license plate type:"
								+ "\n(1) for old (e.g. AAA-111-GP )"
								+ "\n(2) for new (e.g. AA-11-BB-GP )");
						int licenseType = scanner.nextInt();
						scanner.nextLine();
						
						System.out.print("Please enter license plate of the car: ");
						while(true) {
							licensePlate = scanner.next();
							//boolean bool = licensePlateValidation(licensePlate, licenseType);
							if(licensePlateValidation(licensePlate, licenseType) == true) {
								break;
							}else {
								System.out.print("please enter license of the correct format");
							}
						}
						
					}else {
						System.out.println("Please enter valid input");
					}
					
					while(true) {
						try {
							year = Integer.parseInt(scanner.nextLine());
							break;
						}catch(NumberFormatException e) {
							System.out.print("please enter a valid year: ");
						}
					}
					
					
					Car newCar = new Car(name, make, model, vinNo, licensePlate, year);
					cars.add(newCar);
					saveCars(cars);
					System.out.print("\r                        ==================================================================\n"
							+ "\n                                         Vehicle successfully registered"
							+ "\r                        ==================================================================\n");
					break;
					
				case 2:
					if(cars.isEmpty()) {
						System.out.print("No vehicles registered yet.");
					}else {
						for(int i = 0; i < cars.size(); i++) {
							Car car = cars.get(i);
							if(car.getOwnerName().equalsIgnoreCase(name)) {
								System.out.println("                             *************************************************"
										+ "\n\s                                                 VEHICLE REPORT                      "
										+ "\n                             *************************************************\n"
										+ "\n                             NAME:  " + car.getOwnerName()
										+ "\n                             VEHICLE MAKE:  " + car.getMake()
										+ "\n                             VEHICLE MODEL: " + car.getModel()
										+ "\n                             VIN NUMBER: " + car.getVinNo()
										+ "\n                             LICENSE PLATE NUMBER: " + car.getLicenseNo()
										+ "\n                             YEAR: " + car.getYear()
										+ "\n\n                             CREATED AT: " + car.getDate()
										+ "\n\n                             ***********************end*********************\n\n");
							}
							
						}
					}
					break;
				
				case 3:
					System.out.print("Thank you for using my vehicle registration platform");
					
					
			}
			
		}while(choice !=3);
		scanner.close();
	}

	
	public static boolean licensePlateValidation(String licensePlate, int licenseType) {
		boolean bool = false;
		String license_plate_regex_old = "[A-Z]{3}-\\d{3}-[A-Z]{2,3}";
		String license_plate_regex_new = "[A-Z]{2}-\\d{2}-[A-Z]{2}-[A-Z]{2,3}";
		if(licensePlate == null || licensePlate.trim().isEmpty()) {
			bool = false;
		}
		
		String upperLicensePlate = licensePlate.trim().toUpperCase();
		
		switch(licenseType) {
		case 1:
			Pattern pattern = Pattern.compile(license_plate_regex_old);
			Matcher matcher = pattern.matcher(upperLicensePlate);
			bool = matcher.matches();
			break;
			
		case 2:
			pattern = Pattern.compile(license_plate_regex_new);
			matcher = pattern.matcher(upperLicensePlate);
			bool = matcher.matches();
			break;
		}
		
		
		return bool;
	}
	
	public static void saveCars(ArrayList<Car> cars) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(CARS_FILE);
			ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
			objOutput.writeObject(cars);
			objOutput.close();
			fileOutput.close();
		}catch(IOException e) {
			System.out.println("Error saving cars: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Car> loadCars(){
		File file = new File(CARS_FILE);
		if(!file.exists()) {
			return new ArrayList<>();
		}
		
		try {
			FileInputStream fileIn = new FileInputStream(CARS_FILE);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Car> loadedCars = (ArrayList<Car>) in.readObject();
			in.close();
			fileIn.close();
			
			return loadedCars;
		} catch(IOException e) {
			System.out.println("Error loading cars: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}catch(ClassNotFoundException e) {
			System.out.println("Car class not found: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}