package com.example.demo.Service;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Bean.RequestWrapper;

import org.springframework.http.MediaType;

@Service
public class FundService {
    @Autowired
    private RestTemplate restTemplate;
    public String getFundNavChart() {
        
        String url = "https://www.cathaybk.com.tw/cathaybk/service/newwealth/fund/chartservice.asmx/GetFundNavChart";

        // 設置請求頭
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        RequestWrapper.Req req = new RequestWrapper.Req(
                Collections.singletonList("10480016"), 
                "2023/03/10", 
                "2024/03/10"
        );

        RequestWrapper requestWrapper = new RequestWrapper(req);
        HttpEntity<RequestWrapper> request = new HttpEntity<>(requestWrapper,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }
}
