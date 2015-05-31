package net.billhosting.service;

import net.billhosting.model.Bill;
import net.billhosting.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static net.billhosting.service.BillConsumerConstants.*;

/**
 * Default implementation of {@link BillConsumer}
 */
@Service
public class BillConsumerImpl implements BillConsumer {

    private static Logger logger = LoggerFactory.getLogger(BillConsumerImpl.class);

    private RestTemplate restTemplate;

    @Autowired
    public BillConsumerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Bill consumeBill(String billName) {
        String billUrl = buildBillUrl(billName);

        logger.info("Consuming bill from endpoint: {}", billUrl);
        return restTemplate.getForObject(billUrl, Bill.class);
    }

    private String buildBillUrl(String billName) {
        return ROOT_URL + billName;
    }
}
