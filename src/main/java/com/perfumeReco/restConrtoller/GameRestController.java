package com.perfumeReco.restConrtoller;

import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.service.GameService;
import com.perfumeReco.vo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest")
@CrossOrigin(origins = "*")
public class GameRestController {

    @Autowired
    GameService gameService;

    @PostMapping("/score")
    public ResponseDto<String> gamePoint(Score score) {

        ResponseDto<String> response = new ResponseDto<>();
        System.out.println(score.getResult());

        gameService.insertGameResult(score);
        response.setStatus("OK");
        return response;
    }


}
