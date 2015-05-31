package net.billhosting.controller;

import net.billhosting.service.BillConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static net.billhosting.service.BillConsumerConstants.*;

/**
 * MVC Controller for bill endpoints
 */
@Controller
@RequestMapping(value = "/")
public class BillController {

    private static Logger logger = LoggerFactory.getLogger(BillController.class);

    private BillConsumer billConsumer;

    @Autowired
    public BillController(BillConsumer billConsumer) {
        this.billConsumer = billConsumer;
    }

    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public String getBill(Model model) {
        logger.info("Recieved GET request for bill");

        model.addAttribute("bill", billConsumer.consumeBill(DEFAULT_BILL_NAME));

        return "bill_view";
    }
}
