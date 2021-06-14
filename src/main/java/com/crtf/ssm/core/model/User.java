package com.crtf.ssm.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * @author crtf
 * @version 1.0
 */
public class User {
    @Max(100)
    @Min(0)
    private Integer id;

    @NotEmpty
    @Pattern(regexp = "[\\S\\d]{4,16}")
    @Length(min = 5, max = 16)
    private String name;

    @NotEmpty
    @Pattern(regexp = "[\\S\\d]{4,16}")
    @Length(min = 5, max = 16)
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime signUp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public LocalDateTime getSignUp() {
        return signUp;
    }

    public void setSignUp(LocalDateTime signUp) {
        this.signUp = signUp;
    }
}