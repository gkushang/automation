package com.raj.apple;

import com.raj.apple.pojo.User;
import com.raj.apple.utility.ApiOperations;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.raj.apple.utility.ConstantValues.URL_FOR_HTTP_GET_TEST;
import static org.testng.Assert.assertEquals;

/**
 * Created by kshitij on 3/20/18.
 */
public class HttpGetTest {

    private ApiOperations apiOperations = new ApiOperations();
    private HttpResponse httpResponse;
    private List<User> user;

    @BeforeClass
    public void setUp() throws IOException {
        httpResponse = apiOperations.executeGetCall(URL_FOR_HTTP_GET_TEST);
        user = apiOperations.makeUserPojoFromRequest(httpResponse);
    }

    @Test
    public void tenRecordShouldExist() {
        assertEquals(user.size(), 10);
    }
}
