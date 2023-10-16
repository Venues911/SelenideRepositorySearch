import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RepositorySearchTest {
    @Test
    void HaveTextSelenideAtTheTop() {
        // First step to any test - Manual Test that you want automation
        // Write your step - planning what you want to do
        //- Откройте страницу Selenide в Github
        // - Перейдите в раздел Wiki проекта
        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click(); // .class, #id, []
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-testid='results-list'] div").first().$("a").click();
        $("#wiki-tab").click();
        $(".wiki-more-pages-link").$("button").click();
        $$("[data-filterable-for='wiki-pages-filter'] li").findBy(text("SoftAssertions")).$("a").click();

        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).shouldHave(size(1));
        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).
                first().sibling(0).$("pre").shouldHave(text(
    """ 
        @ExtendWith({SoftAssertsExtension.class})                                            
        class Tests {                                               
         @Test                                                 
         void test() {                                                 
         Configuration.assertionMode = SOFT;                                                   
         open("page.html");                                                  
         $("#first").should(visible).click();                                                  
         $("#second").should(visible).click();                                                 
         }                       
         }
    """
       ));
    }
}