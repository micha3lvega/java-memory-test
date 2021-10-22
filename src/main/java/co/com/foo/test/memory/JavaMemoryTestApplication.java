package co.com.foo.test.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.foo.test.memory.repository.IFooRepository;

@SpringBootApplication
public class JavaMemoryTestApplication implements CommandLineRunner {

	@Autowired
	private IFooRepository repository;
	private static final Logger log = LoggerFactory.getLogger(JavaMemoryTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaMemoryTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("duumy value: {}", repository.getDummyValue());

	}

}
