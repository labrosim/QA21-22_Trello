package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoard extends HelperBase{
    public HelperBoard(WebDriver driver) {
        super(driver);
    }
    By buttonCreateNewBoard = By.xpath("//span[text()='Create new board']");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
    By buttonCreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");
    By textBoardTitle = By.xpath("//h1[@data-testid='board-name-display']");
    By buttonBoards = By.xpath("//a[@data-testid='open-boards-link']");
    public void createNewBoard(String boardTitle) {
        clickBase(buttonCreateNewBoard);
        typeBase(inputBoardTitle, boardTitle);
        clickBase(buttonCreateBoard);
    }
    public boolean isBoardTitlePresents(String text){
        return isTextElementEquals(textBoardTitle,text);
    }

    public void clickButtonBoards(){
        clickBase(buttonBoards);
    }

    public void deleteBoard(String boardTitle) {
        pause(5);
        clickBoardsOnTitle(boardTitle);
    }

    private void clickBoardsOnTitle(String boardTitle) {
        driver.navigate().refresh();
      //  String xPathBoardTitle = "//a[@href='/b/hsnwZRdF/"+boardTitle.toLowerCase()+"']";
        String xPathBoardTitle = "//div[@title='"+boardTitle+"']";
        System.out.println(xPathBoardTitle);
        clickBase(By.xpath(xPathBoardTitle));
    }
}
