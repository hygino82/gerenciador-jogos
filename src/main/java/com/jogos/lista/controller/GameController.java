package com.jogos.lista.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jogos.lista.entity.Console;
import com.jogos.lista.entity.Game;
import com.jogos.lista.service.ConsoleService;
import com.jogos.lista.service.GameService;

@Controller
public class GameController {

	@Autowired
	private ConsoleService consoleService;
	
	@Autowired
	private GameService gameService;

	@GetMapping("/game/form/add")
	public ModelAndView getFormAdd() {
		ModelAndView mv = new ModelAndView("gameform");
		List<Console> consoleList = this.consoleService.getConsoleList();
		mv.addObject("consolelist", consoleList);

		return mv;
	}
	
	@PostMapping("/game/form/save")
	public String saveGame(@Valid Game game,BindingResult result, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			redirect.addFlashAttribute("mensagem","Verifique os campos obrigatórios");
			return "redirect:/game/form/add";
		}
		
		this.gameService.save(game);
		
		return "redirect:/lista";
		
	}

}
