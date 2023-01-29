package com.example.ocrmaster.Controller;

import com.example.ocrmaster.Service.GeneralAccurateOCR;
import com.example.ocrmaster.Service.GeneralBasicOCR;
import com.example.ocrmaster.Service.GeneralEfficientOCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcrController {
    @Autowired
    GeneralEfficientOCR geo;
    @Autowired
    GeneralBasicOCR gbo;
    @Autowired
    GeneralAccurateOCR gao;

    @PostMapping("generalEfficientOCR")
    public String generalEfficientOCR(String base64){
        return geo.start(base64);
    }
    @PostMapping("generalBasicOCR")
    public String generalBasicOCR(String base64){
        return gbo.start(base64);
    }
    @PostMapping("generalAccurateOCR")
    public String generalAccurateOCR(String base64){
        return gao.start(base64);
    }
}
