package com.jogos.lista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jogos.lista.entity.Game;
import com.jogos.lista.service.GameService;

@Controller
public class IndexController {

	@Autowired
	GameService gameService;

	@GetMapping("/lista")
	public ModelAndView getList() {
		List<Game> gameList = this.gameService.findAll();

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("gameList", gameList);
		return mv;
	}
}
