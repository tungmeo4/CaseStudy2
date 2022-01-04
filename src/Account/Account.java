package Account;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName;
    private String passWord;

    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
