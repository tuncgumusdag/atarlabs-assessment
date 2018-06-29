package Tests;

import Base.Base;
import Page.ListsPage;
import org.testng.annotations.Test;

public class ListsPageTest extends Base {

    @Test
    public void listsPageTest() {
        ListsPage listsPage = new ListsPage(driver);
        listsPage.clickCreateList();
        listsPage.createPublicShoppingList();
        listsPage.shoppingListAssertion();
        listsPage.addIdea();
        listsPage.ideaAssertion();
        listsPage.addSecondIdea();
        listsPage.moveIdeaToWishList();
        listsPage.moveIdeaAssertion();
        listsPage.deleteIdeaFromWishList();
        listsPage.ideaDeleteAssertion();
        listsPage.returnShoppingList();
    }
}
