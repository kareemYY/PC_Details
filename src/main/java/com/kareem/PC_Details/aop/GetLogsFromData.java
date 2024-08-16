package com.kareem.PC_Details.aop;



import com.kareem.PC_Details.dto.aopDto.PcLogsDto;
import com.kareem.PC_Details.service.PcLogsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class GetLogsFromData {
    
    private PcLogsService pcLogsService;


    @Autowired
    public GetLogsFromData(PcLogsService pcLogsService) {
        this.pcLogsService = pcLogsService;

    }

    @Pointcut("execution(* com.springboot.blog.service.impl.PcDetailsServiceImpl.deletePcData(..))")
    private void deleteData(){}

    @Pointcut("execution(* com.springboot.blog.service.impl.PcDetailsServiceImpl.upDatePcDetails(..))")
    private void updateData(){}

    @Around("deleteData()||updateData()")
    public Object createPcLogs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        int id = getId(proceedingJoinPoint);

        PcLogsDto pcLogsDto1 = pcLogsService.prepareDate(id);
        System.out.println("============1> "+pcLogsDto1);

        Object object = proceedingJoinPoint.proceed();

        PcLogsDto pcLogsDto2= pcLogsService.prepareDate(id);
        System.out.println("============2> "+pcLogsDto2);

        if(!pcLogsDto1.equals(pcLogsDto2)){
            pcLogsDto1.setDateEnd(new Date());
            pcLogsService.createPcLogs(pcLogsDto1);

            System.out.println("============> "+pcLogsDto1);
            System.out.println("============> "+pcLogsDto2);
        }






        return object;

    }

    private int getId(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        int id = 0 ;
        for (Object arg : args) {
            if (arg instanceof Integer){id = (int) arg;}}
        return id;
    }

}
