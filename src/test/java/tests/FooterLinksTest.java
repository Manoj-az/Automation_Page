package tests;

import org.testng.annotations.Test;

import pageObjects.FooterLinksPageObjects;

public class FooterLinksTest {

    FooterLinksPageObjects footerPage = new FooterLinksPageObjects();

    @Test(priority = 0)
    public void verifyHomeLink() {
        footerPage.clickHome();
    }

    @Test(priority = 1)
    public void verifyHiddenAndAjaxElements() throws InterruptedException {
        footerPage.handleHiddenAndAjaxElements();
    }

    @Test(priority = 2)
    public void verifyFileDownloads() throws InterruptedException {
        footerPage.downloadFiles();
    }
}

