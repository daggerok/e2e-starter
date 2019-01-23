package com.github.daggerok.e2e

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.getElement
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.By.cssSelector
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.test.context.junit.jupiter.SpringExtension

@Tags(
    Tag("e2e"),
    Tag("web")
)
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = NONE)
class `E2E Tests` {

  @Test
  fun `should test home page`() {
    open("http://127.0.0.1:8080/app/")
    getElement(cssSelector("p"))
        .shouldBe(visible)
        .shouldHave(text("rest api"))
  }

  @Test
  fun `should test fallback page - home will be rendered instead`() {
    open("http://127.0.0.1:8080/app/wrong-path")
    getElement(cssSelector("p"))
        .shouldBe(visible)
        .shouldHave(text("rest api"))
  }
}
