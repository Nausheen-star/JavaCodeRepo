package com.moneybank.customerservice;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerserviceApplicationTests {





  public boolean isPalindrome(String test) {
    if (test == null || test.trim().isEmpty()) {
        return true;
    }

    String s = test.toLowerCase();
    int i = 0, j = s.length() - 1;

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

}
