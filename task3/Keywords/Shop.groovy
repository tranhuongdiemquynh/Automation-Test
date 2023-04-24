import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select



import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Shop {
	@Keyword
	public void view() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://practice.automationtesting.in/')
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Shop'))
	}
}
public class Shop1 {
	@Keyword
	public void basket() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://practice.automationtesting.in/')
		WebUI.waitForPageLoad(10)
		WebUI.click(findTestObject('Shop'))
		WebUI.waitForElementPresent(findTestObject('AddToBasket'), 6)
		WebUI.scrollToElement(findTestObject('AddToBasket'), 10)
		WebUI.click(findTestObject('AddToBasket'))
	}
}
public class Shop2 {
	@Keyword
	public void price() {
		//Lưu giá trị của giá thực tế và giá cũ vào các biến
		def actualPrice = WebUI.getText(findTestObject('actualPrice'))
		def oldPrice = WebUI.getText(findTestObject('oldPrice'))

		//Kiểm tra xem giá trị của giá thực tế và giá cũ có khớp với các giá trị mong đợi hay không
		WebUI.verifyMatch(actualPrice, '₹450.00', true)
		WebUI.verifyMatch(oldPrice, '₹600.00', true)

	}
}
public class Shop3 {
	@Keyword
	public void total() {

		//lấy giá trị của subtotal và total
		String subtotalWithCurrencySymbol = WebUI.getText(findTestObject('Subtotal'))
		String totalWithCurrencySymbol = WebUI.getText(findTestObject('Total'))

		String currencySymbol = "₹"

		// xóa ký hiệu tiền tệ khỏi subtotal
		String subtotal = subtotalWithCurrencySymbol.replace(currencySymbol, "").trim()

		// xóa ký hiệu tiền tệ khỏi total
		String total = totalWithCurrencySymbol.replace(currencySymbol, "").trim()

		//sử dụng toán tử < để so sánh
		assert subtotal.toFloat() < total.toFloat()
	}
}

public class Shop4 {
	@Keyword
	public void check_sort() {
		TestObject GiaTien = findTestObject("GiaTien")
		// Lấy danh sách các phần tử trên trang web
		List<WebElement> elementList = WebUiCommonHelper.findWebElements(GiaTien, 10)

		// Lưu trữ các giá trị từ các phần tử vào một List<String>
		List<String> valueList = new ArrayList<String>()
		String currencySymbol = "₹"
		//dùng vòng lặp for để lặp qua ds các phần tử và tìm ra số ứng với mỗi phần tử
		for (WebElement element : elementList) {
			List<WebElement> childElements = element.findElements(By.xpath("*"))
			//nếu ptu có nhiều hơn 1 gtri thì gtri t2 sẽ được lấy và xử lý = cách sd pthuc replace và trim
			if(childElements.size() > 1) {
				String x = childElements.get(1).getText()
				String price = x.replace(currencySymbol, "").trim()
				System.out.println(price)
				System.out.flush()
				valueList.add(price)
			}else {
				//pt k có gtri nào khác ngoài nó, code sẽ lấy gtri text của pt = pt getText
				String x = element.getText()
				String price = x.replace(currencySymbol, "").trim()
				System.out.println(price)
				System.out.flush()
				valueList.add(price)
			}
		}
		// Kiểm tra mảng valueList có được sắp xếp theo thứ tự tăng dần hay không
		boolean isSortedAscending = isSorted(valueList, true);
		System.out.println("Mảng đã được sắp xếp tăng dần: " + isSortedAscending);
		System.out.flush();

		// Kiểm tra mảng valueList có được sắp xếp theo thứ tự giảm dần hay không
		boolean isSortedDescending = isSorted(valueList, false);
		System.out.println("Mảng đã được sắp xếp giảm dần: " + isSortedDescending);
		System.out.flush();
	}
	public boolean isSorted(List<String> values, boolean ascendingOrder) {
		//láy kích thước của danh sách và sử dụng vòng lặp để duyệt qua từng phần tử
		int n = values.size();
		for (int i = 1; i < n; i++) {
			//so sánh phần tử hiện tại với phần tử trước nó bằng phương thức compareTo
			int compareResult = values.get(i-1).compareTo(values.get(i));
			//nếu ds k đc sắp xếp theo tt tăng,giảm pthuc sẽ trả về fale và kết thúc
			if (ascendingOrder && compareResult > 0) {
				return false;
			} else if (!ascendingOrder && compareResult < 0) {
				return false;
			}
		}
		return true
	}
}
public class Shop5 {
	@Keyword
	public void tax() {
		double t;
		List<String> optionsTextList = new ArrayList<String>()
		WebElement selectElement = WebUiCommonHelper.findWebElement(findTestObject('Country'), 10)
		Select select = new Select(selectElement)
		List<WebElement> options = select.getOptions()
		for (WebElement option : options) {
			String value = option.getAttribute("value").trim()
			String text = option.getAttribute("innerHTML").trim()
			if(option.getAttribute("innerHTML").trim()=="India") {
				t = 2.0
			}
			else
				t = 5.0
			System.out.println("Value:" + value + ", Text: " + text + ", Tax: " + t )
			if (!text.isEmpty()) {
				optionsTextList.add(text)
			}
		}
	}
}





