package org.molgenis.selenium.model.dataexplorer.data;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.molgenis.selenium.model.AbstractModel;
import org.molgenis.selenium.model.forms.FormsModalModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataModel extends AbstractModel
{
	private static final Logger LOG = LoggerFactory.getLogger(DataModel.class);

	@FindBy(css = "#data-table-container button[title='Add row']")
	private WebElement addRowButton;
	
	@FindBy(css="#data-table-container button[title='Edit row']")
	private List<WebElement> editRowButton;

	@FindBy(css = "div.alerts")
	private WebElement alertsContainer;

	public DataModel(WebDriver driver)
	{
		super(driver);
	}

	public FormsModalModel clickOnAddRowButton()
	{
		LOG.info("clicked on add row button for entity TypeTest");
		this.addRowButton.click();
		spinner().waitTillDone(10, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, FormsModalModel.class);
	}
	
	public FormsModalModel clickOnEditFirstRowButton()
	{
		LOG.info("clicked on edit first row button for entity TypeTest");
		this.editRowButton.get(0).click();
		spinner().waitTillDone(10, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, FormsModalModel.class);
	}

	/**
	 * @return the alertsContainer
	 */
	public WebElement getAlertsContainer()
	{
		return this.alertsContainer;
	}
}
