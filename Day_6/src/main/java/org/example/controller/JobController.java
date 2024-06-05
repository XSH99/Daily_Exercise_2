package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.jobDAO;
import org.example.dto.JobFilterDto;
import org.example.models.Job;

import java.util.ArrayList;

@Path("/JOB")

public class JobController {
    jobDAO dao = new jobDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Job> getAllJob(
//            @QueryParam("min_salary") Double min_salary,
//            @QueryParam("limit") Integer limit,
//            @QueryParam("offset") int offset
            @BeanParam JobFilterDto filter
    ) {
        try {
            return dao.selectAllJobs(filter);
           // return dao.selectAllJobs(min_salary, limit, offset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


        @GET
        @Path("{jobId}")
        public Job getJOB(@PathParam("jobId") int deptId) {

            try {
                return dao.selectJobs(deptId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{jobId}")
        public void deleteJOB(@PathParam("jobId") int deptId) {

            try {
                dao.setDeleteJobs(deptId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void insertJOB(Job dept) {

        try {
            dao.setInsertJobs(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{jobId}")
    public void updateJOB(@PathParam("jobId") int deptId, Job dept) {

        try {
            dept.setJob_id(deptId);
            dao.setUpdateJobs(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    }

