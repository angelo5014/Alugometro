package br.com.alugometro.dto;

public class TokenDTO {
	
	private UsuarioDTO usuario;
	private String token;
	
	public TokenDTO(){
		
	}

	public TokenDTO(UsuarioDTO usuario, String token) {
		this.usuario = usuario;
		this.token = token;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
