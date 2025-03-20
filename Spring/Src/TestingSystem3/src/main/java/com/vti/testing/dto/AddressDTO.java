package com.vti.testing.dto;



import java.util.List;

public class AddressDTO {
    private int id;
    private String street;
    private String city;
    private List<userDTO> users;

    public List<userDTO> getUsers() {
        return users;
    }

    public void setUsers(List<userDTO> user) {
        this.users = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public static class userDTO {
        private int id;
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        }
}