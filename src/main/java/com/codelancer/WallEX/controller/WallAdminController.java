package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.model.WallModel;
import com.codelancer.WallEX.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("admin")
public class WallAdminController {

    @Autowired
    WallService wallService;

    @PostMapping("wall/{CATE}")
    public WallModel addWall(@RequestParam("file") MultipartFile file, @PathVariable("CATE") String category) throws IOException {
        System.out.println(category);
        return wallService.storeWall(file, category);
    }

    @DeleteMapping("wall/{ID}")
    public void deleteWall(@PathVariable("ID") String id){
        wallService.deleteWall(id);
    }
}