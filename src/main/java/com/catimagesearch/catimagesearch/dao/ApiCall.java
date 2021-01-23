package com.catimagesearch.catimagesearch.dao;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Repository
public class ApiCall {

    public String getFullResponse(String apikey,String breed_name){
        String uri = "https://api.thecatapi.com/v1/images/search?api_key="+apikey+"&breed_ids="+breed_name;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            String response=responseEntity.getBody();
            return response;
        }catch(Exception exception){
            return "not valid api_key or breed_name"+exception.getMessage();
        }
    }
}
