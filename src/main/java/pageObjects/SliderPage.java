package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends H3TitlePage {
    private By slider=By.xpath("//input[@type='range']");
    private By range=By.id("range");
	public SliderPage(WebDriver driver) {
		super(driver);
	}
   public void moveSlider(double xMove){
	  xMove=xMove-2.5;
	  WebElement sliderElement=driver.findElement(slider);
	  int sliderWidth=sliderElement.getSize().getWidth();
	  int sliderStep=sliderWidth/10;
	  int stepNumber=(int) (xMove/0.5);
	  int xOffset=(int)(stepNumber*sliderStep);
	  Actions action =new Actions(driver);
	  action.dragAndDropBy(sliderElement, xOffset, 0).build().perform();
   }
   public void moveSliderWithKey(double xMove){
		  //xMove=xMove-2.5;
		  WebElement sliderElement=driver.findElement(slider);
		  int sliderWidth=sliderElement.getSize().getWidth();
		  int sliderStep=sliderWidth/10;
		  int stepNumber=(int) (xMove/0.5);
		  for(int i=0;i<stepNumber;i++){
			  sliderElement.sendKeys(Keys.ARROW_RIGHT);
		  }
	   }
   public String getRange(){
	   return driver.findElement(range).getText();
   }
}
