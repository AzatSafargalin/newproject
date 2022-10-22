package ru.ilb.newproject.usecase.receive.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import org.springframework.jdbc.core.RowMapper;
import ru.ilb.newproject.model.dto.test.ReceiveFromSideDatabaseDto;

/**
 *
 * @author AndrewSych
 */
@Named
public class TestReveiveFromSideDatabaseMapper implements RowMapper<ru.ilb.newproject.model.dto.test.ReceiveFromSideDatabaseDto> {

    @Override
    public ReceiveFromSideDatabaseDto mapRow(ResultSet rs, int i) throws SQLException {
        ReceiveFromSideDatabaseDto dto = new ReceiveFromSideDatabaseDto();
        Long id = rs.getLong("ID");
        String username = rs.getString("USERNAME");
        
        return dto
                .withId(id)
                .withUsername(username);
    }

}
