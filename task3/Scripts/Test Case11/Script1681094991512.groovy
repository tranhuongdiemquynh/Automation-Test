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

//Chức năng cửa hàng. Thêm vào giỏ - xem giỏ thông qua liên kết mặt hàng
CustomKeywords.'Shop1.basket'()

//click on 'item' button(st6)
WebUI.click(findTestObject('Items'))

//click on 'Proceed to checkout' button(st9)
WebUI.waitForElementPresent(findTestObject('Checkout'), 6)

WebUI.scrollToElement(findTestObject('Checkout'), 6)

WebUI.click(findTestObject('Checkout'))

//tiến hành thanh toán(st11)
WebUI.setText(findTestObject('FirstName'), firstname)

WebUI.setText(findTestObject('LastName'), lastname)

WebUI.scrollToElement(findTestObject('Email'), 6)

WebUI.setText(findTestObject('Email'), email)

WebUI.setText(findTestObject('Phone'), phone)

WebUI.click(findTestObject('Country1'))

WebUI.scrollToElement(findTestObject('Country2'), 6)

WebUI.waitForElementPresent(findTestObject('Country2'), 5)

WebUI.click(findTestObject('Country2'))

WebUI.setText(findTestObject('Address'), address)

WebUI.setText(findTestObject('City'), city)

//click on 'order' button(st12)
WebUI.scrollToElement(findTestObject('Order'), 10)

WebUI.click(findTestObject('Order'))

WebUI.delay(3)

WebUI.closeBrowser()

