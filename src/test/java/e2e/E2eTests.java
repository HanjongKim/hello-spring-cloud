package e2e;

import java.lang.invoke.MethodHandles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = E2eTests.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableAutoConfiguration
public class E2eTests {
	private static final Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());
	
	@Value("${application.url}")
	String applicationUrl;
	
	TestRestTemplate testRestTemplate = new TestRestTemplate(HttpClientOption.SSL);

	@Test
	public void shouldWork() {
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("https://" + this.applicationUrl + "/health",String.class);
		
		then(entity.getStatusCode().is2xxSuccessful()).isTrue();
	}
}
