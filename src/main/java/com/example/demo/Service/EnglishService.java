package com.example.demo.Service;

import com.example.demo.Domain.English;
import com.example.demo.Domain.Test;
import com.example.demo.Repository.EnglishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Calendar;
import java.util.List;

@Service
public class EnglishService {

    private EnglishRepo englishRepo;
    @Autowired
    public void setEnglishRepo(EnglishRepo englishRepo) {
        this.englishRepo = englishRepo;
    }

    public List<English> getEnglish(){
        return englishRepo.findAll();
    }
    public List<Test> getTest(){
        return englishRepo.findAllTest();
    }
    public static Test currenrtTest;
    public static String currenrtCorrect;

    public void getTipp(String tipp, String name) {
        System.out.println("találatok:");
        String[] tipps = tipp.split(",");
        int temp = 0;
        int score = 0;
        currenrtCorrect = "";
        for ( English e : getEnglish()) {
            if(e.getCorrect().equals(tipps[temp])){
                System.out.println("helyes: "+e.getCorrect());
                currenrtCorrect += e.getCorrect()+", ";
                score++;
            }
            temp++;
        }


        Test test = new Test("",name,String.valueOf(score),tipp, curerntDate());
        currenrtTest = test; //ezt adjuk oda majd a controllernek, és kiírja a success.html-ben
        englishRepo.insert(test);

        for (Test e:englishRepo.findAllTest()) {
            System.out.println("getid: "+e.getId());
            System.out.println("getTest: "+e.getTest());
            System.out.println("getname: "+e.getName());
            System.out.println("getscore: "+e.getScore());
            System.out.println("gettipp: "+e.getTipp());
            System.out.println("getdate: "+e.getDates());

        }


    }
    public Date curerntDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return date;
    }

}
