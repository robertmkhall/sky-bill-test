package net.billhosting.controller;

import net.billhosting.config.AppConfig;
import net.billhosting.config.WebConfig;
import net.billhosting.model.Bill;
import net.billhosting.model.BillTestBuilder;
import net.billhosting.service.BillConsumer;
import net.billhosting.service.BillConsumerConstants;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link BillController}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
public class BillControllerTest {

    private MockMvc mockMvc;

    private BillConsumer billConsumer;

    @Before
    public void setup() {
        billConsumer = mock(BillConsumer.class);
        BillController billController = new BillController(billConsumer);

        this.mockMvc = MockMvcBuilders.standaloneSetup(billController).build();
    }

    @Test
    public void testGetBill() throws Exception {
        // arrange
        Bill expectedBill = BillTestBuilder.aDefaultBill().build();
        when(billConsumer.consumeBill(BillConsumerConstants.DEFAULT_BILL_NAME)).thenReturn(expectedBill);

        // act
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("bill_view"))
                .andExpect(model().attributeExists("bill"));

        // assert
    }
}