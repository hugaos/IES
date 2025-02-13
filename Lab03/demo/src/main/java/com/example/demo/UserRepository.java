package com.example.demo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}