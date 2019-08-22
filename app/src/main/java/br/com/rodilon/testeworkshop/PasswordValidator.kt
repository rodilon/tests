package br.com.rodilon.testeworkshop

class PasswordValidator {

    fun isValid(password: String): Boolean {
        return password.length < 8
    }

    fun atLeastOneCapsLetter(password: String): Boolean {
        return !password.contains(""".*[A-Z].""".toRegex())
    }

    fun atLeastOneTinyLetter(password: String): Boolean {
        return !password.contains(""".*[a-z].""".toRegex())
    }

    fun atLeastOneNumber(password: String) : Boolean {
        return !password.contains("""[0-9]""".toRegex())
    }

    fun atLeastOneSpecialCharacters(password: String) : Boolean {
        return !password.contains("""[!@#$*%&¨()+=_]""".toRegex())
    }

}
