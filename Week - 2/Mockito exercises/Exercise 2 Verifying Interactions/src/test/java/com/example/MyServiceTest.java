package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData(); // this should call mockApi.getData()

        // Verify that the method was called exactly once
        verify(mockApi).getData();
    }
}
