package org.example.mappers;

import org.example.dto.JobDto;
import org.example.models.Job;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T08:00:13+0300",
    comments = "version: 1.6.0.Beta2, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
*/
public class JobMapperImpl implements JobMapper {

    @Override
    public JobDto toJobDto(Job j) {
        if ( j == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        jobDto.setJob_title( j.getJob_title() );
        jobDto.setJob_id( j.getJob_id() );
        jobDto.setMin_salary( j.getMin_salary() );
        jobDto.setMax_salary( j.getMax_salary() );

        return jobDto;
    }

    @Override
    public Job toModel(JobDto dto) {
        if ( dto == null ) {
            return null;
        }

        Job job = new Job();

        job.setJob_id( dto.getJob_id() );
        job.setJob_title( dto.getJob_title() );
        job.setMin_salary( dto.getMin_salary() );
        job.setMax_salary( dto.getMax_salary() );

        return job;
    }
}
