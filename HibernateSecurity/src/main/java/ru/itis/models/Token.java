package ru.itis.models;

/**
 * 11.05.2017
 * Token
 *
 * @author Aivar Yusupov
 * @version v0.1
 */
public class Token {

    private int id;
    private User user;
    private String token;

    public Token(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.token = builder.token;
    }

    public static class Builder {

        private int id;
        private User user;
        private String token;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Token build() {
            return new Token(this);
        }
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return user + " " + token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null || obj instanceof Token) {
            if (obj == this) return true;
            Token that = (Token) obj;
            return this.id == that.id &&
                    this.user.equals(that.user) &&
                    this.token.equals(that.token);
        } return false;
    }
}
