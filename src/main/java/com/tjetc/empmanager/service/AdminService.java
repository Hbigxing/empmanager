package com.tjetc.empmanager.service;

import com.tjetc.empmanager.domain.Admin;

public interface AdminService {
    Admin login(String account,String password);
}
