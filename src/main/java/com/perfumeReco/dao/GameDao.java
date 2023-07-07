package com.perfumeReco.dao;

import com.perfumeReco.vo.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameDao {


    void insertGameResult(Score score);

}



