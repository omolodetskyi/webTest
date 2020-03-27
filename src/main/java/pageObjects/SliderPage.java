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
    public void moveSlider(double xMove){ //xMove=2
    	xMove=xMove-2.5; //xMove=-0.5
    	WebElement sliderElement=driver.findElement(slider);
    	System.out.println("found element");
    	int sliderWidth=sliderElement.getSize().getWidth(); //sliderWidth=129
    	System.out.println(sliderWidth);
    	int sliderStep=(int)(sliderWidth/10); //sliderStep=129/10=12
    	System.out.println(sliderStep);
    	int stepNumber=(int)(xMove/0.5); //stepNumber=2/0.5=4
    	System.out.println(stepNumber);
    	int xOffset=(int)(stepNumber*sliderStep); //xOffset=4*12=48
    	System.out.println(xOffset);
    	Actions action=new Actions(driver);
    	action.dragAndDropBy(sliderElement, xOffset, 0).build().perform();
    }
    public void moveSliderWithKeyboard(double xMove){
    	xMove=xMove-2.5; //xMove=-0.5
    	WebElement sliderElement=driver.findElement(slider);
    	System.out.println("found element");
    	int sliderWidth=sliderElement.getSize().getWidth(); //sliderWidth=129
    	System.out.println(sliderWidth);
    	int sliderStep=(int)(sliderWidth/10); //sliderStep=129/10=12
    	System.out.println(sliderStep);
    	int stepNumber=Math.abs((int)(xMove/0.5)); //stepNumber=2/0.5=4
    	System.out.println(stepNumber);
    	sliderElement.click();
    	for(int i=0;i<stepNumber;i++)
    	{
    		if(xMove>0){
    		sliderElement.sendKeys(Keys.ARROW_RIGHT);
    		}
    		else {
    			sliderElement.sendKeys(Keys.ARROW_LEFT);
    		}
    		}
    	}
    public String getRange(){
    	return driver.findElement(range).getText();
    }
}
