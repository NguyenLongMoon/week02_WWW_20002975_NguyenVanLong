package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {
    ACTIVE(1), INACTIVE(0), DISCONTINUED(-1);

    private final int status;

    private ProductStatus(int status) {
        this.status = status;
    }

    @JsonValue
    public int getStatus() {
        return status;
    }
}
