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

//Chức năng sắp xếp mặc định của cửa hàng. Người dùng có thể xem được sản phẩm mong muốn khi nhấp vào mục sắp xếp theo 'Low To High' ở dropdown
CustomKeywords.'Shop.view'()

//đợi phần tử hiển thị
WebUI.waitForElementPresent(findTestObject('LowToHigh'), 10)

//scroll đến phần tử
WebUI.scrollToElement(findTestObject('LowToHigh'), 10)

//click dropdown 'LowToHigh'
WebUI.click(findTestObject('LowToHigh'))

//scroll đến phần tử
WebUI.scrollToElement(findTestObject('GiaTien'), 10)

//xác minh phần tử hiển thị 
WebUI.verifyElementPresent(findTestObject('LowToHigh'), 10)

CustomKeywords.'Shop4.check_sort'()

//chụp màn hình
//WebUI.takeScreenshot('Lowtohigh.png')

//delay web
WebUI.delay(3)

//close Browser
WebUI.closeBrowser()

