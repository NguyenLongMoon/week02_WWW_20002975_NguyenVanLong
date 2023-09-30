package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.configs;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.backend.db.Connection;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    public ApplicationConfig() {
        Connection.getInstance().getEntityManager();
    }
}
