package com.perfumeReco.service;


import com.perfumeReco.dao.GameDao;
import com.perfumeReco.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    public void insertGameResult(Score score){
         gameDao.insertGameResult(score);
    }
}
