package br.com.alugometro.service;

import java.math.BigDecimal;
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
	public ReservaService(ReservaDAO reservaDao, AnuncioDAO anuncioDAO){
		this.reservaDAO = reservaDao;
		this.anuncioDAO = anuncioDAO;
	}
	
	public ReservaDTO buscarPorId(Long idReserva){
		return ReservaMapper.paraDTO(this.reservaDAO.buscarPorId(idReserva));
	}
	
	public List<ReservaDTO> buscarPorUsuario(Long idUsuario){
		return ReservaMapper.paraListaDTO(this.reservaDAO.buscarPorIdUsuario(idUsuario));
	}
	
	public ReservaDTO salvar(ReservaDTO dto){
		if(dto.getIdReserva() == null){
			dto.setSituacao(SituacaoReserva.PENDENTE);
		}
		
		Reserva entidade = ReservaMapper.paraEntidade(dto);
		
		return ReservaMapper.paraDTO(this.reservaDAO.salvar(entidade));
	}

	public ReservaConfirmacaoDTO confirmarReserva(Long idAnuncio) {
		Anuncio anuncio = this.anuncioDAO.buscarPorId(idAnuncio);
		
		StringBuilder nomeLocatario = new StringBuilder();
		nomeLocatario.append(anuncio.getUsuario().getNome());
		nomeLocatario.append(" ");
		nomeLocatario.append(anuncio.getUsuario().getSobrenome());
		
		String local = anuncio.getCidade().getNome();
		
		BigDecimal diaria = anuncio.getDiaria();
		
		ReservaConfirmacaoDTO reservaConfirmacao = new ReservaConfirmacaoDTO();
		reservaConfirmacao.setIdAnuncio(anuncio.getIdAnuncio());
		reservaConfirmacao.setNomeLocador(nomeLocatario.toString());
		reservaConfirmacao.setLocal(local);
		reservaConfirmacao.setDiaria(diaria);
		
		return reservaConfirmacao;
	}
}