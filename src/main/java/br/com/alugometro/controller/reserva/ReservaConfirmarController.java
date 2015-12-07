package br.com.alugometro.controller.reserva;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.exception.AbstractException;
import br.com.alugometro.service.CalendarioService;
import br.com.alugometro.service.ReservaService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/reserva")
public class ReservaConfirmarController extends AbstractReservaController{
	
	private UsuarioService ususarioService;
	
	@Autowired
	public ReservaConfirmarController(ReservaService reservaService, UsuarioService ususarioService){
		super(reservaService);
		this.ususarioService = ususarioService;
	}
	
	@RequestMapping(path = "/confirmar/{idAnuncio}", method = RequestMethod.GET)
	public ModelAndView viewConfirmar(@PathVariable("idAnuncio") Long idAnuncio,
										RedirectAttributes redirectAttributes,
										@RequestParam(value="dataInicio", required=false) String strDataInicio,
										@RequestParam(value="dataFim", required=false) String strDataFim){
		
		Date dataInicio = new Date();
		Date dataFim = new Date();
		String[] datas = new String[2];
		
		try {
			dataInicio = CalendarioService.converterStringParaDate(strDataInicio);
			dataFim = CalendarioService.converterStringParaDate(strDataFim);
			datas = CalendarioService.verificarDatas(dataInicio, dataFim);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		ReservaConfirmacaoDTO confirmacaoDTO = this.reservaService.confirmacaoReserva(idAnuncio);
		confirmacaoDTO.setDataInicio(datas[0]);
		confirmacaoDTO.setDataFim(datas[1]);
		
		this.reservaService.calcularTotalReserva(confirmacaoDTO);
		
		try {
			Long idUsuarioLogado = this.ususarioService.obterIdDoUsuarioLogado();
			confirmacaoDTO.setIdUsuarioLocando(idUsuarioLogado);
		} catch (AbstractException e) {
			redirectAttributes.addFlashAttribute("mensagem", e.getMensagem());
		}
		
		return new ModelAndView("reserva/confirmar", "reservaConfirmacao", confirmacaoDTO);
	}
	
	@RequestMapping(path = "/confirmar", method = RequestMethod.POST)
	public ModelAndView confirmarReserva(@ModelAttribute("reservaConfirmacao") ReservaDTO reservaDto,
											RedirectAttributes redirectAttributes){
		
		this.reservaService.salvar(reservaDto);
		
		redirectAttributes.addFlashAttribute("mensagem", "Reserva efetuada com sucesso!");
		
		return new ModelAndView("redirect:/");
	}
	
	@ResponseBody
	@RequestMapping(path = "/calculartotal", method = RequestMethod.GET)
	public BigDecimal teste(@RequestParam(value="dataInicio", required = true) String dataInicio,
													@RequestParam(value = "dataFim", required = true) String dataFim,
														@RequestParam(value = "diaria", required = true) BigDecimal diaria){
			
		ReservaConfirmacaoDTO confirmacaoDTO = new ReservaConfirmacaoDTO();
		confirmacaoDTO.setDataInicio(dataInicio);
		confirmacaoDTO.setDataFim(dataFim);
		confirmacaoDTO.setDiaria(diaria);
		
		this.reservaService.calcularTotalReserva(confirmacaoDTO);
			
		return confirmacaoDTO.getTotal();
	}
}
