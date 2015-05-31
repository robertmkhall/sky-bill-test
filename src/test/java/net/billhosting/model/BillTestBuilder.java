package net.billhosting.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds {@link Bill} objects for unit tests
 */
public class BillTestBuilder {

    public static final String GENERATED_DATE = "2015-01-11";
    public static final String DUE_DATE = "2015-01-25";
    public static final String PERIOD_FROM_DATE = "2015-01-26";
    public static final String PERIOD_TO_DATE = "2015-02-25";

    public static final Double SUMMARY_TOTAL = 136.03d;
    public static final Double PACKAGE_TOTAL = 50.00d;
    public static final Double CALL_CHARGES_TOTAL = 2.13d;
    public static final Double SKY_STORE_TOTAL = 19.98d;

    private Statement statement;
    private Double total;
    private Package _package;
    private CallCharges callCharges;
    private SkyStore skyStore;

    /**
     * START: Mother methods
     */

    private BillTestBuilder() {
    }

    public static BillTestBuilder aDefaultBill() {
        return new BillTestBuilder()
                .withStatement(getDefaultStatement())
                .withTotal(SUMMARY_TOTAL)
                .withPackage(getDefaultPackage())
                .withCallCharges(getDefaultCallCharges())
                .withSkyStore(getDefaultSkyStore());
    }

    /**
     * END: Mother methods
     */

    /**
     * START: Builder methods
     */

    public BillTestBuilder withStatement(Statement statement) {
        this.statement = statement;
        return this;
    }

    public BillTestBuilder withTotal(Double total) {
        this.total = total;
        return this;
    }

    public BillTestBuilder withPackage(Package _package) {
        this._package = _package;
        return this;
    }

    public BillTestBuilder withCallCharges(CallCharges callCharges) {
        this.callCharges = callCharges;
        return this;
    }

    public BillTestBuilder withSkyStore(SkyStore skyStore) {
        this.skyStore = skyStore;
        return this;
    }

    public Bill build() {
        Bill bill = new Bill();
        bill.setStatement(statement);
        bill.setTotal(total);
        bill.setPackage(_package);
        bill.setCallCharges(callCharges);
        bill.setSkyStore(skyStore);
        return bill;
    }

    /**
     * END: Builder methods
     */

    private static Statement getDefaultStatement() {
        Period period = new Period();
        period.setFrom(PERIOD_FROM_DATE);
        period.setTo(PERIOD_TO_DATE);

        Statement statement = new Statement();
        statement.setGenerated(GENERATED_DATE);
        statement.setDue(DUE_DATE);
        statement.setPeriod(period);
        return statement;
    }

    private static Package getDefaultPackage() {
        Subscription subscription = new Subscription();
        subscription.setType("tv");
        subscription.setName("Variety with Movies HD");
        subscription.setCost(50.00d);

        List<Subscription> subscriptions = new ArrayList<Subscription>();
        subscriptions.add(subscription);

        Package _package = new Package();
        _package.setSubscriptions(subscriptions);
        _package.setTotal(PACKAGE_TOTAL);
        return _package;
    }

    private static CallCharges getDefaultCallCharges() {
        Call call = new Call();
        call.setCalled("07716393769");
        call.setDuration("00:23:03");
        call.setCost(2.13d);

        List<Call> calls = new ArrayList<Call>();
        calls.add(call);

        CallCharges callCharges = new CallCharges();
        callCharges.setCalls(calls);
        callCharges.setTotal(CALL_CHARGES_TOTAL);
        return callCharges;
    }

    private static SkyStore getDefaultSkyStore() {
        BuyAndKeep buyAndKeep = new BuyAndKeep();
        buyAndKeep.setTitle("That's what she said");
        buyAndKeep.setCost(9.99d);

        List<BuyAndKeep> buyAndKeeps = new ArrayList<BuyAndKeep>();
        buyAndKeeps.add(buyAndKeep);

        Rental rental = new Rental();
        rental.setTitle("50 Shades of Grey");
        rental.setCost(9.99d);

        List<Rental> rentals = new ArrayList<Rental>();
        rentals.add(rental);

        SkyStore skyStore = new SkyStore();
        skyStore.setBuyAndKeep(buyAndKeeps);
        skyStore.setRentals(rentals);
        skyStore.setTotal(SKY_STORE_TOTAL);
        return skyStore;
    }
}