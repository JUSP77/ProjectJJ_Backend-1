package com.perfumeReco.service;


import com.perfumeReco.dao.ScoreDao;
import com.perfumeReco.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    ScoreDao scoreDao;

    public void uploadScore(Score score){

        scoreDao.uploadScore(score);
    }
}
