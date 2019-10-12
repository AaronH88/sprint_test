package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getTransfer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/transfer")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("sender", "0")
        		.param("receiver", "1")
        		.param("amount", "0"))
                .andExpect(status().isOk())
                .andExpect(content()
                		.string(
                				equalTo("{\"sender\":{\"type\":\"Checking\",\"id\":0},\"receiver\":{\"type\":\"Savings\",\"id\":1},\"id\":0}")));
    }
    
    @Test
    public void getNullTransfer() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/transfer")
        		.accept(MediaType.APPLICATION_JSON)
        		.param("sender", "0")
        		.param("receiver", "1")
        		.param("amount", "100000000000"))
                .andExpect(status().isOk())
                .andExpect(content()
                		.string(
                				equalTo("")));
    }
}