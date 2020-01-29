package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

   /* public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
    }
    public TimeEntry(long id, long projectId, long userId, LocalDate parse, int i) {
    }*/

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }


    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        if (getId() != timeEntry.getId()) return false;
        if (getProjectId() != timeEntry.getProjectId()) return false;
        if (getUserId() != timeEntry.getUserId()) return false;
        if (getHours() != timeEntry.getHours()) return false;
        return getDate().equals(timeEntry.getDate());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (int) (getProjectId() ^ (getProjectId() >>> 32));
        result = 31 * result + (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getHours();
        return result;
    }

    public long getId() {
        return this.id;
    }
}