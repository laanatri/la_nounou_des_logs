CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE monitored_apps (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    service_name VARCHAR(50) NOT NULL,
    description TEXT,
    environment VARCHAR(10) NOT NULL,
    api_key VARCHAR(64) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at timestamptz DEFAULT CURRENT_TIMESTAMP,
    last_log_received_at timestamptz DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_service_name_environment UNIQUE (service_name, environment)
);