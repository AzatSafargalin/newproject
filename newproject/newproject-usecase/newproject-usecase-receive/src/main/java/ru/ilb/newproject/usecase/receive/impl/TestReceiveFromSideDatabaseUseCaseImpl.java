package ru.ilb.newproject.usecase.receive.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.ws.rs.WebApplicationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.ilb.newproject.model.dto.test.ReceiveFromSideDatabaseDto;
import ru.ilb.newproject.usecase.receive.TestReceiveFromSideDatabaseUseCase;
import ru.ilb.newproject.usecase.receive.mappers.TestReveiveFromSideDatabaseMapper;
import ru.ilb.newproject.utils.ExceptionUtils;

@Named
public class TestReceiveFromSideDatabaseUseCaseImpl implements TestReceiveFromSideDatabaseUseCase{

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestReceiveFromSideDatabaseUseCase.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String getBusinessEntitiesSql;

    @Resource(mappedName = "jdbc/.apps.newproject/.apps.test.db.ro")
    public void setJT(DataSource datasource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
    }

    @Override
    public ReceiveFromSideDatabaseDto receiveFromSideDatabase(final Long id) {
        if (id == null) {
            throw new WebApplicationException("Id is null");
        }
        Map params = new HashMap();
        params.put("id", id);
        List<ReceiveFromSideDatabaseDto> dtos;
        try {

            dtos = namedParameterJdbcTemplate.query(getBusinessEntitiesSql, params, new TestReveiveFromSideDatabaseMapper());
        } catch (Exception ex) {
            Logger.getLogger(TestReceiveFromSideDatabaseUseCase.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            logger.error("Ошибка получения testDto из сторонней базы. Id={}, message=\n{}", id, ExceptionUtils.getMessage(ex));
            throw new WebApplicationException("Ошибка получения testDto из сторонней базы. Id=" + id, 550);
        }
        return dtos.get(0);
    }

    @Value("classpath:sql/testReceiveFromSideDatabase.sql")
    private void setBusinessEntityReceiveListSql(org.springframework.core.io.Resource resource) throws IOException {
        Scanner s = new Scanner(resource.getInputStream()).useDelimiter("\\A");
        this.getBusinessEntitiesSql = s.hasNext() ? s.next() : "";
    }

}
