package org.example.Test;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.example.controller.JobController;
import org.example.mappers.JobMapper;
import org.example.models.Job;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.net.URI;
import java.sql.SQLException;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TestJobController {

    @InjectMocks
    JobController JopCont;

    @InjectMocks
    JobController jobController;
// one Mock less

    @Mock
    JobMapper mapper;

    @Mock
    UriInfo uriInfo;



    @Test
    public void TestUpdateJob() throws SQLException,ClassNotFoundException{

        Job jobs = new Job( "Manager" ,8, 6500 , 5500);
        URI uri = URI.create("http://localhost/api/job/1");

        when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromUri(uri));
        Assertions.assertDoesNotThrow(() -> jobController.updateJob(1,jobs));

    }


}
