package com.agrdesign.mockito.mockito101.business;

// import com.agrdesign.mockito.mockito101.MyDataServiceStub;

public class MyBusinessImplementation {

  private MyDataService myDataService;

  public MyBusinessImplementation(MyDataService myDataService) {
    super();
    this.myDataService = myDataService;
  }

  public int findTheLargestValue() {
    int[] someData = myDataService.retrieveAllData();

    int largestValue = Integer.MIN_VALUE;

    for (int theValues : someData) {
      if (theValues > largestValue)
        largestValue = theValues;
    }

    return largestValue;
  }
}

/**
 * MyDataService
 */
// public interface MyDataService {
// int[] retrieveAllData();
// }