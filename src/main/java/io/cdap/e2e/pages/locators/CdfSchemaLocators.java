/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.e2e.pages.locators;

import io.cdap.e2e.utils.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Represents CdfSchemaLocators
 */
public class CdfSchemaLocators {
  @FindBy(how = How.XPATH,
    using = "//div[@data-cy='Output Schema']//div[@data-cy='schema-fields-list']//*[@placeholder='Field name']")
  public static List<WebElement> outputSchemaColumnNames;

  @FindBy(how = How.XPATH, using = "//div[@data-cy='Output Schema']//div[@data-cy='schema-fields-list']//select")
  public static List<WebElement> outputSchemaDataTypes;

  @FindBy(how = How.XPATH,
    using = "//div[@data-cy='Input Schema']//div[@data-cy='schema-fields-list']//*[@placeholder='Field name']")
  public static List<WebElement> inputSchemaColumnNames;

  @FindBy(how = How.XPATH, using = "//div[@data-cy='Input Schema']//div[@data-cy='schema-fields-list']//select")
  public static List<WebElement> inputSchemaDataTypes;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='get-schema-btn']//span[text()='Get Schema']")
  public static WebElement getSchemaLoadComplete;

  @FindBy(how = How.XPATH, using = "//*[@data-cy='select-schema-actions-dropdown']")
  public static WebElement schemaActions;

  public static WebElement schemaActionType(String schemaAction) {
    return SeleniumDriver.getDriver().findElement(By.xpath("//li[@data-value='" + schemaAction + "']"));
  }

  public static WebElement outputSchemaDataTypeDropdown(String fieldName) {
    String xpath = "//*[@data-cy='schema-fields-list']//input[@value='" + fieldName + "']/parent::div" +
      "//*[@data-cy='select-undefined']";
    return SeleniumDriver.getDriver().findElement(By.xpath(xpath));
  }

  public static By outputSchemaDataTypeOption(String fieldName, String option) {
    return By.xpath("//*[@data-cy='schema-fields-list']//input[@value='" + fieldName + "']/parent::div" +
                      "//*[@data-cy='select-undefined']//*[@data-cy='option-" + option + "']");
  }
}
