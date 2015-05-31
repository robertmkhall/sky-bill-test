package net.billhosting.service;

/**
 * Constants for {@link BillConsumer} unit tests
 */
public class BillConsumerTestConstants {

    public static final String TEST_JSON = "{\n" +
            "  \"statement\": {\n" +
            "    \"generated\": \"2015-01-11\",\n" +
            "    \"due\": \"2015-01-25\",\n" +
            "    \"period\": {\n" +
            "      \"from\": \"2015-01-26\",\n" +
            "      \"to\": \"2015-02-25\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"total\": 136.03,\n" +
            "  \"package\": {\n" +
            "    \"subscriptions\": [\n" +
            "      { \"type\": \"tv\", \"name\": \"Variety with Movies HD\", \"cost\": 50.00 }\n" +
            "    ],\n" +
            "    \"total\": 50.00\n" +
            "  },\n" +
            "  \"callCharges\": {\n" +
            "    \"calls\": [\n" +
            "      { \"called\": \"07716393769\", \"duration\": \"00:23:03\", \"cost\": 2.13 }\n" +
            "    ],\n" +
            "    \"total\": 2.13\n" +
            "  },\n" +
            "  \"skyStore\": {\n" +
            "    \"rentals\": [\n" +
            "      { \"title\": \"50 Shades of Grey\", \"cost\": 9.99 }\n" +
            "    ],\n" +
            "    \"buyAndKeep\": [\n" +
            "      { \"title\": \"That's what she said\", \"cost\": 9.99 }\n" +
            "    ],\n" +
            "    \"total\": 19.98\n" +
            "  }\n" +
            "}";
}
