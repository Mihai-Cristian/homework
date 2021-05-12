package com.homework.application;

import org.junit.Assert;
import org.junit.Test;

public class UserTests {

    @Test
    public void createUserTest() {
        User myUser = new User("name", "lastName", 32);

        Assert.assertEquals(myUser.getName(), "name");
        Assert.assertEquals(myUser.getLastName(), "lastName");
        Assert.assertEquals(myUser.getAge(), 32);
    }

    @Test
    public void createEmptyUserTest() {
        User myUser = new User();

        Assert.assertNull(myUser.getName());
        Assert.assertNull(myUser.getLastName());
        Assert.assertEquals(myUser.getAge(), 0);
    }

    @Test
    public void retrieveUserInformationForFirstUsernameTest() {
        User myUser = new User();
        myUser.setUsername("Mishu");

        User myUserInfo = User.getSpecificUserByUsername();
        assert myUserInfo != null;
        Assert.assertEquals(myUserInfo.getName(), "Mihai");
        Assert.assertEquals(myUserInfo.getLastName(), "Toncu");
        Assert.assertEquals(myUserInfo.getAge(), 32);
    }

    @Test
    public void retrieveUserInformationForSecondUsernameTest() {
        User myUser = new User();
        myUser.setUsername("Cristian");

        User myUserInfo = User.getSpecificUserByUsername();
        assert myUserInfo != null;
        Assert.assertEquals(myUserInfo.getName(), "Cristian");
        Assert.assertEquals(myUserInfo.getLastName(), "Popescu");
        Assert.assertEquals(myUserInfo.getAge(), 25);
    }

    @Test
    public void retrieveUserInformationForNonExistentUsernameTest() {
        User myUser = new User();
        myUser.setUsername("Non-Existing");

        User myUserInfo = User.getSpecificUserByUsername();
        Assert.assertNull(myUserInfo);
    }
}