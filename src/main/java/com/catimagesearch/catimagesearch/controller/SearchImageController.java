package com.catimagesearch.catimagesearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.catimagesearch.catimagesearch.implementation.ImageUrl;

@RestController
public class SearchImageController {

    @Autowired
    private ImageUrl imageUrl;

    @RequestMapping(value="/imageurl",method = RequestMethod.GET)
    public String search(@RequestParam("apikey") String apikey,@RequestParam("breed_name")String breed_name){
        if(apikey.length()==0 || breed_name.length()==0 || apikey.equals(" ") ||
           breed_name.equals(" ")){
            return "apikey or breed_name is empty";
        }
        return imageUrl.getImageUrl(apikey,breed_name);
    }
}
