package com.moneybank.customerservice;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerserviceApplicationTests {

   @GetMapping(CUSTOMER_ACCOUNT_DETAILS_END_POINT)
    private ResponseEntity<CustomerOperationResponse> getIndividualCustomerDetails(@PathVariable("id") String id) throws CustomerNotFoundException {
        CustomerExtendedDetails customers = customerService.getCustomerCompleteDetails(Integer.parseInt(id));
        CustomerOperationResponse CustomerDetails = BuilderUtil.responseBuilder(customers, CUSTOMER_DETAILS_FETCHED_SUCCESSFULLY);
        return new ResponseEntity<>(CustomerDetails, HttpStatus.OK);

    }

}

