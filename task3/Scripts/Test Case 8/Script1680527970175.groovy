import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Chức năng đọc thêm của cửa hàng. Người dùng nhấp vào nút 'Readmore' trên trang chủ. Readmore cho biết người dùng không thể thêm sản phẩm đã đọc 
//vì sản phẩm đã hết hàng 
//click on 'Readmore' button
CustomKeywords.'Shop.view'()

//đợi phần tử hiển thị 
WebUI.waitForElementPresent(findTestObject('Readmore'), 10)

//di chuyển đến phần tử
WebUI.scrollToElement(findTestObject('Readmore'), 10)

//click on 'readmore' button
WebUI.click(findTestObject('Readmore'))

//xác minh readmore cho biết hết hàng
WebUI.verifyTextPresent('Out of stock', false)

//xác minh người dùng không thể thêm sản phẩm đã đọc vào giỏ hàng vì hết hàng
WebUI.verifyElementNotPresent(findTestObject('AddToBasket'), 10)

//chụp màn hình
//WebUI.takeScreenshot('Readmore.png')
// delay web
WebUI.delay(3)

//close Browser
WebUI.closeBrowser()

