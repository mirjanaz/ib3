package ib.project;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ib.project.rest.DemoController;

@SpringBootApplication
public class DemoApplication {

private static String putanja;
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("application");
		putanja = rb.getString("dataDir");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		// create files folder in target/classes
		// avoid spaces in name of project, workspace etc.
		new File(DemoController.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + putanja).mkdirs();
	}
}
 