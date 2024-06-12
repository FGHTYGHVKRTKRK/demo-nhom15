package com.example.WebBanHang.repository;

import com.example.WebBanHang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
