package com.example.tugasramdhanday4ch6mvp

interface MainPresenter {
    fun inputBmi (beratBadan: String, tinggiBadan: String)
    fun clearHasil()
    fun loadHasil()
}