package com.perfumeReco.dao;

import com.perfumeReco.vo.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreDao {

    void uploadScore(Score score);

}
