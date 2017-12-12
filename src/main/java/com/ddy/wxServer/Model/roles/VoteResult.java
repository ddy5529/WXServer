package com.ddy.wxServer.Model.roles;

import java.util.Date;

public class VoteResult {
    private int vote_id;
    private String psn_code;
    private String project_code;
    private String psn_project_name;
    private int vote_person_id;
    private Date vote_date;
    private Date updata_date;

    public VoteResult() {
    }

    public VoteResult(String psn_code, String psn_project_name, int vote_person_id) {
        this.psn_code = psn_code;
        this.psn_project_name = psn_project_name;
        this.vote_person_id = vote_person_id;
    }

    public VoteResult(String psn_code, String psn_project_name, int vote_person_id, Date vote_date, Date updata_date) {
        this.psn_code = psn_code;
        this.psn_project_name = psn_project_name;
        this.vote_person_id = vote_person_id;
        this.vote_date = vote_date;
        this.updata_date = updata_date;
    }

    public String getProject_code() {
        return project_code;
    }

    public void setProject_code(String project_code) {
        this.project_code = project_code;
    }

    public int getVote_id() {
        return vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public String getPsn_code() {
        return psn_code;
    }

    public void setPsn_code(String psn_code) {
        this.psn_code = psn_code;
    }

    public String getPsn_project_name() {
        return psn_project_name;
    }

    public void setPsn_project_name(String psn_project_name) {
        this.psn_project_name = psn_project_name;
    }

    public int getVote_person_id() {
        return vote_person_id;
    }

    public void setVote_person_id(int vote_person_id) {
        this.vote_person_id = vote_person_id;
    }

    public Date getVote_date() {
        return vote_date;
    }

    public void setVote_date(Date vote_date) {
        this.vote_date = vote_date;
    }

    public Date getUpdata_date() {
        return updata_date;
    }

    public void setUpdata_date(Date updata_date) {
        this.updata_date = updata_date;
    }
}
