package mx.com.examen.clip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clip")
public class TransactionController {

	@GetMapping("/info")
	public String hello() {
		return "Examen Clip -  23 Junio 2021" + "Autor: César Ricardo Alducin Ruiz";
	}

}
