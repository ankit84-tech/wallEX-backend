package com.codelancer.WallEX.controller;


import com.codelancer.WallEX.service.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("admin")
public class AdminWallpaper {

    @Autowired
    WallpaperService wallpaperService;

    @DeleteMapping("wallpaper/delete/{ID}")
    public void deleteWall(@PathVariable("ID") String id){
        wallpaperService.deleteWall(id);
    }

    @PostMapping("wallpaper/upload/{CATE}")
    public ResponseEntity<String> uploadWall(@RequestParam("wallpaper") MultipartFile[] files, @PathVariable("CATE") String category){
        try {

        if(files.length==0)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no file attached");

        if(wallpaperService.wallUploaded(files, category)){
            return ResponseEntity.ok("wallpaper uploaded");
        }

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to upload");

    }
}
