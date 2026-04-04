package br.com.pi3.chat.model;

public enum Role {

    Admin("Admin"),
    User("User"),
    ;

    private String role;
    Role(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
