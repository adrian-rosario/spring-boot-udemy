package com.agrdesign.mockito.mockito101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.agrdesign.mockito.mockito101.business.MyBusinessImplementation;
import com.agrdesign.mockito.mockito101.business.MyDataService;

public class MyBusinessImplementationTest {

  @Test
  void unitTestUsingStubData() {
    DataServiceStub myDataServiceStub = new DataServiceStub();

    // a stub is clumsy for lots of test cases
    MyBusinessImplementation myMyBusinessImplementation = new MyBusinessImplementation(myDataServiceStub);

    System.out.println("the stub value is: " + myMyBusinessImplementation.findTheLargestValue());
    // myMyBusinessImplementation.findTheLargestValue();
    assertEquals(25, myMyBusinessImplementation.findTheLargestValue());

  }

}

class DataServiceStub implements MyDataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] { 25, 15, 5 };
  }
}