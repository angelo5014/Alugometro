package br.com.alugometro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.alugometro.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
@WebAppConfiguration
public class AbstractInfrastructureTest {

	@Test
	public void testeObrigatorio() {
	}
	
}
