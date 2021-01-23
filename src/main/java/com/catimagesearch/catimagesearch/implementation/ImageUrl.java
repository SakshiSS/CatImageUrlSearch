package com.catimagesearch.catimagesearch.implementation;

import com.catimagesearch.catimagesearch.dao.ApiCall;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageUrl {

    @Autowired
    private ApiCall apiCall;

    public String getImageUrl(String apikey,String breed_name){
        String response=apiCall.getFullResponse(apikey,breed_name);

        if(response.length()==0){
            return "Empty Response";
        }
        if(response.contains("not valid api_key or breed_name")){
            return response;
        }
        response=response.substring(1,response.length()-1);
        if(response.length()==0){
            return "Empty Response";
        }
        try{
            JSONObject jsonObject = new JSONObject(response);
            String imageUrl=(String)jsonObject.get("url");
            return imageUrl;
        }catch(Exception exception){
            return "Invalid Json Response";
        }


    }
}
