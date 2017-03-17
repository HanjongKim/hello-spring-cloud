package unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.invoke.MethodHandles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import helloworld.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class sampleUnitTests {

	private static final Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass());
	
	final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testSayHelloWorld(){

    	try {
    		this.mockMvc.perform(get("/")
                    .accept(MediaType.ALL))
                    .andExpect(status().isOk());
		} catch (Exception e) {
			log.info(e);
			// TODO: handle exception
		}
         

    }
}
