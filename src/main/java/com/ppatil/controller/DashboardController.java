package com.ppatil.controller;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.ppatil.model.MultipartFileSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ppatil.model.Video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DashboardController {

    Path videoLocation = FileSystems.getDefault().getPath("myvideo.mp4");
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("videos", getVideos());
    	model.setViewName("dashboard");
    	return model;
    }

    @RequestMapping(value = "/video",method = RequestMethod.GET)
    public void getVideo(HttpServletRequest request,
                         HttpServletResponse response){
        try {
            MultipartFileSender.fromPath(videoLocation)
                    .with(request)
                    .with(response)
                    .serveResource();
        }catch (Exception e){
            logger.error(e.getLocalizedMessage());
        }
    }

	private List<Video> getVideos() {
		Video video = new Video();
		video.setTitle("Pizza pouch");
		video.setDuration("2 mins");
		video.setDesc("Mordecai and Rigby come up with a novel idea to heat Pizza pouch");
        video.setLink("/video");
		
		return Arrays.asList(video);
	}

}
