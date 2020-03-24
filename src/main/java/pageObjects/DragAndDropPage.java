package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends H3TitlePage {
   private By columnA=By.id("column-a");
   private By columnB=By.id("column-b");
	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}
	
   public void dragAndDrop(WebElement from, WebElement to){
	   /*
	 Actions action=new Actions(driver);
	 action.dragAndDrop(from, to).build().perform();
	 */
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
			                       + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
			                       + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
			                       + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
			                       + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
			                       + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
			                       + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
			                       + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
			                       + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
			                       + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
			                       + "var dropEvent = createEvent('drop');\n"
			                       + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
			                       + "var dragEndEvent = createEvent('dragend');\n"
			                       + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
			                       + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
			                       + "simulateHTML5DragAndDrop(source,destination);", from, to);
   }
 
   public WebElement getColumnA(){
	   return driver.findElement(columnA);
   }
   public WebElement getColumnB(){
	   return driver.findElement(columnB);
   }
}
