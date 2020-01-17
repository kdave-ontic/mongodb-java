package user;

import repository.Mongo;

/**
 * User Detail Class
 */
@Mongo
public class User {

    // Mandatory Field
    private String id;

    // Optional Field
    private String name;
    private String country;
    private String state;
    private String city;

    public User() {

    }

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    /**
     * Builder Class of User
     */
    public static class UserBuilder {
        private String name;
        private String id;

        private String country = "India";
        private String state = "Gujarat";
        private String city;

        public UserBuilder() {

        }
        public UserBuilder(String id) {
            this.id = id;
        }

        /**
         *
         * @param country country of user
         * @return returns (@code UserBuilder Object)
         */
        public UserBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         *
         * @param state state of user
         * @return returns (@code UserBuilder Object)
         */
        public UserBuilder setState(String state) {
            this.state = state;
            return this;
        }

        /**
         *
         * @param city city of user
         * @return returns (@code UserBuilder Object)
         */
        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        /**
         *
         * @param name name of user
         * @return returns (@Code UserBuilder Object)
         */
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
