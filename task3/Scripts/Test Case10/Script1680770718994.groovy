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

//Chức năng mua hàng. Thêm vào giỏ hàng. Xem giỏ hàng
CustomKeywords.'Shop1.basket'()

//xác minh người dùng có thể xem được sách với items giá(st5)
WebUI.verifyElementPresent(findTestObject('Items'), 10)

//click on 'View Basket' button (st6)
WebUI.waitForElementPresent(findTestObject('ViewBasket'), 6)

WebUI.click(findTestObject('ViewBasket'))

//Keyword(st8)
CustomKeywords.'Shop3.total'()

//click on 'Proceed to checkout' button(st9)
WebUI.waitForElementPresent(findTestObject('Checkout'), 6)

WebUI.scrollToElement(findTestObject('Checkout'), 6)

WebUI.click(findTestObject('Checkout'))

//tiến hành thanh toán(st11)
WebUI.setText(findTestObject('FirstName'), GlobalVariable.firstname )

WebUI.setText(findTestObject('LastName'), GlobalVariable.lastname)

WebUI.scrollToElement(findTestObject('Email'), 6)

WebUI.setText(findTestObject('Email'), GlobalVariable.email)

WebUI.setText(findTestObject('Phone'), GlobalVariable.phone)

WebUI.click(findTestObject('Country1'))

WebUI.scrollToElement(findTestObject('Country2'), 6)

WebUI.waitForElementPresent(findTestObject('Country2'), 5)

WebUI.click(findTestObject('Country2'))

WebUI.setText(findTestObject('Address'), GlobalVariable.address)

WebUI.setText(findTestObject('City'), GlobalVariable.city)

//click 'cash on delivery' radio button
//WebUI.waitForElementPresent(findTestObject('PhuongThucTT'), 6)
//WebUI.scrollToElement(findTestObject('PhuongThucTT'), 10)
//WebUI.click(findTestObject('PhuongThucTT'))
//click on 'order' button(st12)
WebUI.scrollToElement(findTestObject('Order'), 10)

WebUI.click(findTestObject('Order'))

WebUI.delay(3)

WebUI.closeBrowser()

