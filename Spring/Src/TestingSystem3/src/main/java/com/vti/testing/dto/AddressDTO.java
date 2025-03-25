package com.vti.testing.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AddressDTO {
    private int id;
    private String street;
    private String city;
    @JsonProperty("user")
    private List<UserDTO.UserAddressDTO> userAddress;

    public List<UserDTO.UserAddressDTO> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(List<UserDTO.UserAddressDTO> userAddress) {
        this.userAddress = userAddress;
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
        public static class UserAddressDTO{
            @JsonProperty("id")
            private int userId;
            @JsonProperty("username")
            private String userUsername;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserUsername() {
                return userUsername;
            }

            public void setUserUsername(String userUsername) {
                this.userUsername = userUsername;
            }
        }
    }
}