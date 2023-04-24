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

//Chức năng lọc cửa hàng theo giá. Người dùng có thể xem sách với mức giá từ 150-450 rps
//Chờ phần tử hiện diện (tính bằng giây)
CustomKeywords.'Shop.view'()

//đợi phần tử hiển thị
WebUI.waitForElementPresent(findTestObject('BoLoc'), 10)

//click on 'BoLoc' Filter
WebUI.click(findTestObject('Boloc'))

//Nhấp vào phần tử đã có (x,y)
WebUI.clickOffset(findTestObject('Boloc'), 0, 100)

//click on 'BoLocMax' filter
WebUI.click(findTestObject('BoLocMax'))

//Nhấp vào phần tử đã có (x,y) 
WebUI.clickOffset(findTestObject('BoLocMax'), -28, 0)

WebUI.delay(3)

//click on 'Filter' button
WebUI.click(findTestObject('Filter'))

//xác minh phần tử có mặt
WebUI.verifyElementPresent(findTestObject('Filter'), 10)

//chụp ảnh màn hình
//WebUI.takeScreenshot('Filter.png')

//delay web
WebUI.delay(3)

//close browser
WebUI.closeBrowser()

