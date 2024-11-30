package org.example.usergenerator;


import utils.Randomizer;

public class User {
        private String email;
        private String password;
        private String name;


        public User(String email, String password, String name ){
            this.email=email;
            this.password = password;
            this.name = name;
        }
        public User(){};

        public static User randomUser() {
            return new User(
                    Randomizer.randomEmail(),
                    Randomizer.randomString(),
                    Randomizer.randomString());
        }



        public String getEmail() {

            return email;
        }

        public void setEmail(String email) {

            this.email = email;
        }

        public String getPassword() {

            return password;
        }

        public void setPassword(String password) {

            this.password = password;
        }

        public String getName() {
            return name;}

        public void setName(String name) {

            this.name = name;
        }


    }

