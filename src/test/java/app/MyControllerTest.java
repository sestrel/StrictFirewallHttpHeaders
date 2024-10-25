package app;


import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;

@WebFluxTest(controllers = MyController.class)
@Import(SecurityConfig.class)
class MyControllerTest
{

	@Autowired
	WebTestClient webClient;

	@BeforeEach
	public void setUp()
	{
		webClient = webClient.mutate().responseTimeout(Duration.ofMillis(3000000)).build();
	}

	@Test
	void test()
	{
		var uri = UriComponentsBuilder.fromUriString("/api/mycontroller").build().toUri();

		webClient.get().uri(uri).exchange().expectStatus().isOk();
	}

}
