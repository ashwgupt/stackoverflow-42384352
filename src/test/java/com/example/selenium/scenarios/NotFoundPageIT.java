package com.example.selenium.scenarios;

import com.example.NotFoundApplication;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NotFoundApplication.class,
        webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotFoundPageIT extends FluentTest {

    private WebDriver webDriver = new HtmlUnitDriver();

    @Value("${local.server.port}")
    private int port;

    @Page
    private NotFoundPage notFoundPage;

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @Override
    public String getDefaultBaseUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void showPageNotFoundWhenEndPointDoesNotExist() throws Exception {
        goTo("/notFound");
        notFoundPage.isAt();
    }

    public static class NotFoundPage extends FluentPage {

        @Override
        public void isAt() {
            assertThat(title()).contains("404 Page Unavailable");
            assertThat(find("body").getText()).contains("The requested page is not found");
        }
    }
}
