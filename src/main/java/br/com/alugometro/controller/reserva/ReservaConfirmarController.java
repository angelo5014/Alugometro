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
import br.com.alugometro.mapper.ReservaMapper;
import br.com.alugometro.service.CalendarioService;
import br.com.alugometro.service.ReservaService;
import br.com.alugometro.service.UsuarioService;

@Controller
@RequestMapping("/reserva")
public class ReservaConfirmarController extends AbstractReservaController{
	
	private UsuarioService usuarioService;
	
	@Autowired
	public ReservaConfirmarController(ReservaService reservaService, UsuarioService usuarioService){
		super(reservaService);
		this.usuarioService = usuarioService;
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
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ReservaConfirmacaoDTO reservaConfirmacaoDTO = this.reservaService.obterDadosParaConfirmacao(idAnuncio);
		reservaConfirmacaoDTO.setDataInicio(datas[0]);
		reservaConfirmacaoDTO.setDataFim(datas[1]);
		
		this.reservaService.verificarPeriodoDisponivel(reservaConfirmacaoDTO);
		this.reservaService.calcularTotalReserva(reservaConfirmacaoDTO);
		
		Long idUsuarioLogado = this.usuarioService.obterIdDoUsuarioLogado();
		reservaConfirmacaoDTO.setIdUsuarioLocando(idUsuarioLogado);
		
		return new ModelAndView("reserva/confirmar", "reservaConfirmacao", reservaConfirmacaoDTO);
	}
	
	@RequestMapping(path = "/confirmar", method = RequestMethod.POST)
	public ModelAndView confirmarReserva(@ModelAttribute("reservaConfirmacao") ReservaConfirmacaoDTO reservaConfirmacaoDTO,
											RedirectAttributes redirectAttributes){

		try {
			if(this.reservaService.verificarDataConflitante(reservaConfirmacaoDTO)){
				ReservaDTO reserva = ReservaMapper.paraDTO(reservaConfirmacaoDTO);
				this.reservaService.salvar(reserva);
				redirectAttributes.addFlashAttribute("mensagem", "Reserva efetuada com sucesso!");
			}else{
				redirectAttributes.addFlashAttribute("mensagem", "As datas selecionadas já estão reservadas!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/anuncio/"+reservaConfirmacaoDTO.getIdAnuncio());
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
	
	@ResponseBody
	@RequestMapping(path = "/verificardisponibilidade", method = RequestMethod.GET)
	public String[] verificarDisponibilidade(@RequestParam(value = "idAnuncio") Long idAnuncio,
															@RequestParam(value = "dataInicio") String dataInicio,
															@RequestParam(value = "dataFim") String dataFim){
		ReservaConfirmacaoDTO dto = new ReservaConfirmacaoDTO();
		dto.setIdAnuncio(idAnuncio);
		dto.setDataInicio(dataInicio);
		dto.setDataFim(dataFim);
		
		this.reservaService.verificarPeriodoDisponivel(dto);
		
		String[] datas = new String[2];
		datas[0] = dto.getDataInicio();
		datas[1] = dto.getDataFim();
		
		return datas;
	}
}
