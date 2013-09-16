package ca.bsolomon.gw2.api.wvw.dao;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WvWMatch {

	@JsonProperty("wvw_match_id")
	private String matchId;
	
	@JsonProperty("red_world_id")
	private int redWorldId;
	
	@JsonProperty("green_world_id")
	private int greenWorldId;
	
	@JsonProperty("blue_world_id")
	private int blueWorldId;
	
	@JsonProperty("start_time")
	private Date startTime;
	
	@JsonProperty("end_time")
	private Date endTime;

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public int getRedWorldId() {
		return redWorldId;
	}

	public void setRedWorldId(int redWorldId) {
		this.redWorldId = redWorldId;
	}

	public int getGreenWorldId() {
		return greenWorldId;
	}

	public void setGreenWorldId(int greenWorldId) {
		this.greenWorldId = greenWorldId;
	}

	public int getBlueWorldId() {
		return blueWorldId;
	}

	public void setBlueWorldId(int blueWorldId) {
		this.blueWorldId = blueWorldId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
