package com.example.tables_DTO;


import java.sql.Date;

public class Project {

    private int id;
    private int client_id;
    private Date startDate;
    private Date finishDate;


    public Project(int id, int client_id, Date startDate, Date finishDate) {
        this.id = id;
        this.client_id = client_id;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                        ", client_id= " + client_id +
                        ", startDate= " + startDate +
                        ", finishDate= " + finishDate;
    }
}
