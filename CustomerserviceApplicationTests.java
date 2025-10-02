package com.moneybank.customerservice;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerserviceApplicationTests {

   @DeleteMapping(CUSTOMER_ID)
    private ResponseEntity<CustomerOperationResponse> deleteCustomer(@PathVariable("id") String id) throws CustomerNotFoundException {
        customerService.deleteCustomer(Integer.parseInt(id));
        CustomerOperationResponse CustomerDetails = BuilderUtil.responseBuilder("", CUSTOMER_DETAILS_DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(CustomerDetails, HttpStatus.OK);

    }



  public boolean isPalindrome(String test) {
    if (test == null || test.trim().isEmpty()) {
        return true;
    }

    String s = test.toLowerCase();
    int i = 0, j = s.length() - 1;

    @Autowired
    private CustomerService customerService;
    while (i < j) {
        // skip non-alphanumeric from the left
        while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
            i++;
        }
        // skip non-alphanumeric from the right
        while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
            j--;
        }

        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}


  @GetMapping(CUSTOMER_ID)
    private ResponseEntity<CustomerDetailsResponse> getIndividualCustomer(@PathVariable("id") String id) throws CustomerNotFoundException {
        CustomerDetails customers = customerService.getCustomerDetails(Integer.parseInt(id));
        CustomerDetailsResponse customerDetailsResponse = CustomerDetailsResponse.builder().customerDetails(customers).httpStatus(HttpStatus.OK).message(CUSTOMER_DETAILS_FETCHED_SUCCESSFULLY).build();
        return new ResponseEntity<>(customerDetailsResponse, HttpStatus.OK);

    }

   @PutMapping(CUSTOMER_ID)
    private ResponseEntity<CustomerOperationResponse> updateCustomerDetails(@PathVariable("id") String id, @RequestBody CustomerDetailsRequest customerDetailsRequest) throws CustomerNotFoundException {
        customerService.updateCustomerDetails(Integer.parseInt(id), customerDetailsRequest);
        CustomerOperationResponse CustomerDetails = BuilderUtil.responseBuilder(customerDetailsRequest, CUSTOMER_DETAILS_UPDATED_SUCCESSFULLY);
        return new ResponseEntity<>(CustomerDetails, HttpStatus.OK);
    }

}

