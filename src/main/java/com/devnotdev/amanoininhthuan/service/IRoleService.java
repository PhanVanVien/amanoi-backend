package com.devnotdev.amanoininhthuan.service;

import com.devnotdev.amanoininhthuan.model.Role;
import com.devnotdev.amanoininhthuan.model.User;

import java.util.List;

public interface IRoleService {
    List<Role> getRoles();

    Role createRole(Role role);

    void deleteRole(Long roleId);

    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);

    User assignRoleToUser(Long userId, Long roleId);

    Role removeAllUsersFromRole(Long roleId);
}
