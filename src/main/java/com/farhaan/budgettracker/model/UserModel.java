package com.farhaan.budgettracker.model;

import com.farhaan.budgettracker.config.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserModel {

    private String Username;

    private String name;

    private String email;

    private String password;

    private Role role;
}
