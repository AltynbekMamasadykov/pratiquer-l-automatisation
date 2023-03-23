package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_RECEIVER_USER_EMAIL = "testdata.receiver.user.email";
    public static final String TESTDATA_RECEIVER_USER_PASSWORD = "testdata.receiver.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withReceiverCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_RECEIVER_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_RECEIVER_USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }

}
