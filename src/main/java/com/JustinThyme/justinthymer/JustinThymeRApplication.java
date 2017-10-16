package com.JustinThyme.justinthymer;

import com.JustinThyme.justinthymer.models.data.SeedDao;
import com.JustinThyme.justinthymer.models.forms.Seed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

import static com.JustinThyme.justinthymer.models.forms.Seed.Area.*;
import static com.JustinThyme.justinthymer.models.forms.Seed.Season.*;

@SpringBootApplication
public class JustinThymeRApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustinThymeRApplication.class, args);
	}

	@Bean
	public CommandLineRunner trial(SeedDao seedDao) {
		return(args) -> {
			//note having trouble instantiating with default for reminder, so changed seed constructor
			//note Date structure see notes in TwillController for details (year(-1900), month(-1), day, hour, minute)
			seedDao.save(new Seed("carrot", WESTCOAST, FALL, new Date(117, 9, 7, 19, 41)));
			seedDao.save(new Seed("peas", MIDNORTH, FALL, new Date(117, 9, 7, 19, 41)));
			seedDao.save(new Seed("onions", SOUTH, SPRING, new Date(117, 3,15, 19, 22)));
			seedDao.save(new Seed("carrot", FLORIDA, SUMMER, new Date(117, 5, 28, 19, 05)));
		};
	}

}
