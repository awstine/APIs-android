package com.example.api_android.data.remote


import com.google.gson.annotations.SerializedName

data class ThroneResponce(
    @SerializedName("#comment")
    val comment: String,
    @SerializedName("html")
    val html: Html
) {
    data class Html(
        @SerializedName("body")
        val body: Body,
        @SerializedName("head")
        val head: Head,
        @SerializedName("@lang")
        val lang: String
    ) {
        data class Body(
            @SerializedName("app-root")
            val appRoot: String,
            @SerializedName("@class")
            val classX: String,
            @SerializedName("script")
            val script: List<Script>,
            @SerializedName("@style")
            val style: String
        ) {
            data class Script(
                @SerializedName("@defer")
                val defer: String,
                @SerializedName("@src")
                val src: String
            )
        }

        data class Head(
            @SerializedName("base")
            val base: Base,
            @SerializedName("link")
            val link: List<Link>,
            @SerializedName("meta")
            val meta: List<Meta>,
            @SerializedName("style")
            val style: List<Style>,
            @SerializedName("title")
            val title: String
        ) {
            data class Base(
                @SerializedName("@href")
                val href: String
            )

            data class Link(
                @SerializedName("@href")
                val href: String,
                @SerializedName("@rel")
                val rel: String,
                @SerializedName("@type")
                val type: String
            )

            data class Meta(
                @SerializedName("@charset")
                val charset: String,
                @SerializedName("@content")
                val content: String,
                @SerializedName("@name")
                val name: String
            )

            data class Style(
                @SerializedName("#text")
                val text: String,
                @SerializedName("@type")
                val type: String
            )
        }
    }
}