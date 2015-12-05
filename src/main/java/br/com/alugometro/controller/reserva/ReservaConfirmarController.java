package br.com.alugometro.controller.reserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.service.AnuncioService;
import br.com.alugometro.service.ReservaService;

@Controller
@RequestMapping("/reserva/confirmar")
public class ReservaConfirmarController extends AbstractReservaController{
	
	@Autowired
	public ReservaConfirmarController(ReservaService reservaService){
		super(reservaService);
	}
	
	@RequestMapping(path = "/{idAnuncio}", method = RequestMethod.GET)
	public ModelAndView viewConfirmar(@PathVariable("idAnuncio") Long idAnuncio){
		ReservaConfirmacaoDTO confirmacaoDTO = this.reservaService.confirmarReserva(idAnuncio);
		
		return new ModelAndView("reserva/confirmar", "reservaConfirmacao", confirmacaoDTO);
	}
}
