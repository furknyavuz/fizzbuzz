package com.furknyavuz.fizzbuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Furkan Yavuz on 18.10.2018.
 */
@Controller
public class HomeController
{
	@GetMapping ( "/" )
	public String homePage ()
	{
		return "index";
	}
}
