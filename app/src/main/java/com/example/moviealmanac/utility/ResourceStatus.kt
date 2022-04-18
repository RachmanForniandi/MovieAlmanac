package com.example.moviealmanac.utility

data class ResourceStatus<out T>(val status: Status, val data: T?, val message: String?){

    companion object {

        fun <T> success(data: T?): ResourceStatus<T> {
            return ResourceStatus(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ResourceStatus<T> {
            return ResourceStatus(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ResourceStatus<T> {
            return ResourceStatus(Status.LOADING, data, null)
        }

    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}