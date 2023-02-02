package com.example.ocrmaster.Controller;

import com.example.ocrmaster.Pojo.OcrPojo;
import com.example.ocrmaster.Service.GeneralAccurateOCR;
import com.example.ocrmaster.Service.GeneralBasicOCR;
import com.example.ocrmaster.Service.GeneralEfficientOCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OcrController {
    @Autowired
    GeneralEfficientOCR geo;
    @Autowired
    GeneralBasicOCR gbo;
    @Autowired
    GeneralAccurateOCR gao;

    @PostMapping("generalEfficientOCR")
    public List<OcrPojo> generalEfficientOCR(String base64){
        return geo.start(base64);
    }
    @PostMapping("generalBasicOCR")
    public List<OcrPojo> generalBasicOCR(String base64){
        return gbo.start(base64);
    }
    @PostMapping("generalAccurateOCR")
    public List<OcrPojo> generalAccurateOCR(String base64){
        return gao.start(base64);
    }
}
