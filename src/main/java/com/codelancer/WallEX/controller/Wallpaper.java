package com.codelancer.WallEX.controller;

import com.codelancer.WallEX.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallpaper")
public class Wallpaper {

    @Autowired
    WallpaperService wallpaperService;

    @GetMapping("get/all")
    public List<com.codelancer.WallEX.model.Wallpaper> getAllWall(){
        return wallpaperService.getAllWall();
    }

    @GetMapping("get/{ID}")
    public com.codelancer.WallEX.model.Wallpaper getWall(@PathVariable("ID") String id){
        return wallpaperService.getWall(id);
    }

    @GetMapping("get/cate/{category}")
    public List<com.codelancer.WallEX.model.Wallpaper> getWallByCate(@PathVariable("category") String cate){
        return wallpaperService.getWallByCate(cate);
    }

}
