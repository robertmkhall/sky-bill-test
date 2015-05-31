package net.billhosting.service;

import net.billhosting.model.Bill;
import net.billhosting.model.BillTestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.unitils.reflectionassert.ReflectionAssert;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static net.billhosting.service.BillConsumerTestConstants.*;

/**
 * Unit tests for {@link BillConsumerImpl}
 */
public class BillConsumerImplTest {

    private MockRestServiceServer restServer;
    private BillConsumerImpl billConsumer;

    @Before
    public void setup() {
        RestTemplate restTemplate = new RestTemplate();
        restServer = MockRestServiceServer.createServer(restTemplate);

        billConsumer = new BillConsumerImpl(restTemplate);
    }

    @Test
    public void testConsumeBill() throws Exception {
        // arrange
        String jsonFileName = "test.json";
        Bill expectedBill = BillTestBuilder.aDefaultBill().build();

        restServer.expect(requestTo(BillConsumerConstants.ROOT_URL + jsonFileName))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(TEST_JSON, MediaType.APPLICATION_JSON));

        // act
        Bill actualBill = billConsumer.consumeBill(jsonFileName);

        // assert
        ReflectionAssert.assertLenientEquals(expectedBill, actualBill);
    }
}