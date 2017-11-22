package dzone.springboot.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dzone.springboot.mysql.dao.SystemRepository;

@SpringBootApplication
@EntityScan("dzone.springboot.mysql.model")
@EnableJpaRepositories("dzone.springboot.mysql.dao")
public class DzoneSpringbootMysqlTestApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SystemRepository systemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DzoneSpringbootMysqlTestApplication.class, args);
	}


	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Our DataSource is = " + dataSource);
		Iterable<dzone.springboot.mysql.model.System> systemList = systemRepository.findAll();
		for (dzone.springboot.mysql.model.System system: systemList) {
			System.out.println(String.format("Here's a system: %s", system.toString()));
		}
	}
}
