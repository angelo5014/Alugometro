package br.com.alugometro.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alugometro.dao.AnuncioDAO;
import br.com.alugometro.dao.ReservaDAO;
import br.com.alugometro.domain.Anuncio;
import br.com.alugometro.domain.Reserva;
import br.com.alugometro.domain.Reserva.SituacaoReserva;
import br.com.alugometro.dto.ReservaConfirmacaoDTO;
import br.com.alugometro.dto.ReservaDTO;
import br.com.alugometro.mapper.ReservaMapper;

@Service
public class ReservaService {

	private ReservaDAO reservaDAO;
	private AnuncioDAO anuncioDAO;

	@Autowired
	public ReservaService(ReservaDAO reservaDao, AnuncioDAO anuncioDAO) {
		this.reservaDAO = reservaDao;
		this.anuncioDAO = anuncioDAO;
	}

	public ReservaDTO buscarPorId(Long idReserva) {
		return ReservaMapper.paraDTO(this.reservaDAO.buscarPorId(idReserva));
	}

	public List<ReservaDTO> buscarPorUsuario(Long idUsuario) {
		return ReservaMapper.paraListaDTO(this.reservaDAO.buscarPorIdUsuario(idUsuario));
	}
	
	public List<ReservaDTO> buscarPorEmailUsuario(String email) {
		
		return ReservaMapper.paraListaDTO(this.reservaDAO.buscarPorEmailUsuario(email));
	}

	public List<ReservaDTO> buscarPorDataESituacao(String dataInicio, String dataFim, SituacaoReserva situacaoReserva) {

		List<Reserva> reservas = reservaDAO.listarPorDataESituacao(dataInicio, dataFim, situacaoReserva);

		List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();
		for (Reserva reserva : reservas) {
			reservasDTO.add(ReservaMapper.paraDTO(reserva));
		}

		return reservasDTO;
	}

	public ReservaDTO salvar(ReservaDTO dto) {
		if (dto.getIdReserva() == null) {
			dto.setSituacao("PENDENTE");
		}

		Reserva entidade = ReservaMapper.paraEntidade(dto);

		return ReservaMapper.paraDTO(this.reservaDAO.salvar(entidade));
	}

	public ReservaConfirmacaoDTO obterDadosParaConfirmacao(Long idAnuncio) {
		Anuncio anuncio = this.anuncioDAO.buscarPorId(idAnuncio);

		StringBuilder nomeLocatario = new StringBuilder();
		nomeLocatario.append(anuncio.getUsuario().getNome());
		nomeLocatario.append(" ");
		nomeLocatario.append(anuncio.getUsuario().getSobrenome());

		String local = anuncio.getCidade().getNome();

		String dataInicio = CalendarioService.converterDateParaString(anuncio.getDataInicio());
		String dataFim = CalendarioService.converterDateParaString(anuncio.getDataFim());

		StringBuilder periodo = new StringBuilder();
		periodo.append(dataInicio);
		periodo.append(" à ");
		periodo.append(dataFim);

		BigDecimal diaria = anuncio.getDiaria();

		ReservaConfirmacaoDTO reservaConfirmacao = new ReservaConfirmacaoDTO();
		reservaConfirmacao.setIdAnuncio(anuncio.getIdAnuncio());
		reservaConfirmacao.setNomeLocador(nomeLocatario.toString());
		reservaConfirmacao.setLocal(local);
		reservaConfirmacao.setPeriodoDisponivel(periodo.toString());
		reservaConfirmacao.setDiaria(diaria);
		
		reservaConfirmacao.setPeriodoDisponivelInicio(anuncio.getDataInicio());
		reservaConfirmacao.setPeriodoDisponivelFim(anuncio.getDataFim());

		return reservaConfirmacao;
	}

	public void calcularTotalReserva(ReservaConfirmacaoDTO confirmacaoDTO) {
		Date dataInicio = new Date();
		;
		try {
			dataInicio = CalendarioService.converterStringParaDate(confirmacaoDTO.getDataInicio());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dataFim = new Date();
		;
		try {
			dataFim = CalendarioService.converterStringParaDate(confirmacaoDTO.getDataFim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Long dias = CalendarioService.obterDiasDeDiferenca(dataInicio, dataFim);
		BigDecimal diaria = confirmacaoDTO.getDiaria();

		confirmacaoDTO.setTotal(diaria.multiply(new BigDecimal(dias)));
	}

	public void verificarPeriodoDisponivel(ReservaConfirmacaoDTO reservaConfirmacaoDTO) {
		Anuncio anuncio = this.anuncioDAO.buscarPorId(reservaConfirmacaoDTO.getIdAnuncio());

		Date dataInicio = new Date();
		Date dataFim = new Date();

		try {
			dataInicio = CalendarioService.converterStringParaDate(reservaConfirmacaoDTO.getDataInicio());
			dataFim = CalendarioService.converterStringParaDate(reservaConfirmacaoDTO.getDataFim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dataInicio.compareTo(anuncio.getDataInicio()) < 0) {
			dataInicio = anuncio.getDataInicio();
		}
		if (dataFim.compareTo(anuncio.getDataFim()) > 0) {
			dataFim = anuncio.getDataFim();
		}

		reservaConfirmacaoDTO.setDataInicio(CalendarioService.converterDateParaString(dataInicio));
		reservaConfirmacaoDTO.setDataFim(CalendarioService.converterDateParaString(dataFim));
	}

	public void cancelarReserva(Long idReserva) {
		reservaDAO.cancelar(idReserva);
	}

	public List<SituacaoReserva> listarSituacoes() {
		List<SituacaoReserva> situacoes = new ArrayList<SituacaoReserva>();
		situacoes.add(SituacaoReserva.PROCESSANDO);
		situacoes.add(SituacaoReserva.PENDENTE);
		situacoes.add(SituacaoReserva.ENCERRADA);
		situacoes.add(SituacaoReserva.CANCELADA);
		return situacoes;
	}

	public boolean verificarDataConflitante(ReservaConfirmacaoDTO reservaConfirmacaoDTO) throws ParseException {
		Reserva reserva = ReservaMapper.paraEntidade(reservaConfirmacaoDTO);
		List<Reserva> reservasComADataRequisitada = reservaDAO.buscarReservaPorPeriodoESituacao(reserva);

		boolean disponivel = false;

		if (reservasComADataRequisitada.isEmpty()) {
			disponivel = true;
		}

		return disponivel;
	}

}
