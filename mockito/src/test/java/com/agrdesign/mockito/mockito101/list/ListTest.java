package com.agrdesign.mockito.mockito101.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

  @Test
  void simpleReturn() {
    List myListMock = mock(List.class);
    when(myListMock.size()).thenReturn(3);
    assertEquals(3, myListMock.size());
  }

  @Test
  void multipleReturns() {
    List myListMock = mock(List.class);
    when(myListMock.size()).thenReturn(3).thenReturn(4);
    assertEquals(3, myListMock.size());
    assertEquals(4, myListMock.size());
    assertEquals(4, myListMock.size());
  }

  @Test
  void specificParameters() {
    List myListMock = mock(List.class);
    when(myListMock.get(0)).thenReturn("some string").thenReturn(4);
    assertEquals("some string", myListMock.get(0));
    assertEquals(null, myListMock.get(1));
  }

  @Test
  void specificGeneric() {
    List myListMock = mock(List.class);
    System.out.println("? any int ? " + myListMock.get(Mockito.anyInt()));
    when(myListMock.get(Mockito.anyInt())).thenReturn("some string");
    assertEquals("some string", myListMock.get(0));
    assertEquals("some string", myListMock.get(1));
  }
}
