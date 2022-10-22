package ru.ilb.newproject.model.dto.test;

/**
 *
 * @author AndrewSych
 */
public class ReceiveFromSideDatabaseDto {

    private Long id;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReceiveFromSideDatabaseDto withId(Long id) {
        this.setId(id);
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ReceiveFromSideDatabaseDto withUsername(String username) {
        this.setUsername(username);
        return this;
    }
}
