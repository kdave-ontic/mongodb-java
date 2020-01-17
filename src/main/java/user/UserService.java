package user;

import service.Filter;


import java.io.IOException;
import java.util.List;

public interface UserService {

    /**
     * This gets the user which satisfy the filters
     *
     * @param usrFilters query
     * @return user
     * @throws NullPointerException if email is null
     */
    User getUserDetail(List<Filter> usrFilters) throws IOException;

    /**
     * @param user user
     * @return user
     */
    User putUserDetail(User user) throws IOException;

    /**
     * @param usrFilters query
     * @return user
     * @throws NullPointerException if id is null
     */
    User updateUserDetail(String id, List<Filter> usrFilters) throws IOException;

    /**
     * @param email user's email id
     * @return user
     * @throws NullPointerException if email is null
     */
    User removeUser(String email) throws IOException;

    void clearDB();
}