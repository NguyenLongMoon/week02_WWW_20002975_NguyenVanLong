package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmployeeStatus {
    WORKING(1), UN_WORKING(0), QUITTED(-1);

    private final int status;

    private EmployeeStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }
}
