package com.github.daggerok.e2e

import assertk.assert
import assertk.assertions.contains
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.getElement
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.WebDriverRunner.source
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
 Tag("rest")
)
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = NONE)
class `E2E REST API Tests` {

  @Test
  fun `should test rest api`() {
    open("http://127.0.0.1:8080/app/api/v1")

    assert(source()).contains("health")
    assert(source()).contains("http://127.0.0.1:8080/app/api/v1")
    println(source())

    val element = getElement(cssSelector("pre"))
    element
        .shouldBe(visible)
        .shouldHave(text("health"))
        .shouldHave(text("http://127.0.0.1:8080/app/api/v1"))
  }

  @Test
  fun `should test rest api ping`() {
    open("http://127.0.0.1:8080/app/api/v1/ping")

    assert(source()).contains("pong")
    assert(source()).contains("status")
    assert(source()).contains("""{"status":"pong"}""")
    println(source())
  }

  @Test
  fun `should test rest api pong`() {
    open("http://127.0.0.1:8080/app/api/v1/pong")

    val element = getElement(cssSelector("body > pre"))
    element
        .shouldBe(visible)
        .shouldHave(text("ping"))
        .shouldHave(text("status"))
        .shouldHave(text("""{"status":"ping"}"""))
    println(element.text)
  }
}
