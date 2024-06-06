package org.example.controller;
import jakarta.ws.rs.core.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.jobDAO;
import org.example.dto.JobDto;
import org.example.dto.JobFilterDto;
import org.example.exceptions.DataNotFoundException;
import org.example.models.Job;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/JOB")

public class JobController {
    jobDAO dao = new jobDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;


//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public ArrayList<Job> getAllJob(
////            @QueryParam("min_salary") Double min_salary,
////            @QueryParam("limit") Integer limit,
////            @QueryParam("offset") int offset
//            @BeanParam JobFilterDto filter
//    ) {
//        try {
//            return dao.selectAllJobs(filter);
//           // return dao.selectAllJobs(min_salary, limit, offset);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,"text/csv"})
    public Response getAllJob(
            @BeanParam JobFilterDto filter
    ) {
        try {
            GenericEntity<ArrayList<Job>> jobs = new GenericEntity<ArrayList<Job>>(dao.selectAllJobs(filter)) {
            };
            if (headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(jobs)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            else if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf("text/csv"))) {
                return Response
                        .ok(jobs)
                        .type("text/csv")
                        .build();
            }

            return Response
//                    .ok()
//                    .entity(jobs)
//                    .type(MediaType.APPLICATION_JSON)
                    .ok(jobs, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

// i have to chnge all this file all type in controler need to change
//    @GET
//    @Path("{jobId}")
//    public Response getJOB(@PathParam("jobId") int deptId) {
//
//        try {
//            Job jobs = dao.selectJobs(jobId);
//            if (headers.getAcceotableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
//                return Response
//                        .ok(dao)
//                        .type(MediaType.APPLICATION_XML)
//                        .build();
//            }
//            JobDto dto = new JobDto();
//            dto.setJob_id(jobs.getJob_id());
//            dto.setJob_title(jobs.getJob_title());
//            dto.setMin_salary(jobs.getMin_salary());
//            dto.setMax_salary(jobs.getMax_salary());
//            return Response.ok(dto).build();
//        }
//    }

    @GET
    @Path("{jobId}")
    public Response getJob(@PathParam("jobId") int jobId) throws SQLException {

        try {
            Job job = dao.selectJobs(jobId);

            if (job == null) {
                throw new DataNotFoundException("Job with ID " + jobId + " not found");
            }
            JobDto dto = new JobDto();
            dto.setJob_id(job.getJob_id());
            dto.setMax_salary(job.getMax_salary());
            dto.setMin_salary(job.getMin_salary());
            dto.setJob_title(job.getJob_title());
            addLinks(dto);
            return Response.ok(dto).build();
        } catch (Exception e) {
            throw new RuntimeException("Error getting job with ID " + jobId, e);
        }
    }


    private void addLinks(JobDto dto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(JobController.class)
                .build();

        dto.addLink(selfUri.toString(), "self");
        dto.addLink(empsUri.toString(), "employees");
    }


//        @DELETE
//        @Path("{jobId}")
//        public void deleteJOB(@PathParam("jobId") int deptId) {
//
//            try {
//                dao.setDeleteJobs(deptId);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

    @DELETE
    @Path("{jobId}")
    public void deleteJob(@PathParam("jobId") int jobId) {

        try {
            dao.setDeleteJobs(jobId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting job with ID " + jobId, e);
        }
    }



//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    public void insertJOB(Job dept) {
//
//        try {
//            dao.setInsertJobs(dept);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response insertJob(Job job) {

        try {
            dao.setInsertJobs(job);
            URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(job.getJob_id())).build();
            return Response.created(uri).build();
        } catch (Exception e) {
            throw new RuntimeException("Error inserting job", e);
        }
    }



//    @PUT
//    @Path("{jobId}")
//    public void updateJOB(@PathParam("jobId") int deptId, Job dept) {
//
//        try {
//            dept.setJob_id(deptId);
//            dao.setUpdateJobs(dept);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @PUT
    @Path("{jobId}")
    public void updateJob(@PathParam("jobId") int jobId, Job job) {

        try {
            job.setJob_id(jobId);
            dao.setUpdateJobs(job);
        } catch (Exception e) {
            throw new RuntimeException("Error updating job with ID " + jobId, e);
        }
    }



}

