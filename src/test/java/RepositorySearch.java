import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class RepositorySearch {
    @Test
    void HaveTextSelenideAtTheTop (){
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

    }

}
