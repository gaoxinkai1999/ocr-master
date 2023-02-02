package com.example.ocrmaster.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.ocrmaster.Pojo.OcrPojo;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.GeneralAccurateOCRResponse;
import com.tencentcloudapi.ocr.v20181119.models.GeneralEfficientOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.GeneralEfficientOCRResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneralEfficientOCR {

    public List<OcrPojo> start(String base64) {

        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户 SecretId 和 SecretKey，此处还需注意密钥对的保密
            // 代码泄露可能会导致 SecretId 和 SecretKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议采用更安全的方式来使用密钥，请参见：https://cloud.tencent.com/document/product/1278/85305
            // 密钥可前往官网控制台 https://console.cloud.tencent.com/cam/capi 进行获取
            Credential cred = new Credential("AKIDtb4GBpCI7fwwf7HCqDI8hz0kEQLzMSGn", "IJ2UfZCBtLXS5SYMt99sJUQ6ZmjPnukJ");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            GeneralEfficientOCRRequest req = new GeneralEfficientOCRRequest();
//            req.setImageUrl("https://i.328888.xyz/2023/01/28/jDcwN.png");
            req.setImageBase64(base64);
            // 返回的resp是一个GeneralEfficientOCRResponse的实例，与请求对象对应
            GeneralEfficientOCRResponse resp = client.GeneralEfficientOCR(req);
            // 输出json格式的字符串回包
            JSONArray textDetections = JSONObject.parseObject(GeneralAccurateOCRResponse.toJsonString(resp)).getJSONArray("TextDetections");
            return textDetections.toJavaList(OcrPojo.class);

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return new ArrayList<>();

    }


}

