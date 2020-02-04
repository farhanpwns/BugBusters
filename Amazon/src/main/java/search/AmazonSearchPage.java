package search;

import base.CommonAPI;
import datasuply.DataSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmazonSearchPage extends CommonAPI {

    @FindBy(how = How.CSS, using = "#twotabsearchtextbox")
    public static WebElement searchInputWebElement;

    @FindBy(how = How.CSS, using = ".nav-input")
    public static WebElement submitWebElement;

    @FindBy(how = How.ID, using = "searchDropdownBox")
    public static WebElement allDropDownWebElement;

    public static WebElement getSearchInputWebElement() {
        return searchInputWebElement;
    }

    public static WebElement getSubmitWebElement() {
        return submitWebElement;
    }

    public static WebElement getAllDropDownWebElement() {
        return allDropDownWebElement;
    }

    public void clearInputBox() {
        getSearchInputWebElement().clear();
    }

    public void typeItemName(String value) {
        getSearchInputWebElement().sendKeys(value);
    }

    public void clickOnSearch() {
        getSubmitWebElement().click();
    }

    public void clearTypeAndClickOnSearch() {
        List<String> list = getItems();
        for (int i = 0; i < list.size(); i++) {
            clearInputBox();
            typeItemName(list.get(i));
            clickOnSearch();
        }
    }

    public void searchItemsAndSubmitButton() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = DataSource.getItemsListFromDB();
        for (int i = 0; i < list.size(); i++) {
            typeItemName(list.get(i));
            clickOnSearch();
            clearInputBox();
        }
    }

    public List<String> getItems() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        List<String> itemsList = new ArrayList<>();
        itemsList.add("watch");
        itemsList.add("Rage Against The Machine");

        return itemsList;
    }

    public List<String> searchItemsHardcoded() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        List<String> itemsList = new ArrayList<>();
        itemsList.add("watch");
        itemsList.add("Rage Against The Machine");

        return itemsList;
    }

    public void doProductSearch() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        typeItemName("iPhone");
        clickOnSearch();
    }

}
