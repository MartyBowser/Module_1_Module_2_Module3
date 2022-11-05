package com.techelevator.tenmo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class Report {

    private int reportId;
    private String location;
    private String language;
    private int numberOfEyewitnesses;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate reportDate;

    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime reportTime;
    private int moonPhaseId;
    private String weather;
    private String description;
    private boolean involvedAlcohol;
    private boolean recurring;
    private int encounterTypeId;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfEyewitnesses() {
        return numberOfEyewitnesses;
    }

    public void setNumberOfEyewitnesses(int numberOfEyewitnesses) {
        this.numberOfEyewitnesses = numberOfEyewitnesses;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public LocalTime getReportTime() {
        return reportTime;
    }

    public void setReportTime(LocalTime reportTime) {
        this.reportTime = reportTime;
    }

    public int getMoonPhaseId() {
        return moonPhaseId;
    }

    public void setMoonPhaseId(int moonPhaseId) {
        this.moonPhaseId = moonPhaseId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInvolvedAlcohol() {
        return involvedAlcohol;
    }

    public void setInvolvedAlcohol(boolean involvedAlcohol) {
        this.involvedAlcohol = involvedAlcohol;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public int getEncounterTypeId() {
        return encounterTypeId;
    }

    public void setEncounterTypeId(int encounterTypeId) {
        this.encounterTypeId = encounterTypeId;
    }
}
