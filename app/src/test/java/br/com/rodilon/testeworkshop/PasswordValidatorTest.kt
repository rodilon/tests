package br.com.rodilon.testeworkshop

import org.junit.Assert
import org.junit.Test

class PasswordValidatorTest {
    @Test
    fun givenPasswordIsShorterThan8_whenLogin_shouldBeInvalid() {
        // arrange
        val password = "123"

        // act
        val result = PasswordValidator().isValid(password)

        // assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun givenCheckAllValidations() {
        givenPasswordIsShorterThan8_whenLogin_shouldBeInvalid()
        givenPasswordAtLeastOneCapsLetter_whenLogin_shouldBeValid()
        givenPasswordAtLeastOneTinyLetter_whenLogin_shouldBeValid()
        givenPasswordAtLeastOneNumber_whenLogin_shouldBeValid()
        givenPasswordAtLeastOneSpecialCharacters_whenLogin_shouldBeValid()
    }

    @Test
    fun givenPasswordAtLeastOneCapsLetter_whenLogin_shouldBeValid() {
        // arrange
        val password = "123A$%123"

        // act
        val result = PasswordValidator().atLeastOneCapsLetter(password)

        // assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun givenPasswordAtLeastOneTinyLetter_whenLogin_shouldBeValid() {
        // arrange
        val password = "123asadA$%123"

        // act
        val result = PasswordValidator().atLeastOneTinyLetter(password)

        // assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun givenPasswordAtLeastOneNumber_whenLogin_shouldBeValid() {
        // arrange
        val password = "1234"

        // act
        val result = PasswordValidator().atLeastOneNumber(password)

        // assert
        Assert.assertEquals(true, result)
    }

    @Test
    fun givenPasswordAtLeastOneSpecialCharacters_whenLogin_shouldBeValid() {
        // arrange
        val password = "123"

        // act
        val result = Validator.validate(password)

        // assert
        Assert.assertEquals(false, result)
    }



    object Validator {
        private val regexList = listOf(
            Regex("\\d+"),
            Regex("^[a-z0-9]", RegexOption.IGNORE_CASE),
            Regex("[a-z]"),
            Regex("A-Z"),
            Regex(".{8,}")
        )

        fun validate(password: String): Boolean {
            regexList.filter {
                return it.find(password) == null
            }
            return true
        }
    }
}