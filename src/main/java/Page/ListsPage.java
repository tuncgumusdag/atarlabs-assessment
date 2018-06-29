package Page;

import Base.Base;
import org.openqa.selenium.WebDriver;

public class ListsPage extends Base {

    protected String elementAccountAndLists = "#nav-link-accountList";
    protected String elementCreateList = "#nav-al-wishlist>a:nth-of-type(1)";
    protected String buttonCreateAList = "#createList-announce";
    protected String elementPublic = "#WLNEW_privacy_public .a-declarative";
    protected String textboxListName = "#WLNEW_list_name";
    protected String dataListName = genericText;
    protected String buttonCreateList = ".a-form-actions .a-button-primary";
    protected String elementListName = "#profile-list-name";
    protected String elementAddIdeaToList = "#wfaFormHeader .a-link-normal";
    protected String textboxIdea = "#wfaTextInput";
    protected String dataIdea1 = "Amazon Kindle";
    protected String dataIdea2 = "iPhone 8";
    protected String buttonAddIdea = "#wfa-note-add-button-wrapper-announce";
    protected String elementIdea1 = ".g-item-details .aok-break-word";
    protected String elementIdeaNew = ".g-item-sortable:nth-of-type(2)";
    protected String buttonMove = ".g-item-sortable:nth-of-type(1) .a-span6 .g-move-button";
    protected String buttonWishList = ".g-move-option:nth-of-type(2)";
    protected String elementWishListLink = "#itemMovedTo_null";
    protected String buttonDelete = ".g-item-sortable:nth-of-type(1) .g-visible-js .a-span6:nth-of-type(2)";
    protected String elementDeleteAlert = ".a-alert-inline-success .a-alert-content";
    protected String dataDeleteAlert = "Deleted";
    protected String elementShoppingList = "#your-lists-nav li:nth-of-type(1) .a-fixed-right-grid-inner";

    public ListsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateList() {
        onHover(elementAccountAndLists);
        click(elementCreateList);
        //Click Create a list (it is under Account & Lists tab)
    }

    public void createPublicShoppingList() {
        click(buttonCreateAList);
        click(elementPublic);
        fillTextBox(textboxListName, dataListName);
        click(buttonCreateList);
        //Create a public shopping list
    }

    public void shoppingListAssertion() {
        assertAreEquals(elementListName, dataListName);
        //Assert shopping list is created successfully
    }

    public void addIdea() {
        click(elementAddIdeaToList);
        fillTextBox(textboxIdea, dataIdea1);
        click(buttonAddIdea);
        //Add an idea into the shopping list (i.e Amazon Kindle)
    }

    public void ideaAssertion() {
        assertAreEquals(elementIdea1, dataIdea1);
        //Assert added idea is in list
    }

    public void addSecondIdea() {
        fillTextBox(textboxIdea, dataIdea2);
        click(buttonAddIdea);
        //Add one more idea to the shopping list (i.e iPhone 8)
    }

    public void moveIdeaToWishList() {
        waitUntilElementLoad(elementIdeaNew);
        click(buttonMove);
        click(buttonWishList);
        //Move this idea to Wish List
    }

    public void moveIdeaAssertion() {
        click(elementWishListLink);
        assertAreEquals(elementIdea1, dataIdea2);
        //Assert this idea is moved to wish list successfully
    }

    public void deleteIdeaFromWishList() {
        click(buttonDelete);
        //Delete added idea from wish list
    }

    public void ideaDeleteAssertion() {
        assertIsInclude(elementDeleteAlert, dataDeleteAlert);
        //Assert idea is deleted from wish list successfully
    }

    public void returnShoppingList() {
        click(elementShoppingList);
        //Return shopping list
    }
}
