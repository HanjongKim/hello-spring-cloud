package scenario.sample;

import static org.assertj.core.api.BDDAssertions.then;

import java.lang.invoke.MethodHandles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration
public class SampleTest {

	private static final Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());

	@Value("${application.url}") String applicationUrl;
	
	TestRestTemplate testRestTemplate = new TestRestTemplate(HttpClientOption.SSL);
	

    @Given("^get sample given$")
    public void get_sample_given(){
    	System.out.println("Cucumber Background Test given");
        
    }

    @Given("^get sample list$")
    public void get_sample_list(){
    	System.out.println("Cucumber Test givenaa");
        ResponseEntity<String> entity = this.testRestTemplate
				.getForEntity("https://" + this.applicationUrl + "/health", String.class);

		
		// HttpStatus Code Check
		then(entity.getStatusCode().is2xxSuccessful()).isTrue();
		System.out.println("Cucumber get list : " + entity.getBody());
    }

    @And("^get sample And$")
    public void get_sample_and(){
        System.out.println("Cucumber Test And");
    }

    @When("^get sample when$")
    public void get_sample_when(){
        System.out.println("Cucumber Test when");

    }

    @But("^get sample But$")
    public void get_sample_but(){
        System.out.println("Cucumber Test But");

    }

    @Then("^get sample then$")
    public void get_sample_then(){
        System.out.println("Cucumber Test then");

    }
}
