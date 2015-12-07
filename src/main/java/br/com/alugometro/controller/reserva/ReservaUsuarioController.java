package br.com.alugometro.controller.reserva;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.service.CalendarioService;
import br.com.alugometro.service.ReservaService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/reserva")
public class ReservaUsuarioController extends AbstractReservaController {

	private UsuarioService usuarioService;
	
	@Autowired
	public ReservaUsuarioController(ReservaService reservaService, UsuarioService usuarioService) {
		super(reservaService);
		this.usuarioService = usuarioService;
	}
	
	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ModelAndView listarReservasDoUsuario(@ModelAttribute("email") String email) {
		
		List<ReservaDTO> reservas = new ArrayList<>();
			reservas = reservaService.buscarPorEmailUsuario(email);
		return new ModelAndView("reserva/listar", "reservas", reservas);
	}
	
	@RequestMapping(path = "/listarReservasPorBusca", method=RequestMethod.GET)
	public ModelAndView listarReservasPorBusca (
			@RequestParam("dataInicio") String dataInicio,
			@RequestParam("dataFim") String dataFim,
			@RequestParam("situacao") Long situacaoReserva) throws ParseException {
		
		Date dataInicioDate = CalendarioService.converterStringParaDate(dataInicio);
		Date dataFimDate = CalendarioService.converterStringParaDate(dataFim);
		
		return new ModelAndView("reserva/listar", "reservas", reservaService.buscarPorDataESituacao(dataInicioDate, 
				dataFimDate, situacaoReserva));
	}
	
}
