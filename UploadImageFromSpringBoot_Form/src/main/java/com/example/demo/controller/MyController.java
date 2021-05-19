package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.MyModel;
import com.example.demo.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService service;
	@GetMapping("/")
	public String test() {
		return "index";
	}
	@PostMapping("/fileupload")
	public String fileUpload(@RequestParam("name")String name,@RequestParam("file")MultipartFile file) {
		try {
			byte[] image=file.getBytes();
			MyModel model=new MyModel();
			model.setImage(image);
			model.setName(name);
			int saveImage=service.saveImage(model);
			if(saveImage==1) {
				return "success";
			}
			else {
				return "error";
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}
		@GetMapping("/getDetail/{id}")
	    public String getDbDetils(@PathVariable String id, ModelMap model) {
	        try {
	            MyModel imagesObj = service.getImage(Long.parseLong(id));
	            model.addAttribute("id", imagesObj.getId());
	            model.addAttribute("name", imagesObj.getName());
	            byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getImage());
	            model.addAttribute("image", new String(encode, "UTF-8"));
	            return "imagedetails";
	        } catch (Exception e) {
	            model.addAttribute("message", "Error in getting image");
	            return "redirect:/";
	        }
		
	}

}
