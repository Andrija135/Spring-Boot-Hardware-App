package hr.tvz.poljak.hardwareapp.hardware.repository;

import hr.tvz.poljak.hardwareapp.hardware.model.Hardware;
import hr.tvz.poljak.hardwareapp.hardware.model.HardwareType;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static final String SELECT_ALL = "SELECT id, name, code, price, type, stock FROM hardware ";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public HardwareRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Hardware> findAll() {
        List<Hardware> hardware = new ArrayList<>();
        try {
            hardware = jdbc.query(SELECT_ALL, this::mapRowToHardware);
            return hardware;
        } catch (EmptyResultDataAccessException ex) {
            return hardware;
        }
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        try {
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE code = ?", this::mapRowToHardware, code)
            );
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> save(Hardware newHardware) {
        try {
            newHardware.setId(saveHardwareDetails(newHardware));
            return Optional.of(newHardware);
        } catch (DuplicateKeyException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> update(String code, Hardware updatedHardware) {
        String sql = "UPDATE hardware SET " +
                "name = ?, " +
                "code = ?, " +
                "price = ?, " +
                "type = ?, " +
                "stock = ? " +
                "WHERE code = ?";

        int executed = jdbc.update(sql,
                updatedHardware.getName(),
                updatedHardware.getCode(),
                updatedHardware.getPrice(),
                updatedHardware.getType().toString(),
                updatedHardware.getStock(),
                code
        );

        if (executed > 0) {
            return Optional.of(updatedHardware);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        String sql = "DELETE FROM hardware WHERE code = ?";
        jdbc.update(sql,code);
    }

    private long saveHardwareDetails(Hardware hardware) {
        Map<String, Object> values = new HashMap<>();

        values.put("name", hardware.getName());
        values.put("code", hardware.getCode());
        values.put("price", hardware.getPrice());
        values.put("type", hardware.getType().toString());
        values.put("stock", hardware.getStock());

        return inserter.executeAndReturnKey(values).longValue();
    }

    private Hardware mapRowToHardware(ResultSet rs, int rowNum) throws SQLException {
        return new Hardware(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getBigDecimal("price"),
                HardwareType.valueOf(rs.getString("type")),
                rs.getInt("stock")
        );
    }
}
