package fr.picart.david;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SiteApplication {

	static final Logger log = Logger.getLogger(SiteApplication.class);

	@PostConstruct
	public void postMain(){
		TimeZone.setDefault(TimeZone.getDefault());
	}

	public static void main(String[] args) {

		log.error(TimeZone.getDefault());
		SpringApplication.run(SiteApplication.class, args);
	}
}
