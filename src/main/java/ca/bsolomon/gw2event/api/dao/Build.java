package ca.bsolomon.gw2event.api.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Build {

	@JsonProperty("build_id")
	private String buildId;

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
}
