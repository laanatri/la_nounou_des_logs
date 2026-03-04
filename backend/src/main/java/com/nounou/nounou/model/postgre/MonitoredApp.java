package com.nounou.nounou.model.postgre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "monitored_apps", uniqueConstraints = {
    @UniqueConstraint(
            name = "uk_service_name_environment",
            columnNames = {"service_name", "environment"}
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonitoredApp {

    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(name = "service_name", nullable = false, length = 50)
    private String serviceName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "environment", nullable = false, length = 10)
    private Environment environment;

    @Column(name = "api_key", unique = true, nullable = false, length = 64)
    private String apiKey;

    @Column (name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_log_received_at", nullable = false)
    private LocalDateTime lastLogReceivedAt;

    @PrePersist
    public void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        if (this.apiKey == null) {
            this.apiKey = "nn_" + UUID.randomUUID().toString().replace("-", "");
        }
        LocalDateTime now = LocalDateTime.now();
        if (this.createdAt == null) {
            this.createdAt = now;
        }
        if (this.lastLogReceivedAt == null) {
            this.lastLogReceivedAt = now;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.lastLogReceivedAt = LocalDateTime.now();
    }

}