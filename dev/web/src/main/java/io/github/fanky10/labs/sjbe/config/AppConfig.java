package io.github.fanky10.labs.sjbe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties specific to AppConfig component.
 *
 * <p>
 *     Properties are configured in the application.yml file.
 * </p>
 */
@Component
@ConfigurationProperties(prefix="app-config")
public class AppConfig {
	
	private Boolean isDev;

	public Boolean getIsDev() {
		return isDev;
	}

	public void setIsDev(Boolean isDev) {
		this.isDev = isDev;
	}
}
