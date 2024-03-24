package com.agrdesign.mockito.mockito101;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.agrdesign.mockito.mockito101.business.MyBusinessImplementation;
import com.agrdesign.mockito.mockito101.business.MyDataService;

@ExtendWith(MockitoExtension.class)
public class MyBusinessImplementationTestMock {

  @Mock
  private MyDataService myMockDataService;

  @InjectMocks
  private MyBusinessImplementation myMyBusinessImplementation;

  @Test
  void unitTestUsingMockData() {

    // DataServiceStub myDataServiceStub = new DataServiceMock();

    // MyDataService myMockDataService = mock(MyDataService.class);
    when(myMockDataService.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 }); // we can change the test easily

    // MyBusinessImplementation myMyBusinessImplementation = new
    // MyBusinessImplementation(myMockDataService);
    System.out.println("the MOCK value is: " + myMyBusinessImplementation.findTheLargestValue());
    assertEquals(25, myMyBusinessImplementation.findTheLargestValue());

  }

  @Test
  void unitTestUsingMockData_noValue() {
    when(myMockDataService.retrieveAllData()).thenReturn(new int[] {});
    System.out.println("the MOCK value is: " + myMyBusinessImplementation.findTheLargestValue());
    assertEquals(Integer.MIN_VALUE, myMyBusinessImplementation.findTheLargestValue());
  }
}
