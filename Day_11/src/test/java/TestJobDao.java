import jakarta.ws.rs.core.UriInfo;
import org.example.dao.jobDAO;
import org.example.dto.JobFilterDto;
import org.example.models.Job;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;



@ExtendWith(MockitoExtension.class)
public class TestJobDao {

    @Mock
    JobFilterDto filter;


    @Mock
    UriInfo uriInfo;

 @Test
    public void testUpdateJob() throws SQLException , ClassNotFoundException{
     jobDAO dao = new jobDAO();
     Job d = new Job("Manager",1,6500,5500);
     Assertions.assertDoesNotThrow(() -> dao.setUpdateJobs(d));
     Job newJ = dao.selectJobs(d.getJob_id());

     Assertions.assertNotNull(newJ);
     Assertions.assertEquals(newJ.getJob_title(),d.getJob_title());
     Assertions.assertEquals(newJ.getMax_salary(),d.getMax_salary());
     Assertions.assertEquals(newJ.getMin_salary(),d.getMin_salary());
}

}
