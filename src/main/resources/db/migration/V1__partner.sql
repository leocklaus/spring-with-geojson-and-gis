CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;

CREATE TABLE IF NOT EXISTS tb_partner(
    id bigint NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    trading_name VARCHAR(255),
    partner_document VARCHAR(255),
    coverage_area GEOMETRY(MULTIPOLYGON, 4326) NOT NULL,
    partner_address GEOMETRY(POINT, 4326) NOT NULL
);

CREATE INDEX partner_coverage_area_idx ON tb_partner USING gist(coverage_area);