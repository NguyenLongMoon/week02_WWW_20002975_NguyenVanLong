package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.models;

import java.time.LocalDateTime;

public class StatisticDate {
    private LocalDateTime dateTime;
    private int count;

    public StatisticDate() {
    }

    public StatisticDate(LocalDateTime dateTime, int count) {
        this.dateTime = dateTime;
        this.count = count;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "StatisticDate{" + "dateTime=" + dateTime + ", count=" + count + '}';
    }
}
