package net.billhosting.service;

import net.billhosting.model.Bill;

/**
 * Consumes a {@link Bill} from a predefined end point
 */
public interface BillConsumer {

    Bill consumeBill(String billName);
}
