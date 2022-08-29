import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class USERS {

    // Header contains relevant text
    @org.junit.Test
    public void headertext() {
        open("http://users.bugred.ru/");
        $(By.cssSelector(".navbar-header")).shouldHave(Condition.text("бесплатный тестовый проект с багами и методами SOAP / REST"));
    }

    // Login button exists
    @org.junit.Test
    public void loginbuttonexists() {
        open("http://users.bugred.ru/");
        $(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]")).should(Condition.appear);
        // Selenide.sleep(2000);
    }

    // Login button is visible
    @org.junit.Test
    public void loginbuttonvisible() {
        open("http://users.bugred.ru/");
        $(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]")).shouldBe(Condition.visible);
    }

    // Login button redirects to the login form
    @org.junit.Test
    public void checkloginbutton() {
        open("http://users.bugred.ru/");
        //Selenide.sleep(2000);
        $(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]")).click();
        $(By.xpath("//form[@action=\"/user/login/index.html\"]")).exists();
    }

    // Login functionality
    @org.junit.Test
    public void logintest() {
        open("http://users.bugred.ru/user/login/index.html");
        $(By.name("login")).clear();
        $(By.name("login")).sendKeys("sefevri@sanalgos.club");
        $(By.name("password")).clear();
        $(By.xpath("//input[@type='password']")).sendKeys("123456");
        $(By.xpath("//input[@value='Авторизоваться']")).click();
        //Selenide.sleep(2000);
        $(By.cssSelector(".btn.btn-danger")).shouldHave(Condition.text("Добавить пользователя"));
        //Selenide.sleep(2000);
    }

    // Steam Social login exists
    @org.junit.Test
    public void steam () {
        open("http://users.bugred.ru/user/login/index.html");
        $(By.cssSelector(".ulogin-dropdown-button")).click();
        $(By.cssSelector("#steam")).exists();
    }

    // User search by valid email
    @org.junit.Test
    public void usersearch() {
        open("http://users.bugred.ru/");
        $(By.xpath("//input[@type='text']")).click();
        $(By.xpath("//input[@type='text']")).sendKeys("sefevri@sanalgos.club");
        //Selenide.sleep(2000);
        $(By.cssSelector(".btn.btn-submit")).click();
        $(By.cssSelector(".ajax_load_row")).shouldHave(Condition.text("sefevri@sanalgos.club"));
    }

    // Reset filters
    @org.junit.Test
    public void resetfilters() {
        open("http://users.bugred.ru/");
        $(By.xpath("//input[@type='text']")).click();
        $(By.xpath("//input[@type='text']")).sendKeys("sefevri@sanalgos.club");
        //Selenide.sleep(2000);
        $(By.cssSelector(".btn.btn-submit")).click();
        $(By.linkText("Сбросить фильтры")).click();
        $(By.xpath("//input[@type='text']")).shouldBe(Condition.empty);
    }

    // Add user button redirects to Create User page
    @org.junit.Test
    public void checkadduserbutton() {
        open("http://users.bugred.ru/user/login/index.html");
        $(By.name("login")).clear();
        $(By.name("login")).sendKeys("sefevri@sanalgos.club");
        $(By.name("password")).clear();
        $(By.name("password")).sendKeys("123456");
        $(By.xpath("//input[@value='Авторизоваться']")).click();
        //Selenide.sleep(2000);
        $(By.cssSelector(".btn.btn-danger")).click();
        $(By.name("act_create")).should(Condition.appear);
        //Selenide.sleep(2000);
    }

    // Pagination appears and is visible
    @org.junit.Test
    public void pagination() {
        open("http://users.bugred.ru/");
        $(By.cssSelector(".pagination")).should(Condition.appear).shouldBe(Condition.visible);
    }
}

