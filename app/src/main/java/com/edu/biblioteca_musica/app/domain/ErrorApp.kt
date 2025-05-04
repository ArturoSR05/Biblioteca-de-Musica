package com.edu.biblioteca_musica.app.domain

sealed class ErrorApp: Throwable() {

    object InternetErrorApp: ErrorApp(){
        private fun message(): Any = InternetErrorApp
    }

    object ServerErrorApp: ErrorApp(){
        private fun message(): Any = ServerErrorApp
    }

    object UnknownErrorApp: ErrorApp(){
        private fun message(): Any = UnknownErrorApp
    }

    object DataErrorApp: ErrorApp(){
        private fun message(): Any = DataErrorApp
    }

    object CacheExpiredErrorApp: ErrorApp(){
        private fun message(): Any = CacheExpiredErrorApp
    }
}