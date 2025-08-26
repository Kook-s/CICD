package kr.handscope.domain.user.repository;

import kr.handscope.domain.user.model.User;

public interface UserRepository {

    User findById(long id);
    User findByEmail(String email);
    User findByPassword(String password);
    Long createUser(User user);
    void updateUser(User user);
}
