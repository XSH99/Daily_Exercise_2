package org.example.controller;

import jakarta.ws.rs.*;
import org.example.dao.jobDAO;
import org.example.models.Job;

import java.util.ArrayList;
@Path("/JOB")
public class JobController {

        jobDAO dao = new jobDAO();

        @GET
        public ArrayList<Job> getAllJOB() {

            try {
                return dao.selectAllJobs();
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
        @Path("{deptId}")
        public void deleteJOB(@PathParam("deptId") int deptId) {

            try {
                dao.setDeleteJobs(deptId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        public void insertJOB(Job dept) {

            try {
                dao.setInsertJobs(dept);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @PUT
        @Path("{deptId}")
        public void updateJOB(@PathParam("deptId") int deptId, Job dept) {

            try {
                dept.setJob_id(deptId);
                dao.setUpdateJobs(dept);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

