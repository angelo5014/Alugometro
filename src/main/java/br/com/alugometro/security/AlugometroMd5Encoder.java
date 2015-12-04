package br.com.alugometro.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public final class AlugometroMd5Encoder extends Md5PasswordEncoder{

	private final String salt = "Alohomora";
	
	@Override
	public String encodePassword(String rawPass, Object salt) {
		return super.encodePassword(rawPass, this.salt);
	}
	
	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		return super.isPasswordValid(encPass, rawPass, this.salt);
	}
}
