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

//chức năng Shop-sale. Người dùng nhấp vào sản phẩm được viết ở trang chủ. Người dùng có thể xem được cụ thể giá cũ và giá hiện tại của sản phẩm
CustomKeywords.'Shop.view'()

//chờ phần tử hiện diện
WebUI.waitForElementPresent(findTestObject('SanPham'), 6)

//di chuyển đến phần tử
WebUI.scrollToElement(findTestObject('SanPham'), 10)

//click on 'SanPham'
WebUI.click(findTestObject('SanPham'))

CustomKeywords.'Shop2.price'()

//chụp màn hình
//WebUI.takeScreenshot('Sanpham.png')

// delay web
WebUI.delay(3)

//close Browser
WebUI.closeBrowser()

